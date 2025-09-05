// // import java.util.scanner;

// // class sum {
// //     private int a, b , result;
// //     void add (){
// //         Scanner sc = new scanner(System.in);
// //         System.out.println("Enter two number");
// //         a = sc.nextInt();
// //         b = sc.nextInt();
// //         result = a + b;
// //         System.out.println("sum is :"+result);


// //     }
// // }

// // class Arthmetic extends sum{
    



// // }

// // public class Test{
// //     public static  void main (string [] args) {
// //         Arthmetic s1 = new Arthmetic();
// //         s1.add();
// //     }
// // }


// import java.util.Scanner;

// class Sum {
//     private int a, b, result;
//     void add() {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter two numbers:");
//         a = sc.nextInt();
//         b = sc.nextInt();
//         result = a + b;
//         System.out.println("Sum is: " + result);
//         sc.close();
//     }
// }

// class Arithmetic extends Sum {
//     @Override
//     void add() {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter three numbers:");
//         int x = sc.nextInt();
//         int y = sc.nextInt();
//         int z = sc.nextInt();
//         int sum = x + y + z;
//         System.out.println("Sum of three numbers is: " + sum);
//         sc.close();
//     }

//     void subtract() {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter two numbers:");
//         int x = sc.nextInt();
//         int y = sc.nextInt();
//         int diff = x - y;
//         System.out.println("Difference is: " + diff);
//         sc.close();
//     }
    
//     void multiply(int a , int b) {
        
//     }
//     void Divide ( int a , int b ) {
//         result = a/b;
//         System.out.println("div is " + result);
       
//     }
// }

// public class day1 {
//     public static void main(String[] args) {
//         Arithmetic s1 = new Arithmetic();
//         s1.add();
//         s1.subtract();
//         s1.multiply();
//         s1.Divide();
//     }
// }



// Improve above code to take inputes from main functions

import java.util.Scanner;

class Sum {
    protected int result;  // Changed to protected for inheritance
    
    void add(int a, int b) {
        result = a + b;
        System.out.println("Sum is: " + result);
    }
}

class Arithmetic extends Sum {
    @Override
    void add(int a, int b) {
        super.add(a, b);
    }
    
    // Method overloading for three numbers
    void add(int a, int b, int c) {
        result = a + b + c;
        System.out.println("Sum of three numbers is: " + result);
    }

    void subtract(int a, int b) {
        result = a - b;
        System.out.println("Difference is: " + result);
    }
    
    void multiply(int a, int b) {
        result = a * b;
        System.out.println("Product is: " + result);
    }
    
    void divide(int a, int b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero!");
            return;
        }
        double divResult = (double)a / b;
        System.out.println("Division is: " + divResult);
    }
}

public class day1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arithmetic s1 = new Arithmetic();
        
        System.out.println("Enter three numbers for addition:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        s1.add(num1, num2, num3);
        
        System.out.println("\nEnter two numbers for other operations:");
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        System.out.println("\nPerforming operations:");
        s1.add(x, y);        // Two number addition
        s1.subtract(x, y);
        s1.multiply(x, y);
        s1.divide(x, y);
        
        sc.close();
    }
}


