/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author PC
 */
public class CardSet extends Card{
    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,EIGHT, NINE, TEN, JACK, QUEEN, KING;

        private String getValue() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    public enum Suit {
        HEARTS, CLUBS, SPADES, DIAMONDS;

        private String getSuit() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
        
        private Value value;
        private Suit suit;


        
    @Override
    public String toString(){
        return value.getValue() + " : " + suit.getSuit();
    }
}
