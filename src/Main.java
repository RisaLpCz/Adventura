import Console.Konzole;

/**
 * @author Jáchym Tlučhoř
 *
 * Třída Main je hlavním vstupním bodem.
 * Spouští herní konzoli a zahajuje herní cyklus.
 */
public class Main {

    /**
     * Hlavní metoda programu.
     * Inicializuje třídu Konzole a spustí herní cyklus.
     *
     */
    public static void main(String[] args) {
        Konzole konzole = new Konzole();
        konzole.start();
    }
}
