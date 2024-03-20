import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Account2 {
   int balance;
   int prevTransaction;
   String customerName;
   String customerID;



Account2(String cname , String cid) {
  customerID = cid ;
  customerName = cname ;
}

void deposit(int amount) {
    if (amount > 0 && amount != 0) {
        balance += amount ;
        prevTransaction = amount ;
    }
}

void withdraw(int amount) {
    if (amount != 0) {
        balance -= amount ;
        prevTransaction = -amount ;
    }
}

void getPrevTransaction () {
    if (prevTransaction > 0) {
        System.out.println("Deposited :" + prevTransaction);
    } else if (prevTransaction < 0) {
        System.out.println("Withdrawn :" + Math.abs(prevTransaction));
    } else {
        System.out.println("No transaction occured.");
    }

}
void showMenu () {
    char option = '\0' ;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome, " + customerName);
    System.out.println("Your ID is: " + customerID);
    System.out.println("---------------");
    System.out.println("What would you like to do?");
    System.out.println();
    System.out.println("A. Check your balance");
    System.out.println("B. Make a deposit");
    System.out.println("C. Make a withdraw");
    System.out.println("D. Show prev transaction");
    System.out.println("E. Show the date");
    System.out.println("F. Exit");



do {
    System.out.println("---------------");
    System.out.println("Pleas enter an option");
    char option1 = scanner.next().charAt(0);
    option = Character.toUpperCase(option1);
    switch (option) {
        case 'A':
             System.out.println("//////////");
             System.out.println("You hava " + balance + "$!");
             System.out.println("//////////");      
        break;
        case 'B':
             System.out.println();
             int amount1 = scanner.nextInt();
             deposit(amount1);    
        break;
        case 'C':
             System.out.println();
             int amount2 = scanner.nextInt();
             withdraw(amount2);  
        break;
        case 'D':
             System.out.println("//////////");
             getPrevTransaction();     
             System.out.println("//////////");  
        break;
        case 'E':
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
             LocalDateTime now = LocalDateTime.now();  
             System.out.println(dtf.format(now));      
        break;
        case 'F':
             System.out.println("-----------");   
        break;    
        default:
             System.out.println("Error: Invalid option. Please enter A,B,C,D,E,F");
            break;
    }

}
while (option !=  'F') ;


}
}