package gui.views;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import trial.Clinic;

/**
 * The Class ClinicRenderer.
 */
@SuppressWarnings("serial")
public class ClinicRenderer extends BasicComboBoxRenderer
{
	
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicComboBoxRenderer#getListCellRendererComponent(javax.swing.JList, java.lang.Object, int, boolean, boolean)
	 */
	@SuppressWarnings("rawtypes") 
	public Component getListCellRendererComponent(
        JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
 
        if (value instanceof Clinic)
        {
        	Clinic clinic = (Clinic)value;
        	//set display value to the Clinic name
            setText(clinic.getName());
        }
 
        return this;
    }
}