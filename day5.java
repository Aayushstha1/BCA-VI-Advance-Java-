
class Customer{
    private String name;
    private boolean member;
    private String memberType;
    
    void setName(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
    void setMember(boolean member){
        this.member = member;
    }
    boolean isMember(){
        return member;
    }
    void setMemberType(String memberType){
        this.memberType = memberType;
    }
    String getMemberType(){
        return memberType;
    }
}

class Discount{
    static double getServiceDiscount(String getMemberType){
        switch(getMemberType){
            case "preminum":
                return 0.20;
            case "gold":
                return 0.15;
            case "silver":
                return 0.10;
            default:
                return 0;
        }
    }
    
    static double getProductDiscount(){
        return 0.10;
    }
}

class Visit{
    private double serviceExpense, productExpense;
    Customer c;
    Visit(Customer c){
        this.c = c;
    }
    void setServiceExpense(double serviceExpense){
        this.serviceExpense = serviceExpense;
    }
    double getServiceExpense(){
        if(c.isMember()){
            return serviceExpense - Discount.getServiceDiscount(c.getMemberType());
        }
        else{
            return serviceExpense;
        }
    }
    
}

public class day5 {
    public static void main(String[] args){
        
    }
}