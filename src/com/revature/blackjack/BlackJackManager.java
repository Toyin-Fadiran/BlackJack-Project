package com.revature.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BlackJackManager {
	
	public static ArrayList<Player> numberPlayers = new ArrayList<>();
	public static int turnCount = 0;
	
	public void playerCreator() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many players? " + "(Max of 4)");
		int numPlayers = keyboard.nextInt();
		keyboard.nextLine();
		
		if (numPlayers < 5) {
			for (int i=1; i < numPlayers + 1; i++ ) {
				numberPlayers.add(new Player(i));
			}
		}else {
				System.out.println("max of 4");
		}
			
	}
	
	
	
	public static void main(String[] args) {
	int x;
	do {
		System.out.println("Welcome to BlackJack!");
		//make 
		Deck decko = new Deck();
		//Player player = new Player(1);
		BlackJackManager bJ = new BlackJackManager();
		bJ.playerCreator();
		
		Dealer dealer = new Dealer();
		
		
		
		
		//adding cards
		for (int id=0; id<numberPlayers.size();id++) {
			numberPlayers.get(id).addCard(decko.dealCard());
		}
		
		//adding cards
		for (int id=0; id<numberPlayers.size();id++) {
			numberPlayers.get(id).addCard(decko.dealCard());
		}
//		
		//display added card
		for (int id=0; id<numberPlayers.size();id++) {
			System.out.println(numberPlayers.get(id));
		}
		
		//DEALER CARDS
				dealer.addCard(decko.dealCard());
				
				dealer.addCard(decko.dealCard());
				
				//System.out.println("dealer's cards here: " + dealer.getPlayerCards());
				 dealer.viewHand();
				 
				 Scanner input = new Scanner(System.in);
			if (dealer.getPlayerCards().get(0).getRank() == 1) {
				
				for (int id=0; id<numberPlayers.size();id++) {
					System.out.println("Player " + numberPlayers.get(id).getId() + ":" +" Do you want insurance? Yes(1) or No(2)?");
					int answer = input.nextInt();
					if (answer ==1) {
						numberPlayers.get(id).setInsureFlag(true);
					}
					
				}
			}
		
		Scanner scan = new Scanner(System.in);
		for (int id=0; id<numberPlayers.size();id++) {
			if( numberPlayers.get(id).getTotalPoints() > 8 && numberPlayers.get(id).getTotalPoints() < 12){
				
				System.out.println("Player " + numberPlayers.get(id).getId() + ": Double Down? Yes(1) or No(2)");
				int response = scan.nextInt();
				if (response ==1) {
					numberPlayers.get(id).addCard(decko.dealCard());
					numberPlayers.get(id).setDoubleFlag(true);
				}
					
			}
		}
		
		//get total points of hand
//		for (int id=0; id<numberPlayers.size();id++) {
//			System.out.println(numberPlayers.get(id).getTotalPoints());
//		}
		
		for (int id=0; id<numberPlayers.size();id++) {
			//numberPlayers.get(id).displayCards();
			//numberPlayers.get(id).viewHand();
		}
		
		Scanner keyboard = new Scanner(System.in);
		
		for (int id=0; id<numberPlayers.size();id++) {
			while(numberPlayers.get(id).getTotalPoints() < 21) 

			{
				if (numberPlayers.get(id).isDoubleFlag()) {
					break;
				}

				System.out.println("Player" + numberPlayers.get(id).getId() + ": What do you want to do? HIT(1) or STAND(2)");
				int answer = keyboard.nextInt();

				if (answer == 1) {
					//adding card to current player's hand
					numberPlayers.get(id).addCard(decko.dealCard());

				} else {
					break;
					//continue;
				}



				//after a round of hitting or standing: GETS ID
				for (int w=0; w<numberPlayers.size();w++) {
					System.out.println(numberPlayers.get(w));
				}

				//after a round of hitting or standing
//				for (int w=0; w<numberPlayers.size();w++) {
//					System.out.println(numberPlayers.get(w).getTotalPoints());
//				}
			}

		}
		//keyboard.close();
		
		for (int w=0; w<numberPlayers.size();w++) {
			
			System.out.println(numberPlayers.get(w));
		}

		
		
		//System.out.println("oustide da lupu");
		
		while (dealer.getTotalPoints()<16) {
			dealer.addCard(decko.dealCard());
		}
		
		for (int w=0; w<numberPlayers.size();w++) {
			//if player busts and doubled down
			if (numberPlayers.get(w).getTotalPoints() >21 && numberPlayers.get(w).isDoubleFlag())
			{	numberPlayers.get(w).setGamePoints(numberPlayers.get(w).getGamePoints() - 20);
				System.out.println("you've busted! :-(");
		//if player bust and did NOT double down	
		}else if (numberPlayers.get(w).getTotalPoints() >21 && !numberPlayers.get(w).isDoubleFlag())
		{	numberPlayers.get(w).setGamePoints(numberPlayers.get(w).getGamePoints() - 10);
		System.out.println("you've busted! :-(");
	
}
			//if dealer wins and player doubled down
			else if(numberPlayers.get(w).getTotalPoints() < dealer.getTotalPoints()&&
					(dealer.getTotalPoints()<21) && numberPlayers.get(w).isDoubleFlag()){
				numberPlayers.get(w).setGamePoints(numberPlayers.get(w).getGamePoints() - 20);
				System.out.println("You've lost to the DealER!");
				
			//if dealer wins and player did NOT double down	
		}else if(numberPlayers.get(w).getTotalPoints() < dealer.getTotalPoints()&&
				(dealer.getTotalPoints()<21) && !numberPlayers.get(w).isDoubleFlag()){
			numberPlayers.get(w).setGamePoints(numberPlayers.get(w).getGamePoints() - 10);
			System.out.println("You've lost to the DealER!");
			
	} else if(numberPlayers.get(w).getTotalPoints() < dealer.getTotalPoints()&&
			(dealer.getTotalPoints() == 21)) {
		if (numberPlayers.get(w).isInsureFlag()) {
			numberPlayers.get(w).setGamePoints(numberPlayers.get(w).getGamePoints() -5);
		}else {
			numberPlayers.get(w).setGamePoints(numberPlayers.get(w).getGamePoints() -10);
		}
		
	}
			
			else if( (numberPlayers.get(w).getTotalPoints()==dealer.getTotalPoints()) ) {
			System.out.println("Tied up!");
		} else {
				if (numberPlayers.get(w).isDoubleFlag()) {
					numberPlayers.get(w).setGamePoints(numberPlayers.get(w).getGamePoints() + 20);
					System.out.println("YOU WIN!");
				} else if (!numberPlayers.get(w).isDoubleFlag()){
					numberPlayers.get(w).setGamePoints(numberPlayers.get(w).getGamePoints() + 10);
					System.out.println("YOU WIN!");
			} else if (numberPlayers.get(w).isInsureFlag()) {
				numberPlayers.get(w).setGamePoints(numberPlayers.get(w).getGamePoints() + 5);
				System.out.println("YOU WIN!");
			} else {
			System.out.println("YOU WIN!");
		}

			//( (numberPlayers.get(w).getTotalPoints() == 21) && ( dealer.getTotalPoints() == 21))
		

		
	}
			System.out.println(dealer.displayCards());
			for (int id=0; id<numberPlayers.size();id++) {
				System.out.println("Player " + numberPlayers.get(id).getId() + ": " + 
			numberPlayers.get(id).getGamePoints() + " GAME Points");
			}
	}
		
			numberPlayers.clear();
			//dealer.getPlayerCards().clear();
			
			for (int id=0; id<numberPlayers.size();id++) { 
			System.out.println(numberPlayers.get(id).displayCards());// + dealer.getPlayerCards());
			}


Scanner gimme = new Scanner(System.in);
System.out.println("would you like to play again? YES(1) or NO(2)?");
 x = gimme.nextInt(); 
}while (x == 1);
		 
		System.out.println();
	}
}
