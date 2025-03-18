import Console.Konzole;
import World.Svet;

public class Main {
    public static void main(String[] args) {
    Svet svet = new Svet();
    svet.loadMap();
        Konzole konzole = new Konzole();
        konzole.start();
    }
}
