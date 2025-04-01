package Characters;

import Belongings.Inventar;

/**
 * Reprezentuje hráče ve hře. Každý hráč má své jméno a inventář.
 */
public class Hrac {
    private String name;
    private static Inventar inventar = new Inventar();

    /**
     * Vytvoří nového hráče se zadaným jménem.
     *
     * @param name Jméno hráče.
     */
    public Hrac(String name) {
        this.name = name;
    }


    public static Inventar getInventar() {
        return inventar;
    }
}