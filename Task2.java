import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialAmount) {
        this.balance = initialAmount;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + "Rs was successful");
        } else {
            System.out.println("Invalid entry! Please choose a number above 0");
        }
    }

    public boolean withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw successful of " + amount + "Rs");
            return true;
        } else {
            System.out.println("Invalid entry!! Insufficient balance or negative value entered");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    boolean success = account.withdraw(withdrawAmount);
                    if (success) {
                        System.out.println("Please collect your cash.");
                    }
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance() + "Rs");
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }
        } while (option != 4);

        scanner.close();
    }
}

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(30000);
        ATM atm = new ATM(userAccount);

        System.out.println("Welcome to the ATM. Please enter your PIN.");
        String pin = scanner.nextLine();

        if (pin.equals("1234")) {
            atm.run();
        } else {
            System.out.println("Invalid PIN. Access denied.");
        }

        scanner.close();
    }
}
