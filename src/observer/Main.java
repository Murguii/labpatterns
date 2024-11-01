package observer;

import java.util.Observable;

import observer.Covid19PacientObs;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Observable	pacient=new	Covid19PacientObs("aitor",	35);
		new	PacientObserverGUI	(pacient);
		new	PacientSymptomGUI((Covid19PacientObs)pacient);	
		new PacientThermometerGUI(pacient);
	}	//


}
	