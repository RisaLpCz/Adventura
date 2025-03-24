import Settings.Controller;

public class Main {
    public static void main(String[] args) {
    Controller controller = new Controller();
    controller.incialization();
    controller.getSvet().loadMap();
    controller.getKonzole().start();
    }
}
