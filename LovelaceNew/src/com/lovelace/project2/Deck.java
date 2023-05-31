package com.lovelace.project2;
import java.util.List;
import java.util.ArrayList;

public class Deck {

	private Card dealtCard;
			private int numberOfCards = 312;
			private static Deck deckOfCards;
			
	
			private Deck(Deck deckOfCards) {
				Deck.deckOfCards = initialDeck();
			}
			
			public Deck() {}
			public Deck(Card dealtCard, int numberOfCards, List<List<Card>> deckOfCards){
				this.dealtCard = dealtCard;
				// implement method?
				this.numberOfCards = numberOfCards;
				Deck.deckOfCards = startingDeck();
				}
			public Card getDealtCard() {
				getDeckOfCards();
				
				return dealtCard; // use random class
			}
			public void setDealtCard(Card dealtCard) {
				this.dealtCard = dealtCard; // probably don't need this method
			}
			public int getNumberOfCards() {
				return numberOfCards;
			}
			public void setNumberOfCards(int numberOfCards) {
				this.numberOfCards = numberOfCards;
			}
			public List<List<Card>> getDeckOfCards() {
				return deckOfCards;
			}
			public void setDeckOfCards (List<List<Card>> deckOfCards) {
				Deck.deckOfCards = deckOfCards;
			}
	
			public static void main(String[] args) {
	
				
			}
			
			public static List<List<Card>> initialDeck() {
				List<Card> startingDeck = new ArrayList<Card>();
				startingDeck.add(new Card(Suit.DIAMONDS, 2));
				startingDeck.add(new Card(Suit.DIAMONDS, 3));
				startingDeck.add(new Card(Suit.DIAMONDS, 4));
				startingDeck.add(new Card(Suit.DIAMONDS, 5));
				startingDeck.add(new Card(Suit.DIAMONDS, 6));
				startingDeck.add(new Card(Suit.DIAMONDS, 7));
				startingDeck.add(new Card(Suit.DIAMONDS, 8));
				startingDeck.add(new Card(Suit.DIAMONDS, 9));
				startingDeck.add(new Card(Suit.DIAMONDS, 10));
				startingDeck.add(new Card(Suit.JACK_OF_DIAMONDS, 10));
				startingDeck.add(new Card(Suit.QUEEN_OF_DIAMONDS, 10));
				startingDeck.add(new Card(Suit.KING_OF_DIAMONDS, 10));
				startingDeck.add(new Card(Suit.DIAMOND_ACE, _));
				startingDeck.add(new Card(Suit.CLUBS, 2));
				startingDeck.add(new Card(Suit.CLUBS, 3));
				startingDeck.add(new Card(Suit.CLUBS, 4));
				startingDeck.add(new Card(Suit.CLUBS, 5));
				startingDeck.add(new Card(Suit.CLUBS, 6));
				startingDeck.add(new Card(Suit.CLUBS, 7));
				startingDeck.add(new Card(Suit.CLUBS, 8));
				startingDeck.add(new Card(Suit.CLUBS, 9));
				startingDeck.add(new Card(Suit.CLUBS, 10));
				startingDeck.add(new Card(Suit.JACK_OF_CLUBS, 10));
				startingDeck.add(new Card(Suit.QUEEN_OF_CLUBS, 10));
				startingDeck.add(new Card(Suit.KING_OF_CLUBS, 10));
				startingDeck.add(new Card(Suit.CLUB_ACE, _));
				startingDeck.add(new Card(Suit.SPADES, 2));
				startingDeck.add(new Card(Suit.SPADES, 3));
				startingDeck.add(new Card(Suit.SPADES, 4));
				startingDeck.add(new Card(Suit.SPADES, 5));
				startingDeck.add(new Card(Suit.SPADES, 6));
				startingDeck.add(new Card(Suit.SPADES, 7));
				startingDeck.add(new Card(Suit.SPADES, 8));
				startingDeck.add(new Card(Suit.SPADES, 9));
				startingDeck.add(new Card(Suit.SPADES, 10));
				startingDeck.add(new Card(Suit.JACK_OF_SPADES, 10));
				startingDeck.add(new Card(Suit.QUEEN_OF_SPADES, 10));
				startingDeck.add(new Card(Suit.KING_OF_SPADES, 10));
				startingDeck.add(new Card(Suit.SPADE_ACE, _));
				startingDeck.add(new Card(Suit.HEARTS, 2));
				startingDeck.add(new Card(Suit.HEARTS, 3));
				startingDeck.add(new Card(Suit.HEARTS, 4));
				startingDeck.add(new Card(Suit.HEARTS, 5));
				startingDeck.add(new Card(Suit.HEARTS, 6));
				startingDeck.add(new Card(Suit.HEARTS, 7));
				startingDeck.add(new Card(Suit.HEARTS, 8));
				startingDeck.add(new Card(Suit.HEARTS, 9));
				startingDeck.add(new Card(Suit.HEARTS, 10));
				startingDeck.add(new Card(Suit.JACK_OF_HEARTS, 10));
				startingDeck.add(new Card(Suit.QUEEN_OF_HEARTS, 10));
				startingDeck.add(new Card(Suit.KING_OF_HEARTS, 10));
				startingDeck.add(new Card(Suit.HEART_ACE, _));
				
				return startingDeck;
			}
	//		public Card[] newDeck() {
	//			
	//		}
	//		System.out.println("Welcome to Blackjack.");
	//
	//        Random rand = new Random();
	//
	//        int value1 = (int) (Math.random() * );
	//        Suit firstCardSuit = (int) (Math.random() *);
	//        int value2 = (int) (Math.random() * );
	//        Suit secondCardSuit = (int) (Math.random() *);
	//
	//        if suit == HEART ...
	//
	//        System.out.print(card(firstCardSuit, int value1]);
	
	
	
			public static int choosingAces(Card card?) {
				Scanner in = new Scanner(System.in);
				if (new Card() == new Card("Ace", 0)) {
					System.out.println("Would you like your Ace to count as a 1 or 10?\nPlease enter below:");
					int answer = in.nextInt();
					if (answer == 1) {
						Card ace1 = new Card("Ace", 1);
						return ace1;
					} else if (answer == 10) {
						Card ace10 = new Card("Ace", 10);
						return ace10;
					} else {
	//					return "Please enter a valid answer";
					}
				}
	//			return throws IllegalArgumentException();
				return null;
			}
			public static void shuffle() {
				Deck.shuffle();
			}
	
			public Card deal() {
				
				return dealtCard;
				
			}
			public Card draw() throws EmptyDeckException
			{
					if(initialDeck.size() < 1)
						throw new EmptyDeckException("The deck is empty !");
					return initialDeck.pollFirst();
			}
	//		  public void deal(){
	//			    for (int i = 0; i < 52; i++) {
	//			       String suit = suits[deck[i] / 10];
	//			       String rank = ranks[deck[i] % 10];
	//			       System.out.println( rank + " of " + suit);
	//			       System.out.println("Remaining cards: " + remainingCards);
	//			     }
	//			   }
	//			}
			// need something to show the cards
			// what cards have been pulled vs what is remaining
			// reset method
			// use new random for dealing
			
	
			
			
			
	

}
