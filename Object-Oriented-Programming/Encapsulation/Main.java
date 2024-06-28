// package Object-Oriented-Programming.Encapsulation;

// BankAccount class demonstrating encapsulation
class BankAccount {
    // Private fields
    private String accNumber;
    private String accHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accNumber, String accHolderName, double initialBalance){
        this.accNumber = accNumber;
        this.accHolderName = accHolderName;
        this.balance = initialBalance;
    }

    // Getter - Public method to get the account balance
    public double getBalance(){
        return balance;
    }

    // Public method to deposit money into the account
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited. Total balance is: " + balance);
        } else{
            System.out.println("Invalid deposit amount.");
        }
    }

    // Public method to withdraw money from the account
    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawn amount:" + amount + ". Total balance is: " + balance);
        }
        else{
            System.out.println("Invalid or insufficient amount.");
        }
    }

    // Public method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accNumber);
        System.out.println("Account Holder Name: " + accHolderName);
        System.out.println("Balance: $" + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("123456789", "Aryajeet Ghosh", 500.0);
        
        // Display the account details
        myAccount.displayAccountDetails();

        // Deposit money
        myAccount.deposit(1000.0);

        // Withdraw money
        myAccount.withdraw(700.0);

        // Attempting to withdraw more than the balance
        myAccount.withdraw(1000);

        // Get the account balance
        System.out.println(myAccount.getBalance());

        // Display the account details
        myAccount.displayAccountDetails();
    }
}
