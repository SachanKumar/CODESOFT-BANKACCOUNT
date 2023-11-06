public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(100000.0);
        ATM atm = new ATM(userAccount);

        atm.start();
    }
}
