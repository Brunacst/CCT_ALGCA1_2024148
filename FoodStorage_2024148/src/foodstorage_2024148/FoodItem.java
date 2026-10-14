package foodstorage_2024148;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


// This class stores the information about one food item.
public class FoodItem {

    // Store the type of food, for example Burger or Pizza.
    private String type;

    // Store the name of the food item.
    private String name;

    // Store the weight of the food in grams.
    private double weight;

    // Store the best-before date of the food.
    private LocalDate bestBefore;

    // Store the date and time when the food was added.
    private LocalDateTime timeAdded;

    // Create a food item with its details.
    public FoodItem(String type, String name, double weight, LocalDate bestBefore) {
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;

        // Save the current date and time.
        this.timeAdded = LocalDateTime.now();
    }

    // Return the food type.
    public String getType() {
        return type;
    }

    // Return the food name.
    public String getName() {
        return name;
    }

    // Return the food weight.
    public double getWeight() {
        return weight;
    }

    // Return the best-before date.
    public LocalDate getBestBefore() {
        return bestBefore;
    }

    // Return the date and time when the food was added.
    public LocalDateTime getTimeAdded() {
        return timeAdded;
    }

    // Display all information about the food item.
    public void displayInfo() {
        System.out.println("------------------------------");
        System.out.println("Type: " + type);
        System.out.println("Name: " + name);
        System.out.println("Weight: " + weight + " g");
        System.out.println("Best Before: "+ bestBefore.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Time Added: " + timeAdded.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }
}