package headfirst.designpatterns.observer;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp = Float.NEGATIVE_INFINITY;
    private float minTemp = Float.POSITIVE_INFINITY;
    private float tempSum = 0.0f;
    private int numReadings = 0;

    private final Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        tempSum += temp;
        numReadings++;

        if (temp > maxTemp) maxTemp = temp;
        if (temp < minTemp) minTemp = temp;

        display();
    }

    @Override
    public void display() {
        float avg = (numReadings == 0) ? 0.0f : (tempSum / numReadings);
        System.out.println("Avg/Max/Min temperature = " + avg + "°C / " + maxTemp + "°C / " + minTemp + "°C");
    }
}
