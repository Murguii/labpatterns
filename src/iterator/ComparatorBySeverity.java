package iterator;

import java.util.Comparator;
import domain.Symptom;

public class ComparatorBySeverity implements Comparator<Symptom> {

	@Override
	public int compare(Symptom symp1, Symptom symp2) {
		return Integer.compare(symp1.getSeverityIndex(), symp2.getSeverityIndex());

	}

}
