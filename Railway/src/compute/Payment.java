package compute;
import java.util.*;

import system.User;

public class Payment extends Booking {
	static String choice;
	private static double totalFair;
	private static boolean paymentStatus;
	
	public static void makePayment(Scanner scanner)
	{
		displayReservation();
		System.out.println("Payment portal");
		System.out.println("=========================");
        System.out.println("1. Confirm Payment");
        System.out.println("2. Cancel Payment");
        System.out.println("=========================");
		choice = scanner.next();
		
		if (choice.equals("1")) {
			debitAmount();
        } else if (choice.equals("2")) {
        	cancelPayment();
        } else {
        	System.out.println("Invalid choice. Please try again.");
        }
	}
	
	public static void displayReservation()
	{
		System.out.println("---------------------------------------------------");
		
		System.out.println("Train name: "+trainArray.get(selectedTrain).getTrainName());
		System.out.println("Train no: "+trainArray.get(selectedTrain).getTrainNumber());
		System.out.println("Departure Station: "+stationArray.get(departureStation).stationName);
		System.out.println("Expected Departure Time: "+trainArray.get(selectedTrain).getDepartureTime(departureStation));
		System.out.println("Arrival Station: "+stationArray.get(arrivalStation).stationName);
		System.out.println("Expected Arrival Time: "+trainArray.get(selectedTrain).getArrivalTime(arrivalStation));
		System.out.println("Compartment: "+selectedCompartment);
		System.out.println("Seat: "+selectedSeat);
		
		System.out.println("---------------------------------------------------");
		
		System.out.println("Passanger: "+User.getUserName());
		System.out.println("Age: "+User.getUserAge());
		System.out.println("Gender: "+User.getUserGender());
		System.out.println("Contact: "+User.getUserContact());
		
		System.out.println("---------------------------------------------------");
		
		double startDistance = stationArray.get(departureStation).stationDistance;
		double endDistance = stationArray.get(arrivalStation).stationDistance;
		
		double diffDistance = Math.abs(startDistance-endDistance);
		
		totalFair = trainArray.get(selectedTrain).getFarePerKm() * diffDistance;
		
		System.out.println("Account Balance: "+User.getUserAccountBalance());
		System.out.println("Ticket Amount: "+totalFair);
		
		if(paymentStatus)
		{
			System.out.println("Payment complete. v-");
		}
		else
			System.out.println("Payment incomplete. X");
	}
	private static void debitAmount()
	{
		double balance = User.getUserAccountBalance();
		if(balance >=totalFair)
		{
			User.setUserAccountBalance(balance-totalFair);
			System.out.println("Payment Successfull.\nAmount debited from account: "+totalFair+"\nAccount balance: "+User.getUserAccountBalance());
			paymentStatus=true;
		}
	}
	private static void cancelPayment()
	{	
		System.out.println("Payment Cancelled");
	}

}
