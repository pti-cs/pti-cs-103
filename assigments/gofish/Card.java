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

    public boolean equals(Card other) {
    	return this.suit.equals(other.getSuit()) && this.rank.equals(other.getRank());
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