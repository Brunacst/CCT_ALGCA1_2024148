# Food Storage System – Stack and Circular Queue

**Module:** Algorithms and Constructs – CA1
**Student ID:** 2024148
**Language:** Java (NetBeans)

## Scenario

A fast-food restaurant stores five types of party food (Burger, Pizza, Fries, Sandwich and Hotdog) in a rectangular storage unit that holds up to **10 trays**. The chef can use the storage in two ways:

| Storage mode | How it works | Data structure |
|---|---|---|
| Same side | Food is added and removed from the **front** | **Stack** (LIFO – Last In, First Out) |
| Opposite sides | Food is added at the **front** and removed from the **opposite side** | **Circular Queue** (FIFO – First In, First Out) |

Each food item stores its **type**, **name**, **weight (grams)**, **best-before date** (maximum two weeks) and the **date and time it was placed** into the storage.

## Features

- Choose the storage system (Stack or Circular Queue) and its capacity (1–10)
- Add a food item
- Remove a food item (from the top of the Stack or the front of the Queue)
- Peek at the item at the top/front without removing it
- Display all food items
- Search food items by name (case-insensitive)
- Return to the storage system menu or exit the application

## Input Validation

| Input | Rule |
|---|---|
| Menu options, capacity, food type | Must be a whole number inside the allowed range |
| Food name | Letters and spaces only, cannot be empty |
| Weight | Must be a number greater than zero |
| Best-before date | Format `dd/MM/yyyy`, must be a real date, from today up to two weeks from today |
| Full storage | Adding is blocked with a message |
| Empty storage | Remove, peek, display and search show "Storage is empty" |

## Class Structure

| Class | Responsibility |
|---|---|
| `Main` | Menus and application flow |
| `InputValidator` | Reads and validates user input |
| `FoodItem` | Stores the information of one food item |
| `FoodStorage` | Uses the selected structure (Stack or Circular Queue) |
| `FoodStack` | Array-based Stack (LIFO) |
| `CircularQueue` | Array-based Circular Queue (FIFO) |

## Time Complexity

| Operation | Stack | Circular Queue |
|---|---|---|
| Add (push / enqueue) | O(1) | O(1) |
| Remove (pop / dequeue) | O(1) | O(1) |
| Peek | O(1) | O(1) |
| Display | O(n) | O(n) |
| Search | O(n) | O(n) |
| isEmpty / isFull / size | O(1) | O(1) |

**Space complexity:** O(n), using a fixed-size array (maximum 10 items).

## Why These Data Structures?

- The storage has a **fixed, small capacity**, so a fixed-size array fits naturally and limits the storage to 10 trays.
- A **Stack** models adding and removing from the same side.
- A **Circular Queue** models adding at one side and removing from the opposite side. The modulo operation `(index + 1) % capacity` reuses free positions at the start of the array, so `dequeue` stays O(1) without shifting elements.
- The Circular Queue uses a **size counter** to check if it is empty or full, which removes the special cases for the first and last element.

## Advantages and Limitations

**Advantages**
- Add, remove and peek run in constant time, O(1)
- Fixed array matches the physical storage limit of 10 trays
- The Circular Queue removes the oldest food first, which helps with best-before dates

**Limitations**
- Search is linear, O(n)
- Capacity is fixed and cannot grow
- In the Stack, the oldest food stays at the bottom and may expire
- Items in the middle cannot be removed directly
- Data is kept in memory only and is lost when the program closes

## How to Run

1. Open the `FoodStorage_2024148` folder in **NetBeans**
2. Run **Clean and Build**
3. Run the project (`Main.java`)
