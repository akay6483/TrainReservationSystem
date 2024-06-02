package system;

import java.util.Scanner;

public class Login {
   
 
    public static void loginMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nLogin Menu");
            System.out.println("1. Login as admin");
            System.out.println("2. Login as passanger");
            System.out.println("3. Return to main menu");
            String choice = scanner.nextLine();
            
            if (choice.equals("1")) {
                Admin.adminLogin(scanner);
            } else if (choice.equals("2")) {
                User.userLogin(scanner);
            } else if (choice.equals("3")){
            	break;
            }else {
            	System.out.println("Invalid choice. Please try again.");
            }
          
        }
    }

    

    
}