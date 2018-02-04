import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JPanel implements ActionListener {
	JFrame frame;
	ArrayList<String> patiensID = new ArrayList<>();
	JButton buttonAdd = new JButton("Add");
	JButton buttonPatientsWindow = new JButton("Show Patient info");
	JButton buttonUploadFile = new JButton("Upload File");
	JButton buttonSelect = new JButton("Select");
	JComboBox comboBox;
	JCheckBox checkbox;
	JTextField userInputNewPatienID = new JTextField(16);
	JTextField addPatientState = new JTextField("Click Add button to add new Patient");

	public void uploadFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			FileHandler.filePath = selectedFile.getAbsolutePath();
			FileHandler.readJsonFile(FileHandler.filePath);
			for (Patient patient : ClinicalTrial.getAllPatients()) {
				patiensID.add(patient.getPatientId());
				frame.dispose();
				displayPatientList();
			}
		}
	}

	public void addPatient() {
		JTextField textField = new JTextField("Enter new patient ID in the box below: ");
		JTextField textField1 = new JTextField("Click button below to display patient reading ");
		JTextField textField2 = new JTextField("Click button below to upload a file for reading ");

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panelSpace = new JPanel();

		panel1.setLayout(new GridLayout(0, 3, 10, 10));
		panel2.setLayout(new GridLayout(0, 3, 10, 10));
		panel3.setLayout(new GridLayout(0, 3, 10, 10));
		panel4.setLayout(new GridLayout(0, 3, 10, 10));
		panelSpace.setLayout(new GridLayout(0, 3, 10, 10));

		panel1.add(textField);
		panel2.add(userInputNewPatienID);

		panel1.add(addPatientState);
		panel2.add(buttonAdd);

		panel3.add(textField1);
		panel3.add(textField2);

		panel4.add(buttonPatientsWindow);
		panel4.add(buttonUploadFile);

		buttonAdd.addActionListener(this);
		buttonPatientsWindow.addActionListener(this);
		buttonUploadFile.addActionListener(this);

		frame = new JFrame();
		frame.setLayout(new GridLayout(5, 1, 10, 10));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panelSpace);
		frame.add(panel3);
		frame.add(panel4);
		frame.pack();
		frame.setLocation(150, 150);
		frame.setVisible(true);
	}

	private void addPatientsToTrial(String patientID) {
		Patient patient = new Patient(patientID);
		ClinicalTrial.getAllPatients().add(patient);
	}

	public void displayPatientList() {
		comboBox = new JComboBox(patiensID.toArray());
		JTextField textField = new JTextField("PatientList");

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0, 3, 10, 10));
		panel1.add(textField);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0, 3, 10, 10));
		panel2.add(comboBox);
		panel2.add(buttonSelect);
		buttonSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				displayPatientInfo(ClinicalTrial.getAllPatients().get(comboBox.getSelectedIndex()).getPatientId());
			};
		});

		frame = new JFrame();
		frame.setLayout(new GridLayout(5, 1, 10, 10));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel1);
		frame.add(panel2);
		frame.pack();
		frame.setLocation(150, 150);
		frame.setVisible(true);
	}

	public void displayPatientInfo(String selectedPatient) {
		JButton buttonBack = new JButton("Back");
		checkbox = new JCheckBox("Check to Active");
		checkbox.setSelected(true);
		JTextField patientID = new JTextField(16);
		JTextField reading = new JTextField();
		reading.setSize(200, 200);

		patientID.setText("PatientID: " + selectedPatient);
		reading.setText(ClinicalTrial.findPatient(selectedPatient).getReadings().toString());

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0, 3, 10, 10));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0, 3, 10, 10));

		panel1.add(patientID);
		panel1.add(checkbox);
		panel1.add(buttonBack);
		panel2.add(reading);
		
		buttonBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				displayPatientList();
			}
		});
		
		checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkbox.isSelected()) {
					ClinicalTrial.findPatient(selectedPatient).setActive(true);
				} else {
					ClinicalTrial.findPatient(selectedPatient).setActive(false);
				}
			};
		});

		frame = new JFrame();
		frame.setLayout(new GridLayout(3, 1, 10, 10));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel1);
		frame.add(panel2);
		frame.pack();
		frame.setLocation(150, 150);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonAdd) {
			String tempId = userInputNewPatienID.getText();
			if (ClinicalTrial.findPatient(tempId) == null) {
				addPatientsToTrial(tempId);
				addPatientState.setText("Patient Added, ready for next patient");
			} else {
				addPatientState.setText("Patient already excist");
			}
		}

		if (e.getSource() == buttonPatientsWindow) {
			if (ClinicalTrial.getAllPatients().size() <= 0) {
				JOptionPane.showMessageDialog(null,
						"No patient record in this clinical trial, plese add new patient first");
			} else {
				frame.dispose();
				displayPatientList();
			}
		}

		if (e.getSource() == buttonUploadFile) {
			uploadFile();
		}
	}
}
