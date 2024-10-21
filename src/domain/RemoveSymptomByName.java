package domain;

import java.util.List;

public class RemoveSymptomByName {
	
	private GetSymptomByName gsbn;

	public Symptom removeSymptomByName(String symptomName, List<Symptom> symptoms) {
		Symptom s=gsbn.getSymptomByName(symptomName, symptoms);
		if (s!=null)removeSymptom(s, symptoms);
		return s;
	}
	
	public void removeSymptom(Symptom s, List<Symptom> symptoms){
		symptoms.remove(s);

	}
}
