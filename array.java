// WAP to enter different number in arraylist  using user input. Also display the largest and smallest number from the arraylist . Also display  there index and interchange them. 

import java.util.ArrayList;
import java.util.Scanner;


public class array {
    public static void main (String[] args){
        ArrayList<Integer> al = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        
        System.out.println("Enter " + n + " numbers:");
        for(int i = 0; i < n; i++) {
            al.add(scanner.nextInt());


             int largest = al.get(0);
        int smallest = al.get(0);
        int largestIndex = 0;
        int smallestIndex = 0;
        
        for(int i = 1; i < al.size(); i++) {
            if(al.get(i) > largest) {
                largest = al.get(i);
                largestIndex = i;
            }
            if(al.get(i) < smallest) {
                smallest = al.get(i);
                smallestIndex = i;
            }
        }
        
        }





    }
    
}
