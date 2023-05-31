package com.lovelace.project2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class House {

//		Cards in hand
//		Earnings
//		Hit method -- in player class
//		Stay method -- in player class
		private static double earnings;
		// figure out how to calculate earnings from betswon / betslost / betplaced
		private static ArrayList<Card> cardsInHand;
		// take dealt cards from arraylist
		// take more if player chose to hit
		private List<Integer> playerBets;
	    private List<Boolean> playerWins;
	    

	    private House() {
	    	earnings = 0;
	    	ArrayList<Card> cardsInHand = new ArrayList<>();
	    	// add the deals together?
	        playerBets = new ArrayList<>();
	        playerWins = new ArrayList<>();
	        
	    }


	    public void placeBet(int betAmount) {
	        playerBets.add(betAmount);
	    }

	    public void playerWin() {
	        playerWins.add(true);
	    }
	    public void playerLose() {
	        playerWins.add(false);
	    }

	    public void calculateHouseEarnings() {
	        for (int i = 0; i < playerBets.size(); i++) {
	            int bet = playerBets.get(i);
	            boolean win = playerWins.get(i);

	            if (win) {
	                earnings -= bet;
	            } else {
	                earnings += bet;
	            }
	        }
	    }

	    public double getHouseEarnings() {
	        return earnings;
	    }
		public Card deal(ArrayList<Card> a) {
			ArrayList<Card>.shuffle(a); // help
			Card drawnCard = ((ArrayList<Card>) a).remove(0);
			return drawnCard;

		}


		// method for calculating total value in hand with ability to bust

		public static ArrayList<Card> getCardsInHand() {
			return cardsInHand;
		}

		public static void setCardsInHand(ArrayList<Card> cardsInHand) {
			House.cardsInHand = cardsInHand;
		}
		public static double getEarnings() {
			return earnings;
		}

		public static void setEarnings(double earnings) {
			House.earnings = earnings;
		}
		public void houseVersionHit(ArrayList<Card> hand) {
		    while (calculateHandValue(hand) < 17) {
		        Card drawnCard = hand.deal(); // figure this out
		       hand.add(drawnCard); // copy from player?
		    }
		}
		//copy stay method for dealer

		public int calculateHandValue(ArrayList<Card> hand) {
		    int totalValue = 0;
		    int numAces = 0;

		    for (Card card : hand) {
		        totalValue += card.getValue();
		        if (card.getSuit() == Suit.SPADE_ACE || card.getSuit() == Suit.DIAMOND_ACE || card.getSuit() == Suit.HEART_ACE || card.getSuit() == Suit.CLUB_ACE ){
		            numAces++;
		        }
		    }
		    // Adjust the value of aces based on the current hand value
		    while (totalValue > 21 && numAces > 0) {
		        totalValue -= 10; // Treat an ace as 1 instead of 11 ?
		        numAces--;
		    }

		    return totalValue;
		}
		public void displayHand(ArrayList<Card> hand) {
		    System.out.println("Cards in hand:");
		    for (Card card : hand) {
		        System.out.println(card.getValue() + " of " + card.getSuit());
		    }
		    System.out.println("Total value: " + calculateHandValue(hand));
		}
		// need to figure out how to build a hand 
}