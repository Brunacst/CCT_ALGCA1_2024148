
package foodstorage_2024148;

import java.time.LocalDate;

public class Burger extends FoodItem{
    //Burger is a type of FoodItem
    public Burger(String name, double weight, LocalDate bestBefore){
        super("Burger",name, weight, bestBefore);
    }
}
