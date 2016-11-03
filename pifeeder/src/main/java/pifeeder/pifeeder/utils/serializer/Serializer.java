package pifeeder.pifeeder.utils.serializer;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
/**
 * Class serialisation en Json
 * @author Belzeb78
 *
 * @param <T>
 */
public class Serializer<T> {

	private final Class<T> type;

	public Serializer(Class<T> type) {
	          this.type = type;
	     }
	
	public Class<T> getType() {
		return type;
	}

	public void writeObject(File file, T obj) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		// Object to JSON in file
		mapper.writeValue(file, obj);
	}

	public T readObject(File file) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		//JSON from URL to Object
		return mapper.readValue(file, getType());
	}
}
