package system;

import java.util.Scanner;
import compute.Booking;
import compute.Payment;

public class Portal {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.println("\nMain Menu");
	            System.out.println("1. Login");
	            System.out.println("2. Book Ticket");
	            System.out.println("3. Make Payment");
	            System.out.println("4. Feedback");
	            System.out.println("5. Exit");
	            System.out.print("Please select an option: ");
	            String choice = scanner.nextLine();

	            if (choice.equals("1")) {
	                Login.loginMenu(scanner);
	            } else if (choice.equals("2")) {
	                Booking.bookTicket(scanner);
	            } else if (choice.equals("3")) {
	            	Payment.makePayment(scanner);  
		        }else if (choice.equals("4")) {
		        	Feedback.appFeedback(scanner);
		        }else if (choice.equals("5")) {
	                System.out.println("Exiting the program. Goodbye!");
	                break;
	            } else {
	                System.out.println("Invalid choice. Please try again.");
	            }
	        }
	        scanner.close();
	    }

}