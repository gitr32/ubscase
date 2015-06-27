/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubscase.model;

import java.sql.Date;
/**
 *
 * @author r128
 */
public class Trade {
    private int tradeID;
    private String accountNo;
    private Date date;
    private String symbol;
    private int volume;
    private double price;

    public Trade(int tradeID, Date date,String accountNo, String symbol, int volume, double price) {
        this.tradeID = tradeID;
        this.date = date;
        this.accountNo = accountNo;
        this.symbol = symbol;
        this.volume = volume;
        this.price = price;
    }

    public int getTradeID() {
        return tradeID;
    }

    public void setTradeID(int tradeID) {
        this.tradeID = tradeID;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
    
}
