package compute;

import java.util.*;

import Data.Details;




public class Booking extends Details{
	
	static int choice;
	static String departureStation;
	static String arrivalStation;
	static String[] availableTrain;
	static int selectedTrain;
	static int selectedCompartment;
	static String selectedSeat;
	
	
	public static void bookTicket(Scanner scanner)
	{
		System.out.println("Select starting station");
		System.out.println("=========================");
		displayStation();
		choice = scanner.nextInt();
		
		departureStation = stationArray.get(choice-1).stationNo;
		
		System.out.println("Select ending station");
		System.out.println("=========================");
		displayStation();
		choice = scanner.nextInt();
		
		arrivalStation = stationArray.get(choice-1).stationNo;
		
		System.out.println("Select train");
		System.out.println("=========================");
		displayTrain();
		choice = scanner.nextInt();
		selectedTrain = choice-1;
			
		System.out.println("Select compartment : "+ "0 - "+trainArray.get(choice-1).getCoachNumber());
		System.out.println("=========================");
		selectedCompartment = scanner.nextInt();
		
		System.out.println("Select seat : ");
		System.out.println("=========================");
		displaySeats();
		selectedSeat = scanner.next();
		
		System.out.println("Booked Ticket Successfully! ");;
        System.out.println("1. Proceed to Payment");
        System.out.println("2. Return to main menu");
        System.out.print("Please select an option: ");
        
        String opt = scanner.next();
        
        if (opt.equals("1")) {
            Payment.makePayment(scanner);
        } else if (opt.equals("2")) {
            Payment.makePayment(scanner);
        }else {
            System.out.println("Invalid choice. Please try again.");
        }
   
	}
	

	private static void displaySeats()
	{
		String seats[][] = trainArray.get(selectedTrain).getCoachSeats();

		for (int i=0;i<seats[1].length;i++)
		{
			for (int j=0;j<seats[2].length;j++)
			{
				System.out.print(seats[i][j]+" | ");
			}
			System.out.println("");
		}
	}

}