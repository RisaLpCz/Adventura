package Characters;

public class Postava {
    private String name = "Huby";
    private int money;
    private int food;
    private int drink;

    public Postava(String name, int money, int food, int drink) {
        this.name = name;
        this.money = money;
        this.food = food;
        this.drink = drink;
    }

    public void offer(Hrac hrac) {}

    public void give(Hrac hrac) {}

    public void buy(Hrac hrac) {}

    public void sell(Hrac hrac) {}

    public void lend(Hrac hrac) {}

    public void eat(Hrac hrac) {}

    public void drink(Hrac hrac) {}

    public void use(Hrac hrac) {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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
}
