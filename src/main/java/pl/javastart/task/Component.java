package pl.javastart.task;

public abstract class Component {
    protected String name;
    protected String producer;
    protected String serialNumber;

    public Component(String name, String producer, String serialNumber) {
        this.name = name;
        this.producer = producer;
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", serialNumber='" + serialNumber;
    }
}
