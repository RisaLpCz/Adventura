package Settings;

import Characters.Hrac;
import Characters.Postava;
import World.Svet;

import java.util.Scanner;

/**
 * Třída Controller je zodpovědná za inicializaci a správu hlavních herních objektů,
 * včetně hráče, nepřítele, světa a inventáře. Také umožňuje interakci mezi těmito objekty
 * a připravuje prostředí pro běh hry.
 */
public class Controller {

    Scanner scan = new Scanner(System.in);

    private Hrac hrac;
    private Svet svet;
    private Statistics stats;

    /**
     * Konstruktor třídy Controller.
     * Vytváří nové instance hráče, nepřítele a světa.
     */
    public Controller() {
    }

    /**
     * Inicializuje hru, vytváří objekty hráče, statistiky, světa a nastavuje počáteční stav.
     */
    public void incialization() {
        hrac = new Hrac(scan.nextLine());
        svet = new Svet();
        stats = new Statistics();
        Postava.postava();
    }

    public Svet getSvet() {
        return svet;
    }

    public Statistics getStats() {
        if (stats == null) {
            System.out.println("KURVA NEGR!!");
        }
        return stats;
    }
}
