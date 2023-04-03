package pl.javastart.task;

public class Processor extends OverclockableComponent implements Overclockable {
    private static final int DEGREES = 10;

    public Processor(String name, String producer, String serialNumber, int clocking, double temperature, double maxSafeTemperature) {
        super(name, producer, serialNumber, clocking, temperature, maxSafeTemperature);
    }

    @Override
    public String getComponentType() {
        return "Procesor";
    }

    @Override
    public int getTemperatureIncrease() {
        return DEGREES;
    }

    @Override
    public String toString() {
        return "{" +
                super.toString() +
                '}';
    }
}
