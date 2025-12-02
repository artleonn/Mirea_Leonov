package computerstore;

public class Processor {
    private String model;
    private double speedGHz;

    public Processor(String model, double speedGHz) {
        this.model = model;
        this.speedGHz = speedGHz;
    }

    public String getModel() {
        return model;
    }

    public double getSpeedGHz() {
        return speedGHz;
    }

    @Override
    public String toString() {
        return "Processor{model='" + model + "', speedGHz=" + speedGHz + "}";
    }
}
