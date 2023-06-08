package com.lovelace.project2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;


public class Game {
	  private static final String PLAYERS_FILE = "players.txt"; // File containing player data
	  
	public static void main(String[] args) {
		
		Map<String, Double> playerData = readPlayerData();
        
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

				  // Read player data from file
		        
		        System.out.println("Previous Player Data:");
		        for (Map.Entry<String, Double> entry : playerData.entrySet()) {
		            String playerName = entry.getKey();
		            double playerWinnings = entry.getValue();
		            System.out.println("Player: " + playerName + ", Winnings: " + playerWinnings);
		        }

		
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
			//Write more information(current cards in each player's hand)
			fileWriter.write("Player: " + name + "\n" + "Player hit\n");
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
        // Update player's earnings based on game outcome
        double playerEarnings = player1.getEarnings();
        playerData.put(playerName, playerEarnings);
        
        // Write updated player data to file
        writePlayerData(playerData);

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
	private static void writePlayerData(Map<String, Double> playerData) {
	    // Sort the player data based on winnings
	    List<Map.Entry<String, Double>> sortedPlayerData = new ArrayList<>(playerData.entrySet());
	    sortedPlayerData.sort(Map.Entry.comparingByValue());

	    try (FileWriter fileWriter = new FileWriter("players.txt")) {
	        // Write the updated player data to the file
	        for (Map.Entry<String, Double> entry : sortedPlayerData) {
	            String playerName = entry.getKey();
	            double winnings = entry.getValue();
	            fileWriter.write(playerName + ", " + winnings + "\n");
	        }
	        fileWriter.flush();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	private static int getTotalValue(List<Card> hand) {
	    int totalValue = 0;
	    int numAces = 0;

	    for (Card card : hand) {
	        totalValue += card.getValue();

	        // Check for Ace cards
	        if (card.getRank() == Rank.ACE) {
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
	private static Map<String, Double> readPlayerData() {
	    Map<String, Double> playerData = new HashMap<>();
	    File file = new File("players.txt");

	    if (!file.exists()) {
	        try {
	            file.createNewFile();
	            FileWriter fileWriter = new FileWriter(file);

	            // Add default player entries
	            playerData.put("Daun", 100.0);
	            playerData.put("Ksena", 250.5);
	            playerData.put("Josh", 50.0);

	            // Write player data to the file
	            for (Map.Entry<String, Double> entry : playerData.entrySet()) {
	                fileWriter.write(entry.getKey() + ", " + entry.getValue() + "\n");
	            }

	            fileWriter.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        try (Scanner scanner = new Scanner(file)) {
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                String[] parts = line.split(", ");
	                if (parts.length == 2) {
	                    String playerName = parts[0].trim();
	                    double winnings = Double.parseDouble(parts[1].trim());
	                    playerData.put(playerName, winnings);
	                }
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

	 // Sort the player data based on winnings
	    List<Map.Entry<String, Double>> sortedPlayerData = new ArrayList<>(playerData.entrySet());
	    sortedPlayerData.sort(Map.Entry.comparingByValue());

	    // Create a sorted map for player data
	    LinkedHashMap<String, Double> sortedPlayerDataMap = new LinkedHashMap<>();
	    for (Map.Entry<String, Double> entry : sortedPlayerData) {
	        sortedPlayerDataMap.put(entry.getKey(), entry.getValue());
	    }

	    return sortedPlayerDataMap;
	}

  
	}



