package com.lovelace.project2;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private double earnings;
	private List<Card> hand;

	// constructors
	public Player(String name) {
		this.name = name;
		this.earnings = 0.0;
		this.hand = new ArrayList<>();
	}

	public Player(String playerName, double playerWinnings) {
		// TODO Auto-generated constructor stub
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public double getEarnings() {
		return earnings;
	}

	public void setEarnings(double earnings) {
		this.earnings = earnings;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void hit(Card card) {
		hand.add(card);
	} // deal?

	public void split() {
		if (hand.size() == 2 && hand.get(0).getValue() == hand.get(1).getValue()) {
			// Check if the player has two cards of the same value for splitting
			Card cardToSplit = hand.remove(1); // Remove the second card from the hand
			// Create a new hand with the split card
			List<Card> newHand = new ArrayList<>();
			newHand.add(cardToSplit);
			// Add the split card to the new hand
			// The original hand still contains the first card

		} else {
			System.out.println("Splitting is not possible. Your hand does not meet the requirements.");
		}
	}

	public void stay() {
		System.out.println("Player chooses to stay.");
		Dealer dealer = new Dealer();
		dealer.play(); // Dealer takes their turn
		evaluateOutcome(dealer); // Evaluate the outcome and determine the winner
	}

	private void evaluateOutcome(Dealer dealer) {
		// TODO Auto-generated method stub
		// compares the scores of the player's hand and the dealer's hand
		// using the calculateScore() method below
		int playerScore = calculateScore(hand);
		int dealerScore = calculateScore(dealer.getHand());

		// The outcome is determined based on the comparison of the scores.
		if (playerScore > 21) {
			// If either the player or the dealer busts (exceeds 21)
			System.out.println("Player busts! Dealer wins.");
		} else if (dealerScore > 21) {
			System.out.println("Dealer busts! Player wins.");
			// the winner is determined based on the highest score
		} else if (playerScore > dealerScore) {
			System.out.println("Player wins!");
		} else if (playerScore < dealerScore) {
			System.out.println("Dealer wins!");
		} else {
			// If the scores are equal it's a tie.
			System.out.println("It's a tie!");
		}
	}

	private int calculateScore(List<Card> hand) {
		// calculates the score based on the blackjack rules
		// considering the values of the cards in the hand
		int score = 0;
		int numAces = 0;

		for (Card card : hand) {
			if (card.getValue() == 1) {
				numAces++;
				score += 11;
			} else if (card.getValue() >= 10) {
				score += 10;
			} else {
				score += card.getValue();
			}
		}

		// Adjust score if there are aces in the hand
		while (score > 21 && numAces > 0) {
			score -= 10;
			numAces--;
		}

		return score;
	}

	public int getValue() {
		int value = 0;
		int numAces = 0;

		for (Card card : hand) {
			value += card.getValue();
			if (card.getValue() == 11) {
				numAces++;
			}
		}

		while (value > 21 && numAces > 0) {
			value -= 10;
			numAces--;
		}

		return value;
	}

}