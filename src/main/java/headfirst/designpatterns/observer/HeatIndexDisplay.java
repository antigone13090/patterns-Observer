package headfirst.designpatterns.observer;

public class HeatIndexDisplay implements Observer, DisplayElement {
    private float heatIndex = 0.0f;

    private final Subject weatherData;

    public HeatIndexDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        heatIndex = computeHeatIndex(temp, humidity);
        display();
    }

    @Override
    public void display() {
        System.out.println("Heat index is " + String.format("%.2f", heatIndex));
    }

    // Approche simple : on garde l’exemple centré sur le pattern, pas sur la météo.
    private float computeHeatIndex(float tC, float rh) {
        float tF = tC * 9.0f / 5.0f + 32.0f;
        float indexF =
            (float)(
                16.923
                + 0.185212 * tF
                + 5.37941 * rh
                - 0.100254 * tF * rh
                + 0.00941695 * (tF * tF)
                + 0.00728898 * (rh * rh)
                + 0.000345372 * (tF * tF * rh)
                - 0.000814971 * (tF * rh * rh)
                + 0.0000102102 * (tF * tF * rh * rh)
                - 0.000038646 * (tF * tF * tF)
                + 0.0000291583 * (rh * rh * rh)
                + 0.00000142721 * (tF * tF * tF * rh)
                + 0.000000197483 * (tF * rh * rh * rh)
                - 0.0000000218429 * (tF * tF * tF * rh * rh)
                + 0.000000000843296 * (tF * tF * rh * rh * rh)
                - 0.0000000000481975 * (tF * tF * tF * rh * rh * rh)
            );
        return (indexF - 32.0f) * 5.0f / 9.0f;
    }
}
