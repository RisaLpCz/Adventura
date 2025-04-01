package Belongings;

import Characters.Hrac;
import Characters.Postava;
import Settings.Controller;

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
        setName("Money");
        setDescription("Adds some coins to your wallet");
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
        Postava.setDrink(Postava.getDrink() + item.getDrink());
        Postava.setFood(Postava.getFood() + item.getFood());
        Postava.setDrunkenness(Postava.getDrunkenness() + item.getDrunkenness());
        Hrac.getInventar().removeItem(item);
    }

    // Gettery a settery

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