package com.lovelace.project2;

import java.util.List;

public class Dealer {
	private List<Card> hand;

	public void play() {

	}

	public List<Card> getHand() {
		return null;
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
