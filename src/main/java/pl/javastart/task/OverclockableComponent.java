package pl.javastart.task;

public abstract class OverclockableComponent extends Component implements Overclockable {
    private int clocking;
    private double temperature;
    private double maxSafeTemperature;

    public OverclockableComponent(String name, String producer, String serialNumber, int clocking, double temperature, double maxSafeTemperature) {
        super(name, producer, serialNumber);
        this.clocking = clocking;
        this.temperature = temperature;
        this.maxSafeTemperature = maxSafeTemperature;
    }

    @Override
    public void overclock() {  // podkręcanie o stałą ilość Mhz
        overclock(CLOCKING_FREQUENCY);
    }

    @Override
    public void overclock(double amount) {
        double increaseTemperature = getTemperatureIncrease() * amount / CLOCKING_FREQUENCY;
        double maxPossibleFrequency = computeMaxPossibleFrequency();

        if (temperature + increaseTemperature > maxSafeTemperature) {
            throw new OverclockException(getComponentType() + " " + name, maxPossibleFrequency);
        }
        this.temperature += increaseTemperature;
        clocking += amount;
    }

    @Override
    public double computeMaxPossibleFrequency() {
        return clocking + (maxSafeTemperature - temperature) * CLOCKING_FREQUENCY / getTemperatureIncrease();
    }

    public abstract String getComponentType();

    public abstract int getTemperatureIncrease();

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", clocking=" + clocking +
                ", temperature=" + temperature +
                ", maxSafeTemperature=" + maxSafeTemperature;

    }
}
