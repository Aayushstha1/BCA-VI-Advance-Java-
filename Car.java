import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

public class Car implements Serializable {
    private String name ;
    private PropertyChabgeSupport  pcs = PropertyChangeSupport(this);
    public car(){}
    public Car (String name){
        this.name=name;

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        String oldName = this.name;
        this.name = name;
        pcs.firePropertyChange("name", oldName, name);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }
    
}

class Main{
    public static void main(String[] args) {
        Car c = new Car("Ferrari");
        c.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void PropertyChange (PropertyChangeEvent e ){
                System.out.println("Property" + e.getPropertyName() + "change form" +
            e.getOldValue() + "to" + e.getNewValue());
            }
        });
        c.setName("BMW");
    }
}