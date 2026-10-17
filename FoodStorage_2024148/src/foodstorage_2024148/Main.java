package foodstorage_2024148;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    // The chef can choose a capacity from 1 to 10
    private static final int MAX_CAPACITY = 10;
    private static final String[] FOOD_TYPES = {"Burger", "Pizza", "Fries", "Sandwich", "Hotdog"};

    public static void main(String[] args) { // My Entrypoint
        Scanner myKB = new Scanner(System.in);

        // Keep showing the first menu until the chef exits
        while (true) {
            System.out.println("\n================================");
            System.out.println("     FOOD STORAGE SYSTEM");
            System.out.println("================================");
            System.out.println("\nChoose your storage system today:");
            System.out.println("1. Stack (LIFO): Add and Remove Food From The Same End");
            System.out.println("2. Circular Queue (FIFO): Add at One End and Remove From the Other End");
            System.out.println("3. Exit");
            
            // Only accepts options from 1 to 3
            int choice = InputValidator.readInt(myKB, "Choose an option: ", 1, 3);
            if (choice == 3) {
                break;
            }

            // Ask how many food items the storage can hold
            int capacity = InputValidator.readInt(myKB, "Choose capacity (1-10): ", 1, MAX_CAPACITY);


            // Create the selected storage system with the chosen capacity
            // Choice == 1(true) para Stack option // if false = Circular Queue option
            FoodStorage storage = new FoodStorage(choice == 1, capacity);


            // If this returns false, the chef chose to exit the application
            if (!runStorageMenu(myKB, storage)) {
                break;
            }
        }

        System.out.println("Program closed.");
        myKB.close();
    }

    // Show the menu for the selected option, Stack or Queue
    private static boolean runStorageMenu(Scanner myKB, FoodStorage storage) {
        while (true) {
            System.out.println("\n===== FOOD STORAGE =====");
            System.out.println("Storage System: " + storage.getSystemName());
            System.out.println("Capacity: " + storage.size() + "/" + storage.getCapacity());

            if (storage.isFull()) {
                System.out.println("Storage Status: FULL - No more food can be added!");
            } else {
                System.out.println("Storage Status: Available");
            }

            System.out.println("1. Add Food");
            System.out.println("2. Remove Food");
            System.out.println("3. Peek Top/Front Food");
            System.out.println("4. Display All Food");
            System.out.println("5. Search Food");
            System.out.println("6. Return to Storage System Menu");
            System.out.println("0. Exit Application");

            int option = InputValidator.readInt(myKB, "Choose an option: ", 0, 6);

            switch (option) {
                case 1:
                    addFood(myKB, storage);
                    break;
                case 2:
                    removeFood(storage);
                    break;
                case 3:
                    peekFood(storage);
                    break;
                case 4:
                    storage.display();
                    break;
                case 5:
                    // There is nothing to search if the storage is empty
                    if (storage.size() == 0) {
                        System.out.println("Storage is empty!");
                        break;
                    }
                    String name = InputValidator.readText(myKB, "Enter the food name to search: ");
                    storage.search(name);
                    break;
                case 6:
                    return true;  // Go back to the first menu
                case 0:
                    return false; // Exit the application
                default:
                    System.out.println("Invalid option.");
                    break;
            }

            // Wait so the chef can read the result before the menu returns
            System.out.println("\nPress Enter to continue =) ! ");
            myKB.nextLine();
        }
    }

    // Ask for food details and add the food item
    private static void addFood(Scanner myKB, FoodStorage storage) {
        if (storage.isFull()) {
            System.out.println("Storage is full. Remove an item first!");
            return;
        }

        System.out.println("\nChoose the food type:");
        for (int i = 0; i < FOOD_TYPES.length; i++) {
            System.out.println((i + 1) + ". " + FOOD_TYPES[i]);
        }

        int typeChoice = InputValidator.readInt(myKB, "Your choice: ", 1, FOOD_TYPES.length);
        String type = FOOD_TYPES[typeChoice - 1];

        String name = InputValidator.readText(myKB, "Enter the food name: ");
        double weight = InputValidator.readWeight(myKB);
        LocalDate bestBefore = InputValidator.readBestBeforeDate(myKB);

        FoodItem item = new FoodItem(type, name, weight, bestBefore);
        storage.add(item);
        System.out.println("Food added successfully.");

        if (storage.isFull()) {
            System.out.println("Storage is now full!");
        }
    }

    // Remove the next item according to the selected data structure
    private static void removeFood(FoodStorage storage) {
        FoodItem item = storage.remove();

        if (item == null) {
            System.out.println("Storage is empty.");
        } else {
            System.out.println("Removed food:");
            item.displayInfo();
        }
    }

    // Show the next item without removing it
    private static void peekFood(FoodStorage storage) {
        FoodItem item = storage.peek();

        if (item == null) {
            System.out.println("Storage is empty!");
        } else {
            item.displayInfo();
        }
    }
}