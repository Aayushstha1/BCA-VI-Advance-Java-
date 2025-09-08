// class Customer{
//     private String name;
//     private boolean member;
//     private String memberType;
    
//     void setName(String name){
//         this.name = name;
//     }
//     String getName(){
//         return name;
//     }
//     void setMember(boolean member){
//         this.member = member;
//     }
//     boolean isMember(){
//         return member;
//     }
//     void setMemberType(String memberType){
//         this.memberType = memberType;
//     }
//     String getMemberType(){
//         return memberType;
//     }
// }

// class Discount{
//     static double getServiceDiscount(String getMemberType){
//         switch(getMemberType){
//             case "preminum":
//                 return 0.20;
//             case "gold":
//                 return 0.15;
//             case "silver":
//                 return 0.10;
//             default:
//                 return 0;
//         }
//     }
    
//     static double getProductDiscount(){
//         return 0.10;
//     }
// }

// class Visit {
//     private double serviceExpense, productExpense;
//     Customer c;
    
//     Visit(Customer c) {
//         this.c = c;
//     }
    
//     void setServiceExpense(double serviceExpense) {
//         this.serviceExpense = serviceExpense;
//     }
    
//     void setProductExpense(double productExpense) {
//         this.productExpense = productExpense;
//     }
    
//     double getServiceExpense() {
//         if(c.isMember()) {
//             return serviceExpense - (serviceExpense * Discount.getServiceDiscount(c.getMemberType()));
//         }
//         return serviceExpense;
//     }
    
//     double getProductExpense() {
//         if(c.isMember()) {
//             return productExpense - (productExpense * Discount.getProductDiscount());
//         }
//         return productExpense;
//     }
    
//     double getTotalExpense() {
//         return getServiceExpense() + getProductExpense();
//     }
// }

// public class day5 {
//     public static void main(String[] args) {
//         Customer customer = new Customer();
//         customer.setName("Ram");
//         customer.setMember(true);
//         customer.setMemberType("gold");
        
//         Visit visit = new Visit(customer);
//         visit.setServiceExpense(100);
//         visit.setProductExpense(50);
        
//         System.out.println("Customer Name: " + customer.getName()); 
//         System.out.println("Member Type: " + customer.getMemberType());
//         System.out.println("Service Expense: RS." + visit.getServiceExpense());
//         System.out.println("Product Expense: Rs." + visit.getProductExpense());
//         System.out.println("Total Expense: RS." + visit.getTotalExpense());
//     }
// }
import java.util.Scanner;

class Customer {
    private String name;
    private boolean member;
    private String memberType;
    
    void setName(String name) {
        this.name = name;
    }
    
    String getName() {
        return name;
    }
    
    void setMember(boolean member) {
        this.member = member;
    }
    
    boolean isMember() {
        return member;
    }
    
    void setMemberType(String memberType) {
        this.memberType = memberType;
    }
    
    String getMemberType() {
        return memberType;
    }
}

class Discount {
    static double getServiceDiscount(String getMemberType) {
        switch(getMemberType) {
            case "premium":
                return 0.20;
            case "gold":
                return 0.15;
            case "silver":
                return 0.10;
            default:
                return 0;
        }
    }
    
    static double getProductDiscount() {
        return 0.10;
    }
}

class Visit {
    private double serviceExpense, productExpense;
    Customer c;
    
    Visit(Customer c) {
        this.c = c;
    }
    
    void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }
    
    void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }
    
    double getServiceExpense() {
        if(c.isMember()) {
            return serviceExpense - (serviceExpense * Discount.getServiceDiscount(c.getMemberType()));
        }
        return serviceExpense;
    }
    
    double getProductExpense() {
        if(c.isMember()) {
            return productExpense - (productExpense * Discount.getProductDiscount());
        }
        return productExpense;
    }
    
    double getTotalExpense() {
        return getServiceExpense() + getProductExpense();
    }
}

public class day5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        
        System.out.print("Enter customer name: ");
        customer.setName(scanner.nextLine());
        
        System.out.print("Is customer a member (true/false)? ");
        customer.setMember(scanner.nextBoolean());
        
        if(customer.isMember()) {
            scanner.nextLine(); 
            System.out.print("Enter member type (premium/gold/silver): ");
            customer.setMemberType(scanner.nextLine().toLowerCase());
        }
        
        Visit visit = new Visit(customer);
        
        System.out.print("Enter service expense: Rs.");
        visit.setServiceExpense(scanner.nextDouble());
        
        System.out.print("Enter product expense: Rs.");
        visit.setProductExpense(scanner.nextDouble());
        
        System.out.println("\n----- Bill Details -----");
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Member Type: " + (customer.isMember() ? customer.getMemberType() : "Non-Member"));
        System.out.println("Service Expense: Rs." + visit.getServiceExpense());
        System.out.println("Product Expense: Rs." + visit.getProductExpense());
        System.out.println("Total Expense: Rs." + visit.getTotalExpense());
        
        scanner.close();
    }
}

