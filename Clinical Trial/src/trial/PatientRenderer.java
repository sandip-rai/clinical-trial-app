package trial;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

@SuppressWarnings("serial")
public class PatientRenderer extends BasicComboBoxRenderer
{
	@SuppressWarnings("rawtypes") 
	public Component getListCellRendererComponent(
        JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
 
        if (value instanceof Patient)
        {
        	Patient patient = (Patient)value;
            setText( patient.getPatientId());
        }
 
        return this;
    }
}