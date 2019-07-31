package observer;

public class StatisticsDisplay implements Observer, Display{
    private Subject weatherData;
    private float averageHumidity=0.0f;
    private float averageTemperature=200;
    private float averagePressure=0.0f;

    public StatisticsDisplay(Subject weatherData){
        this.weatherData = new WeatherData();
        weatherData.registerObserver(this);
    }

    public void display() {
        System.out.println("Average temperature is " + this.averageTemperature + "\n" +
                "Average humidity is " + this.averageHumidity + "\n" +
                "Average pressure is " + this.averagePressure + "\n");
    }

    public void update(float temperature, float humidity, float pressure) {
        this.averageTemperature = calculateAverage(this.averageTemperature, temperature);
        this.averageHumidity = calculateAverage(this.averageHumidity, humidity);
        this.averagePressure = calculateAverage(this.averagePressure, pressure);
        display();
    }

    private float calculateAverage(float previousValue, float currentValue){
        float result;
        if (previousValue != 0)
            result = (previousValue + currentValue) / 2;
        else result = currentValue;
        return result;
    }
}
