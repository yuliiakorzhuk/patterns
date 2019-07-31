package observer;

public class CurrentConditionsDisplay implements Observer, Display{

    private Subject weatherData;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void display() {
        System.out.println("Current conditions: " + this.temperature + "F degrees and " + humidity + "% humidity");
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
