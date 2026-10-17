package foodstorage_2024148;

// A Stack follows LIFO: the last item added is the first one removed
public class FoodStack {

    // This array stores the food items
    private final FoodItem[] items;

    // This stores the position of the top item
    // -1 means the stack is empty
    private int top;

    // Create a stack with the capacity chosen by the user
    public FoodStack(int capacity) {
        items = new FoodItem[capacity];
        top = -1;
    }

    // Check if there are no food items
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if every space in the array is being used
    public boolean isFull() {
        return top == items.length - 1;
    }

    // Return the number of food items in the Stack
    public int size() {
        return top + 1;
    }

    // Add a food item to the top of the Stack
    // O(1): the item is added directly to the top
    public boolean push(FoodItem item) {
        if (isFull()) {
            return false; // There is no free space
        }

        top++;             // Move top to the next position
        items[top] = item; // Store the item at the new top
        return true;
    }

    // Remove and return the food item at the top
    // O(1): the top item is removed directly
    public FoodItem pop() {
        if (isEmpty()) {
            return null; // There is no item to remove
        }

        FoodItem item = items[top]; // Keep the item before removing it
        items[top] = null;          // Clear that array space
        top--;                      // Move top to the previous position
        return item;
    }

    // Show the item at the top without removing it
    // O(1): the top item is accessed directly
    public FoodItem peek() {
        if (isEmpty()) {
            return null; // There is no item to show.
        }

        return items[top];
    }

    // Show all food items, starting from the top
    // O(n): the method may visit every item
    public void display() {
        if (isEmpty()) {
            System.out.println("Storage is empty.");
            return;
        }

        // Start at the top and move down through the array
        for (int i = top; i >= 0; i--) {
            items[i].displayInfo();
        }
    }

    // Search for food items by name
    // O(n): the method may check every item
    public void search(String name) {
        boolean found = false;

        // Check each stored item, starting from the top
        for (int i = top; i >= 0; i--) {
            if (items[i].getName().equalsIgnoreCase(name)) {
                items[i].displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Food item not found with this name!");
        }
    }
}