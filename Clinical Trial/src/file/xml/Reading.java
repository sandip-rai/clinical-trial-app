package file.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Reading {
	private String id;
	private String type;
	//private String Value;
	private Value value;
	private String Date;
	private String patient;
	
	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlAttribute(name = "type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@XmlElement(name = "Date")
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	@XmlElement(name = "Patient")
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	@XmlElement( name = "Value" )
	public Value getValue() {
		return value;
	}
	public void setValue(Value value) {
		this.value = value;
	}
	
	
}
