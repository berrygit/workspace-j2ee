package behavioral.observer.interfaces;

public interface Subject
{

	void registerObserver(Observer o);

	void removeObserver(Observer o);

	void notifyObserver();
}
