package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards;
	
	public Hand() {
		cards = new ArrayList<Card>();
	}
	
	public Hand(List<Card> cards) {
		cards = new ArrayList<Card>();
		this.cards=cards;

	}

	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		cards.clear();
	}
	
	public abstract int getHandValue();
	
	public List<Card> getCards(){
		return cards;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(cards);
		return builder.toString();
	}
	
}
