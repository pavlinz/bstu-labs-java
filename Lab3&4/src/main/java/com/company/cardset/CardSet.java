package com.company.cardset;

import com.company.account.Account;
import java.util.ArrayList;
import java.util.List;

public class CardSet {

    private ArrayList<Account> cardSet;

    public CardSet() {
        cardSet = new ArrayList<Account>();
    }

    public CardSet(ArrayList<Account> cardSet) {
        cardSet = new ArrayList<Account>();
        cardSet = cardSet;
    }

    public List<Account> getCardSet() {
        return cardSet;
    }

    public void setCardSet(ArrayList<Account> cardSet) {
        cardSet = cardSet;
    }

    public void add (Account item) {
        cardSet.add(item);
    }

    public void remove (Account item){
        cardSet.remove(item);
    }
}
