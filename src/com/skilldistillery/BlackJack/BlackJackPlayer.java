package com.skilldistillery.BlackJack;

import java.util.List;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Player;

public class BlackJackPlayer extends Player {
	private BlackJackHand playerHand;
	private int handVal;

	public BlackJackPlayer() {
		playerHand = new BlackJackHand();
		super.setName("Player");
	}

	public void getPlayerHand() {
		List<Card> playersCards = playerHand.getCards();
		System.out.print("Player has: ");
		for (Card card : playersCards) {
			System.out.println(card + " ");
		}

	}
	public void clear() {
		playerHand.clear();
	}

	public int getHandVal() {
		handVal = playerHand.getHandValue();
		return handVal;
	}

	public boolean isBlackjack() {
		if (getHandVal() == 21) {
			System.out.println("Player has blackjack! Player wins!");
			List<Card> playerCards = playerHand.getCards();
			for (Card card : playerCards) {
				System.out.println(card);
			}
			return true;
		}
		return false;

	}

	public boolean isBust() {
		if (getHandVal() > 21) {
			System.out.println("The player busts.");
			return true;
		}
		return false;
	}
	
	public boolean isTwentOne() {
		if(getHandVal() == 21) {
			System.out.println("BLACKJACK! WINNER WINER CHICKEN DINNER!");
			List<Card> playersCards = playerHand.getCards();
			for(Card card: playersCards) {
				System.out.println(card);
			}
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlackjackPlayer [bjHand=");
		builder.append(playerHand);
		builder.append("]");
		return builder.toString();
	}

	public void addCard(Card dealCard) {
playerHand.addCard(dealCard);		
	}
	
}
