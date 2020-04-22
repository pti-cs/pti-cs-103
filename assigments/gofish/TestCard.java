package gofish;

public class TestCard {
  public static void main(String[] args) {
    boolean allGood = true; 
    
    /*-------------  SUPPLIED TESTS  -------------*/
    if (!testGetSuit()) {
      System.out.println("Failed to properly get suit");
      allGood=false;
    }
    
    if (!testRejectBadSuit()) {
      System.out.println("Failed to reject bad suit");
      allGood=false;
    }
    /*--------------------------------------------*/
    
    if (allGood) {
      System.out.println("All good!");
    }
    
  }
  
  public static boolean testGetSuit() {
    String suit = "S";
    String rank = "10";
    Card card = new Card(suit, rank);
    return card.getSuit().equals(suit);
  }

  public static boolean testRejectBadSuit() {
    String suit = "A"; // A is not a suit
    String rank = "10";
    try {
      Card card = new Card(suit, rank);
    }
    catch (IllegalArgumentException e) {
      return true; 
    }
    
    return false; 
  }
}
