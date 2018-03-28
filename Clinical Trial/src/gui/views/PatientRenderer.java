package gui.views;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import trial.Patient;

/**
 * The Class PatientRenderer.
 */
@SuppressWarnings("serial")
public class PatientRenderer extends BasicComboBoxRenderer
{
	
	/* (non-Javadoc)
	 * @see javax.swing.plaf.basic.BasicComboBoxRenderer#getListCellRendererComponent(javax.swing.JList, java.lang.Object, int, boolean, boolean)
	 */
	@SuppressWarnings("rawtypes") 
	public Component getListCellRendererComponent(
        JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
 
        if (value instanceof Patient)
        {
        	Patient patient = (Patient)value;
        	//set display value to the patient ID
            setText( patient.getPatientId());
        }
 
        return this;
    }
}