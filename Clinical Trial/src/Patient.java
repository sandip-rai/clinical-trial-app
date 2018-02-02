
import java.util.ArrayList;

public class Patient {
	private String patientId;
	private boolean active;
	private ArrayList<Reading> readings;

	protected Patient(String patientId){
		this.patientId = patientId;
		this.setActive(true);
		this.readings = new ArrayList<Reading>();
	}

	public String getPatientId() {
		return patientId;
	}

	public ArrayList<Reading> getReadings() {
		return readings;
	}

	public void addReading(String readingId, String type, double value, int date) {
		Reading reading = new Reading (readingId, type, value, date);
		readings.add(reading);
	}

	public void addReading(String readingId, String type, String bpValue, int date){
		Reading reading = new Reading (readingId, type, bpValue, date);
		readings.add(reading);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}

