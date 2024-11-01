package observer;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import observer.Covid19PacientObs;
import domain.Symptom;

import javax.swing.JLabel;
import java.util.Observable;

public class PacientObserverGUI extends JFrame implements Observer{

	private JPanel contentPane;
	private final JLabel symptomLabel = new JLabel("");

	/**
	 * Create the frame.
	 */
	public PacientObserverGUI(Observable obs) {
		setTitle("Pacient symptoms");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 100, 200, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		symptomLabel.setBounds(19, 38, 389, 199);
		contentPane.add(symptomLabel);
		symptomLabel.setText("Still no symptoms");
		obs.addObserver(this);
		this.setVisible(true);
	}
	
	public void update(Observable	o,	Object	arg) {
		Covid19PacientObs	p=(Covid19PacientObs)o;
		 String	s="<html>	Pacient: <b>"+p.getName()+"</b>	<br>";
		 s=s+"Covid impact:	<b>"+p.covidImpact()+"</b><br><br>";
		 s=s+" _____________________	<br>	Symptoms:	<br>";
		 Iterator<Symptom>i = (Iterator<Symptom>) p.getSymptoms().iterator();
		 Symptom	p2;
		 while (i.hasNext())	{
				 p2=i.next();
				 s=s+ "- " +p2.toString()+","+p.getWeight(p2)+"<br>";
				}
				s=s+"</html>";
				symptomLabel.setText(s);
}
	
	

}
