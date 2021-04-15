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
public class CardSet extends Card {

    public enum Suit {

        HEARTS("3"), CLUBS("2"), SPADES("4"), DIAMONDS("1");
        private String displayName;

        private Suit(String name) {
            displayName = name;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public enum Value {

        ACE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"),
        EIGHT("8"), NINE("9"), TEN("10"), JACK("11"), QUEEN("12"), KING("13");

        private String displayName;

        private Value(String name) {
            displayName = name;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
    private Suit suit;
    private Value value;

    public CardSet(){
        
    }
    public CardSet(Value value, Suit suit) {

        this.value = value;
        this.suit = suit;
    }

    /**
     * @return the suit
     */
    public Suit getSuit() {

        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {

        this.suit = suit;
    }

    /**
     * @return the value
     */
    public Value getValue() {

        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Value value) {

        this.value = value;
    }

    @Override
    public String toString() {
        return String.format(value.getDisplayName() + " of " + 
                suit.getDisplayName());
    }
}