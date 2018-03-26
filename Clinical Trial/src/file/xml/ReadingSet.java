package file.xml;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="ReadingSet")
class ReadingSet {
		private ArrayList<Reading> readings;
		private Clinic clinic;
		
		@XmlElement( name = "Clinic" )
		protected Clinic getClinic() { 
		    return clinic;  
		}  
		protected void setClinic(Clinic clinic) {  
		    this.clinic = clinic;  
		}  
		
		
		@XmlElement(name = "Reading")
		protected ArrayList<Reading> getReadings(){
			return readings;
		}
		
		protected void setReadings(ArrayList<Reading> readings) {
			this.readings = readings;
		}
		
				
	}