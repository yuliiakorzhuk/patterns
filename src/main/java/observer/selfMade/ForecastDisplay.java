package observer.selfMade;

public class ForecastDisplay implements Observer, Display {

    private Subject weatherData;
    private float previousPressure;
    private float currentPressure = 29.92f;

    public ForecastDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
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

    public void update(float temperature, float humidity, float pressure) {
        this.previousPressure = currentPressure;
        this.currentPressure = temperature;
        display();
    }
}
