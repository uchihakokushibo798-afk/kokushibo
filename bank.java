import java.util.Scanner;

public class bank {
    static String username="";
    static String password="";
    static double balance= 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Register User");
            System.out.println("2. Login User");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Show Balance");
            System.out.println("6. View Account Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice=scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter username: ");
                    username=scanner.nextLine();
                    System.out.print("Enter password: ");
                    password=scanner.nextLine();
                    balance=0.0; // Initial balance
                    System.out.println("User registered successfully with a balance of $"+balance);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String inputUser=scanner.nextLine();
                    System.out.print("Enter password: ");
                    String inputPass=scanner.nextLine();

                    if (inputUser.equals(username) && inputPass.equals(password)) {
                        System.out.println("Login successful!");
                        System.out.println("Welcome, "+username+"! Your current balance is $"+balance);
                    } else {
                        System.out.println("Login failed. Try again.");
                    }
                    break;

                case 3:
                    System.out.print("Enter deposit amount:");
                    double amount = scanner.nextDouble();
                    if(amount <= 0){
                        System.out.println("Invalid amount, must be greater than zero.");
                    }
                    balance += amount;
                    System.out.println("Deposit successful new balace :$"+balance);
                    break;
                case 4:
                    System.out.println("Enter Withdrawal amount:");
                    double amountwithdraw=scanner.nextDouble();
                    if(amountwithdraw <= 0){
                        System.out.println("Invalid amount. must be greater than zero.");
                    }
                    if(amountwithdraw > balance){
                        System.out.println("Insufficient funds. current balance:$"+balance);
                    }
                    balance -= amountwithdraw;
                    System.out.println("Withdrawal successful! New balance: $"+balance);
                    break;
                case 5:
                    System.out.println("Current balance: $"+balance);
                    break;
                case 6:
                    System.out.println("Account details:");
                    System.out.println("User details:"+ username);
                    System.out.println("Balance: $"+ balance);
                    break;
                case 7:
                    System.out.println("you are Exit!!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while(choice != 7);

        // scanner.close();
    }
}
