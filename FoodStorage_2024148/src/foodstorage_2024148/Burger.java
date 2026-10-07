
package foodstorage_2024148;

//Burger is a type of FoodItem

import java.time.LocalDate;

public class Burger extends FoodItem{
    
    public Burger(String name, double weight, LocalDate bestBefore){
        super("Burger",name, weight, bestBefore);
    }
}
