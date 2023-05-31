package com.lovelace.project2;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
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
		
		System.out.println("Welcome to Lovelace's Blackjack! Are you ready to play?");
		
		String playerName = "Daun Kim";
		String directoryPath = "game_records/" + playerName;
		String filePath = directoryPath + "/game_actions.txt";

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

	}

}

