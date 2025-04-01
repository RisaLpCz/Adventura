package Settings;

import Belongings.Inventar;
import Belongings.ItemRegister;
import Characters.Hrac;
import Characters.Nepritel;
import Characters.Postava;
import Console.Konzole;
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
    private Nepritel nepritel;
    private Svet svet;

    /**
     * Konstruktor třídy Controller.
     * Vytváří nové instance hráče, nepřítele a světa.
     */
    public Controller() {
    }

    /**
     * Inicializuje hru, vytváří objekty hráče, nepřítele, světa a nastavuje počáteční stav.
     */
    public void incialization() {
        hrac = new Hrac(scan.nextLine());
        nepritel = new Nepritel();
        svet = new Svet();
        Postava.postava();
    }

    public Hrac getHrac() {
        return hrac;
    }

    public Nepritel getNepritel() {
        return nepritel;
    }

    public Svet getSvet() {
        return svet;
    }
}
