package trial;

public class SystemSettings {
	private boolean jsonAddUnknownPatients = false;
	private boolean jsonAddUnknownReadings = false;
	private boolean xmlAddUnknownPatients = false;
	private boolean xmlAddUnknownReadings = false;
	
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
}
