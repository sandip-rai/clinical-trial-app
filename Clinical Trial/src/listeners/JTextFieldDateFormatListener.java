package listeners;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gui.GuiController;


//class for buttonBack to perform actionPerformed(ActionEvent e)
public class JTextFieldDateFormatListener implements DocumentListener {
	GuiController guiController;
	//constructor
	public JTextFieldDateFormatListener(GuiController guiController){
		this.guiController = guiController;
	}
	@Override
	public void changedUpdate(DocumentEvent arg0) {	
		updateDateFormat();
	}
	
	@Override
	public void insertUpdate(DocumentEvent arg0) {	
		updateDateFormat();
	
	}
	@Override
	public void removeUpdate(DocumentEvent arg0) {	
		updateDateFormat();
	}
	
	private void updateDateFormat() {
		String dateFormat = guiController.getSystemSettingView().getDateFormat().getText();
		guiController.getClinicalTrial().getSettings().setDateFormat(dateFormat);
	}


}
