package com.lovelace.project2;

public class Card {
    private Suit suit; // enum suit
    private Rank rank; // enum rank
    private int value;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        if (rank.ordinal() > 10) {
            return 10; // Face cards (J, Q, K) have a value of 10
        } else if (rank == Rank.ACE) {
            return 11; // Ace has a value of 11
        } else {
            return rank.ordinal() + 1; // For other cards, the value is the rank + 1
        }
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
