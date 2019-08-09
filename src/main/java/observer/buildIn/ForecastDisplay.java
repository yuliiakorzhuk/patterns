package observer.buildIn;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, Display {
    Observable observable;
    private float previousPressure;
    private float currentPressure = 29.92f;


    public ForecastDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    public void display() {
        System.out.println("Forecast is:");
        if (this.currentPressure > this.previousPressure) {
            System.out.println("Improving weather on the way!" + "\n");
        } else if (this.currentPressure == this.previousPressure) {
            System.out.println("More of the same" + "\n");
        } else if (this.currentPressure < this.previousPressure) {
            System.out.println("Watch out for cooler, rainy weather" + "\n");
        }
    }

    public void update(Observable observable, Object arg) {
        if(observable instanceof WeatherData){
            WeatherData weatherData = (WeatherData)observable;
            this.previousPressure = currentPressure;
            this.currentPressure = weatherData.getPressure();
            display();
        }
    }
}
