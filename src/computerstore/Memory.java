package computerstore;

public class Memory {
    private int sizeGB;
    private String type;

    public Memory(int sizeGB, String type) {
        this.sizeGB = sizeGB;
        this.type = type;
    }

    public int getSizeGB() {
        return sizeGB;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Memory{sizeGB=" + sizeGB + ", type='" + type + "'}";
    }
}
