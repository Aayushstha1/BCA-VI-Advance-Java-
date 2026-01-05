import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class Laptop {
    private String LName;
    private float price;
    private VetoableChangeSupport vcs = new VetoableChangeSupport(this);
    public Laptop(){}
    public Laptop(String name , float price){
        this.LName= name;
        this.price = price;

    }
    public String getName(){
        return LName;
    }
     public void setName(String name){
        return LName;
     }
     public float getPrice () {

        return price;
     }
     public void setPrice(float price) throws PropertyVetoException{
        float oldPrice = this.price;
        PropertyChangeEvent event = new PropertyChangeEvent(this, "price" , oldPrice ,  price);
        vcs.fireVetoableChange(event);
        this.price = price ; 
     }
     public void addVCL(VetoableChangeListener listener){
        vcs.addVetoableChangeListener(listener);
     }

}
class Main {
    public static void main(String[] args) {
        Laptop 1 = new Laptop ("Acer" , 70000);
        l.addVCL(new VetoableChangeListener() {
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                if("price".equals(getPropertyName())){
                    float newPrice = (float) e.getNewValue();
                    if(newPrice < 65000){
                        throw new PropertyVetoException("price cannot be less than 65000", e);
                    }
                }
                System.out.println(e.getPropertyName() + "changed from " + e.getOldValue() + "to" +e.getNewValue());
            }
        });
        try{
            l.setName("Aayush");
            l.setPrice(68000);
            l.setPrice(640000);

        }
        catch (PropertyVetoException e){
            System.out.println(e.getMessage());
        }
    }
}
