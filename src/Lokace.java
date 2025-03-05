import java.util.Arrays;

public class Lokace {
    private String name;
    private int ID;
    private int[] locations;

    public Lokace(){
    }

    public Lokace(String name, int ID, String[] locations) {
        this.name = name;
        this.ID = ID;
        if (locations != null && locations.length > 0) {
            this.locations = new int[locations.length];
            for (int i = 0; i < locations.length; i++) {
                this.locations[i] = Integer.parseInt(locations[i]);
            }
        } else {
            this.locations = new int[0];
        }
    }

    @Override
    public String toString() {
        return "Lokace{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", locations=" + Arrays.toString(locations) +
                '}';
    }

    public int[] getLocations() {
        return locations;
    }
}
