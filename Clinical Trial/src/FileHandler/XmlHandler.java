package FileHandler;
import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class XmlHandler extends FileHandler {
	/*
	 * 
	 * Read the xml file, and please note that this also adds a clinic id.
	 */
	public boolean readXMLFile(String file, boolean addUnkownPatients, boolean addUnknownReadings) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(XmlReadingSet.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			XmlReadingSet ReadingSet = (XmlReadingSet) jaxbUnmarshaller.unmarshal(new File(file));
			System.out.println(ReadingSet.getClinic());
			return true;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
