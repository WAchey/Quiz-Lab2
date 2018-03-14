package pkgCore;
import pkgEnum.*; // importing here so we don't have to write pkgEnum several times in the class.
public class Card implements Comparable {

	//  Add eRank and eSuit as attributes.
	private eRank eRank;
	private eSuit eSuit;
	
	
	//	Constructor for card, passes in eRank and eSuit.
	public Card(eRank eRank, eSuit eSuit) {
		this.eRank = eRank;
		this.eSuit = eSuit;
	}
	// Overloading constructor so it can be accessed both ways.
	public Card(eSuit eSuit, eRank eRank) {
		this.eRank = eRank;
		this.eSuit = eSuit;
	}
	

	@Override
	public int compareTo(Object o) {
		Card c = (Card) o;
		return this.getCardValue() - c.getCardValue();
	}


	public eRank geteRank() {
		return eRank;
	}


	private void seteRank(eRank eRank) {
		this.eRank = eRank;
	}


	public eSuit geteSuit() {
		return eSuit;
	}


	private void seteSuit(eSuit eSuit) {
		this.eSuit = eSuit;
	}
	
	public int getCardValue() {
		return this.geteRank().getiRankNbr();
	}
}
