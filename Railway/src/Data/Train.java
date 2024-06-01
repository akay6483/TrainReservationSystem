package Data;

public class Train {
	 	private int trainNumber;
	    private String trainName;
	    private String source;
	    private String destination;
	    private int availableSeats;
	    private int coachNumber;
	    private String coachSeats[][];
	    private boolean stationStop[];
	    private String departureTime[];
	    private String arrivalTime[];
	    private double farePerKm;

	    public Train(int trainNumber, String trainName, String source, String destination, int availableSeats, int coachNumber, String coachSeats[][], boolean stationStop[], String departureTime[], String arrivalTime[], double farePerKm) {
	        this.trainNumber = trainNumber;
	        this.trainName = trainName;
	        this.source = source;
	        this.destination = destination;
	        this.availableSeats = availableSeats;
	        this.coachNumber = coachNumber;
	        this.coachSeats = coachSeats;
	        this.stationStop=stationStop;
	        this.departureTime = departureTime;
	        this.arrivalTime = arrivalTime;
	        this.farePerKm = farePerKm;
	    }
	   
}

