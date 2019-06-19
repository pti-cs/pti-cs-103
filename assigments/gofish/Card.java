/**
 * Represents card with suit and rank.
 *----------------------------------------------------------------------------*/

package gofish;

import java.util.ArrayList;

public class Card {
		
	private String suit;
	private String rank;

	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public String getSuit() {
		return this.suit;
	}

	public String getRank() {
		return this.rank;
	}

	public String toString() {
		return this.rank + this.suit;
	}

	public boolean equalsRank(Card other) {
		return this.rank.equals(other.getRank());
	}

	public String getRankAsWord() {
		String[] numNames = {
			"one", "two", "three", "four", "five",
			"six", "seven", "eight", "nine", "ten"
		};
		if (this.rank.equals("J")) {
			return "jack";
		} else if (this.rank.equals("Q")) {
			return "queen";
		} else if (this.rank.equals("K")) {
			return "king";
		} else if (this.rank.equals("A")) {
			return "ace";
		} else {
			return numNames[Integer.parseInt(this.rank) - 1];
		}
	}

	public int getRankAsInt() {
		if (this.rank.equals("J")) {
			return 11;
		} else if (this.rank.equals("Q")) {
			return 12;
		} else if (this.rank.equals("K")) {
			return 13;
		} else if (this.rank.equals("A")) {
			return 14;
		} else {
			return Integer.parseInt(this.rank);
		}
	}
}