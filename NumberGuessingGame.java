import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain;

        do {
            playGame(scanner, random);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thank you for playing! Goodbye.");
        scanner.close();
    }

    public static void playGame(Scanner scanner, Random random) {
        int maxAttempts;
        int maxNumber;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Select a difficulty level:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.print("Enter your choice (1-3): ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: // Easy
                maxAttempts = 10;
                maxNumber = 50;
                break;
            case 2: // Medium
                maxAttempts = 7;
                maxNumber = 100;
                break;
            case 3: // Hard
                maxAttempts = 5;
                maxNumber = 200;
                break;
            default:
                System.out.println("Invalid choice. Starting with Medium difficulty.");
                maxAttempts = 7;
                maxNumber = 100;
        }

        int secretNumber = random.nextInt(maxNumber) + 1;

        System.out.println("I'm thinking of a number between 1 and " + maxNumber + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        int attempts = 0;
        boolean guessedCorrectly = false;

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Too low! Attempts remaining: " + (maxAttempts - attempts));
            } else if (guess > secretNumber) {
                System.out.println("Too high! Attempts remaining: " + (maxAttempts - attempts));
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                guessedCorrectly = true;
                break;
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Oops! You ran out of attempts. The number was: " + secretNumber);
        }
    }
}
