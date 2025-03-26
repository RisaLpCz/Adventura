package Belongings;

import Characters.Postava;
import Settings.Controller;

public class Item {
    private String name;
    private String description;
    private int drink;
    private int food;
    private int drunkenness;
    private int amount;
    private boolean useable;
    private boolean isMoney;

    public Item(String name, String description, int drink, int food, int drunkenness, boolean useable) {
        setName(name);
        setDescription(description);
        setDrink(drink);
        setFood(food);
        setDrunkenness(drunkenness);
        setUseable(useable);
    }

    public Item(int amount) {
        setName("Money");
        setDescription("adds some coins to your wallet");
        setAmount(amount);
        this.isMoney = true;
    }

    public Item(String name, String description, boolean useable) {
        setName(name);
        setDescription(description);
        setUseable(useable);
    }

    public void useItem(Item item) {
        Postava.setDrink(Postava.getDrink() + item.getDrink());
        Postava.setFood(Postava.getFood() + item.getFood());
        Postava.setDrunkenness(Postava.getDrunkenness() + item.getDrunkenness());
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
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
