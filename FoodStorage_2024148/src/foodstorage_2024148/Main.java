package foodstorage_2024148;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner myKB = new Scanner(System.in);

        //Ask the user for the storage capacity
        System.out.println("Enter the storage capacity");
        int capacity = Integer.parseInt(myKB.nextLine());

        // Create the food storage
        FoodStorage storage = new FoodStorage(capacity);
        
        // Create the date format
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        boolean running = true;
        // Repeat the menu while the program is running
        while (running) {

            System.out.println("\n==============================");
            System.out.println("      FAST FOOD STORAGE");

            System.out.println("==============================");
            System.out.println("1. Add food");
            System.out.println("2. Display all food");
            System.out.println("3. Show first food");
            System.out.println("4. Remove food");
            System.out.println("5. Search food");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = Integer.parseInt(myKB.nextLine());

            switch (option) {

                case 1:

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
                    switch (choice) {
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
                            break;
                    }

                    // Check if the selected food type is valid
                    if (choice < 1 || choice > 5) {
                        break;
                    }

                    // Save the selected food type
                    type = switch (choice) {
                        case 1 -> "Burger";
                        case 2 -> "Pizza";
                        case 3 -> "Fries";
                        case 4 -> "Sandwich";
                        default -> "Hotdog";
                    };

                    // Ask for the food name
                    System.out.println("Enter the food name: ");
                    String name = myKB.nextLine();

                    // Ask for the food weight
                    System.out.println("Enter the weight in grams: ");
                    double weight = Double.parseDouble(myKB.nextLine());

                    // Ask for the best before date
                    System.out.println("Enter the best-before date (dd/MM/yyyy): ");
                    String dateText = myKB.nextLine();

                    try {
                        LocalDate bestBefore
                                = LocalDate.parse(dateText, formatter);

                        // Check if the date is within the next two weeks
                        if (bestBefore.isBefore(LocalDate.now())
                                || bestBefore.isAfter(LocalDate.now().plusWeeks(2))) {

                            System.out.println(
                                    "The date must be between today and two weeks from today.");

                            break;
                        }

                        // Add the food item to the storage
                        storage.addFood(type, name, weight, bestBefore);

                        // Display the stored food item
                        System.out.println("\nFood added successfully!");
                        System.out.println("Added item: " + name);

                        // Display the stored food items
                        System.out.println("\nCurrent storage:");
                        storage.display();

                    } catch (DateTimeParseException e) {
                        System.out.println(
                                "Invalid date. Please use dd/MM/yyyy.");
                    }
                    break;

                case 2:
                    // Display all food items
                    storage.display();
                    break;

                case 3:
                    // Show the first food item
                    storage.peek();
                    break;

                case 4:
                    // Remove the first food item
                    storage.removeFromFront();
                    break;

                case 5:
                    // Search for a food item
                    System.out.print("Enter the food name to search: ");
                    String searchName = myKB.nextLine();
                    storage.search(searchName);
                    break;

                case 6:
                    // Stop the menu
                    running = false;
                    System.out.println("Program closed.");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;

            } // End of switch

        // Wait before showing the menu again
        if (running) {
            System.out.println("\nPress Enter to return to the menu...");
            myKB.nextLine();
        }

    } // End of while

    myKB.close();
    }
}