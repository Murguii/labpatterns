package observer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import factory.SymptomFactory;
import iterator.Covid19PacientIterator;
import domain.*;

public class Covid19PacientObs extends Observable {
	private String  name; 
	private int age;
	private Map<Symptom,Integer> symptoms=new HashMap<Symptom,Integer>();
	private SymptomFactory sf;

	public Covid19PacientObs(String name, int years) {
		this.name = name;
		this.age = years;
		this.sf = SymptomFactory.getInstance();
	} //
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight(Symptom s) {
		return symptoms.get(s);
	}

	public Set<Symptom> getSymptoms() {
		return symptoms.keySet();
	}
	
	public Symptom getSymptomByName(String symptomName) {
		Iterator<Symptom> i= getSymptoms().iterator();
		Symptom s=null;
		while (i.hasNext()) {
			s=i.next();
			if (s!=null && s.getName().equals(symptomName)) return s;
		}
		return null;	
	}

	public void addSymptom(Symptom c, Integer w){
		symptoms.put(c,w);
	}
	
	public Symptom addSymptomByName(String symptom, Integer w){
		Symptom s=getSymptomByName(symptom);
		setChanged();
		notifyObservers();
		if (s==null) {
			s=createSymptom(symptom); 
			symptoms.put(s,w);		
		}
		return s;
	}

	public Symptom removeSymptomByName(String symptomName) {
		Symptom s=getSymptomByName(symptomName);
		setChanged();
		notifyObservers();
		System.out.println("Simptom to remove: "+s);
		if (s!=null) symptoms.remove(s);
		return s;
	}
	public Iterator iterator() {
		return new Covid19PacientIterator(this.symptoms.keySet());
	}
	
	public double covidImpact() {
		double afection=0;
		double increment=0;
		double impact=0;
		
		//calculate afection
		for (Symptom c: symptoms.keySet()) {
			if (c!=null )
			   afection=afection+c.getSeverityIndex()*symptoms.get(c);
		}
		afection=afection/symptoms.size();
		
		//calculate increment
		if (getAge()>65) increment=afection*0.5;
		
		//calculate impact
		impact=afection+increment;
		return impact;
	}
	
	private Symptom createSymptom(String symptomName) {
		return sf.createSymptom(symptomName);		
		
	}
	
}