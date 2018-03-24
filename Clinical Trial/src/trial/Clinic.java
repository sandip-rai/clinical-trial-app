package trial;

public class Clinic {

	// data fields for Clinic class
	private String name;
	private String ID;
	
	// constructor for clinic 
	public Clinic(String name, String id){
			
		this.name= name;
		
		this.ID= id;		
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}


	@Override
	public String toString() {
		return "Clinic [name=" + name + ", ID=" + ID + "]";
	}
	
	
	
	
}
