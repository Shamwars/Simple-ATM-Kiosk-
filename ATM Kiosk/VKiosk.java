/*** 
 * Student Name: Yassin Ting
 * Student ID: 2014359
 * Module: Object Oriented Construct CA2
 * Program that as an interactive menu for a Video Kiosk. The kiosk presents a video Titles list on the
 * screen. The customer selects the video(s) they like by entering a ‘selection’ number (integer), one
 * video title per selection. The selected videos are removed from the Titles list and moved to a Basket
 *list. When the video selection is complete the contents of the Basket list are processed using the
 * Machine.class from CA1. Assume the card you present has a valid PIN to start, and that there is 100
 * units in the bank account.Each video has a rental ‘cost’. You will need to scan the Basket list and calculate the total for the
 * ATM transaction. You can assume there is always enough units in the bank account to cover the cost
 * of the rental for this exercise.
 ***/

//import all java util
import java.util.*;

// class VKiosk
public class VKiosk{
	// declaring variables
	private int serial;
	private String title;
	private double price;
	
	public VKiosk(int serial, String title, double price){
		this.serial = serial;
		this.title = title;
		this.price  = price;
	}

	public String getTitle() {return title;}
	public int getSerial() {return serial;}
    public double getPrice() {return price;}
    	
	public String getVideo(){
		return serial + " " + title + " Price: " + price;
	}
	
	//	Upgrade output of toString ()
	@Override
	public String toString(){
		return "["+getVideo()+"]";
	}
	
	//main class
	public static void main(String[] args){
		
		//declaring arraylist for VKiosk
		List<VKiosk> vls = new ArrayList<VKiosk>();
		//declaring Scanner for user/customer input
		Scanner sc = new Scanner(System.in);
		List<VKiosk> hls = new ArrayList<VKiosk>();
		
		System.out.println("Welcome to Video Rental Kiosk");
		System.out.println();
		System.out.println("Choices of Movies Available:");
		
		//adding movie titles and prices
		VKiosk v1 = new VKiosk((vls.size()+1), "Bladerunner",5.50);
		vls.add(v1);
		VKiosk v2 = new VKiosk((vls.size()+1), "Wages of Fear",5.00);
		vls.add(v2);
		VKiosk v3 = new VKiosk((vls.size()+1), "Grease",3.50);
		vls.add(v3);
		VKiosk v4 = new VKiosk((vls.size()+1), "Mama Mia",4.00);
		vls.add(v4);
		VKiosk v5 = new VKiosk((vls.size()+1), "L'Illusionniste",6.00);
		vls.add(v5);
        
		//declaring boolean
        boolean shopping = true;
        String euros = "\u20AC";
        //starting while loop
        while(shopping ==true){
        	for(VKiosk v : vls){
        		System.out.println((vls.indexOf(v))+1 + "   "+v.getTitle()+"  "+ euros +v.getPrice());	
        	}
        	
        	//User selection and input
        	System.out.println();
        	System.out.print("Kindly Select the title/s: ");
        	int selection = sc.nextInt();
        	hls.add(vls.get(selection-1));
        	vls.remove(selection -1);
        	
        	System.out.println();
        	System.out.print("Press 1 to checking out or 2 to continue shopping:  ");
        	
        	//user input for option
        	int option = sc.nextInt();
        	if(option == 1){
        		shopping = false;
        	}
        }//end of while loop
        
        // print to screen items chosed and prices
        System.out.println("Your basket contains the following item/s");
        String euro2 = "\u20AC";
		double sum  = 0;
		for (VKiosk v : hls){
			System.out.println((hls.indexOf(v))+1 + "   "+v.getTitle()+"  "+ euro2 + v.getPrice());	
     		sum = sum + v.getPrice();
		}
		
		String euro = "\u20AC";
		System.out.println("Please pay " + euro +sum);
		
		//Instantiate new MMachine
		MMachine m = new MMachine();
		m.Txn(sum);
	}
}//end of main class

