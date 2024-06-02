package Data;

import java.util.*;

import java.util.ArrayList;
import system.User;

public class Details {
	
	public static ArrayList <Station> stationArray = new ArrayList <Station>();
	public static ArrayList <Train> trainArray = new ArrayList <Train>();
	
	public static void initializeData()
	{
		User.InitializeUser();
		
		stationArray.add(new Station("Thiruvananthapuram Central","145DF",0));
		stationArray.add(new Station("Kollam Junction","254FDF",64));
		stationArray.add(new Station("Alappuzha","5df5F",148));
		stationArray.add(new Station("Kottayam Junction","4224FD",160));
		stationArray.add(new Station("Eranakulam Town","5eD478",220));
		stationArray.add(new Station("Thrissur","5454df6",291));
		stationArray.add(new Station("Shoranur Junction","745dfg",325));
		stationArray.add(new Station("Kozhikode Main","8rtr54",411));
		stationArray.add(new Station("Kannur","9qerw78",500));
		stationArray.add(new Station("Kasargod","10fg7rt7",586));
		
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
		
		String coachSeatsThree[][] = new String[6][6];
		char coachThree[]={'A','B','C','D','E','F'};
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++)
			{
				coachSeatsThree[i][j]=coachThree[i]+""+(j+1);
			}
		}
			
		String arrivalTimeOne[] = {"NA","5:10 AM","6:00 AM","6:50 AM","7:23 AM","8:25 AM","9:30 AM","10:00 AM","11:00 AM","12:00 PM"};
		String departureTimeOne[] = {"5:15 AM","6:05 AM","6:55 AM","7:27 AM","8:28 AM","9:33 AM","10:04 AM","11:05 AM","12:05 PM","NA"};
		
		String arrivalTimeTwo[] = {"6:10 AM","7:23 AM","8:34 AM","9:20 AM","10:55 AM","12:26 PM","2:00 PM","4:20 PM","6:28 PM","7:57 PM"};
		String departureTimeTwo[] = {"6:15 AM","7:26 AM","8:36 AM","9:23 AM","11:00 AM","12:28 PM","2:05 PM","5:00 PM","6:29 PM","7:58 PM"};
		
		String arrivalTimeThree[] = {"NA","8:11 PM","9: 35 PM","10:30 PM","11:48 PM","12:45 AM","1:57 AM","3:12 AM","4:14 AM","5:20 AM"};
		String departureTimeThree[] = {"7:15 PM","8:13 PM","9:35 PM","10:35 PM","11:50 AM","12:50 AM","2:00 AM","3:15 AM","4:16 AM","NA"};
		
		trainArray.add(new Train("154DF","Kasargod Vande Bharat Express","Thiruvananthapuram Central","Kasargod",300,10,coachSeatsOne,departureTimeOne,arrivalTimeOne,3.14));
		trainArray.add(new Train("4CF452","Parasuram Express","Thiruvananthapuram Central","Kasargod",800,15,coachSeatsTwo,departureTimeTwo,arrivalTimeTwo,1.58));
		trainArray.add(new Train("12431","Hazrat Nizamuddin Rajdhani Express","Thiruvananthapuram Central","Kasargod",1050,18,coachSeatsThree,departureTimeThree,arrivalTimeThree,2.50));
		
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
	
	

}



