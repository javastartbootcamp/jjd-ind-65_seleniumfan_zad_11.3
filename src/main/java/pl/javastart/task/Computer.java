package pl.javastart.task;

import java.util.Objects;

public class Computer {
    private Overclockable processor;
    private Overclockable memory;
    private HardDrive hardDrive;

    public Computer(Overclockable processor, Overclockable memory, HardDrive hardDrive) {
        if (Objects.isNull(processor) || Objects.isNull(memory) || Objects.isNull(hardDrive)) {
            throw new NullPointerException("Komputer musi posiadać procesor, pamięc i dysk twardy");
        }

        this.processor = processor;
        this.memory = memory;
        this.hardDrive = hardDrive;
    }

    public Overclockable getProcessor() {
        return processor;
    }

    public void setProcessor(Overclockable processor) {
        this.processor = processor;
    }

    public Overclockable getMemory() {
        return memory;
    }

    public void setMemory(Overclockable memory) {
        this.memory = memory;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }

    @Override
    public String toString() {
        return "processor=" + processor +
                ", \nmemory=" + memory +
                ", \nhardDrive=" + hardDrive + '\n';
    }
}
