// you are asked to write a discount system for a beauty salon, which provides services and sell beauty product.
//it offers 3 types of memberships: premium, gold and silver. premium, gold and silver member receive a discount of 20%,15% and 10%, respectively for all services provided.Customer without member  recive no discount.
// All members recive a flat 10% discount discount on the product purchased(this might change in future).
// your system shall consist of three classes: customer, discount and vist.
// it shall compute the total bill if a customer purchase $x of products and $y of services for a visit
// also write a test program to exercise all the class


/* You are asked to write a discount system for a beauty salon, which provides services and sells beauty products. 
   It offers 3 types of memberships: Premium, Gold and Silver. Premium, gold and silver members receive a discount of 20%, 
   15%, and 10%, respectively, for all services provided. Customers without membership receive no discount. 
   All members receive a flat 10% discount on products purchased (this might change in future). 
   Your system shall consist of three classes: Customer, Discount and Visit. 
   It shall compute the total bill if a customer purchase $x of products and $y of services, for a visit. 
   Also write a test program to exercise all the classes.*/

import java.lang.reflect.Member;
import java.util.Scanner;

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


class Discount {
    static double getServiceDiscount(String getMemberType) {
        switch(getMemberType.toLowerCase()) {  
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
            return serviceExpense * (1 - Discount.getServiceDiscount(c.getMemberType()));
        }
        return serviceExpense;
    }
    
    double getProductExpense() {
        if(c.isMember()) {
            return productExpense * (1 - Discount.getProductDiscount());
        }
        return productExpense;
    }
    
    double getTotalExpense() {
        return getServiceExpense() + getProductExpense();
    }
}

public class MyDiscount {

 public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Customer customer = new Customer();

    System.out.println( "Enter the customer name:");
    customer.setName(scanner.nextLine());

    System.out.println("Is the customer a member (true/false)?");
    customer.setMember(scanner.nextBoolean());

    if(customer.isMember()){
        scanner.nextLine();
        System.out.print("Enter member type (premium/gold/silver): ");
        System.out.println(scanner.nextLine().toLowerCase());
    }
    Visit visit = new Visit(customer);
    System.out.println("Enter the Services Expense: Rs.");
    visit.setServiceExpense(scanner.nextDouble());
    
    System.out.println("Enter the Product Expense: Rs");
    visit.setProductExpense(scanner.nextDouble());

    System.out.println("Customer Name: " + customer.getName());
    System.out.println("Member Type: " +(customer.isMember()? customer.getMemberType() : "Non-member" ) );
    System.out.println("Service Expense: Rs" + visit.getServiceExpense() );
    System.out.println("Product Expense: Rs" + visit.getProductExpense() );
    System.out.println("Total Expense: Rs" + visit.getTotalExpense());
    scanner.close();


 }

}

//         Scanner scanner = new Scanner(System.in);
//         Customer customer = new Customer();
        
//         System.out.print("Enter customer name: ");
//         customer.setName(scanner.nextLine());
        
//         System.out.print("Is customer a member (true/false)? ");
//         customer.setMember(scanner.nextBoolean());
        
//         if(customer.isMember()) {
//             scanner.nextLine(); 
//             System.out.print("Enter member type (premium/gold/silver): ");
//             customer.setMemberType(scanner.nextLine().toLowerCase());
//         }
        
//         Visit visit = new Visit(customer);
        
//         System.out.print("Enter service expense: Rs.");
//         visit.setServiceExpense(scanner.nextDouble());
        
//         System.out.print("Enter product expense: Rs.");
//         visit.setProductExpense(scanner.nextDouble());
        
//         System.out.println("\n----- Bill Details -----");
//         System.out.println("Customer Name: " + customer.getName());
//         System.out.println("Member Type: " + (customer.isMember() ? customer.getMemberType() : "Non-Member"));
//         System.out.println("Service Expense: Rs." + visit.getServiceExpense());
//         System.out.println("Product Expense: Rs." + visit.getProductExpense());
//         System.out.println("Total Expense: Rs." + visit.getTotalExpense());
        
//         scanner.close();
//     }
// }











    // public static void main(String[] args) {
    //     Customer premiumCustomer = new Customer();
    //     premiumCustomer.setName("Aayush");
    //     premiumCustomer.setMember(true);
    //     premiumCustomer.setMemberType("premium");

    //     Customer regularCustomer = new Customer();
    //     regularCustomer.setName("hari");
    //     regularCustomer.setMember(false);
    //     regularCustomer.setMemberType("");

    //     Visit premiumVisit = new Visit(premiumCustomer);
    //     premiumVisit.setServiceExpense(100.0);
    //     premiumVisit.setProductExpense(50.0);

    //     Visit regularVisit = new Visit(regularCustomer);
    //     regularVisit.setServiceExpense(100.0);
    //     regularVisit.setProductExpense(50.0);

    //     System.out.println("Premium Member Bill Details:");
    //     System.out.println("Customer: " + premiumCustomer.getName());
    //     System.out.println("Service Expense: RS" + premiumVisit.getServiceExpense());
    //     System.out.println("Product Expense: Rs" + premiumVisit.getProductExpense());
    //     System.out.println("Total Bill: Rs" + premiumVisit.getTotalExpense());
    //     System.out.println();

    //     System.out.println("Regular Customer Bill Details:");
    //     System.out.println("Customer: " + regularCustomer.getName());
    //     System.out.println("Service Expense: RS" + regularVisit.getServiceExpense());
    //     System.out.println("Product Expense: RS" + regularVisit.getProductExpense());
    //     System.out.println("Total Bill: Rs" + regularVisit.getTotalExpense());
     

        
   

//     public void setServiceExpense(double expense) {
//         this.serviceExpense = expense;
//     }

//     public void setProductExpense(double expense) {
//         this.productExpense = expense;
//     }

//     public double getTotalBill() {
//         double serviceDiscount = discount.getServiceDiscount(customer.getMemberType());
//         double productDiscount = discount.getProductDiscount(customer.isMember());

//         double finalService = serviceExpense * (1 - serviceDiscount);
//         double finalProduct = productExpense * (1 - productDiscount);

//         return finalService + finalProduct;
//     }
// }

// public class day4 {
//     public static void main(String[] args) {
//         // Test the system
//        
