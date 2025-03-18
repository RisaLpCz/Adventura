package Characters;

import Belongings.Inventar;

public class Hrac {
    private String name;
    private Inventar inventar;

    public Hrac(String name) {
        this.name = name;
        this.inventar = new Inventar();
    }

    public void heal(Hrac hrac) {}

    public void addMoney(Hrac hrac) {}

    public void removeMoney(Hrac hrac) {}

    public Inventar getInventar() {
        return inventar;
    }
}
