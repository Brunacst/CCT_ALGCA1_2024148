
package foodstorage_2024148;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Main {
    
    public static void main (String[] args){
        
        Scanner myKB = new Scanner(System.in);
        
        //Ask the user for the storage capacity
        System.out.println("Enter the storage capacity");
        int capacity = Integer.parseInt(myKB.nextLine());
        
        // Create the food storage
        FoodStorage storage = new FoodStorage(capacity);
        
        // Create the date format
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Ask for the food type
        System.out.println("\nChoose the food type:");
        System.out.println("1. Burger");
        System.out.println("2. Pizza");
        System.out.println("3. Fries");
        System.out.println("4. Sandwich");
        System.out.println("5. Hotdog");
        System.out.print("Your choice: ");

        int choice = Integer.parseInt(myKB.nextLine());
        
        String type;
        
        //Save the selected food type
        switch (choice){
            case 1:
                type = "Burger";
                break;
            case 2:
                type = "Pizza";
                break;
            case 3:
                type = "Fries";
                break;
            case 4:    
                type = "Sandwich";
                break;
            case 5:    
                type = "Hotdog";
                break;
            default:
                    System.out.println("Invalid Food Type");
                    myKB.close();
                    return;
        }
      
        // Ask for the food name
        System.out.println("Enter the food name: ");
        String name = myKB.nextLine();
       
        
        // Ask for the food weight
        System.out.println("Enter the weight in grams: ");
        double weight = Double.parseDouble (myKB.nextLine());
        
        // Ask for the best before date
        System.out.println("Enter the best-before date (dd/MM/yyyy): ");
        String dateText = myKB.nextLine();
        
        try{
            LocalDate bestBefore =
                    LocalDate.parse(dateText, formatter);

            // Check if the date is within the next two weeks
            if (bestBefore.isBefore(LocalDate.now())
                    || bestBefore.isAfter(LocalDate.now().plusWeeks(2))) {

                System.out.println(
                        "The date must be between today and two weeks from today.");
                              
        myKB.close();
        return;
        }
               
    
        // Add the food item to the storage
            storage.addFood(type, name, weight, bestBefore);

            // Display the stored food item
            System.out.println("\nCurrent storage:");
            storage.display();

        } catch (DateTimeParseException e) {
            System.out.println(
                    "Invalid date. Please use dd/MM/yyyy.");
        }
        myKB.close();
    }
}

