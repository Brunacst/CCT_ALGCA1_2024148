package foodstorage_2024148;

// This class sends each operation to the selected storage system
public class FoodStorage {

    // Store the stack and the queue
    private final FoodStack stack;
    private final CircularQueue queue;

    // This tells us which storage system is being used
    private final boolean stackMode;

    // Store the maximum number of food items allowed
    private final int capacity;

    // Create the selected storage system with the given capacity
    public FoodStorage(boolean stackMode, int capacity) {
        this.stackMode = stackMode;
        this.capacity = capacity;

        // Create a stack if the chef selects Stack
        if (stackMode) {
            stack = new FoodStack(capacity);
            queue = null;
        } else {
            // Create a queue if the chef selects Circular Queue
            stack = null;
            queue = new CircularQueue(capacity);
        }
    }

    // Return the name of the selected storage system
    public String getSystemName() {
        if (stackMode) {
            return "Stack (LIFO)";
        }
        return "Circular Queue (FIFO)";
    }

    // Return the maximum capacity of the storage
    public int getCapacity() {
        return capacity;
    }

    // Return the number of food items currently stored
    public int size() {
        if (stackMode) {
            return stack.size();
        }
        return queue.size();
    }

    // Check if the storage is full
    public boolean isFull() {
        if (stackMode) {
            return stack.isFull();
        }
        return queue.isFull();
    }

    // Add a food item to the selected storage system
    public boolean add(FoodItem item) {
        if (stackMode) {
            return stack.push(item);
        }
        return queue.enqueue(item);
    }

    // Remove a food item from the selected storage system
    public FoodItem remove() {
        if (stackMode) {
            return stack.pop();
        }
        return queue.dequeue();
    }

    // Show the next food item without removing it
    public FoodItem peek() {
        if (stackMode) {
            return stack.peek();
        }
        return queue.peek();
    }

    // Display all food items in the selected storage system
    public void display() {
        if (stackMode) {
            stack.display();
        } else {
            queue.display();
        }
    }

    // Search for a food item by name.
    public void search(String name) {
        if (stackMode) {
            stack.search(name);
        } else {
            queue.search(name);
        }
    }
}