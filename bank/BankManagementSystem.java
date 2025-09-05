package bank;

abstract class Account {
    int accNo;
    String holderName;
    double balance;

    Account(int accNo, String holderName, double balance) {
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
    }

    abstract void deposit(double amount);

    abstract void withdraw(double amount);

    void displayDetails() {
        System.out.println("Account No: " + accNo);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

class SavingAccount extends Account {
    double interestRate = 0.05;

    SavingAccount(int accNo, String holderName, double balance) {
        super(accNo, holderName, balance);
    }

    @Override
    void deposit(double amount) {
        balance += amount + (amount * interestRate); // adds interest
        System.out.println("Deposited " + amount + " with interest. New Balance: " + balance);
    }

    @Override
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}

class CurrentAccount extends Account {
    double overdraftLimit = 1000;

    CurrentAccount(int accNo, String holderName, double balance) {
        super(accNo, holderName, balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ". New Balance: " + balance);
    }

    void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Overdraft Limit Exceeded!");
        }
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {

        Account acc1 = new SavingAccount(101, "Ali", 5000);
        Account acc3 = new SavingAccount(3232, "Sumsam", 320);
        Account acc2 = new CurrentAccount(102, "Sara", 2000);

        acc1.displayDetails();
        acc1.deposit(1000);
        acc1.withdraw(2000);

        acc2.displayDetails();
        acc2.deposit(2000);
        acc2.withdraw(3500);
        acc3.displayDetails();
    }
}
