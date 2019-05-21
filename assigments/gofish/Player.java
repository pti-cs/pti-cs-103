import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Player {

	private List<Card> hand;
	private int numBooks;
	private Random rand = new Random();

	public Player() {
		this.hand = new ArrayList<Card>();
	}

	public boolean isRankInHand(String guessedRank) {
		for (Card card : this.hand) {
			if (card.getRank().equals(guessedRank)) {
				return true;
			}
		}
		return false;
	}

	public String guessRank() {
		int r = this.rand.nextInt(this.hand.size());
		Card guessedCard = this.hand.get(r);
		return guessedCard.getRank();
	}

	public List<Card> giveAll(String rank) {
		List<Card> cardsToRemove = new ArrayList<Card>();
		for (Card card : this.hand) {
			if (card.getRank().equals(rank)) {
				cardsToRemove.add(card);
			}
		}
		this.hand.removeAll(cardsToRemove);
		return cardsToRemove;
	}

	public void addToHand(Card newCard) {
		this.hand.add(newCard);
	}

	public void addToHand(List<Card> newCards) {
		this.hand.addAll(newCards);
	}

	public int getNumCards() {
		return this.hand.size();
	}

	public int getNumBooks() {
		return this.numBooks;
	}

	public Card checkForBooks() {
		for (Card c : this.hand) {
			int num = 0;
			for (Card d : this.hand) {

				if (c == d) {
					num++;
				}
			}
			if (num == 2) {
				System.out.println("num books == 2");
				for (Card d : this.hand) {
					if (c == d) this.hand.remove(d);
				}
				this.numBooks++;
				return c;
			}
		}
		return null;
	}

	public String printHand() {
		this.hand.sort((Card c1, Card c2) -> c1.getRankAsInt() < c2.getRankAsInt() ? 1 : 0);
		List<String> cardsAsStrings = new ArrayList<String>();
		String result = "";
		for (Card card : this.hand) {
			cardsAsStrings.add(card.toString());
		}
		return String.join(", ", cardsAsStrings);
	}
}