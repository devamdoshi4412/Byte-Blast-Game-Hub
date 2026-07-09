// GAME 4 --> Dungeon Rush.
import java.util.*;

class DungeonRush 
{
    static int MAX_LEVEL = 3;
    static Random RANDOM = new Random();
    static Scanner sc = new Scanner(System.in);
	static GameZone gz;

    void main(String[] args) 
	{
        int level = 1;
        boolean gameEnded = false;

        while (level <= MAX_LEVEL && !gameEnded) 
		{
            System.out.println("\n--- Level " + level + " ---");
            gameEnded = exploreLevel(level);
            level++;
        }

        if(gameEnded==true)
		{
            return;
        }       
    }

    static boolean exploreLevel(int level) 
	{
        switch (level) 
		{
            case 1:
			{
                return exploreLevel1();
			}
            case 2:
			{
                return exploreLevel2();
			}
            case 3:
			{
                return exploreLevel3();
			}
        }
        return true;
    }

    static boolean exploreLevel1() 
	{
        System.out.println("Choose your path: ");
        System.out.println("1. Go left");
        System.out.println("2. Go right");        
        boolean flag = true;
        while(flag)
		{
            System.out.print("Enter your choice (1-2): ");
            int choice = sc.nextInt();
            System.out.println();

            if(choice==1 || choice==2)
			{
                flag = false;
                switch (choice) 
				{
                    case 1:
					{
                        return exploreLeftPathLevel1();
					}
                    case 2:
					{
                        return exploreRightPathLevel1();
					}
                }
            }
            else
			{
                System.out.println("Enter Valid Choice.");
                continue;
            }
        }
        return true;
    }

    static boolean exploreLeftPathLevel1() 
	{
        System.out.println("You enter a large chamber.");
        System.out.println("In the center, there is an ancient book.");
        System.out.println("What do you want to do?");
        System.out.println("1. Read the book");
        System.out.println("2. Leave the chamber");
        boolean flag = true;
        while(flag)
		{
            System.out.print("Enter your choice (1-2): ");
            int bookChoice = sc.nextInt();

            if (bookChoice == 1) 
			{
                flag = false;
                return readBookOutcome();
            }
            else if (bookChoice == 2) 
			{
                flag = false;
                return leaveChamberOutcome();
            }
            else
			{
                System.out.println("Enter Valid Choice.");
                continue;
            }
        }
        return true; // Game ended
    }

    static boolean readBookOutcome() 
	{
        if (RANDOM.nextInt(10) < 7) 
		{
            System.out.println("As you start reading, the room shakes.");
            System.out.println("You gain ancient knowledge and safely exit the chamber.");
            return false;
        }
        else 
		{
            System.out.println("As you read, the room fills with darkness, and you lose consciousness.");
            endGame(0);
            return true; // Game ended
        }
    }

    static boolean leaveChamberOutcome() 
	{
        if (RANDOM.nextInt(10) < 6) 
		{
            System.out.println("As you leave the chamber, you hear a roar.");
            System.out.println("Suddenly, a rockslide blocks your way.");
            endGame(0);
            return true;
        }
        else 
		{
            System.out.println("You decide to leave the chamber and continue exploring.");
            System.out.println("The cave twists and turns, leading you to a hidden passage.");
            return false;
        }
    }

    static boolean exploreRightPathLevel1() 
	{
        System.out.println("You enter a dark passage.");
        System.out.println("What do you want to do?");
        System.out.println("1. Continue through the passage");
        System.out.println("2. Retreat and go back");
        System.out.println();
        boolean flag = true;
        while(flag)
		{
            System.out.print("Enter your choice (1-2): ");
            int darkPassageChoice = sc.nextInt();

            if (darkPassageChoice == 1) 
			{
                flag = false;
                System.out.println("You find a hidden exit leading to a well-lit chamber.");
                return false;
            }
            else if (darkPassageChoice == 2) 
			{
                flag = false;
                if (RANDOM.nextInt(10) < 4) 
				{
                    System.out.println("You decide to retreat and return to the cave entrance.");
                    return false;
                }
                else 
				{
                    System.out.println("As you exit, the cave entrance collapses.");
                    endGame(0);
                    return true; // Game ended
                }
            }
            else
			{
                System.out.println("Enter Valid Choice.");
                continue;
            }
        }
        return true;
    }

    static boolean exploreLevel2() 
	{
        System.out.println("You find yourself in a narrow tunnel with mysterious markings on the walls.");
        System.out.println("What do you want to do?");
        System.out.println("1. Follow the markings");
        System.out.println("2. Find your way without following the markings");
        System.out.println("3. Enter the secret code on a keypad next to the markings");
        System.out.println();
        boolean flag = true;
        while(flag)
		{
            System.out.print("Enter your choice (1-3): ");
            int tunnelChoice = sc.nextInt();
            if(tunnelChoice==1 || tunnelChoice==2 || tunnelChoice==3)
			{
                flag = false;
                switch (tunnelChoice) 
				{
                    case 1:
                        return exploreMarkingsOutcome();
                    case 2:
                        return findYourWayOutcome();
                    case 3:
                        return enterSecretCodeOutcome();
                }
            }
            else
			{
                System.out.println("Enter Valid choice.");
                continue;
            }
        }
        return true;
    }

    static boolean exploreMarkingsOutcome() 
	{
        if (RANDOM.nextInt(10) < 5) 
		{
            System.out.println("You carefully follow the markings and discover an underground path.");
            System.out.println("You found an exit to the tunnel.");
            return false;
        }
        else {
            System.out.println("As you follow the markings, they lead you into a dead-end.");
            endGame(1);
            return true; // Game ended
        }
    }

    static boolean findYourWayOutcome() 
	{
        if (RANDOM.nextInt(10) < 6) 
		{
            System.out.println("You decide not to rely on the markings and navigate the maze successfully.");
            return false;
        }
        else 
		{
            System.out.println("Without the markings, you get lost in the twisting tunnels.");
            endGame(1);
            return true; // Game ended
        }
    }

    static boolean enterSecretCodeOutcome() 
	{
        System.out.println("Hint: The code is a famous mathematical constant. It represents the ratio of a circle's circumference to its diameter. It is a 3-digit decimal code.");
        System.out.print("Enter the Secret Code: ");
        double codeEntry = sc.nextDouble();

        if (codeEntry == 3.14) {
            System.out.println("You enter the correct code, and a hidden door opens.");
            return false;
        }
        else 
		{
            System.out.println("The code is incorrect, and a security alarm goes off.");
            endGame(1);
            return true; // Game ended
        }
    }

    static boolean exploreLevel3() 
	{
        System.out.println("You find yourself in a area with multiple paths.");
        System.out.println("In the center, there's a chest guarded by a mystical force.");
        System.out.println("What do you want to do?");
        System.out.println("1. Open the chest");
        System.out.println("2. Attempt to solve a riddle");
        System.out.println();
        boolean flag = true;
        while(flag)
		{
            System.out.print("Enter your choice: ");
            int cavernChoice = sc.nextInt();
            if(cavernChoice==1 || cavernChoice==2)
			{
                switch (cavernChoice) 
				{
                    case 1:
                        return openChestOutcome();
                    case 2:
                        return solveRiddleOutcome();
                }
            }
            else{
                System.out.println("Enter Valid Choice.");
                continue;
            }
        }
        return true;
    }

    static boolean openChestOutcome() 
	{
        if (RANDOM.nextInt(10) < 3) 
		{
            System.out.println("You open the chest and find a rare artifact. Congratulations You Completed All Levels!");
            endGame(3);
            return true; // Game ended
        }
        else 
		{
            System.out.println("As you open the chest, a magical trap is triggered.");
            endGame(2);
            return true; // Game ended
        }
    }

    static String getRandomRiddle() 
	{
        String[] riddles = {
            "The more you take, the more you leave behind. What am I?",
            "I can fly without wings. I can cry without eyes. Wherever I go, darkness follows me. What am I?",
            "What comes once in a minute, twice in a moment, but never in a thousand years?",
            "The person who makes it, sells it. The person who buys it never uses it. What is it?"
        };
        int randomIndex = new Random().nextInt(riddles.length);
        return riddles[randomIndex];
    }

    static boolean isCorrectAnswer(String riddle, String userAnswer) 
	{
        switch (riddle) 
		{
            case "The more you take, the more you leave behind. What am I?":
                return userAnswer.equalsIgnoreCase("footsteps");
            case "I can fly without wings. I can cry without eyes. Wherever I go, darkness follows me. What am I?":
                return userAnswer.equalsIgnoreCase("cloud");
            case "What comes once in a minute, twice in a moment, but never in a thousand years?":
                return userAnswer.equalsIgnoreCase("m");
            case "The person who makes it, sells it. The person who buys it never uses it. What is it?":
                return userAnswer.equalsIgnoreCase("coffin");
            default:
                return false;
        }
    }

    static boolean solveRiddleOutcome() 
	{
        String riddle = getRandomRiddle();
        System.out.println("Here's a riddle for you:\n");
        System.out.print("Your answer: ");
        String userAnswer = sc.next();

        if (isCorrectAnswer(riddle, userAnswer)) {
            System.out.println("Congratulations! You solved the riddle and Completed all Levels.");
            endGame(3);
            return true; // Game ended
        }
        else {
            System.out.println("The answer is incorrect. A mysterious force hinders your progress.");
            endGame(2);
            return true; // Game ended
        }
    }

    static void endGame(int level) 
	{
        System.out.println("\nMax Level Reached: " + level);
        System.out.println("Game over!");

        gz = new GameZone();
        if (level == 0)
            gz.tokensEarned = 0;
        else if (level == 1)
            gz.tokensEarned = 15;
        else if (level == 2)
            gz.tokensEarned = 20;
        else if (level == 3)
            gz.tokensEarned = 25;
    }
}
