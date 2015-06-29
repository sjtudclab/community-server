package cn.edu.sjtu.se.dclab.server.entity;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Huiyi on 2015/6/29.
 */
public class Card {
    private String cardId;
    private int cardOwner;
    private int balance;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(int cardOwner) {
        this.cardOwner = cardOwner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
