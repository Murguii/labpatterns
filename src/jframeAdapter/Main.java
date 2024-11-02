package jframeAdapter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import domain.Covid19Pacient;
import domain.DigestiveSymptom;
import domain.NeuroMuscularSymptom;
import domain.RespiratorySymptom;
import domain.Symptom;

	public class Main {

		public static void main(String[] args) {
			Covid19Pacient p=new Covid19Pacient("Ane", 29);
			p.addSymptom(new NeuroMuscularSymptom("cefalea", 10, 10), 1);
			p.addSymptom(new DigestiveSymptom("vomitos", 10, 10), 2);
			p.addSymptom(new RespiratorySymptom("tos seca", 10, 10), 3);
			p.addSymptom(new RespiratorySymptom("congestion nasal", 10, 10), 4);
			p.addSymptom(new NeuroMuscularSymptom("fiebre", 10, 10), 5);
			
			Covid19PacientModelAdapter pacientModelAdapter=new Covid19PacientModelAdapter(p);        
			
			JFrame j=new JFrame();
			JTable table = new JTable(pacientModelAdapter);
			 j.add(new JScrollPane(table));
	         
		     j.setTitle(p.getName()+"'s symptoms");
		     j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
		     j.pack();
		     j.setVisible(true);

		}

	}

