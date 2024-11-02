package iterator;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Vector;

import adapter.InvertedIterator;
import domain.Symptom;

public class Covid19PacientIterator implements Iterator, InvertedIterator{
	List<Symptom> symptoms=new Vector<Symptom>();
	int position;
	ListIterator<Symptom> iterator;

	public Covid19PacientIterator(Set<Symptom> s) {
		Iterator<Symptom> i=s.iterator();
		while (i.hasNext())
			symptoms.add(i.next());
	}

	@Override
	public boolean hasNext() {
		return position<=symptoms.size();
	}

	@Override
	public Object next() {
		if(hasNext()) {
			position++;
			Symptom symptom=symptoms.get(position);		
			return symptom;
		}
		return null;
	}

	@Override
	public Object previous() {
		if(hasPrevious()) {
		Symptom symptom = symptoms.get(position);
		position--;
		return symptom;
		}
		return null;
	}

	@Override
	public boolean hasPrevious() {
		return position >=0;
		
	}

	@Override
	public void goLast() {
		position = symptoms.size() - 1;		
	}

}
