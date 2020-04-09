import gofish.Card;

public class TestDeck {
  public static void main(String[] args) {
    boolean allGood = true; 
    
    /*-------------  SUPPLIED TESTS  -------------*/
    if (!cardGetsSuit()) {
      System.out.println("Failed to properly get suit");
      allGood=false;
    }
    
    if (!cardRejectsBadSuit()) {
      System.out.println("Failed to reject bad suit");
      allGood=false;
    }
    /*--------------------------------------------*/
    
    if (allGood) {
      System.out.println("All good!");
    }
    
  }
  
  public static boolean cardGetsSuit() {
    String suit = "S";
    String rank = "10";
    Card card = new Card(suit, rank);
    return card.getSuit()==suit;
  }

  public static boolean cardRejectsBadSuit() {
    String suit = "A"; // A is not a suit
    String rank = "10";
    try {
      Card card = new Card(suit, rank);
    }
    catch (Exception e) {
      return true; 
    }
    
    return false; 
  }
}
