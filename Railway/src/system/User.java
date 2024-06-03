package system;
import java.util.*;
import java.util.ArrayList;

public class User {
	
	 private static ArrayList <String> userArray = new ArrayList <String>();
	 private static ArrayList <String> passwordArray = new ArrayList <String>();
	 private static ArrayList <Double> accountBalanceArray = new ArrayList <Double>();
	 private static ArrayList <Integer> ageArray = new ArrayList <Integer>();
	 private static ArrayList <Character> genderArray = new ArrayList <Character>();
	 private static ArrayList <Long> contactDetailsArray = new ArrayList <Long>();
	 private static int currentIndex;
	 private static int MAX_USER = 5;

	public static void InitializeUser()
	{
        userArray.add("menon");
        passwordArray.add("123");
        accountBalanceArray.add(1200.50);
        ageArray.add(58);
        genderArray.add('m');
        contactDetailsArray.add(9445248621L);
        
        userArray.add("aishu");
        passwordArray.add("321");
        accountBalanceArray.add(2015.30);
        ageArray.add(26);
        genderArray.add('f');
        contactDetailsArray.add(8625324121L);
	}
	 
	public static void userLogin(Scanner scanner)
	{	
		while(true)
		{
			System.out.println("-------------------------");
			 System.out.println("1. Sign In");
	         System.out.println("2. Sign Up");
	         System.out.println("3. Back to Main Menu");
	         System.out.println("Please select an option: ");
	         String choice = scanner.nextLine();
	        System.out.println("-------------------------");
	         
	         if (choice.equals("1")) {
	             signIn(scanner);
	         } else if (choice.equals("2")) {
	             signUp(scanner);
	         } else if (choice.equals("3")) {
	             break;
	         } else {
	             System.out.println("Invalid choice. Please try again.");
	             break;
	         }
         
		}
	}
	
	private static void signIn(Scanner scanner) {
        System.out.println("Enter your username: ");
        String username = scanner.next();
        System.out.println("Enter your password: ");
        String password = scanner.next();

        boolean found = false;
        for (int i = 0; i < userArray.size(); i++) {
            if (userArray.get(i).equals(username) && passwordArray.get(i).equals(password)) {
                found = true;
                currentIndex = i;
                break;
            }
        }

        if (found) {
            System.out.println("Successfully signed in as " + username + ".");
            while(true)
            {
            System.out.println("\n-------------------------");
            System.out.println("1. View account balance");
            System.out.println("2. Deposit amount");
            System.out.println("3. Withdraw amount");
            System.out.println("4. Close account");
            System.out.println("5. Back to menu");
            System.out.println("-------------------------");
            String opt = scanner.next();
            
            if(opt.equals("1"))
            {
            	System.out.println("Balance :"+accountBalanceArray.get(currentIndex));
            }
            else if (opt.equals("2"))
            {
            	System.out.println("Enter amount to deposit: ");
            	double amt = scanner.nextDouble();
            	accountBalanceArray.set(currentIndex, accountBalanceArray.get(currentIndex)+amt);
            }
            else if (opt.equals("3"))
            {
            	System.out.println("Enter amount to withdraw: ");
            	double amt = scanner.nextDouble();
            	if(accountBalanceArray.get(currentIndex)>amt) {
            		accountBalanceArray.set(currentIndex, accountBalanceArray.get(currentIndex)-amt);
            	}
            }
            else if (opt.equals("4"))
            {
            	System.out.println("Enter user name to confirm account closure");
            	String user = scanner.next();
            	if(userArray.get(currentIndex).equals(user))
            	{
            		userArray.remove(currentIndex);
            		passwordArray.remove(currentIndex);
            		accountBalanceArray.remove(currentIndex);
            		ageArray.remove(currentIndex);
            		genderArray.remove(currentIndex);
            		contactDetailsArray.remove(currentIndex);
            		System.out.println("Account closed successfully");
            		break;
            	}
            }
            else if (opt.equals("5")){
            	break;
            }
            else {
            	System.out.println("Invalid input try again.");
            }
            	
            }
            
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
	
	private static void signUp(Scanner scanner) {
        if (userArray.size()>MAX_USER) {
            System.out.println("User limit reached. Cannot sign up more users.");
            return;
        }

        System.out.print("Enter a new username: ");
        userArray.add(scanner.next());

        System.out.print("Enter a new password: ");
        passwordArray.add(scanner.next());

        System.out.print("Enter amount to deposit in reservation account: ");
        accountBalanceArray.add(scanner.nextDouble());
        
        System.out.print("Enter age: ");
        ageArray.add(scanner.nextInt());

        System.out.print("Enter gender (m/f): ");
        genderArray.add(scanner.next().charAt(0));
        
        System.out.print("Enter contact detials: ");
        contactDetailsArray.add(scanner.nextLong());
        
        System.out.println("Successfully signed up as " + userArray.get(userArray.size()-1) + ".");
    }
	
	public static String getUserName()
	{
		return userArray.get(currentIndex);
	}
	public static int getUserAge()
	{
		return ageArray.get(currentIndex);
	}
	public static char getUserGender()
	{
		return genderArray.get(currentIndex);
	}
	public static long getUserContact()
	{
		return contactDetailsArray.get(currentIndex);
	}
	public static double getUserAccountBalance()
	{
		return accountBalanceArray.get(currentIndex);
	}
	public static void setUserAccountBalance(double balance)
	{
		accountBalanceArray.set(currentIndex, balance);
	}
}
