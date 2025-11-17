package MVC;

public class Main {
    public static void main(String[] args) {
        User u = new User("", "");
        View v = new View();
        Controller c = new Controller(u, v);
        v.setVisible(true);
    }
}
