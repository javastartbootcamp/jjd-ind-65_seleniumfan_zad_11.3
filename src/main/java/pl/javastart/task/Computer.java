package pl.javastart.task;

import java.util.Objects;

public class Computer {
    private OverclockableComponent processor;
    private OverclockableComponent memory;
    private HardDrive hardDrive;

    public Computer(OverclockableComponent processor, OverclockableComponent memory, HardDrive hardDrive) {
        if (Objects.isNull(processor) || Objects.isNull(memory) || Objects.isNull(hardDrive)) {
            throw new NullPointerException("Komputer musi posiadać procesor, pamięc i dysk twardy");
        }

        this.processor = processor;
        this.memory = memory;
        this.hardDrive = hardDrive;
    }

    public OverclockableComponent getProcessor() {
        return processor;
    }

    public void setProcessor(OverclockableComponent processor) {
        this.processor = processor;
    }

    public OverclockableComponent getMemory() {
        return memory;
    }

    public void setMemory(OverclockableComponent memory) {
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
