package iterator;

import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import domain.Covid19Pacient;
import domain.DigestiveSymptom;
import domain.NeuroMuscularSymptom;
import domain.RespiratorySymptom;
import domain.Symptom;
import adapter.Sorting; 
import adapter.InvertedIterator;
import java.util.Comparator;
	public class Main {

		public static void main(String[] args) {
			Covid19Pacient p=new Covid19Pacient("Ane", 29);
			p.addSymptom(new NeuroMuscularSymptom("cefalea", 10, 10), 1);
			p.addSymptom(new DigestiveSymptom("vomitos", 10, 10), 2);
			p.addSymptom(new RespiratorySymptom("tos seca", 10, 10), 3);
			p.addSymptom(new RespiratorySymptom("congestion nasal", 10, 10), 4);
			p.addSymptom(new NeuroMuscularSymptom("fiebre", 10, 10), 5);
			
			InvertedIterator pi = new Covid19PacientIterator(p.getSymptoms());
			Comparator compname = new ComparatorByName();
			Comparator compindex = new ComparatorBySeverity();
			
		
			Iterator<Symptom> sortedIterator = Sorting.sortedIterator(pi, compname);
			
			while(sortedIterator.hasNext())
				System.out.println(sortedIterator.next());

			Iterator<Symptom> sortedItera2 = Sorting.sortedIterator(pi, compindex);
			
			while(sortedItera2.hasNext())
				System.out.println(sortedItera2.next());
		}
		
		
	}

