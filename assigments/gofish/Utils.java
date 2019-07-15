/**
 * Private functions.
 *----------------------------------------------------------------------------*/

package gofish;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Utils {

	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static void printGreeting() {
		System.out.println(ANSI_BLUE + "===================================");
		System.out.println("\n"
			+ "  _____         ______ _     _     \n"
			+ " / ____|       |  ____(_)   | |    \n"
			+ "| |  __  ___   | |__   _ ___| |__  \n"
			+ "| | |_ |/ _ \\  |  __| | / __| '_ \\ \n"
			+ "| |__| | (_) | | |    | \\__ \\ | | |\n"
			+ " \\_____|\\___/  |_|    |_|___/_| |_|\n");
		System.out.println("===================================\n" 
			+ ANSI_RESET);
	}

	public static void printStats(String message, Player player) {
		System.out.println("** " + message + " hand ("
			+ player.getNumCards() + " / "
			+ player.getNumBooks() + "): "
			+ player.printHand());
	}

	public static boolean playComputersHand(Scanner scanner, Deck deck, Player computer, Player human) {
		String guess = computer.guessRank();
		System.out.println(ANSI_RED + "COMPUTER : Do you have a " + guess + "? (yes / go fish)" + ANSI_RESET);
		System.out.print("YOU      : ");
		String answer = scanner.nextLine().toLowerCase();
		if (answer.equals("yes")) {
			List<Card> cardsToSwap = human.giveAll(guess);
			if (cardsToSwap.size() == 0) {
				System.out.println(ANSI_RED + "COMPUTER : No you don't!" + ANSI_RESET);
				return false;
			} else {
				computer.addToHand(cardsToSwap);
				return true;
			}
		} else if (answer.equals("go fish")) {
			if (human.isRankInHand(guess)) {
				System.out.println(ANSI_RED + "COMPUTER : Hey! Are you sure?" + ANSI_RESET);
				return false;
			} else{
				computer.addToHand(deck.draw());
				return true;
			}
		} else {
			System.out.println(ANSI_RED + "COMPUTER : I do not understand that answer." + ANSI_RESET);
			return false;
		}
	}

	public static boolean playHumansHand(Scanner scanner, Deck deck, Player computer, Player human) {
		System.out.print("** What rank do you want to ask for?\nYOU      : ");
		String guess = scanner.nextLine();
		if (!human.isRankInHand(guess)) {
			System.out.println(ANSI_RED + "COMPUTER : You can only guess ranks that are in your hand! Try again." + ANSI_RESET);
			return false;
		}
		if (computer.isRankInHand(guess)) {
			System.out.println(ANSI_RED + "COMPUTER : Yes. Good guess!" + ANSI_RESET);
			List<Card> cardsToSwap = computer.giveAll(guess);
			human.addToHand(cardsToSwap);
			return true;
		} else {
			System.out.println(ANSI_RED + "COMPUTER : Go fish!" + ANSI_RESET);
			human.addToHand(deck.draw());
			return true;
		}
	}

	public static void printSep() {
		System.out.println("-----------------------------------");
	}
}