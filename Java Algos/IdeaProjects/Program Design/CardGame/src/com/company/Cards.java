package com.company;

/**
 * Created by awdesh on 7/29/15.
 */
public class Cards
{
    public enum Suit
    {
        CLUBS(1),
        SPADES(2),
        HEARTS(3),
        DIAMONDS(4);

        int value;

        private Suit(int v)
        {
            value = v;
        }
    };

    private int card;
    private Suit suit;

    public Cards(int r, Suit s)
    {
        card = r;
        suit = s;
    }

    public int getCard()
    {
        return card;
    }

    public Suit getSuit()
    {
        return suit;
    }
}
