
package foodstorage_2024148;

// This class stores the food information

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FoodStorage {

    private String[] foodTypes;
    private String[] foodNames;
    private double[] foodWeights;
    private LocalDate[] bestBeforeDates;
    private LocalDateTime[] timeAdded;
    
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    //Create tje storage with the capacity entered by the user
    public FoodStorage(int capacity){
        
        this.capacity = capacity;
        
        foodTypes = new String[capacity];
        foodNames = new String[capacity];
        foodWeights = new double[capacity];
        bestBeforeDates = new LocalDate[capacity];
        timeAdded = new LocalDateTime[capacity]; 
        
        front = 0;
        rear = -1;
        size =0;
    }
    
    // Check if the storage is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Check if the storage is full
    public boolean isFull() {
        return size == capacity;
    }
    // Add a food item to the queue
    public void addFood(String type, String name, double weight,LocalDate bestBefore) {

        if (isFull()) {
            System.out.println("Storage is full!");
            return;
        }
        
        rear = (rear+1)%capacity;
        
        foodTypes[rear] = type;
        foodNames[rear] = name;
        foodWeights[rear] = weight;
        bestBeforeDates [rear] = bestBefore;
        timeAdded [rear] = LocalDateTime.now();
        
        size++;
        
        System.out.println(name+ "added succesfully.");
    }
    
    //Remove a food item from the front
    public void removeFromFront(){
        
        if(isEmpty()){
            System.out.println("Storage is empty!");
            return;
        }
        
        System.out.println(foodNames[front]+"removed");
        
        front = (front +1) % capacity;
        size--;
    }
    
    //Remove a food item from the back
    public void removeFromBack(){
        
        if (isEmpty){
            System.out.println("Storage is empty!");
            return;
        }
        
        System.out.println(foodNames[rear] + "removed.");
        
        rear = (rear - 1 + capacity) % capacity;
        size--;
    }
    
    //Show the food item at the front
    public void peek(){
        
         if (isEmpty){
            System.out.println("Storage is empty!");
            return;
    }
         
         displayFood(front);
}
    // Display all food items
    public void display(){
        
         if (isEmpty){
            System.out.println("Storage is empty!");
            return;
         }
         
         for (int i=0; i < size; i++){
             int index = (front + i) % capacity;
             displayFood(index);
         }
    }
    
    //Display the details of one food item
    private void displayFood (int index){
        
        System.out.println("-------------------");
        System.out.println("Type: " + foodTypes[index]);
        System.out.println("Name: " + foodNames[index]);
        System.out.println("Weight: " + foodWeights[index]);
        System.out.println("Best Before: " + bestBeforeDates[index]);
        System.out.println("Time Added: " + timeAdded[index]);
    }
    
    //Search for a food item by its name
    public void search(String name){
        
         if (isEmpty()) {
            System.out.println("Storage is empty!");
            return;
        }
         
         boolean found = false;
         
         for(int i =0; i < size, i++){
             
             int index = (front + i) % capacity;
             
             if (foodNames[index].equalsIgnoreCase(name)) {
                displayFood(index);
                found = true;
            }
         }
         
         if (!found){
             System.out.println("Food item not found =/ ");
         }
    }
}
