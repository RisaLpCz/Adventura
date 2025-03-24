package Settings;

import Characters.Hrac;
import Characters.Nepritel;
import Characters.Postava;
import Console.Konzole;
import World.Svet;

import java.util.Scanner;

public class Controller {

    Scanner scan = new Scanner(System.in);

    Hrac hrac;
    Nepritel nepritel;
    Svet svet;
    Konzole konzole;

    public Controller() {
    }

    public void incialization() {
        hrac = new Hrac(scan.nextLine());
        nepritel = new Nepritel();
        svet = new Svet();
        konzole = new Konzole();
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

    public Konzole getKonzole() {
        return konzole;
    }
}
