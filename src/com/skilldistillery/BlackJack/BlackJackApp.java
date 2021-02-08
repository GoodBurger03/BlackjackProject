package com.skilldistillery.BlackJack;

import java.util.Scanner;

//import com.skilldistillery.cards.Deck;
//import com.skilldistillery.cards.Player;

public class BlackJackApp {

	private BlackJackPlayer player;
	private Dealer dealer;
	//private int numPlayers;
	//private Player[] played;

	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
//		playerAmount();
		app.launch();
	}

	private void launch() {
		greetingAtTable();

	}

	private void greetingAtTable() {

		System.out.println("");
		System.out.println(
				"Hello, and welcome to Caesars at Las Vegas. \nThis is our high rollers table, you must be pretty good! ");
		System.out.println("If you would like to play, please press 1. ");
		System.out.println("If you would rather keep your chips, press 2 to walk away. ");
		System.out.println("=================================================================");
		int selection = kb.nextInt();
		switch (selection) {
		case 1:
			newGame();
			
			break;
		case 2:
			System.out.println("I knew you did not have the chips!");
			break;
		default:
			System.out.println("Not a valid option. Please enter 1 or 2.");
			selection = kb.nextInt();
			break;
		}
	}
//   This is a method to ask the user for the amount of people playing, did not have time to finish incorporating it... maybe in the future
	
//	private void playerAmount() {
//
//		do {
//			System.out.print("How many people are playing (1-6)? ");
//			players = kb.nextInt();
//
//		} while (numPlayers < 6 || numPlayers > 0);
//
//		playerS = new Player[players];
//		Deck deck = new Deck();
//
//		int users = 0;
//		// Asks for player names and assigns them
//		for (int i = 0; i < users; i++) {
//			System.out.print("What is player " + (i + 1) + "'s name? ");
//			String names = kb.next();
//			playerS[i] = new Player();
//			playerS[i].setName(names);
//		}
//	}

	private void newGame() {
		player = new BlackJackPlayer();
		dealer = new Dealer();
		dealer.dealerShuffle();

		player.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());

		player.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());

		player.getPlayerHand();
		System.out.println("Player: " + player.getHandVal());
		System.out.println();
		dealer.dealersFirstHand();

		checkBlackjack();

		if (dealer.getHandValue() < 21 && player.getHandVal() < 21) {
			stayVhit();
		}

	}

	private void continueGame() {
		System.out.println("\nWould you like to play another hand?");
		System.out.println("\nEnter 1 to Play");
		System.out.println("Enter 2 to Exit");
		System.out.print(">>");
		int selection = kb.nextInt();
		switch (selection) {
		case 1:
			newRound();
			break;
		case 2:
			System.out.println("Don't let the door hit ya where the good lord split ya!");
			System.exit(0);
			break;
		default:
			System.out.println("Not a valid option. Please enter 1 or 2.");
			selection = kb.nextInt();
			break;
		}

	}

	private void newRound() {
		clear();
		checkDeck();
		player.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());

		player.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());

		player.getPlayerHand();
		System.out.println("Player: " + player.getHandVal());
		System.out.println();
		dealer.dealersFirstHand();

		checkBlackjack();

		if (dealer.getHandValue() < 21 && player.getHandVal() < 21) {
			stayVhit();
		}

	}

	private void checkWin() {
		if (player.getHandVal() == dealer.getHandValue()) {
			System.out.println("\n<><><> Push! <><><>");

		}
		if (player.getHandVal() > dealer.getHandValue() || dealer.getHandValue() > 21) {
			System.out.println("\n<><><><> Player wins! <><><>");

		}

		if (player.getHandVal() < dealer.getHandValue() || player.getHandVal() > 21) {
			System.out.println("\n<><><> Dealer wins! <><><>");

		}
		dealer.showDealersHand();
		continueGame();
	}

	private void stayVhit() {
		System.out.println("\nTo HIT enter 1");
		System.out.println("To STAY enter 2");
		int selection = kb.nextInt();
		switch (selection) {
		case 1:
			playerHit();
			break;
		case 2:
			System.out.println("So you think you can win huh? We'll see... Dealer's move.");
			if (player.getHandVal() <= 21 && dealer.getHandValue() < 17) {
				dealerHit();
				dealer.isBust();
				continueGame();
			}

			if (player.getHandVal() == dealer.getHandValue()) {
				System.out.println("\n*** Push! ***");
				dealer.showDealersHand();
				continueGame();

			} else if (dealer.getHandValue() > 16 && dealer.getHandValue() < 21) {
				player.isTwentOne();
				player.isBust();
				checkWin();
			}

			break;

		default:
			System.out.println("Not a valid option. Please enter 1 or 2.");
			selection = kb.nextInt();
			break;
		}
	}

	private void playerHit() {
		player.addCard(dealer.dealCard());
		player.isBust();
		player.getPlayerHand();
		System.out.println("Player: " + player.getHandVal());
		if (player.getHandVal() < 22) {
			stayVhit();
		}
		continueGame();
	}

	private void dealerHit() {
		while (dealer.getHandValue() < 17) {
			dealer.addCard(dealer.dealCard());
			System.out.println("\nDealer hits!");
		}

		if (player.isTwentOne() && dealer.isTwentyOne()) {
			System.out.println("\n<><><> Push! <><><>");
			clear();

		} else if (dealer.getHandValue() > 16 && dealer.getHandValue() < 22) {
			checkWin();
		}

	}

	private boolean checkBlackjack() {
		if (dealer.isBlackjack()) {
			continueGame();
			return true;
		}
		if (dealer.getHandValue() < 21 && player.isBlackjack()) {
			continueGame();
			return true;

		} else {
			return false;
		}

	}

	private void checkDeck() {
		if (dealer.getDeckSize() < 14) {
			System.out.println("\n...shuffling new deck...");
			dealer = new Dealer();
			dealer.dealerShuffle();
		}
	}

	private void clear() {
		player.clear();
		dealer.clear();
	}
}
