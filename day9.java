// wap to enter different numer in arraylist using user input.
//  also display the largest and smallest number from arraylist.also swap largest and smallect number
import java.util.ArrayList;
import java.util.Scanner;

 
public class day9 {
    public static void main(String[] args) {
        int c,size,min,max,temp,imax,imin;
        Scanner sc= new Scanner(System.in);
        ArrayList<Integer> arr=new ArrayList<>();
        System.out.println("how many number do you want: ");
        c=sc.nextInt();
        System.out.println("enter the number :");
        for(int i=1;i<=c;i++){
            arr.add(sc.nextInt());
        }
        System.out.println(arr);

        imax=0;
        imin=0;
        max=arr.get(0);
        min=arr.get(0);
        for(int a=1;a<=c-1;a++){
            if(arr.get(a)>max){
                max=arr.get(a);
                imax=a;
            }
            if(arr.get(a)<min){
                min=arr.get(a);
                imin=a;
            }

        }
        
        System.out.println("largest number is : "+max+" .at index: "+imax);
        System.out.println("Smallest number is : "+min+" .at index: "+imin);

        System.out.println("--------------------after swaping----------------");
        arr.set(imax,min);
        arr.set(imin,max);
        for (int i = 0; i <= arr.size()-1; i++) {
            System.out.println(arr.get(i));
            
        }
        // temp=max;
        // max=min;
        // min=temp;
        // System.out.println("largest number is : "+max);
        // System.out.println("Smallest number is : "+min);


    }
   
    
}