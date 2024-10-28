package adapter2;

import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientTableModelAdapter extends AbstractTableModel {
	  protected Covid19Pacient pacient;
	  protected String[] columnNames = new String[] {"Symptom", "Weight" };
	  private List<Symptom> symptomsList;

	  public Covid19PacientTableModelAdapter(Covid19Pacient p) {
	    this.pacient=p;
	  }

	  public int getColumnCount() {
		 return columnNames.length;
	  }

	  public String getColumnName(int i) {
		  return columnNames[i];
	  }

	  public int getRowCount() {
		 Set<Symptom> s = pacient.getSymptoms();
		 return s.size();
	  }

	  public Object getValueAt(int row, int col) {
		  symptomsList = new ArrayList<>(pacient.getSymptoms());
		  Symptom s = symptomsList.get(row);			 
		  if (col == 0) return s;
		  else if (col == 1) return pacient.getWeight(s);
		  else return null;

	  }
	}