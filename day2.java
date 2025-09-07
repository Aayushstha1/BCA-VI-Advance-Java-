import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printDetails() {
        System.out.println("\nBook Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: Rs." + price);
        System.out.println("----------------------");
    }
}

public class day2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input for first book
        System.out.println("Enter details for Book 1:");
        System.out.print("Enter title: ");
        String title1 = sc.nextLine();
        System.out.print("Enter author: ");
        String author1 = sc.nextLine();
        System.out.print("Enter price: ");
        float price1 = sc.nextFloat();
        
        sc.nextLine(); 
        
         System.out.println("\nEnter details for Book 2:");
        System.out.print("Enter title: ");
        String title2 = sc.nextLine();
        System.out.print("Enter author: ");
        String author2 = sc.nextLine();
        System.out.print("Enter price: ");
        float price2 = sc.nextFloat();

        Book book1 = new Book(title1, author1, price1);
        Book book2 = new Book(title2, author2, price2);

        book1.printDetails();
        book2.printDetails();

        sc.close();
    }
}