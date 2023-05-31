package com.lovelace.project2;

public class Card {
	private Suit suit; //enum suit
    private int value;
    
    
    
    public Card(Suit suit, int value) {
        this.value = value;
        this.suit = suit;
        
        System.out.println("Suit: " + suit);   // Output: Suit: Hearts
        System.out.println("Value: " + value); // Output: Value: 0
    }

    public int getValue() {
        return value;
    }

	public Suit getSuit() {
		return suit;
	
	}
}
