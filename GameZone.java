// Runs Full GameHub.
import java.util.*;

class GameZone 
{
    static int tokensToPurchase;
    static int totalTokensPurchased;
    static int userTokens = 0;
    static int rupeesPerToken = 10;
    static int tokensDeducted;
    static int tokensEarned;
    static int totalTokensWon;
    static int tokensToRedeem;
    static int rupeesEarned;
    static int paymentMethod;
    static int gameChoice;
    static double updatedRupees;

    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        Rules r = new Rules();

        r.GameZoneRules();
        
        while (true) 
		{
            System.out.println("------------- MAIN MENU -------------");
            System.out.println("1. Purchase Tokens");
            System.out.println("2. Go to Games Station");
            System.out.println("3. Show Token Balance");
            System.out.println("4. Redeem Tokens and Exit Application");
            System.out.println("-------------------------------------");
            System.out.print("Enter your choice (1-4): ");
            int choice = sc.nextInt();

            switch (choice) 
			{
                case 1:
                    purchaseTokens();
                    break;
                case 2:
                    playGames();
                    break;
                case 3: 
                    System.out.println("\nTotal Tokens Available: "+userTokens);
                    break;
                case 4:
                    redeemAndGenerateBill();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }

    static void purchaseTokens() 
	{
        PaymentMethods pm = new PaymentMethods();

        Scanner s = new Scanner(System.in);
        System.out.print("\nEnter the number of tokens to purchase: ");
        tokensToPurchase = s.nextInt();

        if (tokensToPurchase > 0) 
		{
            int totalCost = tokensToPurchase * rupeesPerToken;
            System.out.println("Total Cost: " + totalCost + " rupees");
            System.out.println("\nEnter 1 to confirm payment through UPI.");
            System.out.println("Enter 2 to confirm payment through Debit/Credit Card: ");
            System.out.print("Enter Your Choice (1-2): ");
            paymentMethod = s.nextInt();

            switch (paymentMethod) 
			{
                case 1:
                    pm.confirmPaymentByUPI(tokensToPurchase, totalCost);
                    break;
                case 2:
                    pm.confirmPaymentByCard(tokensToPurchase, totalCost);
                    break;
                default:
                    System.out.println("Invalid payment method. Purchase canceled.\n");
            }
        }
        else 
		{
            System.out.println("Invalid number of tokens. Purchase canceled.\n");
        }
    }

    static void playGames() 
	{
        Scanner s = new Scanner(System.in);
        
        boolean backToMenu = true;
        
        while(backToMenu)
		{
            System.out.println("\n------------- GAMES STATION -------------");
            System.out.println("1. Tic-Tac-Toe        (Pay -> 5 Tokens)");
            System.out.println("2. Memory Game        (Pay -> 5 Tokens)");
            System.out.println("3. Hangman            (Pay -> 5 Tokens)");
            System.out.println("4. Dungeon Rush       (Pay -> 10 Tokens)");
            System.out.println("5. Exit to Main Menu.");
            System.out.println("-----------------------------------------");
            System.out.print("Enter Your Choice (1-5): ");
            gameChoice = s.nextInt();
            switch (gameChoice) 
			{
                
                case 1:
				{
                    if(userTokens>=5)
					{
                        playTicTacToe();
                    }
                    else
					{
                        System.out.println("Insufficient tokens to play. Purchase more tokens.");
                    }
                    break;
				}
                case 2:
				{
                    if(userTokens>=5)
					{
                        playMemoryGame();
                    }
                    else
					{
                        System.out.println("Insufficient tokens to play. Purchase more tokens.");
                    }
                    break;
				}
                case 3:
				{
                    if(userTokens>=5)
					{
                        playHangman();
                    }
                    else
					{
                        System.out.println("Insufficient tokens to play. Purchase more tokens.");
                    }
                    break;
				}
                case 4:
				{
                    if(userTokens>=10)
					{
                        playDungeonRush();
                    }
                    else
					{
                        System.out.println("Insufficient tokens to play. Purchase more tokens.");
                    }
                    break;
				}
                case 5:
				{
                    backToMenu=false;
                    System.out.println();
                    return;
				}
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    
    static void playTicTacToe() 
	{
        Rules r =  new Rules();
        TicTacToe ticTacToe = new TicTacToe();
        deductTokens(5);
        r.showRules();
        ticTacToe.main(null);
        winTokens(tokensEarned);
    }

    static void playMemoryGame() 
	{
        Rules r = new Rules();
        MemoryGame memoryGame = new MemoryGame();
        deductTokens(5);
        r.showRules();
        memoryGame.main(null);
        winTokens(tokensEarned);
    }

    static void playHangman() 
	{
        Rules r = new Rules();
        Hangman hangman = new Hangman();
        deductTokens(5);
        r.showRules();
        hangman.main(null);
        winTokens(tokensEarned);
    }

    static void playDungeonRush() 
	{
        Rules r = new Rules();
        DungeonRush dr = new DungeonRush();
        deductTokens(10);
        r.showRules();
        dr.main(null);
        winTokens(tokensEarned); 
    }

    static void deductTokens(int tokensToDeduct) 
	{
        if (userTokens >= tokensToDeduct) 
		{
            userTokens -= tokensToDeduct;
            tokensDeducted += tokensToDeduct;
            System.out.println("\nTokens deducted: " + tokensToDeduct);
            System.out.println("Remaining Tokens: " + userTokens);
        }
    }

    static void winTokens(int tokensToWin) 
	{
        totalTokensWon += tokensToWin;
        userTokens += tokensToWin;
        System.out.println("\nYou won " + tokensToWin + " tokens.");
        System.out.println("Total Tokens remaining: " + userTokens);
    }

    static void redeemAndGenerateBill() 
	{
        TokenBill bill = new TokenBill();
        if (userTokens > 0) 
		{
            System.out.println("\nRedeeming remaining tokens...");
            rupeesEarned = userTokens * rupeesPerToken;
            updatedRupees = rupeesEarned - (0.20 * rupeesEarned);
            System.out.println("Tokens available: " + userTokens);
            System.out.println("Rupees earned: " + updatedRupees);
        }
        else 
		{
            System.out.println("No tokens to redeem.");
        }
        bill.generateBill();
    }
}