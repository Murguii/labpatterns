package observer;

import java.util.Observable;
public interface Observer {
	public void update(Observable observable,	Object	arg);
}
