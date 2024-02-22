import java.util.Scanner;

public class Task1 {

    public static int generateRandomNumber(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalGames = 0;
        int totalAttempts = 0;
        int totalWins = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            totalGames++;

            System.out.println("\nGame #" + totalGames);
            System.out.println("---------------");

            System.out.print("Enter the maximum number: ");
            int max = scanner.nextInt();

            System.out.print("Enter the minimum number: ");
            int min = scanner.nextInt();

            int secretNumber = generateRandomNumber(max, min);
            int attempts = 0;

            while (true) {
                attempts++;
                System.out.print("Guess the number between " + min + " and " + max + ": ");
                int guess = scanner.nextInt();

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
                    totalWins++;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }
            }

            totalAttempts += attempts;

            System.out.println("\nStatistics:");
            System.out.println("Total games played: " + totalGames);
            System.out.println("Total wins: " + totalWins);
            System.out.println("Win rate: " + (totalWins * 100.0 / totalGames) + "%");

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Thank you for playing!");
    }
}
