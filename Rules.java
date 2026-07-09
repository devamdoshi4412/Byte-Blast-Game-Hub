// Rules for each game.
class Rules 
{
    static GameZone gz;
    void GameZoneRules()
	{
        System.out.print("\n\n\n\n\n\n\n\n\n");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                   WELCOME TO BYTEBLAST GAME HUB!\n");
        System.out.println("Rules:");
        System.out.println("1. You can purchase Tokens through available payment methods provided.");
        System.out.println("   Note: Wrong payment choice will auto decline the payment process and you will have to start payment process again.");
        System.out.println("2. You can play different games available and earn Tokens in Games Station by spending Tokens.");
        System.out.println("3. You can check your available balance at Main menu.");
        System.out.println("4. When you chose exit, your available Tokens will be redeemed and you will exit the GameHub.");
        System.out.println("   Note: Amount earned will be credited after charging online handling fees and taxes (20% charge) to your account by chosing available payment method.\n\n");
    }

    void showRules()
	{
        switch(gz.gameChoice)
		{
            case 1:
			{
                System.out.println("\nWelcome to Tic-Tac-Toe!\n");
                System.out.println("Rules:");
                System.out.println("1. The game is played on a 3x3 grid.");
                System.out.println("2. You are 'X', and the computer is 'O'.");
                System.out.println("3. To make a move, enter the number corresponding to the position where you want to place your 'X'.");
                System.out.println("   The positions are numbered from 1 to 9 as follows:");
                System.out.println("   1 | 2 | 3");
                System.out.println("   ---------");
                System.out.println("   4 | 5 | 6");
                System.out.println("   ---------");
                System.out.println("   7 | 8 | 9");
                System.out.println("4. The first player to get three of their symbols in a row (horizontally, vertically, or diagonally) wins.");
                System.out.println("   If the board is full and no player has three in a row, the game is a tie.");
                System.out.println("5. Rewards:");
                System.out.println("   - You earn 10 tokens if you win.");
                System.out.println("   - You earn 5 tokens if the game is a tie.");
                System.out.println("   - You lose 5 tokens if you lose.");
                System.out.println("Let's start!\n");
                break;
            }
            case 2:
			{
                System.out.println("\nWelcome to MEMORY Game!\n");
                System.out.println("Rules:");
                System.out.println("1. The game consists of 4 pairs of cards with letters (A, B, C, D).");
                System.out.println("2. All cards are initially face-down ('?').");
                System.out.println("3. On each turn, flip two cards to find matching pairs.");
                System.out.println("4. If the cards match, they remain face-up. If not, they are hidden again.");
                System.out.println("5. Your goal is to find all 4 pairs with the least number of chances.");
                System.out.println("6. You have 6 chances to complete the game.");
                System.out.println("7. Rewards:");
                System.out.println("   - You earn 10 tokens if you find all pairs.");
                System.out.println("   - You earn 0 tokens if you are out of chances.");
                System.out.println("Let's start!\n");
                break;
            }
            case 3:
			{
                System.out.println("\nWelcome to Hangman!\n");
                System.out.println("Rules:");
                System.out.println("1. You need to guess the hidden word by entering letters.");
                System.out.println("2. You can choose from three difficulty levels: Easy, Medium, and Hard.");
                System.out.println("3. You have a limited number of attempts based on the word given.");
                System.out.println("4. For each incorrect guess, the number of attempts decreases.");
                System.out.println("5. If you successfully guess the word, you earn tokens based on the difficulty level.");
                System.out.println("   - Easy Level: 7 tokens");
                System.out.println("   - Medium Level: 10 tokens");
                System.out.println("   - Hard Level: 15 tokens");
                System.out.println("If you lose you earn 0 tokens.");
                System.out.println("6. Good luck!\n");
                break;
            }
            case 4:
			{
                System.out.println("\nWelcome to THE DUNGEON RUSH!\n");
                System.out.println("Rules:");
                System.out.println("1. You find yourself in a mysterious Dungeon with multiple levels.");
                System.out.println("2. Navigate through each level by making choices.");
                System.out.println("3. Earn tokens based on your progress in the dungeon:");
                System.out.println("   - Level 1: 15 tokens (Exploring paths)");
                System.out.println("   - Level 2: 20 tokens (Navigating tunnels)");
                System.out.println("   - Level 3: 25 tokens (Confronting challenges.)");
                System.out.println("   - If you lose on Level 1 you earn 0 tokens.");
                System.out.println("4. Be cautious!, wrong choices (depending on luck) may lead to the end of the game.");
                System.out.println("5. Good luck!\n");
                break;
            }
        }
    }
}
