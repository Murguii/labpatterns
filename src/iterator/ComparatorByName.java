package iterator;

import java.util.Comparator;

import domain.Symptom;

public class ComparatorByName implements Comparator<Symptom> {

	@Override
	public int compare(Symptom symptom1, Symptom symptom2) {
		return symptom1.getName().compareTo(symptom2.getName());

	}

}
