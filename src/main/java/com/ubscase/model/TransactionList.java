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
public class TransactionList {
    private TransactionDAO transactionDAO;
    //private AccountDAO accountDAO;
    private String accountNo;
    
    public TransactionList (String accountNo){
        this.accountNo = accountNo;
        //accountDAO = new AccountDAO();
        transactionDAO = new TransactionDAO();
    }
    
    public ArrayList<Transaction> retrieveTransactions(){
        
        ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
        
        ArrayList<Transaction> accTransList = transactionDAO.retrieveTransactions(accountNo);
        transactionList.addAll(accTransList);

        return transactionList;
    }
    
    public void addTransaction(String accountNo,double amount,String purpose) {
        java.util.Date date = new GregorianCalendar().getTime();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        transactionDAO.addTransaction(accountNo, sqlDate, amount, purpose);
    }
}
