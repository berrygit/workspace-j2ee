package behavioral.observer;

import behavioral.observer.interfaces.DisplayElement;
import behavioral.observer.interfaces.Observer;
import behavioral.observer.interfaces.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement
{
	private float temperature;
	private float humidity;

	@SuppressWarnings("unused")
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData)
	{
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display()
	{
		System.out.println(temperature + humidity);
	}

	@Override
	public void update(float temperature, float humidity, float pressure)
	{
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

}
