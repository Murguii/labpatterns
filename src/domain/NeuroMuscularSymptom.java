package domain;

public class NeuroMuscularSymptom extends Symptom{

	private static NeuroMuscularSymptom instance;
	
	private NeuroMuscularSymptom(String name, int covidImpact, int severityIndex) {
		super(name, covidImpact, severityIndex);
		// TODO Auto-generated constructor stub
	}

	public static NeuroMuscularSymptom getInstance(String name, int covidImpact, int severityIndex) {
        if (instance == null) {
            instance = new NeuroMuscularSymptom(name, covidImpact, severityIndex);
        }
        return instance;
    }
	
}
