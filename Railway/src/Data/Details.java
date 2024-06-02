package Data;

import java.util.*;
import java.util.ArrayList;

public class Details {
	
	public static ArrayList <Station> stationArray = new ArrayList <Station>();
	public static ArrayList <Train> trainArray = new ArrayList <Train>();
	
	public static void initializeData()
	{
		stationArray.add(new Station("Thiruvananthapuram Central","1",0));
		stationArray.add(new Station("Kollam Junction","2",64));
		stationArray.add(new Station("Kottayam Junction","4",160));
		stationArray.add(new Station("Eranakulam Town","5",220));
		stationArray.add(new Station("Thrissur","6",291));
		stationArray.add(new Station("Shoranur Junction","7",325));
		stationArray.add(new Station("Kozhikode Main","8",411));
		stationArray.add(new Station("Kannur","9",500));
		stationArray.add(new Station("Kasargod","10",586));
		
		String coachSeatsOne[][] = new String[6][4];
		char coachOne[]={'A','B','C','D','E','F'};
		
		for (int i=0;i<6;i++)
		{
			for (int j=0;j<4;j++)
			{
				coachSeatsOne[i][j]=coachOne[i]+""+(j+1);
			}
		}
		
		
		String coachSeatsTwo[][] = new String[8][8];
		char coachTwo[]={'A','B','C','D','E','F','G','H'};
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++)
			{
				coachSeatsTwo[i][j]=coachTwo[i]+""+(j+1);
			}
		}
			
		String arrivalTimeOne[] = {"NA","5:10 AM","6:00 AM","6:50 AM","7:23 AM","8:25 AM","9:30 AM","10:00 AM","11:00 AM","12:00 PM"};
		String departureTimeOne[] = {"5:15 AM","6:05 AM","6:55 AM","7:27 AM","8:28 AM","9:33 AM","10:04 AM","11:05 AM","12:05 PM","NA"};
		
		String arrivalTimeTwo[] = {"6:10 AM","7:23 AM","8:34 AM","9:20 AM","10:55 AM","12:26 PM","2:00 PM","4:20 PM","6:28 PM","7:57 PM"};
		String departureTimeTwo[] = {"6:15 AM","7:26 AM","8:36 AM","9:23 AM","11:00 AM","12:28 PM","2:05 PM","5:00 PM","6:29 PM","7:58 PM"};
		
		trainArray.add(new Train("154DF","Kasargod Vande Bharat Express","Thiruvananthapuram Central","Kasargod",300,10,coachSeatsOne,departureTimeOne,arrivalTimeOne,3.14));
		trainArray.add(new Train("4CF452","Parasuram Express","Thiruvananthapuram Central","Kasargod",800,15,coachSeatsTwo,departureTimeTwo,arrivalTimeTwo,1.58));
		trainArray.add(new Train("4572AY","Rajdhani Express","Thiruvananthapuram Central","Kasargod",800,15,coachSeatsTwo,departureTimeTwo,arrivalTimeTwo,1.58));
	}
	
	public static void displayStation()
	{
		for(int i=0;i<stationArray.size();i++)
		{
			String stNo = stationArray.get(i).stationNo;
			String stName = stationArray.get(i).stationName;
			System.out.println((i+1)+". | "+stNo+" | "+stName);
		}
	}
	
	public static void displayTrain()
	{
		for(int i=0;i<trainArray.size();i++)
		{
			System.out.println((i+1)+". | "+trainArray.get(i).getTrainNumber()+" | "+trainArray.get(i).getTrainName()+" | $"+trainArray.get(i).getFarePerKm());
		}
	}
	
	protected static void addStation(Scanner scanner) throws StationAddFail
	{
		try {
		System.out.println("Enter station name: ");
		String stationName = scanner.next();
		System.out.println("Enter station number: ");
		String stationNo = scanner.next();
		System.out.println("Enter station distance from Trivandrum Central(South-Zone Railway): ");
		double stationDistance = scanner.nextDouble();
		
		for(int i=0;i<stationArray.size();i++)
		{
			if(stationDistance < stationArray.get(i).stationDistance)
			{
				stationArray.add(i, new Station(stationName,stationNo,stationDistance));
				System.out.println("Station added successfully");
				break;
			}
					
		}
		}
		catch(Exception e)
		{
			throw new StationAddFail();
		}
	}
	
	protected static void deleteStation(Scanner scanner)
	{
		System.out.println("Enter station index: ");
		int stationIndex = Integer.parseInt(scanner.next());
		stationArray.remove(stationIndex-1);
		System.out.println("Station removed successfully");
	}
	
	protected static void addTrain(Scanner scanner)
	{
		System.out.print("Enter train number: ");
        String trainNumber = scanner.next();
        System.out.print("Enter train name: ");
        String trainName = scanner.next();
        System.out.print("Enter source station: ");
        String source = scanner.next();
        System.out.print("Enter destination station: ");
        String destination = scanner.next();
        System.out.print("Enter available seats: ");
        int availableSeats = scanner.nextInt();
        System.out.print("Enter coach number: ");
        int coachNumber= scanner.nextInt();
        System.out.print("Enter fare per km: ");
        double farePerKm = scanner.nextDouble();
   
        
        String arrivalTimeOne[] = {"NA","5:10 AM","6:00 AM","6:50 AM","7:23 AM","8:25 AM","9:30 AM","10:00 AM","11:00 AM","12:00 PM"};
		String departureTimeOne[] = {"5:15 AM","6:05 AM","6:55 AM","7:27 AM","8:28 AM","9:33 AM","10:04 AM","11:05 AM","12:05 PM","NA"};
		String coachSeatsTwo[][] = new String[8][8];
		char coachTwo[]={'A','B','C','D','E','F','G','H'};
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++)
			{
				coachSeatsTwo[i][j]=coachTwo[i]+""+(j+1);
				System.out.println("Train added successfully");
			}
		}
		
		try{
        trainArray.add(new Train(trainNumber, trainName, source, destination, availableSeats, coachNumber, coachSeatsTwo, departureTimeOne, arrivalTimeOne, farePerKm));
		}
		catch(Exception gen)
		{
			System.out.println("Error! Cannot add train.");
		}
        
	}
	protected static void deleteTrain(Scanner scanner)
	{
		System.out.println("Enter train index: ");
		int trainIndex = scanner.nextInt();
		trainArray.remove(trainIndex-1);
		System.out.println("Train removed successfully");
	}

}

class StationAddFail extends Exception
{
	StationAddFail()
	{
		System.out.println("Error! Cannot add station.");
	}
}
