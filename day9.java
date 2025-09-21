// wap to enter different numer in arraylist using user input.
//  also display the largest and smallest number from arraylist.also swap largest and smallect number
// import java.util.ArrayList;
// import java.util.Scanner;

 
// public class day9 {
//     public static void main(String[] args) {
//         int c,size,min,max,temp,imax,imin;
//         Scanner sc= new Scanner(System.in);
//         ArrayList<Integer> arr=new ArrayList<>();
//         System.out.println("how many number do you want: ");
//         c=sc.nextInt();
//         System.out.println("enter the number :");
//         for(int i=1;i<=c;i++){
//             arr.add(sc.nextInt());
//         }
//         System.out.println(arr);

//         imax=0;
//         imin=0;
//         max=arr.get(0);
//         min=arr.get(0);
//         for(int a=1;a<=c-1;a++){
//             if(arr.get(a)>max){
//                 max=arr.get(a);
//                 imax=a;
//             }
//             if(arr.get(a)<min){
//                 min=arr.get(a);
//                 imin=a;
//             }

//         }
        
//         System.out.println("largest number is : "+max+" .at index: "+imax);
//         System.out.println("Smallest number is : "+min+" .at index: "+imin);

//         System.out.println("--------------------after swaping----------------");
//         arr.set(imax,min);
//         arr.set(imin,max);
//         for (int i = 0; i <= arr.size()-1; i++) {
//             System.out.println(arr.get(i));
            
//         }
//         // temp=max;
//         // max=min;
//         // min=temp;
//         // System.out.println("largest number is : "+max);
//         // System.out.println("Smallest number is : "+min);


//     }
   
    
// }

import java.util.ArrayList;
import java.util.Scanner;

class NumberOperations {
    private int c, max, min, imin = 0, imax = 0;
    private ArrayList<Integer> al = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    void input() {
        System.out.println("How many numbers do you want to enter?");
        c = sc.nextInt();
        System.out.println("Enter numbers:");
        for(int i = 1; i <= c; i++) {
            al.add(sc.nextInt());
        }
    }

    void operation() {
        max = al.get(0);
        min = al.get(0);
        for(int i = 1; i < al.size(); i++) {
            if(al.get(i) > max) {
                max = al.get(i);
                imax = i;
            }
            if(al.get(i) < min) {
                min = al.get(i);
                imin = i;
            }
        }
        System.out.println("Largest number is: " + max + " at index: " + imax);
        System.out.println("Smallest number is: " + min + " at index: " + imin);
    }

    void swap() {
        int temp = al.get(imax);
        al.set(imax, al.get(imin));
        al.set(imin, temp);
        System.out.println("\nAfter swapping largest and smallest numbers:");
    }

    void display() {
        System.out.println("Numbers in ArrayList:");
        for(int num : al) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

public class day9 {
    public static void main(String[] args) {
        NumberOperations obj = new NumberOperations();
        
        obj.input();
        System.out.println("\nOriginal Array:");
        obj.display();
        
        obj.operation();
        
        obj.swap();
        obj.display();
    }
}