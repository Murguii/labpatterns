package domain;

import java.util.Iterator;
import java.util.List;

public class GetSymptomByName {

	public Symptom getSymptomByName(String symptomName, List<Symptom> symptoms) {
		Iterator<Symptom> i= symptoms.iterator();
		Symptom s=null;
		while (i.hasNext()) {
			s=i.next();
			if (s!=null && s.getName().compareTo(symptomName)==0) return s;
		}
		return null;	
	}
}
