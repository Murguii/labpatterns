package domain;

public class RespiratorySymptom extends Symptom{

	private static RespiratorySymptom instance;

	
	private RespiratorySymptom(String name, int covidImpact, int severityIndex) {
		super(name, covidImpact, severityIndex);
		// TODO Auto-generated constructor stub
	}
	
	public static RespiratorySymptom getInstance(String name, int covidImpact, int severityIndex) {
        if (instance == null) {
            instance = new RespiratorySymptom(name, covidImpact, severityIndex);
        }
        return instance;
    }

}
