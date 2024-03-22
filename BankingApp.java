package org.bank;
import java.util.*;
public class BankingApp {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        //create initial accounts  
    	System.out.println("********************Welcome in Indian Bank ***************************");

        System.out.print("How many number of customers do you want to input?[1-10Max] ");
        int n = sc.nextInt();
        
        if(n==0) {
            System.out.println("Created  failed! Customer should not be zero..!!");
            System.exit(0);
        }
        if(n >3) {
            System.out.println("Create failed!Can not added more than 3 customers ..!!");
            System.exit(0);
        }
        
        BankDetails C[] = new BankDetails[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new BankDetails();
            C[i].openAccount();
        }
        // loop will run until number 5 is not pressed to exit from the banking system
        int ch;
        do {
            System.out.println("\n ***Indian Banking System Application***");
        	System.out.println("----------------------------------------------");

            System.out.println("\n\t 1. Display all account details of the Account Number "
            					+ "\n\t 2. Search by the Account number"
            					+ "\n\t 3. Deposit amount in the Account Number"
            					+ "\n\t 4. Withdraw the amount from the Account Number"
            					+ "\n\t 5. Exit from the Bank");
           
            System.out.println("Enter your choice [1-5 Options] : ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    for (int i = 0; i < C.length; i++) {
                        C[i].showAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 5:
                    System.out.println("Happy to serve you again");
                    break;
                default :
                    System.out.println("Options are not available .....Only select option betweeen [1-5]");
                    break;
            }
        }
        while (ch != 5);
    }
}
