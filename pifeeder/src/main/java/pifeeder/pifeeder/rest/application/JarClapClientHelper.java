package pifeeder.pifeeder.rest.application;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.logging.Level;

import org.restlet.Client;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Reference;
import org.restlet.data.Status;
import org.restlet.engine.local.ClapClientHelper;
import org.restlet.engine.local.Entity;
import org.restlet.representation.InputRepresentation;
import org.restlet.representation.Representation;
import org.restlet.service.MetadataService;

public class JarClapClientHelper extends ClapClientHelper {

	public JarClapClientHelper(Client client) {
		super(client);
	}

	/**
	 * Handles a call with a given class loader.
	 * 
	 * @param request
	 *            The request to handle.
	 * @param response
	 *            The response to update.
	 */
	protected void handleClassLoader(Request request, Response response, ClassLoader classLoader) {
		MetadataService metadataService = getMetadataService();

		if (!request.getMethod().equals(Method.GET) && !request.getMethod().equals(Method.HEAD)) {
			response.setStatus(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED);
			response.getAllowedMethods().add(Method.GET);
			response.getAllowedMethods().add(Method.HEAD);

			return;
		}

		String path = request.getResourceRef().getPath();
		URL url = null;
		Date modificationDate = null;

		// Prepare a classloader URI, removing the leading slash
		if ((path != null) && path.startsWith("/")) {
			path = path.substring(1);
		}

		// Get the URL to the classloader 'resource'
		if (classLoader != null) {
			// As the path may be percent-encoded, it has to be
			// percent-decoded.
			url = classLoader.getResource(Reference.decode(path));
		} else {
			getLogger().warning("Unable to get the resource. The selected classloader is null.");
		}

		// The ClassLoader returns a directory listing in some cases.
		// As this listing is partial, it is of little value in the context
		// of the CLAP client, so we have to ignore them.
		if (url != null) {
			if (url.getProtocol().equals("file")) {
				File file = new File(url.getFile());
				modificationDate = new Date(file.lastModified());

				if (file.isDirectory()) {
					url = null;
				}
			} else if (url.getProtocol().equals("jar")) {
				try {
					JarURLConnection conn = (JarURLConnection) url.openConnection();
					modificationDate = new Date(conn.getJarEntry().getLastModifiedTime().toMillis());
					if (conn.getJarEntry().isDirectory()) {
						url = null;
					}

				} catch (IOException ioe) {
					getLogger().log(Level.WARNING, "Unable to open the representation's input stream", ioe);
					response.setStatus(Status.SERVER_ERROR_INTERNAL);
				}
			}
		}

		if (url == null) {
			response.setStatus(Status.CLIENT_ERROR_NOT_FOUND);
			return;
		}

		try {
			InputStream inputStream = url.openStream();

			// check for empty input stream on jar directories
			if (url.getProtocol().equals("jar")) {
				if (inputStream.available() == 0) {
					response.setStatus(Status.CLIENT_ERROR_NOT_FOUND);
					return;
				}
			}

			Representation output = new InputRepresentation(inputStream, metadataService.getDefaultMediaType());
			output.setLocationRef(request.getResourceRef());
			output.setModificationDate(modificationDate);

			// Update the expiration date
			long timeToLive = getTimeToLive();

			if (timeToLive == 0) {
				output.setExpirationDate(null);
			} else if (timeToLive > 0) {
				output.setExpirationDate(new Date(System.currentTimeMillis() + (1000L * timeToLive)));
			}

			// Update the metadata based on file extensions
			String name = path.substring(path.lastIndexOf('/') + 1);
			Entity.updateMetadata(name, output, true, getMetadataService());

			// Update the response
			response.setEntity(output);
			response.setStatus(Status.SUCCESS_OK);
		} catch (IOException ioe) {
			getLogger().log(Level.WARNING, "Unable to open the representation's input stream", ioe);
			response.setStatus(Status.SERVER_ERROR_INTERNAL);
		}
	}

}
