package headfirst.designpatterns.observer;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        new CurrentConditionsDisplay(weatherData);
        new StatisticsDisplay(weatherData);
        new ForecastDisplay(weatherData);
        new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(26.0f, 65.0f, 1012.0f);
        System.out.println("---");
        weatherData.setMeasurements(28.0f, 70.0f, 1009.5f);
        System.out.println("---");
        weatherData.setMeasurements(22.0f, 90.0f, 1008.0f);
    }
}
