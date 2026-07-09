// Redeems available tokens and Generates Bill.
import java.util.*;

class TokenBill 
{
    static int creditChoice;
    static String redeemCard,redeemUpi;
    void generateBill() 
	{
        Scanner sc = new Scanner(System.in);
        GameZone gz = new GameZone();
        PaymentMethods pm = new PaymentMethods();

        if(gz.userTokens>0)
		{
            System.out.println("\nEnter Payment Method to credit rupees earned from redeemed tokens: ");
            System.out.println("1. UPI Number");
            System.out.println("2. Credit/Debit Card");
            System.out.print("Enter Your Choice: ");
            creditChoice = sc.nextInt();
            pm.confirmRedeem();
        }

        System.out.println("\n------------------------------------ BILL ----------------------------------");
        System.out.println("Tokens Purchased: " + (gz.totalTokensPurchased));
        System.out.println("Tokens Used: "+ (gz.tokensDeducted));
        System.out.println("Tokens Won: "+ (gz.totalTokensWon));
        System.out.println("Tokens Redeemed: "+ (gz.userTokens));
        if(gz.userTokens>0){
            if(creditChoice==1)
			{
                StringBuffer maskedUpi = new StringBuffer(redeemUpi);
                maskedUpi.delete(0, 7);
                System.out.println(gz.updatedRupees+ " Rs. will be credited to your UPI Number: XXXXXXX"+maskedUpi+" in 24 Hours.");
            }
            else if(creditChoice==2)
			{
                StringBuffer maskedCard = new StringBuffer(redeemCard);
                maskedCard.delete(0, 8);
                System.out.println(gz.updatedRupees+" Rs. will be credited to your Card Number: XXXX XXXX "+maskedCard+" in 24 Hours.");
            }
        }
        else
		{
            System.out.println("Sorry, you did not win any tokens.");
        }
        System.out.println("Thank you for playing!");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("\nDEVELOPED BY: DEVAM DOSHI.");
		System.out.println("----------------------------------------------------------------------------");
    }    
}
