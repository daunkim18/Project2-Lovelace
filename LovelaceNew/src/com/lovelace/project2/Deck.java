package com.lovelace.project2;

import java.util.List;

import java.util.Scanner;
import java.util.ArrayList;

public class Deck {

	private static Card dealtCard;
	private int numberOfCards = 312;
	private static Deck deckOfCards;

	public Deck() {
	}

	public Deck(Card dealtCard, int numberOfCards, List<Card> deckOfCards) {
		Deck.dealtCard = dealtCard;
		// implement method?
		this.numberOfCards = numberOfCards;
		Deck.deckOfCards = (Deck) initialDeck();
	}

	public Card getDealtCard() {
		return dealtCard;
	}

	public void setDealtCard(Card dealtCard) {
		Deck.dealtCard = dealtCard; // probably don't need this method
	}

	public int getNumberOfCards() {
		return numberOfCards;
	}

	public void setNumberOfCards(int numberOfCards) {
		this.numberOfCards = numberOfCards;
	}

	public Deck getDeckOfCards() {
		return deckOfCards;
	}

	public void setDeckOfCards(Deck deckOfCards) {
		Deck.deckOfCards = deckOfCards;
	}

	public static List<Card> initialDeck() {
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
		startingDeck.add(new Card(Suit.DIAMOND_ACE, choosingAces(dealtCard)));
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
		startingDeck.add(new Card(Suit.CLUB_ACE, choosingAces(dealtCard)));
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
		startingDeck.add(new Card(Suit.SPADE_ACE, choosingAces(dealtCard)));
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
		startingDeck.add(new Card(Suit.HEART_ACE, choosingAces(dealtCard)));

		return startingDeck;
	}

	public static int choosingAces(Card card) {
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like your Ace to count as a 1 or 10?\nPlease enter below:");
		int answer = in.nextInt();
		if (answer == 1) {
			dealtCard.setValue(1);
			return 1;
		} else if (answer == 10) {
			dealtCard.setValue(10);
			return 10;
		} else { // need to handle other cases

		}
		return answer;

	}

	public static void shuffle(Deck deck) {
		Deck.shuffle(deck);
	}

	public Card deal() {

		Deck a = new Deck();
		Deck.shuffle(a);
		Card dealtCard = ((List<Card>) a).remove(0);
		return dealtCard;

	}

}
