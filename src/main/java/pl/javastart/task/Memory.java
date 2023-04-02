package pl.javastart.task;

public class Memory extends Component implements Overclockable {
    private int amount;
    private int clocking;
    private double temperature;
    private double maxSafeTemperature;
    private static final int CLOCKING_FREQUENCY = 100;
    private static final int DEGREES = 15;

    public Memory(String name, String producer, String serialNumber, int amount, int clocking, double temperature, double maxSafeTemperature) {
        super(name, producer, serialNumber);
        this.amount = amount;
        this.clocking = clocking;
        this.temperature = temperature;
        this.maxSafeTemperature = maxSafeTemperature;
    }

    @Override
    public void overclock() { // podkręcanie o stałą ilość Mhz
        overclock(CLOCKING_FREQUENCY);
    }

    @Override
    public void overclock(double amount) {
        double increaseTemperature = DEGREES * amount / CLOCKING_FREQUENCY;
        double maxPossibleFrequency = computeMaxPossibleFrequency();

        if (temperature + increaseTemperature > maxSafeTemperature) {
            throw new OverclockException("Pamięć " + name, maxPossibleFrequency);
        }
        this.temperature += increaseTemperature;
        clocking += amount;
        System.out.println("Pamięć podkręcona o: " + amount + " Mhz " +
                "(Maksymalnie możesz podkęcić do: " + maxPossibleFrequency + " Mhz)");
    }

    @Override
    public String toString() {
        return "{" +
                "clocking=" + clocking +
                ", temperature=" + temperature +
                ", maxSafeTemperature=" + maxSafeTemperature +
                ", amount=" + amount +
                super.toString();
    }

    @Override
    public double computeMaxPossibleFrequency() {
        return clocking + (maxSafeTemperature - temperature) * CLOCKING_FREQUENCY / 15;
    }
}
