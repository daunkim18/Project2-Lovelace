package com.lovelace.project2;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

public class Game {
	public static void main(String[] args) {
//		Main method: Game logic
//		At the start of the program, read in the names and winnings of all previous players
//		At the start of the program, prompt the user for their name
//		During the game, keep a record of the actions taken (create a separate file for each player and save it in a directory folder)
//		At the end of each round,
//		Prompt the user if they would like to continue playing
//		Shuffle the deck between each round
//		Upon completion of a game, write to file the player's updated earnings (Optional: sort the data being saved based on winnings)
	
		//playgain loop
		Scanner in = new Scanner(System.in);
		 boolean playAgain = true;
		    
		    while (playAgain) {
		
		
		System.out.println("Welcome to Lovelace's Blackjack! Are you ready to play?");
		  System.out.println("┌─────────┐");
			System.out.println("│         │");
	        System.out.println("│LOVELACE │");
	        System.out.println("│BLACKJACK│");	        
	        System.out.println("│         │");
	        System.out.println("│         │");
	        System.out.println("│         │");
	        System.out.println("└─────────┘");
			System.out.println("\nCreated by Daun & Ksena");
			Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name:");
		String name = scanner.next();
		System.out.println("Hi " + name + " ! Let's get started! ");
		System.out.println("Type anything to continue");
		//start loop?
		Scanner in1 = new Scanner(System.in);
		String playerName = in1.nextLine();
		
		//if // player name = something in the directory, println "Welcome again, name!" if not, "welcome, name!"
		Player player1 = new Player(playerName);
		String directoryPath = "game_records/" + playerName;
		String filePath = directoryPath + "/game_actions.txt";
		double x = player1.getEarnings();
		// add this to welcome line
		// Create the player's directory if it doesn't exist
		File directory = new File(directoryPath);
		if (!directory.exists()) {
			directory.mkdirs();
		}

		// Write game actions to the player's file
		try (FileWriter fileWriter = new FileWriter(filePath, true)) {
			// Write the game actions, e.g., player's moves, dealer's moves
			fileWriter.write("Player hit\n");
			fileWriter.write("Dealer stay\n");

			// Flush and close the file writer
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    
	      
		 // Initialize a new deck and shuffle it
        Deck deck = new Deck();
        House house = new House(deck);

        
        //shuffle deck
        deck.shuffle();

        // Deal initial cards to the player and dealer
        List<Card> playerHand = new ArrayList<>();
        playerHand.add(deck.deal(deck));
        playerHand.add(deck.deal(deck));
        List<Card> dealerHand = new ArrayList<>();
        dealerHand.add(deck.deal(deck));
        dealerHand.add(deck.deal(deck));

        // why is this not the way it should look

        
        
        // Play the game
        boolean gameOver = false;
        boolean playerBusted = false;
        boolean dealerBusted = false;
        
   


        while (!gameOver) {
            System.out.println("\nPlayer's Hand: " + playerHand + " (Total: " + player1.getHand() + ")");
            System.out.println("Dealer's Hand: " + dealerHand.get(0) + " ?");

            // Player's turn
            System.out.print("Do you want to Hit? Enter \"H\" ");
            String choice = in1.nextLine().toUpperCase();

            if (choice.equals("H")) {
                playerHand.add(deck.deal(deck)); 
                if (getTotalValue(playerHand) > 21) { // need to add how to get value of hand
                	System.out.println("\nPlayer's Hand: " + playerHand + " (Total: " + getTotalValue(playerHand) + ")");

                    System.out.println("Player busts! Dealer wins.");
                    playerBusted = true;
                    gameOver = true;
                }
            } else if (choice.equals("S")) {
                // Dealer's turn
                while (getTotalValue(dealerHand) < 17) { // need to edit dealer class to get value of a hand
                    dealerHand.add(deck.deal(deck));
                }

                System.out.println("\nDealer's Hand: " + dealerHand + " (Total: " + getTotalValue(dealerHand) + ")");
                if (getTotalValue(dealerHand) > 21) {
                    System.out.println("Dealer busts! Player wins.");
                    dealerBusted = true;
                } else {
                    if (getTotalValue(playerHand) > getTotalValue(dealerHand)) { 
                        System.out.println("Player wins!");
                    } else if (getTotalValue(playerHand) < getTotalValue(dealerHand)) {
                        System.out.println("Dealer wins.");
                    } else {
                        System.out.println("It's a tie.");
                    }
                }

                gameOver = true;
            }
        }

        // Check if the player wants to play again
        System.out.println("Do you want to play again? Enter \"yes\" or \"no\"");
        String playAgainChoice = in.nextLine().toLowerCase();
      

        if (playAgainChoice.equals("no")) {
            playAgain = false;
            System.out.println("Thank you for playing the game! See you next time!\"" + "\n⠀⠀⠀⢀⡴⠋⠉⢉⠍⣉⡉⠉⠉⠉⠓⠲⠶⠤⣄⠀⠀⠀\r\n"
    				+ "⠀⠀⢀⠎⠀⠪⠾⢊⣁⣀⡀⠄⠀⠀⡌⠉⠁⠄⠀⢳⠀⠀\r\n" + "⠀⣰⠟⣢⣤⣐⠘⠛⣻⠻⠭⠇⠀⢤⡶⠟⠛⠂⠀⢌⢷⡀\r\n" + "⢸⢈⢸⠠⡶⠬⣉⡉⠁⠀⣠⢄⡀⠀⠳⣄⠑⠚⣏⠁⣪⠇\r\n"
    				+ "⠀⢯⡊⠀⠹⡦⣼⣍⠛⢲⠯⢭⣁⣲⣚⣁⣬⢾⢿⠈⡜⠀\r\n" + "⠀⠀⠙⡄⠀⠘⢾⡉⠙⡟⠶⢶⣿⣶⣿⣶⣿⣾⣿⠀⡇⠀\r\n" + "⠀⠀⠀⠙⢦⣤⡠⡙⠲⠧⠀⣠⣇⣨⣏⣽⡹⠽⠏⠀⡇⠀\r\n"
    				+ "⠀⠀⠀⠀⠀⠈⠙⠦⢕⡋⠶⠄⣤⠤⠤⠤⠤⠂⡠⠀⡇⠀\r\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠑⠒⠦⠤⣄⣀⣀⣀⣠⠔⠁⠀");

        


        }
    }
    
    in.close();
        
    }
	private static int getTotalValue(List<Card> hand) {
	    int totalValue = 0;
	    int numAces = 0;

	    for (Card card : hand) {
	        totalValue += card.getValue();

	        // Check for Ace cards
	        if (card.getValue() == 11) {
	            numAces++;
	        }

	        // Adjust the value if the total exceeds 21 and there are Aces
	        while (totalValue > 21 && numAces > 0) {
	            totalValue -= 10; // Convert an Ace from 11 to 1
	            numAces--;
	        }
	    }

	    return totalValue;
	}

  
	}



