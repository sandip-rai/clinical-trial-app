package file.xml;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class ReadingSet.
 * Helper class to read XML files
 */
@XmlRootElement(name="ReadingSet")
class ReadingSet {
		
		/** The readings. */
		private ArrayList<Reading> readings;
		
		/** The clinic. */
		private Clinic clinic;
		
		/**
		 * Gets the clinic.
		 *
		 * @return the clinic
		 */
		@XmlElement( name = "Clinic" )
		protected Clinic getClinic() { 
		    return clinic;  
		}  
		
		/**
		 * Sets the clinic.
		 *
		 * @param clinic the new clinic
		 */
		protected void setClinic(Clinic clinic) {  
		    this.clinic = clinic;  
		}  
		
		
		/**
		 * Gets the readings.
		 *
		 * @return the readings
		 */
		@XmlElement(name = "Reading")
		protected ArrayList<Reading> getReadings(){
			return readings;
		}
		
		/**
		 * Sets the readings.
		 *
		 * @param readings the new readings
		 */
		protected void setReadings(ArrayList<Reading> readings) {
			this.readings = readings;
		}
		
				
	}