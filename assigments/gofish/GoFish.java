package gofish;

import java.util.ArrayList;
import java.util.Scanner;

/*----------------------------------------------------------------------------*/

public class GoFish {

	public static void main(String[] args) {

		Utils.printGreeting();

		Deck deck = new Deck();

		Player  computer = new Player();
		Player  human    = new Player();
		Scanner scanner  = new Scanner(System.in);

		int N_CARDS_PER_PLAYER = 7;
		computer.addToHand(deck.deal(N_CARDS_PER_PLAYER));
		human.addToHand(deck.deal(N_CARDS_PER_PLAYER));

		boolean is_computers_turn = true;
		boolean success;
		Card book;
		ArrayList<Card> humanBooks = new ArrayList<Card>();
		ArrayList<Card> computerBooks = new ArrayList<Card>();

		while (!deck.isEmpty()) {

			book = computer.checkForBooks();
			if (book != null)
			{
				System.out.println("** The COMPUTER got a book of " + book.getRankAsWord() + "s!");
				computerBooks.add(book);
			}
			book = human.checkForBooks();
			if (book != null)
			{
				System.out.println("** You got a book of " + book.getRankAsWord() + "s!");
				humanBooks.add(book);
			}

			Utils.printHand("Your      ", human);
//			Utils.printHand("Computer's", computer);
			Utils.printBooks("Your      ", humanBooks);
			Utils.printBooks("Computer's", computerBooks);

			if (is_computers_turn)
				success = Utils.playComputersHand(scanner, deck, computer, human);
			else
				success = Utils.playHumansHand(scanner, deck, computer, human);
			
			Utils.printSep();
			if (!success)
				is_computers_turn = !is_computers_turn;
		}
		System.out.println("** Deck finished, game ends! ");
		String winner = (humanBooks.size() > computerBooks.size() ?
				"You" : (humanBooks.size() == computerBooks.size()?
				"Tie" : "Computer"));
		System.out.println("** Winner: " + winner + "! Books: " +
				humanBooks.size() + "/" + computerBooks.size());
	}
}