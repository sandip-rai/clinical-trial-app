import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JPanel implements ActionListener {
	int numberOfPatiens;
	ArrayList<String> patiensID = new ArrayList<>();
	
	public void uploadFile(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		    FileHandler fh = new FileHandler();
//		    numberOfPatiens = fh.patients.size();
//		    for (Patient patient: fh.patients) {
//		    	patiensID.add(patient.getPatientId());
//		    }
		}
	}
	
	public void displayPatientInfo(){
		//String[] patientIdList = (String[]) patiensID.toArray();
		String[] patientIdList = {"123123123", "3213213", "9294124", "56756"};
		JComboBox comboBox = new JComboBox(patientIdList);
		JButton button = new JButton("Select");
		
		JTextField textField = new JTextField("PatientList");
		
		
		JPanel firstPanel = new JPanel();
		firstPanel.setLayout(new GridLayout(0, 3, 10, 10));
		firstPanel.add(textField);
		
		JPanel secondPanel = new JPanel();
		secondPanel.setLayout(new GridLayout(0, 3, 10, 10));
		secondPanel.add(comboBox);
		secondPanel.add(button);
		button.addActionListener(this);
		
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(2, 1, 10, 10));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(firstPanel);
		frame.add(secondPanel);
		frame.pack();
		frame.setLocation(150, 150);
		frame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
