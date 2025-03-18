package Characters;

public class Nepritel {

    public String lose(Postava postava) {
        if (postava.getDrink() >= 5 && postava.getFood() <= 5) {
            return "You escaped the enenmy!";
        }
        return "You cannot escape!";
    }
}
