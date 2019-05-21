import java.util.Scanner;

public class GoFish {

	Deck deck;
	Player computer1;
	Player computer2;
	Player human;

	public GoFish() {
		this.deck = new Deck();
		this.deck.shuffle();

		this.computer1 = new Player();
		this.computer2 = new Player();
		this.human     = new Player();

		this.computer1.addToHand(this.deck.deal(5));
		this.computer2.addToHand(this.deck.deal(5));
		this.human.addToHand(this.deck.deal(5));

		System.out.println(this.computer1.visualizeHand());
		System.out.println(this.computer2.visualizeHand());
		System.out.println(this.human.visualizeHand());
	}

	public boolean gameOver() {
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GoFish game = new GoFish();

		while (!game.gameOver()) {
			System.out.println("Please enter a card rank and suite, e.g. 9 Hearts");
			String guess = scanner.next();
			String[] parts = guess.split("-");
			Card guessedCard = new Card(parts[0], parts[1]);
			boolean result = game.computer1.cardInHand(guessedCard);
			System.out.println(result);
		}
	}
}