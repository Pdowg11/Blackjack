package com.blackjack;

import javax.swing.JFrame;
import java.awt.*;
import java.util.*;

public class Main extends JFrame {

    /**public Main() {
        super("Blackjack");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        //Game game = new Game();


    }*/

    public static void main(String[] args) {
        Card[] deckOfCards = new Card[52];
        String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
        int playerTotal = 0, dealerTotal = 0;
        var in = new Scanner(System.in);
        boolean gameOver = false;
        boolean playerBust = false;
        boolean dealerBust = false;
        boolean playerTurnOver = false;

        //Build deck
        for (int i=0;i<4;i++) {
            for (int j=0;j<13;j++) {
                deckOfCards[13*i+j] = new Card(j+1,suits[i]);
            }
        }

        int tempIndex = getCard(deckOfCards);
        System.out.println("Player's first card: " + deckOfCards[tempIndex].toString() + " of " + deckOfCards[tempIndex].suit);
        playerTotal += deckOfCards[tempIndex].actualValue;

        tempIndex = getCard(deckOfCards);
        System.out.println("Dealer's first card: " + deckOfCards[tempIndex].toString() + " of " + deckOfCards[tempIndex].suit);
        dealerTotal += deckOfCards[tempIndex].actualValue;

        tempIndex = getCard(deckOfCards);
        System.out.println("Player's second card: " + deckOfCards[tempIndex].toString() + " of " + deckOfCards[tempIndex].suit);
        playerTotal += deckOfCards[tempIndex].actualValue;

        tempIndex = getCard(deckOfCards);
        System.out.println("Dealer's second card: Drawn face down!");
        //Uncomment below for debugging
        // System.out.println(deckOfCards[tempIndex].toString() + " of " + deckOfCards[tempIndex].suit);
        dealerTotal += deckOfCards[tempIndex].actualValue;

        System.out.println("Player total: " + playerTotal);
        //Uncomment below to debug
        //System.out.println("Dealer total: " + dealerTotal);

        while (!gameOver) {
            if (dealerTotal == 21) {
                System.out.println("Dealer wins by Blackjack!");
                gameOver = true;
            }
            else if (playerTotal == 21) {
                System.out.println("Player wins by Blackjack!");
                gameOver = true;
            }

            while (playerTotal <= 21 && !playerTurnOver && !gameOver) {
                System.out.println("Player total: " + playerTotal + "\nWould you like to hit or stay? ");
                String response = in.nextLine().toLowerCase();
                if (response.equals("hit")) {
                    playerTotal += deckOfCards[getCard(deckOfCards)].actualValue;
                    if (playerTotal > 21) {
                        System.out.println("The player busts!");
                        playerBust = true;
                        gameOver = true;
                        break;
                    }
                } else {
                    playerTurnOver = true;
                }
            }

            while (dealerTotal <= 21 && playerTurnOver && !gameOver) {
                //uncomment below to debug
                //System.out.println("Dealer total: " + dealerTotal);
                if (dealerTotal <= 16) {
                    System.out.println("Dealer hits");
                    dealerTotal += deckOfCards[getCard(deckOfCards)].actualValue;
                    if (dealerTotal > 21) {
                        System.out.println("The dealer busts!");
                        dealerBust = true;
                        gameOver = true;
                        break;
                    }
                }
                else {
                    System.out.println("Dealer stays");
                    gameOver = true;
                }
            }

            if (dealerBust) {
                System.out.println("Player Wins!");
                break;
            }
            else if (playerBust) {
                System.out.println("Dealer Wins!");
                break;
            }
            else if (dealerTotal < playerTotal && gameOver) {
                System.out.println("Player Wins!");
                break;
            }
            else if (dealerTotal > playerTotal && gameOver) {
                System.out.println("Dealer Wins!");
                break;
            }
            else if (dealerTotal == playerTotal && gameOver) {
                System.out.println("Draw!");
                break;
            }
        }
    }//End of main

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
