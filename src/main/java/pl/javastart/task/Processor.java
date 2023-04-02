package pl.javastart.task;

public class Processor extends Component implements Overclockable {
    private int clocking;
    private double temperature;
    private double maxSafeTemperature;
    private static final int CLOCKING_FREQUENCY = 100;
    private static final int DEGREES = 10;

    public Processor(String name, String producer, String serialNumber, int clocking, double temperature, double maxSafeTemperature) {
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
        double increaseTemperature = DEGREES * amount / CLOCKING_FREQUENCY;
        double maxPossibleFrequency = computeMaxPossibleFrequency();

        if (temperature + increaseTemperature > maxSafeTemperature) {
            throw new OverclockException("Procesor " + name, maxPossibleFrequency);
        }
        this.temperature += increaseTemperature;
        clocking += amount;

        System.out.println("Procesor podkręcony o: " + amount + " Mhz " +
                "(Maksymalnie możesz podkęcić do: " + maxPossibleFrequency + " Mhz)");
    }

    @Override
    public String toString() {
        return "{" +
                "clocking=" + clocking +
                ", temperature=" + temperature +
                ", maxSafeTemperature=" + maxSafeTemperature +
                super.toString();
    }

    @Override
    public double computeMaxPossibleFrequency() {
        return clocking + (maxSafeTemperature - temperature) * CLOCKING_FREQUENCY / DEGREES;
    }
}
