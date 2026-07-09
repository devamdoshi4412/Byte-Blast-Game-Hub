// Payments Methods For GameHub.
import java.util.*;

class PaymentMethods 
{
    static String upiNumber;
    static String cardNumber;
    static GameZone gz;

    void confirmPaymentByUPI(int tokensPurchased, int totalCost) 
	{
        Scanner sc = new Scanner(System.in);
		boolean m=true;
		System.out.print("\nEnter your UPI number (10 digits): ");
		upiNumber = sc.next();
		String upiii=upiNumber.substring;
		while(m)
		{
			if (upiNumber.length() == 10) 
			{
				System.out.println("Payment confirmed! " + tokensPurchased + " tokens added to your account.");
				gz.userTokens += tokensPurchased;
				System.out.println("Total Tokens Available: " +"\n");
				m=false;
			}
			else 
			{
				System.out.println("Invalid UPI. Purchase canceled.\n");
			}
		}
    }

    void confirmPaymentByCard(int tokensPurchased, int totalCost) 
	{
        GameZone gz = new GameZone();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your card number (12 digits): ");
        cardNumber = sc.next();
        System.out.print("Enter your CVV code (3 digits): ");
        int cvv = sc.nextInt();
        if (cardNumber.length() == 12 && String.valueOf(cvv).length() == 3) 
		{
            System.out.println("Payment confirmed! " + tokensPurchased + " tokens added to your account.");
            gz.userTokens += tokensPurchased;
            System.out.println("Total Tokens Available: " + "\n");
        }
        else 
		{
            System.out.println("Invalid card information. Purchase canceled.\n");
        }
    }

    void confirmRedeem()
	{
        TokenBill bill = new TokenBill();
        Scanner sc = new Scanner(System.in);
        boolean paymentStatus = true;
        while(paymentStatus)
		{
            switch(bill.creditChoice)
			{
                case 1:
				{
                    System.out.print("\nEnter UPI Number: ");
                    bill.redeemUpi = sc.next();
                    if(bill.redeemUpi.length()==10)
					{
                        gz.totalTokensPurchased += gz.tokensToPurchase;
                        paymentStatus = false;
                        break;
                    }
                    else
					{
                        System.out.println("Invalid UPI Number, please try again.");
                    }
                    break;
                }
                case 2:
				{
                    boolean cvvStatus = true;    
                    System.out.print("\nEnter your card number (12 digits): ");
                    bill.redeemCard = sc.next();     
                    if (bill.redeemCard.length() == 12) 
					{
                        while (cvvStatus) 
						{
                            System.out.print("Enter your CVV code (3 digits): ");
                            int cvv = sc.nextInt();
                            if (String.valueOf(cvv).length() == 3) 
							{
                                paymentStatus = false;
                                cvvStatus = false;
                                gz.totalTokensPurchased += gz.tokensToPurchase;
                            }
                            else 
							{
                                System.out.println("Invalid CVV Number, please enter again.");
                            }
                        }
                    }
                    else 
					{
                        System.out.println("Invalid Card Number, please enter again.");
                    }
                    break;
                }
                default:{
                    System.out.println("Enter Valid Payment Choice.");
                }
            }
        }
    }
}
