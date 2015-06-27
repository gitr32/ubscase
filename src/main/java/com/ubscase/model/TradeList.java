/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubscase.model;

import java.util.*;
import java.sql.Date;

/**
 *
 * @author r128
 */
public class TradeList {

    private TradeDAO tradeDAO;
    private TransactionDAO transactionDAO;
    
    public TradeList() {
        this.tradeDAO = new TradeDAO();
    }
    
    
    public ArrayList<Trade> retrieveTrades(String accountNo) {
        return tradeDAO.retrieveTrades(accountNo);
    }
    
    public void addTrade(String accountNo,String symbol,int volume, double price) {
        java.util.Date date = new GregorianCalendar().getTime();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        tradeDAO.addTrade(sqlDate, accountNo, symbol, volume, price);
        
    }
}
