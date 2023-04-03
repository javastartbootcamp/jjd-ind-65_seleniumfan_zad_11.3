package pl.javastart.task;

public class Memory extends OverclockableComponent implements Overclockable {
    private int amount;
    private static final int DEGREES = 15;

    public Memory(String name, String producer, String serialNumber, int clocking, double temperature, double maxSafeTemperature, int amount) {
        super(name, producer, serialNumber, clocking, temperature, maxSafeTemperature);
        this.amount = amount;
    }

    @Override
    public String getComponentType() {
        return "Pamięć";
    }

    @Override
    public int getTemperatureIncrease() {
        return DEGREES;
    }

    @Override
    public String toString() {
        return "{" +
                super.toString() +
                ", amount=" + amount +
                '}';
    }
}
