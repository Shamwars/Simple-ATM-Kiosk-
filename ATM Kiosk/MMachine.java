import java.util.Scanner;
import java.io.IOException;

// sample solution/implementation of bankmachine
// for use with CA2 
// Class provides one method which encapsulates the transaction from CA1

public class MMachine extends ATMCard{
	
	public void Txn(double amount){
		
		ATMCard card = new ATMCard();
		Account acc  = new Account();
	
		Scanner sc = new Scanner(System.in);
		String pin;
		int attempts = 0;
		int value = (int) amount;
		String euro = "\u20AC";

		if(card.isLocked() == true) {
			System.out.println("Card Is locked");
		}else{	
		
			while ((attempts < 3) || (card.isLocked() == false)){
			
				System.out.println("Please enter your PIN");
				pin = sc.nextLine();
				if (card.pinOK(Integer.parseInt(pin))){
										
					if(acc.debit(value)){
						System.out.println("Your Transaction was successful.");
						System.out.println("Your balance is " + euro + acc.getBalance() );
						System.exit(1);						
					}else{
						System.out.println("Insufficient funds.");
						System.out.println("Do you want to try again? Yes/No");
						String wantAgain = sc.nextLine();
						
						if((wantAgain.contains("n") || wantAgain.contains("N"))){
							System.out.println("Thank You!");
						}else{
							new MMachine();
						}							
					}	
				}else{
					attempts ++;
					System.out.println("Pin Incorrect");
					if((attempts > 2) || (pin.isEmpty())){
						card.lockCard();
						System.out.println("Your Card is locked. Please call the bank");
					}
				}
			}
		}
	}
}
