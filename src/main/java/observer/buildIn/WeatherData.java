package observer.buildIn;

import java.util.ArrayList;
import java.util.Observable;

public class WeatherData extends Observable {

    private float pressure;
    private float humidity;
    private float temperature;
    private ArrayList observers;

    public WeatherData(){}

    public void measurementsChanged() {
        System.out.println("NEW DATA");
        setChanged();
        notifyObservers();
        System.out.println("-------------------------------------------");
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        setTemperature(temperature);
        setHumidity(humidity);
        setPressure(pressure);
        measurementsChanged();
    }

    public float getPressure() {
        return this.pressure;
    }

    public float getHumidity() {
        return this.humidity;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
