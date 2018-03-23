package trial;

import java.io.File;
import java.util.*;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XmlHandler extends FileHandler {
	/*
	 * 
	 * Read the xml file, and please note that this also adds a clinic id.
	 */
	public void readXMLFile(String file) {
	    String clinicName="", clinicId="";
	    String[] readingId, readingType, readingValue, patientId;
        File inputFile = new File(file);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nl1 = doc.getElementsByTagName("Clinic");
            Node n = nl1.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE){
                Element el = (Element) n;
                clinicId = el.getAttribute("id");
                clinicName = el.getTextContent();
            }
            NodeList nl2 = doc.getElementsByTagName("Reading");
            readingId = new String[nl2.getLength()];
            readingType = new String[nl2.getLength()];
            readingValue = new String[nl2.getLength()];
            patientId = new String[nl2.getLength()];
            for (int temp = 0; temp < nl2.getLength(); temp++){
                Node n2 = nl2.item(temp);
                if (n2.getNodeType() == Node.ELEMENT_NODE) {
                    Element el2 = (Element) n2;
                    readingId[temp] = el2.getAttribute("id");
                    readingType[temp] = el2.getAttribute("type");
                    readingValue[temp] = el2.getElementsByTagName("value").item(0).getTextContent();
                    patientId[temp] = el2.getElementsByTagName("patient").item(0).getTextContent();
                }
            }
            ArrayList<FileReading> rjl = new ArrayList<>();

            for (int i = 0; i < readingId.length; i++){
            	FileReading rj = new FileReading(patientId[i], readingType[i], readingId[i], readingValue[i], null, clinicId, clinicName);
                rjl.add(rj);
            }

            AddReadingToPatient(rjl);

        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
