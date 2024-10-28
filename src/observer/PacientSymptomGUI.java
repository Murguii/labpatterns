package observer;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import domain.*;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PacientSymptomGUI extends JFrame {
	private JPanel contentPane;
	private JTextField weightField;
	JComboBox<Symptom> symptomComboBox;
	private JButton btnRemoveSymptom;
	private JLabel errorLabel;
	private JLabel lblPacient;
	private JLabel labelPacient;

	//coment
	/**
	 * Create the frame.
	 */
	public PacientSymptomGUI(Covid19Pacient pacient) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectSymptom = new JLabel("Select Symptom");
		lblSelectSymptom.setBounds(32, 68, 100, 16);
		contentPane.add(lblSelectSymptom);
		
		symptomComboBox = new JComboBox<Symptom>();
		symptomComboBox.setBounds(195, 57, 192, 27);
		symptomComboBox.addItem(NeuroMuscularSymptom.getInstance("fiebre",100,5));
		symptomComboBox.addItem(RespiratorySymptom.getInstance("tos seca",100,5));
		symptomComboBox.addItem(NeuroMuscularSymptom.getInstance("astenia",100,5));
		symptomComboBox.addItem(RespiratorySymptom.getInstance("expectoracion",100,5));
		
		symptomComboBox.addItem(RespiratorySymptom.getInstance("disnea",100,3));
		symptomComboBox.addItem(NeuroMuscularSymptom.getInstance("dolor de garganta",100,3));
		symptomComboBox.addItem(NeuroMuscularSymptom.getInstance("cefalea",100,3));
		symptomComboBox.addItem(NeuroMuscularSymptom.getInstance("mialgia",100,3));
		symptomComboBox.addItem(NeuroMuscularSymptom.getInstance("escalofríos",100,3));

		symptomComboBox.addItem(DigestiveSymptom.getInstance("náuseas o vómitos",100,1));
		symptomComboBox.addItem(RespiratorySymptom.getInstance("congestión nasal",100,1));
		symptomComboBox.addItem(DigestiveSymptom.getInstance("diarrea",100,1));
		symptomComboBox.addItem(RespiratorySymptom.getInstance("hemoptisis",100,1));
		symptomComboBox.addItem(RespiratorySymptom.getInstance("congestión conjuntival",100,1));
		
		
		contentPane.add(symptomComboBox);
		
		JLabel lblSymptomWeight = new JLabel("Symptom weight");
		lblSymptomWeight.setBounds(32, 96, 125, 16);
		contentPane.add(lblSymptomWeight);
		
		weightField = new JTextField();
		weightField.setBounds(195, 91, 130, 26);
		contentPane.add(weightField);
		weightField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Symptom");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pacient.addSymptomByName(((Symptom)symptomComboBox.getSelectedItem()).getName(),Integer.parseInt(weightField.getText()));
				errorLabel.setText(" ");
				if (new Integer(weightField.getText())<=3) {
		    	System.out.println("Symptom added :"+(Symptom)symptomComboBox.getSelectedItem());

				//addSymptomByName ...
				
			} else errorLabel.setText("ERROR, Weight between [1..3]");
				
			}//jdfaldf
		});
		btnNewButton.setBounds(88, 202, 117, 29);
		contentPane.add(btnNewButton);
		
		btnRemoveSymptom = new JButton("Remove Symptom");
		btnRemoveSymptom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pacient.removeSymptomByName(((Symptom)symptomComboBox.getSelectedItem()).getName());
				errorLabel.setText(" ");

		    	System.out.println("Symptom removed :"+(Symptom)symptomComboBox.getSelectedItem());

				//removeSymptomByName...
				
			} 
		});
		btnRemoveSymptom.setBounds(255, 202, 147, 29);
		contentPane.add(btnRemoveSymptom);
		
		errorLabel = new JLabel("");
		errorLabel.setBounds(117, 146, 238, 16);
		contentPane.add(errorLabel);
		
		lblPacient = new JLabel("Pacient:");
		lblPacient.setBounds(210, 17, 61, 16);
		contentPane.add(lblPacient);
		
	    labelPacient = new JLabel("New label");
		labelPacient.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		labelPacient.setBounds(271, 17, 131, 16);
		labelPacient.setText(pacient.getName());

		contentPane.add(labelPacient);
		this.setVisible(true);
	}
}
