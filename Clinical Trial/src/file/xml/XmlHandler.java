package file.xml;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import file.Handler;

public class XmlHandler extends Handler {
	/*
	 * 
	 * Read the xml file, and please note that this also adds a clinic id.
	 */
	public boolean readXMLFile(String file, boolean addUnkownPatients, boolean addUnknownReadings) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ReadingSet.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ReadingSet ReadingSet = (ReadingSet) jaxbUnmarshaller.unmarshal(new File(file));
			System.out.println(ReadingSet.getClinic());
			return true;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}