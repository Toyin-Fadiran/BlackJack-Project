package com.revature.blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	ArrayList<Card> deckOfCards = new ArrayList<>();
	
	public Deck() {
		// TODO Auto-generated method stub
		for (int suit = 0; suit <=3; suit++ ) {
			for (int rank = 1; rank <= 13; rank++) {
				deckOfCards.add(new Card(rank,suit));				
		}
			Collections.shuffle(deckOfCards);
	}
	}

	
	
	
	public static void main(String[] args) {
		Deck d = new Deck();
		
		for (Card c: d.deckOfCards) {
			System.out.println(c);
		}
		
		
		System.out.println();
		for (Card c: d.deckOfCards) {
			System.out.println(c);
		}
		System.out.println("this "+d.deckOfCards.get(0));
		}
	
	public Card dealCard() {
		
		Card whatever = deckOfCards.get(0);
		
		
		deckOfCards.remove(0);
		 
		return whatever;


	}
}



