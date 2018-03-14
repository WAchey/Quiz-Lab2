package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class DeckTest {

	@Test
	public void TestDeck() {
		
		//	DONE: Build a deck(1), make sure there are 52 cards in the deck
		Deck d1 = new Deck(1);
		if(d1.DeckSize() != 52) {
			fail("Deck is the wrong size");
		}
	
		//	DONE: Build a deck(6), make sure there are 312 cards in the deck 
		Deck d2 = new Deck(6);
		if(d2.DeckSize() != 312) {
			fail("Deck is the wrong size");
		}
	}
	
	@Test
	public void QuizTest() throws Exception {
		
		Deck d1 = new Deck();
		
		int countSuit = 0;
		int countRank = 0;
		for(eSuit suit: eSuit.values()) {
			countSuit += d1.getRemaning(suit);
		}
		for(eRank rank: eRank.values()) {
			countRank += d1.getRemaning(rank);
		}
		assertEquals(52, countSuit);
		assertEquals(52, countRank);
		
		Card c = d1.Draw();
		
		assertEquals(13-1, d1.getRemaning(c.geteSuit()));
		assertEquals(4-1, d1.getRemaning(c.geteRank()));
	}

}
