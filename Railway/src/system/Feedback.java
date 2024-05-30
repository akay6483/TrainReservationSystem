package system;

import java.util.Scanner;

public class Feedback {
	
	private static int rating;
	private static String feedback;
	
    public static void appFeedback(Scanner scanner) 
    {
        
    	System.out.println("Please rate your experience (from 1 to 5 stars):");
        rating = scanner.nextInt();
    	
        System.out.println("Please provide your feedback for the train reservation system:");
        feedback = scanner.next();
           
        while (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Please rate your experience from 1 to 5 stars:");
            rating = scanner.nextInt();
        }
        System.out.println("\nThank you for your feedback and rating!");
        System.out.println("Feedback: " + feedback);
        System.out.println("Rating: " + rating);
        
    }
}
