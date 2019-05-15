import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Deck {

	private ArrayList<Card> cards;

	public Deck() {
		String[] SUITS = {
			"Clubs", "Diamonds", "Hearts", "Spades"
		};

		String[] RANKS = {
			"2", "3", "4", "5", "6", "7", "8", "9", "10",
			"Jack", "Queen", "King", "Ace"
		};

		// initialize deck
		int n = SUITS.length * RANKS.length;

		this.cards = new ArrayList<Card>();

		for (int i = 0; i < RANKS.length; i++) {
			for (int j = 0; j < SUITS.length; j++) {
				Card newCard = new Card(RANKS[i], SUITS[j]);
				this.cards.add(newCard);
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(this.cards); 
	}

	public Card deal() {
		int min = 0;
		int max = this.cards.size();
		int r = ThreadLocalRandom.current().nextInt(min, max + 1);
		return this.cards.remove(r);
	}

	public ArrayList<Card> deal(int nCards) {
		ArrayList<Card> dealtCards = new ArrayList<Card>();
		for (int i = 0; i < nCards; i++) {
			int min = 0;
			int max = this.cards.size();
			int r = ThreadLocalRandom.current().nextInt(min, max + 1);
			dealtCards.add(this.cards.remove(r));
		}
		assert dealtCards.size() == nCards;
		return dealtCards;

	}
}