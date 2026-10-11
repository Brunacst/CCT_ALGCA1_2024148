
package foodstorage_2024148;

import java.util.Scanner;


public class Main {
    
    public static void main (String[] args){
        
        Scanner myKB = new Scanner(System.in);
        
        //Ask the user for the storage capacity
        System.out.println("Enter the storage capacity");
        
        int capacity = myKB.nextInt();
        
        // Create the food storage
        FoodStorage storage = new FoodStorage(capacity);
        
        System.out.println("Storage created successfully =) ");
        System.out.println("Capacity: "+ capacity);
        
        myKB.close();
    }
    
}
