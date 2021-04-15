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
public class GuessHigherOrLowerPlayer extends Player {

    Scanner sc = new Scanner(System.in);
    private ArrayList<CardSet> playerHand = new ArrayList();

    private CardSet discardCard = new CardSet();
    public int guess;
    public int score;

    public CardSet getDiscardCard() {
        return discardCard;
    }

    public void setDiscardCard(CardSet discardCard) {
        this.discardCard = cz.getDiscardCard();
    }
   
    private GuessHigerhOrLowerGame cz = new GuessHigerhOrLowerGame("GuessHigherhOrLowerGame", true);
    CardSet discardCardSet = new CardSet();

    public GuessHigherOrLowerPlayer() {
        super();
    }

    public GuessHigherOrLowerPlayer(String name) {
        super(name);
    }

    public GuessHigherOrLowerPlayer(String name, ArrayList<CardSet> playerHand) {
        super(name);
        this.playerHand = playerHand;
    }

    public ArrayList<CardSet> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(ArrayList<CardSet> playerHand) {
        this.playerHand = playerHand;
    }

    @Override
    public void play() {

        System.out.println("Available cards");
        ArrayList<CardSet> playableCard = new ArrayList();

        for (CardSet c : playerHand) {

            if (c.getSuit() == discardCard.getSuit() || c.getValue() == 
                    discardCard.getValue()) {
                playableCard.add(c);
            }
                   
            if (playableCard.isEmpty()) {

                System.out.println("You have no playable cards; drawing from "
                        + "the stack ");
                //need to draw cards from the stack. Draw up to 5 cards then 
                //skip turn if a playable card is not drawn
                for (int i = 5; i > 0; i--) {
                    //what happens when the deck is out of cards
                    if(cz.getDiscardCard() == null) {
                        System.out.println("The deck has no more cards. You "
                                + "lose your turn!");
                        continue;
                    }
                 
                    discardCardSet = cz.getDiscardCard();
                    playerHand.add(discardCardSet);
                    cz.deck.getCardSet().remove(0);
                    if (discardCardSet.getValue() == discardCard.getValue() || 
                            discardCardSet.getSuit() == discardCard.getSuit()) {
                        System.out.println("You have drawn " +
                                discardCardSet.toString() + " and this card is "
                                        + "being played");
                        playerHand.remove(discardCardSet);
                        break;
                    }

                    System.out.println("You have not drawn a playable card and "
                            + "have lost your turn");
                }
            }
        }
        
        System.out.println("You can play the following cards");
        for (int i = 0; i < playableCard.size(); i++) {

            System.out.println("Option " + (i + 1) + ": " + 
                    playableCard.toString());
        }

        System.out.println("Enter the number for the card you want to play: ");
        int input = sc.nextInt();

        discardCard.setSuit(playableCard.get(input - 1).getSuit());
        discardCard.setValue(playableCard.get(input - 1).getValue());
        cz.setDiscardCard(discardCard);
        
        if (discardCard.getValue() == CardSet.Value.EIGHT) {
            System.out.println("To which suit would you like to change the "
                    + "discard pile (spell exactly)?: ");
                for(CardSet.Suit c: CardSet.Suit.values()) {
                    System.out.println(c.getDisplayName());
                }
            String choice = sc.nextLine().toUpperCase();
            
            switch(choice) {
                case "HEARTS":  discardCard.setSuit(CardSet.Suit.HEARTS); break;
                case "DIAMONDS": discardCard.setSuit(CardSet.Suit.DIAMONDS); break;
                case "SPADES": discardCard.setSuit(CardSet.Suit.SPADES); break;
                case "CLUBS" : discardCard.setSuit(CardSet.Suit.CLUBS);
            }
            //updating the card with the new value
            cz.setDiscardCard(discardCard);
            
        }

        for (int i = 0; i < playerHand.size(); i++) {
            if (playerHand.get(i).getSuit() == discardCard.getSuit() && 
                    playerHand.get(i).getValue() == discardCard.getValue()) {
                playerHand.remove(i);
                break;  //or is it continue?
            }
        }

    }
 
    public void drawCard() {
        
        discardCardSet = cz.getDiscardCard();
        playerHand.add(cz.deck.getCardSet().get(0));
        cz.deck.getCardSet().remove(0);
    }
}
