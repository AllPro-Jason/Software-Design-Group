/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author PC
 */
public class StandardDeck extends GroupOfCards {

    private ArrayList<CardSet> cardSet = new ArrayList();
 //   private CardSet[] cards = new CardSet[52];

    public StandardDeck(int size) {
        super(size);
        generateDeck();
    }
    
    public ArrayList<CardSet> getCardSet() {
        return cardSet;
    }
    @Override
    public void shuffle() {
        Collections.shuffle(cardSet);

//        System.out.println(cardSet.size());

    }
   
    public void generateDeck() {

        for (CardSet.Suit s : CardSet.Suit.values()) {             
            for (CardSet.Value v : CardSet.Value.values()) {            
                CardSet card = new CardSet(v, s);           
                cardSet.add(card);    
            }
        }
    }
}

