package file.xml;
import java.util.ArrayList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;


/**
 * The Class ReadingSet.
 * Helper class to read XML files
 */
@Root
class ReadingSet {
		
		/** The readings. */
		@ElementList(name="Reading", inline=true)
		private ArrayList<Reading> readings;
		
		/** The clinic. */
		@Element(required=false, name = "Clinic")
		private Clinic clinic;
		
		/**
		 * Gets the clinic.
		 *
		 * @return the clinic
		 */
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