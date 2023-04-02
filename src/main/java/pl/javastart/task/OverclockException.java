package pl.javastart.task;

public class OverclockException extends RuntimeException {
    public OverclockException(String componentName, double maxPossibleFrequency) {
        super(componentName + ": niebezpieczeństwo spalenia. Brak możliwości podkręcenia. Maks. możesz podkręcić do: " + maxPossibleFrequency + " Mhz");
    }
}
