package pkgCore;
import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.*;

public class Deck {

	//	DONE: Add 'cards' attribute that is an ArrayList of Card
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	//	DONE: Add a contructor that passes in the number of decks, and then populates
	//			ArrayList<Card> with cards (depending on number of decks).
	//			Example: Deck(1) will build one 52-card deck.  There are 52 different cards
	//			2 clubs, 3 clubs... Ace clubs, 2 hearts, 3 hearts... Ace hearts, etc
	//			Deck(2) will create an array of 104 cards.
	public Deck() {
		buildDeck();
	}
	
	public Deck(int numDecks) {
		for(int i = 0; i < numDecks; i++) {
			buildDeck();
		}
	}
	
	private void buildDeck() {
		for(eRank eRank : eRank.values()) {
			for(eSuit eSuit : eSuit.values()) {
				cards.add(new Card(eRank,eSuit));
			}
		}
		
		Collections.shuffle(cards);
		// This randomizer is not totally random; it uses a seed.
	}
	
	//	DONE: Add a draw() method that will take a card from the deck and
	//			return it to the caller
	public Card Draw() throws Exception {
		if(cards.size() == 0) {
			throw new Exception("Deck empty");
		} // if exception is thrown, then anything below it isn't even read.
		return cards.remove(0);
	}
	
	// a size getter for testing
	public int DeckSize() {
		return this.cards.size();
	}
	
	public int getRemaning(Object eNum) {
		int count = 0;
		for(Card card : cards) {
			if(card.geteRank().equals(eNum) || card.geteSuit().equals(eNum))
				count++;
		}
		return count;
				
	}
}
