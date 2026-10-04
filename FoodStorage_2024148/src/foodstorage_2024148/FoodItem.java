package foodstorage_2024148;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author bruna
 */
public class FoodItem {
    
    // All info needed for food items
    private String type;
    private String name;
    private double weight;
    private LocalDate bestBefore;
    private LocalDateTime timeAdded;
    
    //Constructor: to create a new Food item object and initialises the attributes
    public FoodItem(String type, String name, double weight, LocalDate bestBefore){
        this.type =type; // stores the food type for exemple "hot dog", in the object's type attribute
        this.name=name; // stores the name of the food for exemple "Vegan hot dog", in the object's name attribute
        this.weight=weight; // stores the food weight in kilograms, in the object's weight attribute
        this.bestBefore=bestBefore; // stores the food Best before date, in the object's bestBefore attribute
        
        // Saving the current date and time
        this.timeAdded = LocalDateTime.now();
    }
            
    //Get the food name
    public String getName(){
        return name;
    }
    
    //Get the food weight
    public double getWeight(){
        return weight;
    }
    //Get the best before date
    public LocalDate getBestBefore(){
        return bestBefore;
    }
        //Get the time when the food was added
    public LocalDateTime getTimeAdded(){
        return timeAdded;
    }
    
    //Method to display the food information
    public void displayInfo(){
            System.out.println("Food name:" +name);    
            System.out.println("Weight:" +weight); 
            System.out.println("Best Before:" +bestBefore); 
            System.out.println("Time Added:" +timeAdded); 
    }
}
