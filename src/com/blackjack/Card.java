package com.blackjack;

import javax.imageio.ImageIO;
import  java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**public class Card {

    private int suit;
    private int rank;
    private int value;

    public Card() {
        suit = 0;
        rank = 0;
        value = 0;
    }

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public int getSuit() {
        return suit;
    }
    public void setSuit(int suit) {
        this.suit = suit;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public void printCard(Graphics2D g2, boolean dealerTurn, boolean faceDown, int cardNumber) throws IOException {
        BufferedImage deckImg = ImageIO.read(new File("images/cardSpriteSheet.png"));
        int imgWidth = 950;
        int imgHeight = 392;

        BufferedImage[][] cardPictures = new BufferedImage[4][13];
        BufferedImage backOfACard = ImageIO.read(new File("images/backsideOfACard.jpg"));

        for (int c=0;c<4;c++) {
            for (int r=0;r<13;r++) {
                cardPictures[c][r] = deckImg.getSubimage(r*imgWidth/13, c*imgHeight/4, imgWidth/13, imgHeight/4);
            }
        }

        int yPosition;
        if (dealerTurn) {
            yPosition = 75;
        }
        else {
            yPosition = 400;
        }

        int xPosition = 500 + 75 * cardNumber;

        if (faceDown) {
            g2.drawImage(backOfACard, xPosition, yPosition, null);
        }
        else {
            g2.drawImage(cardPictures[suit][rank], xPosition, yPosition, null);
        }
    }
 }*/


public class Card {
     protected int faceValue;
     protected int actualValue;
     protected String suit;
     protected boolean inDeck;

     public Card(int fv, String s) {
        faceValue = fv;
        suit = s;
        inDeck = true;
        if (fv == 1) {
            actualValue = 11;
        }
        else actualValue = Math.min(fv, 10);
     }

     public String toString() {
         String face;
         if (faceValue == 1) {
             face = "Ace";
         }
         else if (faceValue <= 10) {
             face = String.valueOf(faceValue);
         }
         else if (faceValue == 11) {
             face = "Jack";
         }
         else if (faceValue == 12) {
             face = "Queen";
         }
         else {
             face = "King";
         }
         return face;
     }
}