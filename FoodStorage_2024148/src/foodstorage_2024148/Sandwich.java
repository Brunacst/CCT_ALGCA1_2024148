
package foodstorage_2024148;

import java.time.LocalDate;


public class Sandwich extends FoodItem{
    
       public Sandwich(String name, double weight, LocalDate bestBefore){
        super("Sandwich", name, weight, bestBefore);
    }
}
