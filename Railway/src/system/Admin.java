package system;

import java.util.*;

import Data.TrainReservationSystem;
import Data.Station;
import Data.Train;

public class Admin{
	
	private static final String ADMIN_PASSWORD = "admin123";
	
	public static void adminLogin(Scanner scanner)
	{
		System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();
        
        if (ADMIN_PASSWORD.equals(adminPassword)) {
            while (true) {
            	System.out.println("-------------------------");
                System.out.println("1. Add Station");
                System.out.println("2. Delete Station");
                System.out.println("3. Add Train");
                System.out.println("4. Delete Train");
                System.out.println("5. Display Station");
                System.out.println("6. Display Train");
                System.out.println("7. Logout");
                System.out.println("Enter your choice: ");
                System.out.println("-------------------------");
                int adminChoice = scanner.nextInt();

                switch (adminChoice) 
                {
                    case 1:
                    	try {
                    	addStation(scanner);
                    	}
                    	catch(Exception e)
                    	{
                    		e.getMessage();
                    	}
                        break;

                    case 2:
                    	deleteStation(scanner);
                        break;

                    case 3:
                        addTrain(scanner);
                        break;

                    case 4:
                        deleteTrain(scanner);
                        break;
                    case 5:
                    	TrainReservationSystem.displayStation();
                    	break;
                    case 6:
                    	TrainReservationSystem.displayTrain();
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
	private static void addStation(Scanner scanner)
	{
		try {
		System.out.println("Enter station name: ");
		String stationName = scanner.next();
		System.out.println("Enter station number: ");
		String stationNo = scanner.next();
		System.out.println("Enter station distance from Trivandrum Central(South-Zone Railway): ");
		double stationDistance = scanner.nextDouble();
		
		for(int i=0;i<TrainReservationSystem.stationArray.size();i++)
		{
			if(stationDistance < TrainReservationSystem.stationArray.get(i).stationDistance)
			{
				TrainReservationSystem.stationArray.add(i, new Station(stationName,stationNo,stationDistance));
				System.out.println("Station added successfully");
				break;
			}
					
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private static void deleteStation(Scanner scanner)
	{
		System.out.println("Enter station index: ");
		int stationIndex = Integer.parseInt(scanner.next());
		TrainReservationSystem.stationArray.remove(stationIndex-1);
		System.out.println("Station removed successfully");
	}
	
	private static void addTrain(Scanner scanner)
	{
		System.out.println("Enter train number: ");
        String trainNumber = scanner.next();
        System.out.println("Enter train name: ");
        String trainName = scanner.next();
        System.out.println("Enter source station: ");
        String source = scanner.next();
        System.out.println("Enter destination station: ");
        String destination = scanner.next();
        System.out.println("Enter available seats: ");
        int availableSeats = scanner.nextInt();
        System.out.println("Enter coach number: ");
        int coachNumber= scanner.nextInt();
        System.out.println("Enter fare per km: ");
        double farePerKm = scanner.nextDouble();
   
        
        String arrivalTimeOne[] = {"NA","5:10 AM","6:00 AM","6:50 AM","7:23 AM","8:25 AM","9:30 AM","10:00 AM","11:00 AM","12:00 PM"};
		String departureTimeOne[] = {"5:15 AM","6:05 AM","6:55 AM","7:27 AM","8:28 AM","9:33 AM","10:04 AM","11:05 AM","12:05 PM","NA"};
		String coachSeatsTwo[][] = new String[8][8];
		char coachTwo[]={'A','B','C','D','E','F','G','H'};
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++)
			{
				coachSeatsTwo[i][j]=coachTwo[i]+""+(j+1);
			}
		}
		
		try{
        TrainReservationSystem.trainArray.add(new Train(trainNumber, trainName, source, destination, availableSeats, coachNumber, coachSeatsTwo, departureTimeOne, arrivalTimeOne, farePerKm));
        System.out.println("Train added successfully");
		}
		catch(Exception gen)
		{
			System.out.println("Error! Cannot add train.");
		}
        
	}
	private static void deleteTrain(Scanner scanner)
	{
		System.out.println("Enter train index: ");
		int trainIndex = scanner.nextInt();
		TrainReservationSystem.trainArray.remove(trainIndex-1);
		System.out.println("Train removed successfully");
	}
}

