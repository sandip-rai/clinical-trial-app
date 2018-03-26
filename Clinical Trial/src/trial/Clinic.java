package trial;

public class Clinic {

	// data fields for Clinic class
	private String name;
	private String id;
	
	// constructor for clinic 
	public Clinic(String name, String id){
			
		this.name= name;
		
		this.id= id;		
	}

	// getters and setters
	public String getName() {
		if (name == null) {
			return getId();
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		if (id == null) {
			return "Unknown";
		}
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Clinic Name: " + getName() + "\nClinic ID: " + getId();
	}
	
	
	
	
}
