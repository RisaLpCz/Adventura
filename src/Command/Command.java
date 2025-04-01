package Command;

import java.io.IOException;

/**
 * Rozhraní pro příkazy ve hře.
 * Každý příkaz musí implementovat metodu execute a exit.
 */
public interface Command {
    /**
     * Spustí příkaz a vrátí výsledek jako řetězec.
     *
     * @return Výsledek provedení příkazu.
     * @throws IOException Pokud nastane chyba při vstupu/výstupu.
     */
    String execute() throws IOException;

    /**
     * Určuje, zda příkaz ukončuje běh aplikace.
     *
     * @return pokud příkaz ukončuje aplikaci.
     */
    boolean exit();
}