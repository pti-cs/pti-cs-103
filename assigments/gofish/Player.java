import java.util.ArrayList;

public class Player {

	private ArrayList<Card> cards;

	public Player() {
		this.cards = new ArrayList<Card>();
	}

	public boolean cardInHand(Card guessCard) {
		for (Card card : this.cards) {
			if (card == guessCard) {
				return true;
			}
		}
		return false;
	}

	public void addToHand(Card newCard) {
		this.cards.add(newCard);
	}

	public void addToHand(ArrayList<Card> newCards) {
		this.cards.addAll(newCards);
	}

	public int getNumCards() {
		return this.cards.size();
	}

	public String visualizeHand() {
		String result = "";

		for (int i = 0; i < this.cards.size(); i++) {
			result += this.cards.get(i).toString() + " ";
		}
		return result;
	}
}