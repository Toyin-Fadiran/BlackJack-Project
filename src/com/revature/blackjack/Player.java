package com.revature.blackjack;

import java.util.ArrayList;

public class Player {
	

private Card card;
private Deck deck;
private boolean doubleFlag;
private boolean insureFlag;
private int gamePoints = 50;

public boolean isDoubleFlag() {
	return doubleFlag;
}

public void setDoubleFlag(boolean doubleFlag) {
	this.doubleFlag = doubleFlag;
}

public boolean isInsureFlag() {
	return insureFlag;
}

public void setInsureFlag(boolean insureFlag) {
	this.insureFlag = insureFlag;
}

private int id;



ArrayList<Card> playerCards = new ArrayList<>();


public Player() {
	super();
}

public Player(int id) {
	 doubleFlag = false;
	 insureFlag = false;
	this.id = id;
	
	//this.gamePoints = 50;
	

 //this.hand = new Hand(id);
}

//public int getId() {
//	return id;
//}

public int getGamePoints() {
	return gamePoints;
}

public void setGamePoints(int gamePoints) {
	this.gamePoints = gamePoints;
}

public ArrayList<Card> getPlayerCards() {
	return playerCards;
}

public void viewHand() {
	System.out.println(playerCards.get(0).toString());
	//return playerCards.get(0).toString();
	//return "";
}

public void addCard (Card c) {
	
	
	
	playerCards.add(c);
	
}

//public String displayCard () {
//	
//	System.out.println();
//	
//	return "card";
	
	
	
	
	
	
//}
public int getTotalPoints() {
	
	int totalP=0;
	for(Card c : playerCards) {
		
		if (c.getRank() == 1) {
			if (totalP < 11) {
				totalP +=11;
			} else {
				totalP +=1;
			}
		}
		
		totalP += c.getPoints();
	}
	//playerCards.get(index)
	
	return totalP;
}

//public void hit() {
//	
//	decko
//	
//}



public String displayCards() {
	//return id + playerCards;
	return "Player" + id + ": " + getPlayerCards() + " Total points!: " + getTotalPoints() + " RUNNING_GAME_TOTAL: " + getGamePoints();
}

@Override
public String toString() {
	return displayCards();
}

public int getId() {
	return id;
}



	
}

