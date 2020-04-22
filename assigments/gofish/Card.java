package gofish;

import java.util.ArrayList;

public class Card {

    private String suit;
    private String rank;

    public Card(String suit, String rank) {

        ArrayList<String> allowedSuits = new ArrayList<String>();
        allowedSuits.add("C");
        allowedSuits.add("D");
        allowedSuits.add("H");
        allowedSuits.add("S");

        if (!allowedSuits.contains(suit))
            throw new IllegalArgumentException("Not an allowed suit!");

        ArrayList<String> allowedRanks = new ArrayList<String>();
        allowedRanks.add("1");
        allowedRanks.add("2");
        allowedRanks.add("3");
        allowedRanks.add("4");
        allowedRanks.add("5");
        allowedRanks.add("6");
        allowedRanks.add("7");
        allowedRanks.add("8");
        allowedRanks.add("9");
        allowedRanks.add("10");
        allowedRanks.add("J");
        allowedRanks.add("Q");
        allowedRanks.add("K");
        allowedRanks.add("A");

        if (!allowedRanks.contains(rank))
            throw new IllegalArgumentException("Not an allowed rank!");

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

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Card)) {
            return false;
        }
        return this.equalsRank(((Card) other)) && (this.suit.equals(((Card) other).getSuit()));
    }


    public String getRankAsWord() {
        String[] numNames = {
                "two", "three", "four", "five",
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
            return numNames[Integer.parseInt(this.rank) - 2];
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