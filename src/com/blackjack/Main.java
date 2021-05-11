package com.blackjack;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        Card[] deckOfCards = new Card[52];
        char[] suits = {'H','D','C','S'};

        for (int i=0;i<4;i++) {
            for (int j=0;j<13;j++) {
                deckOfCards[13*i+j] = new Card(j+1,suits[i]);
            }
        }

        for (int i=1;i<20;i++) {
            int index = getCard(deckOfCards);
            System.out.println(deckOfCards[index].toString() + " of " + deckOfCards[index].suit);
        }
    }

    public static int getCard(Card[] deck) {
        boolean found = false;
        int index = 0;
        while (!found) {
            index = (int) (Math.random() * 52);
            if (deck[index].inDeck) {
                deck[index].inDeck = false;
                found = true;
            }
        }
        return index;
    }
}
