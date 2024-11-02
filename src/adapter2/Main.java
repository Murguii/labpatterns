package adapter2;

import domain.Covid19Pacient;

public class Main {

	public static void main(String[] args) {
		Covid19Pacient pacient=new Covid19Pacient("aitor", 35);
		
		pacient.addSymptomByName("disnea", 2);
		pacient.addSymptomByName("cefalea", 1);
		pacient.addSymptomByName("nauseas", 3);
		
		Covid19Pacient pacient2=new Covid19Pacient("aitor2", 35);
		
		pacient2.addSymptomByName("diarrea", 2);
		pacient2.addSymptomByName("fiebre", 1);
		pacient2.addSymptomByName("disnea", 3);
		
		ShowPacientTableGUI gui=new ShowPacientTableGUI(pacient);
		gui.setPreferredSize(
			      new java.awt.Dimension(300, 200));
		gui.setVisible(true);
		
		ShowPacientTableGUI gui2=new ShowPacientTableGUI(pacient2);
		gui2.setPreferredSize(
			      new java.awt.Dimension(300, 200));
		gui2.setVisible(true);


	}

}
