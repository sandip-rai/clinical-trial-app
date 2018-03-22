package trial;

public class Clinic {

	
	private String name;
	private String ID;
	
	
	
	public Clinic(String name, String id){
		
		
		this.name= name;
		
		this.ID= id;		
	}



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
