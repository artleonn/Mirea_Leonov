package computerstore;

public class Monitor {
    private double sizeInches;
    private String resolution;

    public Monitor(double sizeInches, String resolution) {
        this.sizeInches = sizeInches;
        this.resolution = resolution;
    }

    public double getSizeInches() {
        return sizeInches;
    }

    public String getResolution() {
        return resolution;
    }

    @Override
    public String toString() {
        return "Monitor{sizeInches=" + sizeInches + ", resolution='" + resolution + "'}";
    }
}
