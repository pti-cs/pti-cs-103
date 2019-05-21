/**
 * MIT License
 *
 * Copyright (c) 2019 The Prison Teaching Initiative
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *----------------------------------------------------------------------------*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoFish {

	/**
	 * TODO: Javadoc for every public method.
	 */
	public static void main(String[] args) {

		Deck deck = new Deck();
		deck.shuffle();

		Player computer = new Player();
		Player human    = new Player();
		Scanner scanner = new Scanner(System.in);
		GoFish game     = new GoFish();

		computer.addToHand(deck.deal(5));
		human.addToHand(deck.deal(5));

		System.out.println("===================================");
		System.out.println("\n"
			+ "  _____         ______ _     _     \n"
			+ " / ____|       |  ____(_)   | |    \n"
			+ "| |  __  ___   | |__   _ ___| |__  \n"
			+ "| | |_ |/ _ \\  |  __| | / __| '_ \\ \n"
			+ "| |__| | (_) | | |    | \\__ \\ | | |\n"
			+ " \\_____|\\___/  |_|    |_|___/_| |_|\n");
		System.out.println("===================================\n");

		int i = 0;

		while (!deck.isEmpty()) {

			System.out.println("** Your hand       ("
				+ human.getNumCards() + " / "
				+ human.getNumBooks() + "): "
				+ human.printHand());
			System.out.println("** Computer's hand ("
				+ computer.getNumCards() + " / "
				+ computer.getNumBooks() + "): "
				+ computer.printHand());

			if (i % 2 == 0) {
				String guessedRank = computer.guessRank();
				System.out.println("COMPUTER : Do you have a " + guessedRank + "? (yes / go fish)");
				System.out.print("YOU      : ");
				String answer = scanner.nextLine();
				if (answer.equals("yes")) {
					List<Card> cardsToSwap = human.giveAll(guessedRank);
					computer.addToHand(cardsToSwap);
					Card book = computer.checkForBooks();
					if (book != null) {
						System.out.println("** You got a book of " + book.toString() + "s!");
					}
				} else {
					computer.addToHand(deck.draw());
				}
			} else {
				System.out.print("** What rank do you want to ask for?\nYOU      : ");
				String guessedRank = scanner.nextLine();
				if (computer.isRankInHand(guessedRank)) {
					System.out.println("COMPUTER : Good guess!");
					List<Card> cardsToSwap = computer.giveAll(guessedRank);
					human.addToHand(cardsToSwap);
					Card book = human.checkForBooks();
					if (book != null) {
						System.out.println("** You got a book of " + book.toString() + "s!");
					}
				} else {
					System.out.println("COMPUTER : Go fish!");
					human.addToHand(deck.draw());
				}
			}
			System.out.println("-----------------------------------");
			i++;
		}
	}
}