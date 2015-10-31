package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by awdesh on 7/29/15.
 */
public class Player
{
    private final List<Cards> playerCards;
    private int bet;

    public Player()
    {
        playerCards = new ArrayList<Cards>(3);
        bet = 5;
    }

    public int Bet()
    {
        return bet;
    }

    public int RaiseBet()
    {
        return bet+5;
    }

    public int ShowCards()
    {
        int sum = 0;
        for(int i = 0; i <2; i++)
        {
            sum = sum + playerCards.get(i).getCard();
        }
        return sum;
    }

    public void GetCard(Cards card)
    {
        playerCards.add(card);
    }

}
