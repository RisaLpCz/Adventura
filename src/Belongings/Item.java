package Belongings;

import Characters.Hrac;
import Characters.Postava;
import Settings.Controller;
import Settings.SETTINGS;

/**
 * Reprezentuje předmět ve hře, který může mít různé vlastnosti, například
 * ovlivňovat hlad, žízeň nebo opilost postavy. Některé předměty mohou být použitelné,
 * jiné slouží jako měna.
 */
public class Item {
    private String name;
    private String description;
    private int drink;
    private int food;
    private int drunkenness;
    private int amount;
    private boolean useable;
    private boolean isMoney;

    /**
     * Vytvoří nový předmět s definovanými vlastnostmi.
     *
     * @param name Název předmětu.
     * @param description Popis předmětu.
     * @param drink Hodnota zvyšující žízeň postavy.
     * @param food Hodnota zvyšující hlad postavy.
     * @param drunkenness Hodnota zvyšující opilost postavy.
     * @param useable Určuje, zda je předmět použitelný.
     */
    public Item(String name, String description, int drink, int food, int drunkenness, boolean useable) {
        setName(name);
        setDescription(description);
        setDrink(drink);
        setFood(food);
        setDrunkenness(drunkenness);
        setUseable(useable);
    }

    /**
     * Vytvoří nový předmět představující peníze.
     *
     * @param amount Množství peněz.
     */
    public Item(int amount) {
        setName("Peníze");
        setDescription("Přidá obnost peněz do vaší peněženky");
        setAmount(amount);
        this.isMoney = true;
    }

    /**
     * Vytvoří nový předmět bez specifických vlastností jako jídlo nebo pití.
     *
     * @param name Název předmětu.
     * @param description Popis předmětu.
     * @param useable Určuje, zda je předmět použitelný.
     */
    public Item(String name, String description, boolean useable) {
        setName(name);
        setDescription(description);
        setUseable(useable);
    }

    /**
     * Použije daný předmět a aplikuje jeho efekty na postavu.
     * Po použití je předmět odstraněn z inventáře hráče.
     *
     * @param item Předmět k použití.
     */
    public void useItem(Item item) {
        int newDrink = Postava.getDrink() + item.getDrink();
        Postava.setDrink(Math.max(0, Math.min(SETTINGS.MAX_HYDRATION, newDrink)));

        int newFood = Postava.getFood() + item.getFood();
        Postava.setFood(Math.max(0, Math.min(SETTINGS.MAX_FOOD, newFood)));

        double newDrunkenness = Postava.getDrunkenness() + item.getDrunkenness();
        Postava.setDrunkenness(Math.max(0.0, newDrunkenness));

        Hrac.getInventar().removeItem(item);
    }



    public int getDrunkenness() {
        return drunkenness;
    }

    public void setDrunkenness(int drunkenness) {
        this.drunkenness = drunkenness;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getDrink() {
        return drink;
    }

    public void setDrink(int drink) {
        this.drink = drink;
    }

    public boolean isUseable() {
        return useable;
    }

    public void setUseable(boolean useable) {
        this.useable = useable;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isMoney() {
        return isMoney;
    }

    public void setMoney(boolean money) {
        isMoney = money;
    }

    @Override
    public String toString() {
        return  name;
    }
}