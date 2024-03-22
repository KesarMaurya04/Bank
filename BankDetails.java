package org.bank;
import java.util.*;
class BankDetails {
    private String accno;
    private String name;
    private String acc_type;
    private long balance=0;
    Scanner sc = new Scanner(System.in);
    //method to open new account
    public void openAccount() {
        System.out.println("-------------------------------");
        System.out.print("Enter Account No[10-16 Digit]: ");
        accno = sc.next();

        if(accno.length() ==0 || accno.length() > 16  || accno.length() < 10 ) {
            System.out.println("Create failed! Account should not be less than 10-digit ..!!");
            System.exit(0);
        }

        System.out.print("Enter Account type [Saving/Current/Demat]: ");
        acc_type = sc.next();

        if(acc_type.length() ==0) {
            System.out.println("Create failed! Account Type should be  Saving/Current/Demat  ..!!");
            System.exit(0);
        }else if(acc_type.equalsIgnoreCase("Saving") || acc_type.equalsIgnoreCase("Current") || acc_type.equalsIgnoreCase("Demat") )
        {
            //System.out.println("Create failed! Account Type should be  Saving/Current/Demat..!!");
            // System.exit(0);
        }else
        {
            System.out.println("Create failed! Account Type should be  Saving/Current/Demat..!!");
            System.exit(0);
        }


        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance : ");
        balance = sc.nextLong();
        System.out.println("-------------------------------");
    }
    //method to display account details  
    public void showAccount() {
        System.out.println("-------------------------------");
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
        System.out.println("-------------------------------");
    }
    //method to deposit money  
    public void deposit() {
        System.out.println("-------------------------------");
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        balance = balance + amt;
        System.out.println("-------------------------------");
    }
    //method to withdraw money  
    public void withdrawal() {
        System.out.println("-------------------------------");
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );
        }
        System.out.println("-------------------------------");
    }
    //method to search an account number  
    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}
