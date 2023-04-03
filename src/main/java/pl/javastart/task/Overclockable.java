package pl.javastart.task;

public interface Overclockable {
    int CLOCKING_FREQUENCY = 100;

    void overclock(); // podkecanie o stałą ilość mhz

    void overclock(double amount);

    double computeMaxPossibleFrequency();
}