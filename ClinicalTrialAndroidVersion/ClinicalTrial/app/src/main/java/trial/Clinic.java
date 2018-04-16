package trial;

/**
 * The Class Clinic.
 */
public class Clinic {

	/** The name. */
	// data fields for Clinic class
	private String name;
	
	/** The id. */
	private String id;
	
	/**
	 * Instantiates a new clinic.
	 *
	 * @param name the name
	 * @param id the id
	 */
	// constructor for clinic 
	public Clinic(String name, String id){
			
		this.name= name;
		
		this.id= id;		
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	// getters and setters
	public String getName() {
		if (name == null) {
			return getId();
		}
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		if (id == null) {
			return "Unknown";
		}
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setID(String id) {
		this.id = id;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Clinic Name: " + getName() + "\nClinic ID: " + getId();
	}
	
	
	
	
}
