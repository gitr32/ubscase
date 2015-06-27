/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubscase.model;

/**
 *
 * @author r128
 */
public class Account {
    private String accountUser;
    private String accountNo;
    private double balance;

    public Account(String accountUser, String accountNo, double balance) {
        this.accountUser = accountUser;
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(String accountUser) {
        this.accountUser = accountUser;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
