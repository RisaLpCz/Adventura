package Belongings;

public class Item {
    private String name;
    private boolean usable;
    private boolean drinkable;
    private boolean eatable;

    public Item(String name) {
        this.name = name;
    }

    public String discription() {
        return "Item " + name + " is " + isUsable() + " and is " + isDrinkable() + " and is " + isEatable();
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public boolean isDrinkable() {
        return drinkable;
    }

    public void setDrinkable(boolean drinkable) {
        this.drinkable = drinkable;
    }

    public boolean isEatable() {
        return eatable;
    }

    public void setEatable(boolean eatable) {
        this.eatable = eatable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
