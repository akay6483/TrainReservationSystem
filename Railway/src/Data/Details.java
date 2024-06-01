package Data;

public class Details {
	
	public static Station[] stationArray;
	
	public static void initializeData()
	{
		stationArray = new Station[10];
		stationArray[0] = new Station("Thiruvananthapuram Central",1,0);
		stationArray[1] = new Station("Kollam Junction",2,64);
		stationArray[2] = new Station("Chengannur",3,125);
		stationArray[3] = new Station("Kottayam Junction",4,160);
		stationArray[4] = new Station("Eranakulam Town",5,220);
		stationArray[5] = new Station("Thrissur",6,291);
		stationArray[6] = new Station("Shoranur Junction",7,325);
		stationArray[7] = new Station("Kozhikode Main",8,411);
		stationArray[8] = new Station("Kannur",9,500);
		stationArray[9] = new Station("Kasargod",10,586);
		
		
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
		
		boolean stationStopOne[] = {true,true,true,true,true,true,true,true,true,true};
		boolean stationStopTwo[] = {true,true,true,true,true,true,true,true,true,true};
		
		//boolean stationStopThree[] = {true,true,true,true,true,false,false,false,false,false};
		//boolean stationStopFour[] = {true,false,true,true,false,true,true,false,true,true};
		//boolean stationStopFive[] = {false,false,false,false,false,true,true,true,true,true};
		
		String arrivalTimeOne[] = {"NA","5:10 AM","6:00 AM","6:50 AM","7:23 AM","8:25 AM","9:30 AM","10:00 AM","11:00 AM","12:00 PM"};
		String departureTimeOne[] = {"5:15 AM","6:05 AM","6:55 AM","7:27 AM","8:28 AM","9:33 AM","10:04 AM","11:05 AM","12:05 PM","NA"};
		
		String arrivalTimeTwo[] = {"6:10 AM","7:23 AM","8:34 AM","9:20 AM","10:55 AM","12:26 PM","2:00 PM","4:20 PM","6:28 PM","7:57 PM"};
		String departureTimeTwo[] = {"6:15 AM","7:26 AM","8:36 AM","9:23 AM","11:00 AM","12:28 PM","2:05 PM","5:00 PM","6:29 PM","7:58 PM"};
		
		Train[] trainArray = new Train[5];
		trainArray[0] = new Train(1,"Kasargod Vande Bharat Express","Thiruvananthapuram Central","Kasargod",300,10,coachSeatsOne,stationStopOne,departureTimeOne,arrivalTimeOne,3.14);
		trainArray[1] = new Train(2,"Parasuram Express","Thiruvananthapuram Central","Kasargod",800,15,coachSeatsTwo,stationStopTwo,departureTimeTwo,arrivalTimeTwo,1.58);
	}

}
