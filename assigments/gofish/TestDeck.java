package gofish;
import java.util.Collection;
import java.util.Random;

public class TestDeck {
  public static void main(String[] args) {
    boolean allGood = true; 
    
    /*-------------  SUPPLIED TESTS  -------------*/
    if (!testSize()) {
      System.out.println("Failed to test size");
      allGood = false;
    }
    
    if (!testDrawEmpty()) {
      System.out.println("Failed to test drawing from empty deck");
      allGood = false;
    }

    if (!testDeal()){
      System.out.println("Failed to test dealing cards");
      allGood = false;
    }
    /*--------------------------------------------*/
    
    if (allGood) {
      System.out.println("All good!");
    }
    
  }

  public static boolean testSize(){
    Deck deck = new Deck();
    for (int i = 52; i > 0; i--) {
      if(deck.size() != i){
        return false;
      }
      deck.draw();
    }
    return true;
  }

  public static boolean testDeal(){
    Deck deck = new Deck();
    Random rand = new Random();
    int drawAmount = rand.nextInt(52) + 1;
    Collection<Card> dealtCards = deck.deal(drawAmount);
    if(dealtCards.size() != drawAmount){
      return false;
    }
    if(deck.size() != 52 - drawAmount){
      return false;
    }
    return true;
  }

  public static boolean testDrawEmpty(){
    Deck deck = new Deck();
    deck.deal(52);
    try {
      deck.draw();
    }
    catch (IllegalStateException e) {
      return true;
    }
    return false;
  }

}
