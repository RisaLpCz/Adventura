package Characters;

import Settings.SETTINGS;

public class Postava {
    private static String name;
    private static int money;
    private static int food;
    private static int drink;
    private static double drunkenness;

    public static void postava() {
        name = "Huby";
        money = SETTINGS.STARTING_MONEY;
        food = SETTINGS.MAX_FOOD;
        drink = SETTINGS.MAX_HYDRATION;
        drunkenness = 0;
    }

    public static String playerStete() {
        return "You have " + getMoney() + " crowns in your wallet " + "your hunger is " + getFood() + "/" + SETTINGS.MAX_FOOD + ", thirst " + getDrink() + "/" + SETTINGS.MAX_HYDRATION + ", drunkenness " + getDrunkenness();
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Postava.name = name;
    }

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        Postava.money = money;
    }

    public static int getFood() {
        return food;
    }

    public static void setFood(int food) {
        Postava.food = food;
    }

    public static int getDrink() {
        return drink;
    }

    public static void setDrink(int drink) {
        Postava.drink = drink;
    }

    public static double getDrunkenness() {
        return drunkenness;
    }

    public static void setDrunkenness(double drunkenness) {
        Postava.drunkenness = drunkenness;
    }
}
