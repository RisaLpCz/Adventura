package Command;

import Characters.Hrac;
import Settings.Controller;
import World.Lokace;
import World.Svet;

/**
 * Třída Search implementuje příkaz pro prohledání aktuální lokace ve hře.
 * Umožňuje hráči najít předměty na jeho současné lokaci.
 *
 * @implements Command
 */
public class Search implements Command {

    private Controller controller;
    private Svet svet;
    private Lokace lokace;

    /**
     * Konstruktor třídy Search.
     * Inicializuje třídu Search a získává instanci Controller pro přístup k hernímu světu.
     *
     * @param controller Instance třídy Controller pro získání herního světa.
     */
    public Search(Controller controller) {
        this.controller = controller;
        this.svet = controller.getSvet();
    }

    /**
     * Provádí prohledání aktuální lokace hráče.
     * Pokud jsou na lokaci nějaké předměty, vrátí jejich seznam.
     * Pokud nejsou nalezeny žádné předměty, vrátí zprávu o jejich absenci.
     *
     * @return Zpráva o nalezených předmětech nebo o jejich absenci.
     */
    @Override
    public String execute() {
        lokace = svet.getCurrentPosition();
        if (!lokace.isSearched()) {
            lokace.addLocationItems(lokace);
            lokace.setSearched(true);
        }

        if (!lokace.getItems().isEmpty()) {
            return "Našel jste tyto předměty " + lokace.getItems();
        }
        return "Žádné předmety nalezeny";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
