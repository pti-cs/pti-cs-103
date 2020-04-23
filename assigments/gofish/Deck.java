package gofish;

import gofish.Card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
//import java.util.List;
import java.util.Random;

public class Deck {

 private ArrayList<Card> cards;
 private Random rand = new Random();

 public Deck() {
  String[] SUITS = {
   "C", "D", "H", "S"
  };

  String[] RANKS = {
   "2", "3", "4", "5", "6", "7", "8", "9", "10",
   "J", "Q", "K", "A"
  };

  // initialize deck
  int n = SUITS.length * RANKS.length;

  this.cards = new ArrayList<Card>();

  for (int i = 0; i < RANKS.length; i++) {
   for (int j = 0; j < SUITS.length; j++) {
    Card newCard = new Card(SUITS[j], RANKS[i]);
    this.cards.add(newCard);
   }
  }
  Collections.shuffle(this.cards);
 }

 public boolean isEmpty() {
  return this.cards.size() == 0;
 }

 public int size() {
   return this.cards.size();
 }

 public Card draw() {
   if (this.isEmpty())
     throw new IllegalStateException("No cards left to draw!");
   return this.cards.remove(this.cards.size() - 1);
 }
 
 public Collection<Card> deal(int nCards) {
   if (this.cards.size()<nCards)
     throw new IllegalStateException("Not enough cards to deal!");
   ArrayList<Card> dealtCards = new ArrayList<Card>();
   for (int i = 0; i < nCards; i++) {
     dealtCards.add(this.draw());
   }
   assert dealtCards.size() == nCards;
   return dealtCards;
 }
}