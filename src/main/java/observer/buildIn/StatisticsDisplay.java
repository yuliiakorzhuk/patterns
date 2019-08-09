package observer.buildIn;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, Display {
    Observable observable;
    private float averageHumidity=0.0f;
    private float averageTemperature=200;
    private float averagePressure=0.0f;

    public StatisticsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    public void display() {
        System.out.println("Average temperature is " + this.averageTemperature + "\n" +
                "Average humidity is " + this.averageHumidity + "\n" +
                "Average pressure is " + this.averagePressure + "\n");
    }

    private float calculateAverage(float previousValue, float currentValue){
        float result;
        if (previousValue != 0)
            result = (previousValue + currentValue) / 2;
        else result = currentValue;
        return result;
    }

    public void update(Observable o, Object arg) {
        if(observable instanceof WeatherData){
            WeatherData weatherData = (WeatherData)observable;
            this.averageTemperature = calculateAverage(this.averageTemperature, weatherData.getTemperature());
            this.averageHumidity = calculateAverage(this.averageHumidity, weatherData.getHumidity());
            this.averagePressure = calculateAverage(this.averagePressure, weatherData.getPressure());
            display();
        }
    }
}
