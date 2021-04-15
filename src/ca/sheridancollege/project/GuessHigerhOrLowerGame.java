/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class GuessHigerhOrLowerGame extends Game {

    Scanner sc = new Scanner(System.in);

    StandardDeck deck = new StandardDeck(52);

    ArrayList<GuessHigherOrLowerPlayer> players = new ArrayList();

    //the top card of the discard pile
    private CardSet discardCard = new CardSet();

    public CardSet getDiscardCard() {
        return discardCard;
    }

    public void setDiscardCard(CardSet discardCard) {
        this.discardCard = discardCard;
    }

    String winnerName = "";

    private boolean isOver;

    public GuessHigerhOrLowerGame(String name, boolean isOver) {
        super(name);
        setIsOver(isOver);
    }

    public void setIsOver(boolean isOver) {
        this.isOver = isOver;
    }

    public boolean isIsOver() {
        return isOver;
    }

    @Override
    public void play() {

        deck.generateDeck();
        deck.shuffle();

        isOver = false;  

        System.out.println("Please enter the number of players (between 2 to 4)");
        int numPlayers = sc.nextInt();

        while (numPlayers < 2 || numPlayers > 4) {
            System.out.println("Sorry, number of players must be between 2 to 4");
            System.out.println("Enter the number of players");
            numPlayers = sc.nextInt();
        }

        String name = "";
        GuessHigherOrLowerPlayer pl = new GuessHigherOrLowerPlayer(name);

        for (int i = 1; i < numPlayers + 1; i++) {
System.out.println("Enter the name of player " + i);
            name = sc.next();
            players.add(new GuessHigherOrLowerPlayer(name));
            System.out.println("Player " + i + ": " + players.get(i - 1).getName());
        }
        
        while (!isOver) {
            System.out.println("First card is: " + deck.getCardSet().get(0).getSuit() 
                    + "-" + deck.getCardSet().get(0).getValue());
            System.out.println("Guess which card is bigger? The first or the second?");
            System.out.println("1：Means the second one is bigger \n"
                    + "0：Represents a tie \n"
                    + "-1：Means the first one is bigger");
            for (int i = 1; i < numPlayers + 1; i++) {
                System.out.println("Please " + players.get(i - 1).getName() + " guess");
                players.get(i - 1).guess = sc.nextInt();
                while (!(players.get(i - 1).guess == 1 || players.get(i - 1).guess == 0 || players.get(i - 1).guess == -1)) {
                    System.out.println("Sorry, number must be \'1\' or \'0\' or \'-1\'");
                    System.out.println("Please " + players.get(i - 1).getName() + " guess");
                    numPlayers = sc.nextInt();
                }

            }
            int card1 = Integer.parseInt(deck.getCardSet().get(0).getValue().getDisplayName() + deck.getCardSet().get(0).getSuit().getDisplayName());
            int card2 = Integer.parseInt(deck.getCardSet().get(1).getValue().getDisplayName() + deck.getCardSet().get(1).getSuit().getDisplayName());
            if (card1 > card2) {
                for (int i = 1; i < numPlayers + 1; i++) {
                    if (players.get(i - 1).guess == -1) {
                        players.get(i - 1).score++;
                    }
                }
            } else if (card1 < card2) {
                for (int i = 1; i < numPlayers + 1; i++) {
                    if (players.get(i - 1).guess == 1) {
                        players.get(i - 1).score++;
                    }
                }

            } else {
                for (int i = 1; i < numPlayers + 1; i++) {
                    if (players.get(i - 1).guess == 0) {
                        players.get(i - 1).score++;
                    }
                }
            }
            System.out.println("Second card is: " + deck.getCardSet().get(1).getSuit() + ":" + deck.getCardSet().get(1).getValue());
            System.out.println("The current score is:");
            for (int i = 1; i < numPlayers + 1; i++) {
                System.out.println("Player" + i + ":" + players.get(i - 1).getName() + "; score: " + players.get(i - 1).score);
            }
            System.out.println("Continue play？Y/N");
            String continuePlay = sc.next();
            if (continuePlay.equalsIgnoreCase("N")) {
                isOver = true;
            }
            deck.getCardSet().remove(0);
            if (deck.getCardSet().size() == 2) {
                deck.generateDeck();
                deck.shuffle();
            }
        }
        int maxScore = players.get(0).score;
        
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).score > maxScore) {
                maxScore = players.get(i).score;
            }
        }
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).score == maxScore) {
                winnerName += (players.get(i).getName() + " ");
            }
        }
    }

    @Override
    public void declareWinner() {
        if (isOver) {
            System.out.println("Game Over. The Winner is(are): " + winnerName);
        }
    }
    
}
