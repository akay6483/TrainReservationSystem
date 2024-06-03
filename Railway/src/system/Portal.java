package system;

import java.util.Scanner;


import Data.TrainReservationSystem;
import compute.Booking;
import compute.Payment;

public class Portal {
	private static int rating;
	private static String feedback;
	
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        TrainReservationSystem.initializeData();
	        
	        while (true) {
	        	System.out.println("\n-------------------------");
	            System.out.println("Main Menu");
	            System.out.println("-------------------------");
	            System.out.println("1. Login");
	            System.out.println("2. Book Ticket");
	            System.out.println("3. Reservation Status");
	            System.out.println("4. Payment Menu");
	            System.out.println("5. Feedback");
	            System.out.println("6. Exit");
	            System.out.println("Please select an option: ");
	            System.out.println("-------------------------");
	            String choice = scanner.nextLine();

	            if (choice.equals("1")) {
	               loginMenu(scanner);
	            } else if (choice.equals("2")) {
	                Booking.bookTicket(scanner);
	            } else if (choice.equals("3")) {
	            	Payment.displayReservation();  
		        }else if (choice.equals("4")) {
		        	Payment.makePayment(scanner);
		        }else if (choice.equals("5")) {
		        	appFeedback(scanner);
		        }else if (choice.equals("6")) {
	                System.out.println("Exiting the program. Visit again!");
	                break;
	            } else {
	                System.out.println("Invalid choice. Please try again.");
	            }
	        }
	        scanner.close();
	    }
	 
	 public static void loginMenu(Scanner scanner) {
	        while (true) {
	        	System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println("Login Menu");
	            System.out.println("1. Login as admin");
	            System.out.println("2. Login as user");
	            System.out.println("3. Return to main menu");
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
	            String choice = scanner.nextLine();
	            
	            if (choice.equals("1")) {
	                Admin.adminLogin(scanner);
	            } else if (choice.equals("2")) {
	                User.userLogin(scanner);
	            } else if (choice.equals("3")){
	            	break;
	            }else {
	            	System.out.println("Invalid choice. Please try again.");
	            	break;
	            }
	          
	        }
	    }
	 public static void appFeedback(Scanner scanner) 
	    {
	        
	    	System.out.println("Please rate your experience (from 1 to 5 stars):");
	        rating = scanner.nextInt();
	    	
	        System.out.println("Please provide your feedback for the train reservation system:");
	        feedback = scanner.nextLine();
	           
	        while (rating < 1 || rating > 5) {
	            System.out.println("Invalid rating. Please rate your experience from 1 to 5 stars:");
	            rating = scanner.nextInt();
	        }
	        System.out.println("\nThank you for your feedback and rating!");
	        System.out.println("Feedback: " + feedback);
	        System.out.println("Rating: " + rating);
	        
	    }

}