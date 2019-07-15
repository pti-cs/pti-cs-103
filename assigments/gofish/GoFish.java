/**
 * Main module.
 *----------------------------------------------------------------------------*/

package gofish;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import gofish.Card;
import gofish.Deck;
import gofish.Player;
import gofish.Utils;

/*----------------------------------------------------------------------------*/

public class GoFish {

	public static void main(String[] args) {

		Utils.printGreeting();

		Deck deck = new Deck();
		deck.shuffle();

		Player  computer = new Player();
		Player  human    = new Player();
		Scanner scanner  = new Scanner(System.in);
		GoFish  game     = new GoFish();

		int N_CARDS_PER_PLAYER = 7;
		computer.addToHand(deck.deal(N_CARDS_PER_PLAYER));
		human.addToHand(deck.deal(N_CARDS_PER_PLAYER));

		boolean is_computers_turn = true;
		boolean success;
		Card book;

		while (!deck.isEmpty()) {

			book = computer.checkForBooks();
			if (book != null)
				System.out.println("** The COMPUTER got a book of " + book.getRankAsWord() + "s!");
			book = human.checkForBooks();
			if (book != null)
				System.out.println("** You got a book of " + book.getRankAsWord() + "s!");

			Utils.printStats("Your      ", human);
			Utils.printStats("Computer's", computer);

			if (is_computers_turn)
				success = Utils.playComputersHand(scanner, deck, computer, human);
			else
				success = Utils.playHumansHand(scanner, deck, computer, human);
			
			Utils.printSep();
			if (success)
				is_computers_turn = !is_computers_turn;
		}
	}
}