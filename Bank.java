import java.util.Scanner;

// User class to encapsulate account details
class User {
    String username;
    String email;
    String password;
    double balance;

    // Constructor
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.balance = 0.0; // Initial balance
    }

    // Getters
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public double getBalance() { return balance; }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: $" + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: $" + balance);
        }
    }

    // Show account details
    public void showDetails() {
        System.out.println("Account details:");
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Balance: $" + balance);
    }
}

public class Bank {
    private static User currentUser = null; // Logged-in user

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
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Register
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine().trim();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine().trim();
                    if (!email.contains("@")) {
                        System.out.println("Invalid email! Must contain '@'.");
                        break;
                    }

                    System.out.print("Enter password: ");
                    String password = scanner.nextLine().trim();
                    if (password.length() < 8) {
                        System.out.println("Password too short! Must be at least 8 characters.");
                        break;
                    }

                    currentUser = new User(username, email, password);
                    System.out.println("User registered successfully with balance $0.0");
                    break;

                case 2: // Login
                    if (currentUser == null) {
                        System.out.println("No user registered yet!");
                        break;
                    }
                    System.out.print("Enter email: ");
                    String inputEmail = scanner.nextLine().trim();
                    System.out.print("Enter password: ");
                    String inputPass = scanner.nextLine().trim();

                    if (inputEmail.equals(currentUser.getEmail()) && inputPass.equals(currentUser.getPassword())) {
                        System.out.println("Login successful! Welcome " + currentUser.getUsername());
                    } else {
                        System.out.println("Login failed. Invalid email or password.");
                    }
                    break;

                case 3: // Deposit
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                        break;
                    }
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    currentUser.deposit(depositAmount);
                    break;

                case 4: // Withdraw
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                        break;
                    }
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    currentUser.withdraw(withdrawAmount);
                    break;

                case 5: // Show balance
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                        break;
                    }
                    System.out.println("Current balance: $" + currentUser.getBalance());
                    break;

                case 6: // Show details
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                        break;
                    }
                    currentUser.showDetails();
                    break;

                case 7: // Exit
                    System.out.println("You are exiting. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
