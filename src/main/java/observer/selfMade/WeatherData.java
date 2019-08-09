package observer.selfMade;

import java.util.ArrayList;

public class WeatherData implements Subject {

    private float pressure;
    private float humidity;
    private float temperature;
    private ArrayList observers;

    public WeatherData(){
        this.observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) { // ?
        this.observers.add(o);
    }

    public void removeObserver(Observer o) { // ?
        int i  = this.observers.indexOf(0);
        if(i>=0){
            this.observers.remove(i);
        }
    }

    public void notifyObservers() {
        for(int i=0; i<this.observers.size();i++){
            Observer observer = (Observer)observers.get(i);
            observer.update(this.temperature, this.humidity, this.pressure);
        }
    }

    public void measurementsChanged() {
        System.out.println("NEW DATA");
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
