package headfirst.designpatterns.observer;

public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 1013.0f;
    private float lastPressure = 1013.0f;

    private final Subject weatherData;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    @Override
    public void display() {
        if (currentPressure > lastPressure) {
            System.out.println("Forecast: Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("Forecast: More of the same.");
        } else {
            System.out.println("Forecast: Watch out for cooler, rainy weather.");
        }
    }
}
