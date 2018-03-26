package trial;

public class SystemSettings {
	private boolean jsonAddUnknownPatients = false;
	private boolean jsonAddUnknownReadings = false;
	private boolean xmlAddUnknownPatients = true;
	private boolean xmlAddUnknownReadings = true;
	private boolean addUnknownClinics = true;

	private String dateFormat = "ddMMMyyyy HH:mm";
	
	public boolean jsonAddUnknownPatients() {
		return jsonAddUnknownPatients;
	}
	public void setJsonAddUnknownPatients(boolean jsonAddUnknownPatients) {
		this.jsonAddUnknownPatients = jsonAddUnknownPatients;
	}
	public boolean jsonAddUnknownReadings() {
		return jsonAddUnknownReadings;
	}
	public void setJsonAddUnknownReadings(boolean jsonAddUnknownReadings) {
		this.jsonAddUnknownReadings = jsonAddUnknownReadings;
	}
	public boolean xmlAddUnknownPatients() {
		return xmlAddUnknownPatients;
	}
	public void setXmlAddUnknownPatients(boolean xmlAddUnknownPatients) {
		this.xmlAddUnknownPatients = xmlAddUnknownPatients;
	}
	public boolean xmlAddUnknownReadings() {
		return xmlAddUnknownReadings;
	}
	public void setXmlAddUnknownReadings(boolean xmlAddUnknownReadings) {
		this.xmlAddUnknownReadings = xmlAddUnknownReadings;
	}
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public boolean addUnknownClinics() {
		return addUnknownClinics;
	}
	public void setAddUnknownClinics(boolean addUnknownClinics) {
		this.addUnknownClinics = addUnknownClinics;
	}

}
