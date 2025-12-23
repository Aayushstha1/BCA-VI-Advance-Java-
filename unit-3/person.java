import java.io.Serializable;

public class person implements Serializable {
    private String name;
    private int age;

    public person() {
    }

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

   
}
