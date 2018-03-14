package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {

	private int iScore;
	private ArrayList<Card> cards = new ArrayList<Card>();

	public Hand() {

	}

	public ArrayList<Integer> ScoreHand() { 
		
		//returns a list size 2^(amount of aces in hand)
		//Sets this.iScore value
		
		//ArrayList requires objects. Use Integer instead of primitive int.

		ArrayList<Integer> iScore = new ArrayList<Integer>();

		iScore.add(0);

		for (Card c : cards) {
			if (c.geteRank().getiRankNbr() < 11) {
				for(Integer score : iScore) {
					score += c.geteRank().getiRankNbr();
				}
			} else if (c.geteRank().getiRankNbr() < 14) {
				for(Integer score : iScore) {
					score += 10;
				}
			} else {
				int startSize = iScore.size();
				for(int i = 0; i < startSize; ++i) {
					iScore.add(iScore.get(i) + 11);
					iScore.set(i, iScore.get(i));
				}
			}
			// DONE: Determine the score.
			// Cards:
			// 2-3-4 - score = 9
			// 5-J-Q - score = 25
			// 5-6-7-2 - score = 20
			// J-Q - score = 20
			// 8-A = score = 9 or 19
			// 4-A = score = 5 or 15

		}
		
		//Sets this.iScore equal to the largest possible score less than 22.
		Collections.sort(iScore, Collections.reverseOrder()); 
		for(Integer score : iScore) { 
			if(score < 22) {
				this.iScore = score;
				break;
			}
			else if(score.equals(iScore.get(iScore.size()-1))) {
				this.iScore = score;
				break;
			}
		}
		return iScore;
	}

	public void Draw(Deck d) {
		// DONE: add a card to 'cards' from a card drawn from Deck d
		try {
			cards.add(d.Draw());
		} catch (Exception e) {
			// The deck is empty
			try {
				cards.add(new Deck().Draw()); // Draws a random card.
			} catch (Exception e2) {
				// This should never occur since the drawn card is from a new deck with 52
				// cards.
			}
		}

	}

	private void AddCard(Card c) {
		cards.add(c);
	}

	public int getiScore() {
		return iScore;
	}
}
