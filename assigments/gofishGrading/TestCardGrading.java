package gofishGrading;

import gofish.Card;
import gofish.Utils;
import org.junit.Rule;
import org.junit.Test;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

public class TestCardGrading {

    int nIterTests = 100000;

    @Test
    public void testInitGoodArgs(){
        String[] suits = new String[]{"D", "C", "S", "H"};
        String[] ranks = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "J", "Q", "K", "A"};
        for (String suit: suits) {
            for (String rank: ranks) {
                Card card = new Card(suit, rank);
            }
        }
    }

    @Test
    public void testInitBadArgs(){
        Random generator = new Random();
        String badSuitCharacters = "ABEFGIJKLMNOPQRTUVWXYZ";
        // bad suit, good rank
        for (int i = 0; i < nIterTests; i++) {
            String suit = Character.toString(badSuitCharacters.
                    charAt(generator.nextInt(badSuitCharacters.length())));
            String rank = Integer.toString(generator.nextInt(10) + 1);
            assertThrows(IllegalArgumentException.class, () -> new Card(suit, rank));
        }
        // bad rank, good suit
        String goodSuitCharacters = "DCSH";
        String badRankCharacters = "BCDEFGHILMNOPRSTUVWXYZ";
        for (int i = 0; i < nIterTests; i++) {
            String suit = Character.toString(goodSuitCharacters.
                    charAt(generator.nextInt(goodSuitCharacters.length())));
            String rank;
            if (generator.nextBoolean()) {
                rank = Character.toString(badRankCharacters.
                        charAt(generator.nextInt(badRankCharacters.length())));
            }
            else {
                rank = Integer.toString(generator.nextInt(100) + 11);
            }
            assertThrows(IllegalArgumentException.class, () -> new Card(suit, rank));
        }

        String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < nIterTests; i++) {
            String suit = "";
            int nSuitChars = generator.nextInt(3);
            for(int j = 0; j < nSuitChars; j++) {
                suit += alphaNumeric.charAt(generator.nextInt(alphaNumeric.length()));
            }
            String rank = "";
            for(int j = 0; j < nSuitChars; j++) {
                rank += alphaNumeric.charAt(generator.nextInt(alphaNumeric.length()));
            }
            if (!Utils.legalSuitAndRank(suit, rank)) {
                String finalSuit = suit;
                String finalRank = rank;
                assertThrows(IllegalArgumentException.class, () -> new Card(finalSuit, finalRank));
            }
        }

    }

    // TODO: test getRank, toString, equalsRank, equals, getRankAsWord, getRankAsInt
    // TODO: erease the Card and Deck classes content after testing tests.
    @Test
    public void testGetRank(){
        for (int i = 0; i < nIterTests; i++) {
            CardReference reference = sampleRandomCard();
            Card card = new Card(reference.getSuit(), reference.getRank());
            assertEquals(reference.getRank(), card.getRank());
        }
    }

    @Test
    public void testToString(){
        for (int i = 0; i < nIterTests; i++) {
            CardReference reference = sampleRandomCard();
            Card card = new Card(reference.getSuit(), reference.getRank());
            assertEquals(reference.toString(), card.toString());
        }
    }

    @Test
    public void testGetRankAsWord(){
        for (int i = 0; i < nIterTests; i++) {
            CardReference reference = sampleRandomCard();
            Card card = new Card(reference.getSuit(), reference.getRank());
            assertEquals(reference.getRankAsWord(), card.getRankAsWord());
        }
    }


    @Test
    public void testEqualsRank(){
        for (int i = 0; i < nIterTests; i++) {
            CardReference reference = sampleRandomCard();
            Card otherCard = new Card(reference.getSuit(), reference.getRank());
            reference = sampleRandomCard();
            Card card = new Card(reference.getSuit(), reference.getRank());
            assertEquals(reference.equalsRank(otherCard), card.equalsRank(otherCard));
        }
    }

    @Test
    public void testEquals(){
        CardReference reference = null;
        Card card = null;
        for (int i = 0; i < (int)sqrt(nIterTests); i++) {
            reference = sampleRandomCard();
            Card otherCard = new Card(reference.getSuit(), reference.getRank());
            reference = sampleRandomCard();
            card = new Card(reference.getSuit(), reference.getRank());
            Random generator = new Random();
            if (generator.nextBoolean()) {
                otherCard = new Card(reference.getSuit(), reference.getRank());
            }
            assertEquals(reference.equals(otherCard), card.equals(otherCard));
        }
        assertEquals(reference.equals(3), card.equals(3));
        assertEquals(reference.equals(null), card.equals(null));
        assertEquals(reference.equals("AS"), card.equals("AS"));
    }

    @Test
    public void testGetRankAsInt(){
        for (int i = 0; i < nIterTests; i++) {
            CardReference reference = sampleRandomCard();
            Card card = new Card(reference.getSuit(), reference.getRank());
            assertEquals(reference.getRankAsInt(), card.getRankAsInt());
        }
    }


    public CardReference sampleRandomCard() {
        String[] suits = new String[]{"D", "C", "S", "H"};
        String[] ranks = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10",
                "J", "Q", "K", "A"};
        Random random = new Random();
        return new CardReference(suits[random.nextInt(suits.length)], ranks[random.nextInt(ranks.length)]);
    }
}
