package com.revature.blackjack;

import java.util.ArrayList;

public class Dealer extends Player {

	public Dealer() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Card> getPlayerCards() {
		//System.out.println(getPlayerCards());
		// TODO Auto-generated method stub
		return super.getPlayerCards();
	}

	@Override
	public int getTotalPoints() {
		// TODO Auto-generated method stub
		return super.getTotalPoints();
	}
	@Override
	public void viewHand() {
		System.out.println("Dealer: " + playerCards.get(0).toString() + " , [card hidden]");
	}

	@Override
	public String displayCards() {
		//return "Player [id=" + id + ", playerCards=" + playerCards + "]";
		return "Dealer: " + playerCards + " Total points!: " + getTotalPoints();
		//return super.displayCards();
	}
	
	
	
	

}
