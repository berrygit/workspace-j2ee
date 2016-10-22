package behavioral.observer;

import java.util.Observable;

public class WeatherData extends Observable
{
	private float temperature;
	private float humidity;
	private float pressure;

	public void measurementsChanged()
	{
		setChanged();
		notifyObservers();
	}

	/**
	 * @return the temperature
	 */
	public float getTemperature()
	{
		return temperature;
	}

	/**
	 * @return the humidity
	 */
	public float getHumidity()
	{
		return humidity;
	}

	/**
	 * @return the pressure
	 */
	public float getPressure()
	{
		return pressure;
	}

}
