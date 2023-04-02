package pl.javastart.task;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OverclockingTest {
    private final Scanner scanner;
    private Computer computer;
    private static final int OVERCLOCK_PROCESSOR = 1;
    private static final int OVERCLOCK_MEMORY = 2;
    private static final int SHOW_COMPUTER_INFO = 3;
    private static final int EXIT = 4;

    public OverclockingTest() {
        Overclockable processor = new Processor("Core i5", "Intel", "12400F", 2500, 65, 95);
        Overclockable memory = new Memory("Fury Beast", "Kingston", "343434", 32, 3200, 60, 90);
        HardDrive hardDrive = new HardDrive("Segate Expansion Portable", "Segate", "980", 1000);
        this.computer = new Computer(processor, memory, hardDrive);;
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        OverclockingTest overclockingTest = new OverclockingTest();

        try {
            overclockingTest.start();
        } catch (IllegalArgumentException | OverclockException e) {
            System.err.println(e.getMessage());
        }
    }

    private void start() {
        boolean end = false;

        do {
            printMenu();
            int selectedOption = -1;
            try {
                selectedOption = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }

            switch (selectedOption) {
                case OVERCLOCK_PROCESSOR -> overclockBy(computer.getProcessor());
                case OVERCLOCK_MEMORY -> overclockBy(computer.getMemory());
                case SHOW_COMPUTER_INFO -> System.out.println(computer);
                case EXIT -> end = true;
                default -> System.err.println("Nieprawidłowa opcja\n");
            }
        } while (!end);
    }

    private void printMenu() {
        System.out.println("Wybierz jedną z opcji:");
        System.out.println(OVERCLOCK_PROCESSOR + " - Podkęcanie procesora");
        System.out.println(OVERCLOCK_MEMORY + " - Podkęcanie pamięci RAM");
        System.out.println(SHOW_COMPUTER_INFO + " - Informacje o komputerze");
        System.out.println(EXIT + " - Wyjście z programu");
    }

    private void overclockBy(Overclockable element) {
        System.out.println("O ile Mhz chcesz podkręcić: ");
        int amount = scanner.nextInt();
        element.overclock(amount);
    }
}