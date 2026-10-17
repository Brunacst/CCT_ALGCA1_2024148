package foodstorage_2024148;

// A Circular Queue stores food items using the FIFO rule
public class CircularQueue {

    // This array stores the food items
    private final FoodItem[] items;

    // This stores the position of the first item
    private int front;

    // This stores the position of the last item
    private int rear;

    // This stores the number of items in the queue
    private int size;

    // Create a Circular Queue with the chosen capacity
    public CircularQueue(int capacity) {
        items = new FoodItem[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == items.length;
    }

    // Return the number of items in the queue
    public int size() {
        return size;
    }

    // Add a food item to the rear of the queue
    // O(1): the item is added directly to the next position
    public boolean enqueue(FoodItem item) {
        if (isFull()) {
            return false;
        }

        // Move the rear to the next position
        // If rear reaches the end, move it back to the beginning
        rear = (rear + 1) % items.length;
        items[rear] = item;
        size++;
        return true;
    }

    // Remove and return the first food item
    // O(1): the front item is removed directly
    public FoodItem dequeue() {
        if (isEmpty()) {
            return null;
        }

        FoodItem item = items[front];
        items[front] = null;

        // Move the front to the next position
        // If front reaches the end, return to the beginning
        front = (front + 1) % items.length;
        size--;
        return item;
    }

    // It show us the first food item without removing it
    // O(1): the front item is accessed directly
    public FoodItem peek() {
        if (isEmpty()) {
            return null;
        }
        return items[front];
    }

    // Display all food items, starting with the front item
    // O(n): the method may visit every item
    public void display() {
        if (isEmpty()) {
            System.out.println("Storage is empty!");
            return;
        }

        // Go through the items and wrap around the array when needed
        for (int i = 0; i < size; i++) {
            int index = (front + i) % items.length;
            items[index].displayInfo();
        }
    }

    // Search for food items by name
    // O(n): the method may check every item
    public void search(String name) {
        boolean found = false;

        // Check each item, starting from the front
        for (int i = 0; i < size; i++) {
            int index = (front + i) % items.length;

            if (items[index].getName().equalsIgnoreCase(name)) {
                items[index].displayInfo();
                found = true;
            }
        }

        // Show a message if no matching item was found
        if (!found) {
            System.out.println("Food item not found with this name!");
        }
    }
}