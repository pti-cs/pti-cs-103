package gofish;

import java.util.*;

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

	public static void printHand(String message, Player player) {
		System.out.println("** " + message + " hand ("
			+ player.getNumCards() + " cards): "
			+ player.printHand());
	}

	public static void printBooks(String message, ArrayList<Card> books) {
		System.out.println("** " + message + " books: "
				+ printBooks(books));
	}

	public static String printBooks(ArrayList<Card> books)
	{
		StringBuilder s = new StringBuilder();
		for (Card book: books) {
			s.append(book.getRank()).append(", ");
		}
		return s.toString();
	}

	public static boolean playComputersHand(Scanner scanner, Deck deck, Player computer, Player human) {
		String guess = computer.guessRank();
		while(true) {
			System.out.println(ANSI_RED + "COMPUTER : Do you have a " + guess + "? (yes / go fish)" + ANSI_RESET);
			System.out.print("YOU      : ");
			String answer = scanner.nextLine().toLowerCase();
			if (answer.equals("yes")) {
				List<Card> cardsToSwap = human.giveAll(guess);
				if (cardsToSwap.size() == 0) {
					System.out.println(ANSI_RED + "COMPUTER : No you don't!" + ANSI_RESET);
				} else {
					computer.addToHand(cardsToSwap);
					return true;
				}
			} else if (answer.equals("go fish")) {
				if (human.isRankInHand(guess)) {
					System.out.println(ANSI_RED + "COMPUTER : Hey! Are you sure?" + ANSI_RESET);
				} else {
					Card draw = deck.draw();
					computer.addToHand(draw);
					if(draw.getRank().equals(guess))
					{
						System.out.println(
								"** Computer fished " +
								draw.toString() +
								" and gets another turn!");
					}
					return draw.getRank().equals(guess);
				}
			} else {
				System.out.println(ANSI_RED + "COMPUTER : I do not understand that answer." + ANSI_RESET);
			}
		}
	}

	public static boolean playHumansHand(Scanner scanner, Deck deck, Player computer, Player human) {
		while(true) {
			if (human.getNumCards() == 0)
			{
				System.out.println("** Your hand was empty, so you fished a card");
				human.addToHand(deck.draw());
				if(deck.isEmpty()){
					return false;
				}
			}
			System.out.print("** What rank do you want to ask for?\nYOU      : ");
			String guess = scanner.nextLine();
			if (!human.isRankInHand(guess)) {
				System.out.println(ANSI_RED + "COMPUTER : You can only guess ranks that are in your hand! Try again." + ANSI_RESET);
				continue;
			}
			if (computer.isRankInHand(guess)) {
				System.out.println(ANSI_RED + "COMPUTER : Yes. Good guess!" + ANSI_RESET);
				List<Card> cardsToSwap = computer.giveAll(guess);
				human.addToHand(cardsToSwap);
				return true;
			} else {
				System.out.println(ANSI_RED + "COMPUTER : Go fish!" + ANSI_RESET);
				Card draw = deck.draw();
				human.addToHand(draw);
				if(draw.getRank().equals(guess))
				{
					System.out.println(
							"** You fished " +
							draw.toString() +
							" and get another turn!");
				}
				return draw.getRank().equals(guess);
			}
		}
	}

	public static void printSep() {
		System.out.println("-----------------------------------");
	}


	public static boolean legalSuitAndRank(String suit, String rank) {

		ArrayList<String> allowedSuits = new ArrayList<String>();
		allowedSuits.add("C");
		allowedSuits.add("D");
		allowedSuits.add("H");
		allowedSuits.add("S");

		if (!allowedSuits.contains(suit))
			return false;

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

		if (!allowedRanks.contains(rank)) {
			return false;
		}
		return true;
	}
}