package foodstorage_2024148;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

// This class reads the chef's input and checks if it is valid
public class InputValidator {

    // This is the date format used when the chef types a date
    // STRICT rejects dates that do not exist, such as 31/02/2026
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd/MM/uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);

    // Read a whole number inside the allowed range
    public static int readInt(Scanner myKB, String message, int min, int max) {
        while (true) {
            System.out.print(message);
            try {
                int number = Integer.parseInt(myKB.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                }
            } catch (NumberFormatException e) {
                // Show the message below if the input is not a whole number
            }
            System.out.println("Please enter a number from " + min + " to " + max + ".");
        }
    }

    // Read text and accept only letters and spaces
    public static String readText(Scanner myKB, String message) {
        while (true) {
            System.out.print(message);
            String text = myKB.nextLine().trim();

            if (text.matches("[a-zA-Z ]+")) {
                return text;
            }

            System.out.println(
                    "Invalid name. Please use letters and spaces only."
            );
        }
    }

    // Read a weight greater than zero
    public static double readWeight(Scanner myKB) {
        while (true) {
            System.out.print("Enter the weight in grams: ");
            try {
                double weight = Double.parseDouble(myKB.nextLine().trim());
                if (Double.isFinite(weight) && weight > 0) {
                    return weight;
                }
            } catch (NumberFormatException e) {
                // Show the message below if the input is not a number
            }
            System.out.println("Enter a weight greater than zero.");
        }
    }

    // Read a date from today up to two weeks from today
    public static LocalDate readBestBeforeDate(Scanner myKB) {
        while (true) {
            System.out.print("Enter the best-before date (dd/MM/yyyy): ");
            try {
                LocalDate date = LocalDate.parse(
                        myKB.nextLine().trim(), DATE_FORMAT
                );

                if (!date.isBefore(LocalDate.now())
                        && !date.isAfter(LocalDate.now().plusWeeks(2))) {
                    return date;
                }
                System.out.println("The date must be within the next two weeks.");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Please use dd/MM/yyyy.");
            }
        }
    }
}
