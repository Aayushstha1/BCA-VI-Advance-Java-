package MVC;

public class User {
    private String un;
    private String ps;

    public User() {
        this.un = "";
        this.ps = "";
    }

    public User(String username, String password) {
        this.un = username;
        this.ps = password;
    }

    public String getUsername() {
        return un;
    }

    public String getPassword() {
        return ps;
    }

    public void setUsername(String username) {
        this.un = username;
    }

    public void setPassword(String password) {
        this.ps = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + un + '\'' +
                ", password='" + ps + '\'' +
                '}';
    }
}
