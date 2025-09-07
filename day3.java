// create a class person which has 3 data members name , age and address. create seete and getter methods to set and get data members . derive a  class student from a person class which has a data member roll no. create setter and getter to set and get rollno . Now create a oject in main method and set all the details of student. expect set rollno only if students age is greater than or equal to 16 . Also, display all the details of student

import java.util.Scanner;

class person{
    private String name , address;
    private int age ;
    void setAll(String name, String address, int age ) {
        this.name= name ;
        this.address= address;
        this.age = age;
    }
    String getName(){
        return name;
    }
    String getaddress(){
        return address;
    }

    int getage (){
        return age ;
    }
}



class Student extends person {
    private int rollno;
    
    public void setRollNo(int rollno) {
        this.rollno = rollno;
        System.out.println("Roll no set successfully");
    }
    
    public int getRollNo() {
        return rollno;
    }
    // public void displayDetails(){
    //     System.out.println("\n Student Details ");
    //     System.out.println("Name: " + getName());
    //     System.out.println("Address: "+ getaddress());
    //     System.out.println("Age: "+ getage());
    //     if(getage <= 16){
    //         System.out.println("Roll no " + getRollNo);
    //     }

    // }

}
public class day3 {
     public static void main(String[] args) {
        Student s = new Student();
        String name, address;
        int age, roll; 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the name ");
        name = sc.next();
        System.out.println("Enter the age :");
        age = sc.nextInt();
        System.out.println("Enter the address:");
        address = sc.next();
        s.setAll(name, address, age);
        
        if(s.getage() >= 16) {
            System.out.println("Enter roll number: ");
            roll = sc.nextInt();
            s.setRollNo(roll);
        } else {
            System.out.println("Age must be 16 or above.. Cannot set roll number");
        }
        
        System.out.println("Name: " + s.getName());
        System.out.println("Address: " + s.getaddress());
        System.out.println("Age: " + s.getage());
        System.out.println("Roll no: " + s.getRollNo()); 
        
        sc.close();
     }
}
