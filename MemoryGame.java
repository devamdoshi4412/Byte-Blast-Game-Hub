// GAME 2 --> Memory Game.
import java.util.*;

class MemoryGame 
{
    static GameZone gz;

    void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

        String[] cards = {"A", "A", "B", "B", "C", "C", "D", "D"};
        shuffleArray(cards);

        String[] board = new String[cards.length];
        boolean[] flipped = new boolean[cards.length];
        int pairsFound = 0;
        int chances = 10;

        while (pairsFound < 4 && chances > 0) 
		{
            printBoard(board);

            // Gets the first card index
            System.out.print("Enter index of first card to flip (1-8): ");
            int firstIndex = getValidIndex(sc, flipped);
            board[firstIndex - 1] = cards[firstIndex - 1];
            flipped[firstIndex - 1] = true;

            printBoard(board);

            // Gets the second card index
            System.out.print("Enter index of second card to flip (1-8): ");
            int secondIndex = getValidIndex(sc, flipped);
            board[secondIndex - 1] = cards[secondIndex - 1];
            flipped[secondIndex - 1] = true;

            // Checks if found a pair or not
            if (cards[firstIndex - 1].equals(cards[secondIndex - 1])) 
			{
                System.out.println("Great, you found a pair!");
                pairsFound++;
            }
            else 
			{
                System.out.println("Sorry, those cards don't match.");
                chances--;

                board[firstIndex - 1] = null;
                board[secondIndex - 1] = null;
                flipped[firstIndex - 1] = false;
                flipped[secondIndex - 1] = false;
            }

            System.out.println("Chances left: " + chances);
            System.out.println();
        }

        // Sets token for winning and losing
        if (pairsFound == 4) 
		{
            gz.tokensEarned = 10;
            System.out.println("Congratulations, you won!");
        }
        else 
		{
            gz.tokensEarned = 0;
            System.out.println("Sorry, you are out of chances. Better luck next time!");
        }
    }

    // Prints board
    static void printBoard(String[] board) 
	{
        for (int i = 0; i < board.length; i++) 
		{
            if (board[i] != null) 
			{
                System.out.print("| " + board[i] + " ");
            }
            else 
			{
                System.out.print("| " + "? ");
            }
        }
        System.out.println("|");
        System.out.println();
    }

    // Shuffles array
    static void shuffleArray(String[] array) 
	{
        for (int i = array.length - 1 ; i > 0; i--) 
		{
            int j = (int) (Math.random() * (i + 1));

            // Swap array[i] and array[j]
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // Gets valid first and second card index
    static int getValidIndex(Scanner sc, boolean[] flipped) 
	{
        int index;
        do 
		{
            index = sc.nextInt();

            if (index < 1 || index > 8) 
			{
                System.out.println("Invalid index. Please enter a number between 1 and 8.");
            }
            else if (flipped[index - 1]) 
			{
                System.out.println("This card has already been flipped or paired correctly. Please choose another index.");
            }
        } while (index < 1 || index > 8 || flipped[index - 1]);

        return index;
    }
}
