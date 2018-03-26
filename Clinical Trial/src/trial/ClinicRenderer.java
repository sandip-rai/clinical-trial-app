package trial;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

@SuppressWarnings("serial")
public class ClinicRenderer extends BasicComboBoxRenderer
{
	@SuppressWarnings("rawtypes") 
	public Component getListCellRendererComponent(
        JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
 
        if (value instanceof Clinic)
        {
        	Clinic clinic = (Clinic)value;
            setText(clinic.getName());
        }
 
        return this;
    }
}