import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 10 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
            return true;
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;
    private Scanner input;

    public ATM(BankAccount account) {
        userAccount = account;
        input = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Current balance: $" + userAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter the deposit amount: $");
                double depositAmount = input.nextDouble();
                userAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter the withdrawal amount: $");
                double withdrawalAmount = input.nextDouble();

                userAccount.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    public void start() {
        while (true) {
            displayOptions();
            System.out.print("Select an option (1-4): ");
            int choice = input.nextInt();

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice. Please select a valid option.");
            } else {
                performTransaction(choice);
            }
        }
    }
}
