package FileHandler;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
class XmlReadingSet {
		private XmlClinic clinic;
		private ArrayList<XmlReading> readings;
		
		
		protected XmlClinic getClinic() { 
		    return clinic;  
		}  
		protected void setClinic(XmlClinic clinic) {  
		    this.clinic = clinic;  
		}  
		
		protected ArrayList<XmlReading> getReadings(){
			return readings;
		}
		
		protected void setReadings(ArrayList<XmlReading> readings) {
			this.readings = readings;
		}		
	}