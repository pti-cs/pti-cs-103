package gofish;

import gofish.Card;

//import java.util.Arrays;
import java.util.*;
//import java.util.Comparator;


public class Player {

 private List<Card> hand;
 private int numBooks;
 private Random rand = new Random();
 private String prevGuess = null;

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
  String newGuess;
  do {
   int r = this.rand.nextInt(this.hand.size());
   Card guessedCard = this.hand.get(r);
   newGuess = guessedCard.getRank();
  } while (newGuess.equals(this.prevGuess));
  this.prevGuess = newGuess;
  return newGuess;
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

 public Iterator<Card> getHand() {
  return this.hand.iterator();
 }

 public void addToHand(Card newCard) {
  this.hand.add(newCard);
 }

 public void addToHand(Collection<Card> newCards) {
  this.hand.addAll(newCards);
 }

 public int getNumCards() {
  return this.hand.size();
 }

 public int getNumBooks() {
  return this.numBooks;
 }

 public Card checkForBooks() {
  int NUM_FOR_BOOK = 4;
  for (Card c : this.hand) {
   int num = 0;
   for (Card d : this.hand) {
    if (c.equalsRank(d)) {
     num++;
    }
   }
   if (num >= NUM_FOR_BOOK) {
    Iterator<Card> iterator = this.hand.iterator();
    while (iterator.hasNext()) {
     Card d = iterator.next();
     if (c.equalsRank(d)) {
      iterator.remove();
     }
    }
    this.numBooks++;
    return c;
   }
  }
  return null;
 }

 public String printHand() {
   // TODO: sort cards by rank.
  List<String> cardsAsStrings = new ArrayList<String>();
  String result = "";
  for (Card card : this.hand) {
   cardsAsStrings.add(card.toString());
  }
  // Join cardsAsStrings 
  String s = "";
  for (String str : cardsAsStrings) {
     s += str + ", ";
  }
  return s;
 }
}

