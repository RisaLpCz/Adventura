package Characters;

import Belongings.Inventar;

public class Hrac {
    private String name;
    private static Inventar inventar = new Inventar();

    public Hrac(String name) {
        this.name = name;
    }

    public void addMoney(Hrac hrac) {}

    public void removeMoney(Hrac hrac) {}

    public static Inventar getInventar() {
        return inventar;
    }
}
