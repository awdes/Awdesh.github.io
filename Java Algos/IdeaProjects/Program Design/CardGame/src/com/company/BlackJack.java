package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by awdesh on 7/29/15.
 */
public class BlackJack
{
    List<Cards> cardsList = new ArrayList<Cards>();
    List<Player> players = new ArrayList<Player>(5);
    Player dealer = new Player();

    public BlackJack(List<Cards> cards)
    {
        this.cardsList = cards;
    }

    public List<Cards> shuffleCards()
    {
        return cardsList;
    }

    public void AskForBet()
    {
        for(int i = 0; i< players.size(); i++)
        {
            players.get(i).Bet();
        }
    }

    public void DrawCards(List<Cards> cardsList)
    {
        for(int i = 0; i< players.size(); i++)
        {
            players.get(i).GetCard(cardsList.get(0));
        }

        dealer.GetCard(cardsList.get(0));
    }

    public int DealerCardsSum()
    {

    }

    public void CompareTotal()
    {
        int dealerSum = DealerCardsSum();
        for(int i = 0; i< players.size(); i++)
        {
            players.get(i).ShowCards();
        }
    }

    public int giveMoney()
    {
        return
    }

    public void collectMoney()
    {

    }

}
