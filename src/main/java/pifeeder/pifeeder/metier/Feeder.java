package pifeeder.pifeeder.metier;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.LoggerFactory;

import com.pi4j.component.servo.ServoDriver;
import com.pi4j.component.servo.ServoProvider;
import com.pi4j.component.servo.impl.RPIServoBlasterProvider;

public abstract class Feeder {
	
	public static void feed(int nbRepetition,int tempsPause,int angleDebut,int angleFin) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM à HH:mm:ss");
		LoggerFactory.getLogger(Feeder.class).info(String.format("### Lancement Servo Moteur le %s ###", LocalDateTime.now().format(dtf)));
		LoggerFactory.getLogger(Feeder.class).info(String.format("### Lancement Servo Moteur pour %d répétitions entre %d et %d avec pause de %d ms.",nbRepetition,angleDebut,angleFin,tempsPause));
		ServoProvider servoProvider;
		try {
			servoProvider = new RPIServoBlasterProvider();

			ServoDriver servo7 = servoProvider.getServoDriver(servoProvider.getDefinedServoPins().get(7));
//			long start = System.currentTimeMillis();
			for (int i = 0; i < nbRepetition; i++) {
				servo7.setServoPulseWidth(testRangeAngle(angleFin));
				Thread.sleep(tempsPause);
				servo7.setServoPulseWidth(testRangeAngle(angleDebut));
				Thread.sleep(tempsPause);
			}
				// while (System.currentTimeMillis() - start < 5000) { // 2 minutes
				// for (int i = 75; i < 195; i++) {
				// servo7.setServoPulseWidth(i); // Set raw value for this servo
				// // driver - 50 to 195
				// Thread.sleep(5);
				// }
				// for (int i = 195; i > 75; i--) {
				// servo7.setServoPulseWidth(i); // Set raw value for this servo
				// // driver - 50 to 195
				// Thread.sleep(5);
				// }
//			}
		} catch (IOException e) {
			LoggerFactory.getLogger(Feeder.class).warn("Erreur I/O dans Feeder");
			e.printStackTrace();
		} catch (InterruptedException e) {
			LoggerFactory.getLogger(Feeder.class).warn("Erreur de thread/sleep dans Feeder");
			e.printStackTrace();
		}
	}

	private static int testRangeAngle(int angle) {		
		return Integer.max(Integer.min(angle,195),45);
	}

}
