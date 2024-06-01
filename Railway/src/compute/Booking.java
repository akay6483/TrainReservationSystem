package compute;

import java.util.*;

import Data.Details;
import system.Feedback;
import system.Login;


public class Booking extends Details{
	
	static int choice;
	static int departureStation;
	static int arrivalStation;
	static String[] availableTrain;
	static int selectedTrain;
	static int selectedCompartment;
	static String selectedSeat;
	
	
	public static void bookTicket(Scanner scanner)
	{
		Details.initializeData();
		
		System.out.println("Select starting station");
		System.out.println("=========================");
		displayStation();
		choice = scanner.nextInt();
		System.out.println("=========================");
		
		departureStation = stationArray[choice-1].stationNo;
		
		System.out.println("Select ending station");
		System.out.println("=========================");
		displayStation();
		choice = scanner.nextInt();
		System.out.println("=========================");
		
		arrivalStation = stationArray[choice-1].stationNo;
		
		System.out.println("Select available trains");
		System.out.println("=========================");
		displayAvailableTrains(departureStation,arrivalStation);
		choice = scanner.nextInt();
		selectedTrain = trainArray[choice-1].getTrainNumber();
		System.out.println("=========================");
		
		
		System.out.println("Select compartment : "+ "0 - "+trainArray[choice-1].getCoachNumber());
		System.out.println("=========================");
		selectedCompartment = scanner.nextInt();
		System.out.println("=========================");
		
		System.out.println("Select seat : ");
		System.out.println("=========================");
		displaySeats();
		selectedSeat = scanner.next();
		System.out.println("=========================");
		
		System.out.println("Booked Ticket Successfully! ");
        System.out.println("1. View detials");
        System.out.println("2. Make Payment");
        System.out.println("3. Return to main menu");
        System.out.print("Please select an option: ");
        choice = scanner.nextInt();

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
	private static void displayStation()
	{
		for(int i=0;i<10;i++)
		{
			int stNo = Details.stationArray[i].stationNo;
			String stName = Details.stationArray[i].stationName;
			System.out.println(stNo+" | "+stName);
		}
	}
	private static void displayAvailableTrains(int start, int end)
	{
		availableTrain = new String[2];
		
		for (int i=0;i<trainArray.length;i++)
		{
			boolean stops[]=trainArray[i].getStationStop();
			
			if(stops[departureStation] && stops[arrivalStation])
			{
				availableTrain[i] = trainArray[i].getTrainNumber()+" | "+trainArray[i].getTrainName()+" | "+trainArray[i].getDepartureTime(departureStation)+" | "+trainArray[i].getArrivalTime(arrivalStation);
			}
			else
			{
				availableTrain[i] = trainArray[i].getTrainNumber()+" | "+"Train not available";
			}
		}
		
		for(int i=0;i<availableTrain.length;i++)
		{
			System.out.println(availableTrain[i]);
		}
	}
	
	private static void displaySeats()
	{
		String seats[][]=trainArray[selectedTrain-1].getCoachSeats();
		
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