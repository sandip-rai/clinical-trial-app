package file.xml;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement 
class ReadingSet {
		private Clinic clinic;
		private ArrayList<Reading> readings;
		
		
		protected Clinic getClinic() { 
		    return clinic;  
		}  
		protected void setClinic(Clinic clinic) {  
		    this.clinic = clinic;  
		}  
		
		protected ArrayList<Reading> getReadings(){
			return readings;
		}
		
		protected void setReadings(ArrayList<Reading> readings) {
			this.readings = readings;
		}		
	}