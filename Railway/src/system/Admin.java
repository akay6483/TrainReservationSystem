package system;

import java.util.*;
import Data.Details;

public class Admin extends Details{
	
	private static final String ADMIN_PASSWORD = "admin123";
	
	public static void adminLogin(Scanner scanner)
	{
		System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();
        
        if (ADMIN_PASSWORD.equals(adminPassword)) {
            while (true) {
                System.out.println("1. Add Station");
                System.out.println("2. Delete Station");
                System.out.println("3. Add Train");
                System.out.println("4. Delete Train");
                System.out.println("5. Display Station");
                System.out.println("6. Display Train");
                System.out.println("7. Logout");
                System.out.print("Enter your choice: ");
                int adminChoice = scanner.nextInt();

                switch (adminChoice) 
                {
                    case 1:
                    	try {
                    	Details.addStation(scanner);
                    	}
                    	catch(Exception e)
                    	{
                    		e.getMessage();
                    	}
                        break;

                    case 2:
                    	Details.deleteStation(scanner);
                        break;

                    case 3:
                        Details.addTrain(scanner);
                        break;

                    case 4:
                        Details.deleteTrain(scanner);
                        break;
                    case 5:
                    	Details.displayStation();
                    	break;
                    case 6:
                    	Details.displayTrain();
                    	break;
                    case 7:
                        break;
                        
                    
                    	
                    default:
                        System.out.println("Invalid choice");
                }

                if (adminChoice == 7) {break;};
   
            }
        }
	}
}

