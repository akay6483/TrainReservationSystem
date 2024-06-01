package compute;

import java.util.*;

import Data.Details;

public class Booking extends Details{
	
	public static void bookTicket(Scanner scanner)
	{
		Details.initializeData();
		
		System.out.println("1.Select starting station");
		displayStation();
		System.out.println("2.Select ending station");
		displayStation();
			
	}
	private static void displayStation()
	{
		for(int i=0;i<10;i++)
		{
			String stNo = Details.stationArray[i].stationName;
			System.out.println(stNo);
		}
	}

}