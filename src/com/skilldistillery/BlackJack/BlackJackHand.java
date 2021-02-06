package com.skilldistillery.BlackJack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Hand;

public class BlackJackHand extends Hand {
private int handValPlayer;
	

BlackJackHand()	{
	}{
}
	

public boolean isBlackJack() {
	if(getHandValue() == 21) {
		return true;

	}
	return false;
}


	public BlackJackHand(int handValPlayer) {
	super();
	this.handValPlayer = handValPlayer;
}






	public int getHandValue() {
handValPlayer = 0;
for(Card card: cards) {
	handValPlayer += card.getValue();
	
}
	return handValPlayer;
	}

}
