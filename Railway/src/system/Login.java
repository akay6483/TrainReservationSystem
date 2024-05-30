package system;

import java.util.Scanner;

public class Login {
    private static final int MAX_USERS = 100;
    private static String[] usernames = new String[MAX_USERS];
    private static String[] passwords = new String[MAX_USERS];
    private static int userCount = 0;

   
    public static void loginMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nLogin Menu");
            System.out.println("1. Sign In");
            System.out.println("2. Sign Up");
            System.out.println("3. Back to Main Menu");
            System.out.print("Please select an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                signIn(scanner);
            } else if (choice.equals("2")) {
                signUp(scanner);
            } else if (choice.equals("3")) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void signIn(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Successfully signed in as " + username + ".");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void signUp(Scanner scanner) {
        if (userCount >= MAX_USERS) {
            System.out.println("User limit reached. Cannot sign up more users.");
            return;
        }

        System.out.print("Enter a new username: ");
        String newUsername = scanner.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(newUsername)) {
                System.out.println("Username already exists. Please try a different username.");
                return;
            }
        }

        System.out.print("Enter a new password: ");
        String newPassword = scanner.nextLine();

        usernames[userCount] = newUsername;
        passwords[userCount] = newPassword;
        userCount++;

        System.out.println("Successfully signed up as " + newUsername + ".");
    }
}