/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubscase.model;

import java.util.*;
/**
 *
 * @author r128
 */
public class Transaction {
    private String accountNo;
    private Calendar date;
    private double amount;
    private String purpose;

    public Transaction(String accountNo, Calendar date, double amount, String purpose) {
        this.accountNo = accountNo;
        this.date = date;
        this.amount = amount;
        this.purpose = purpose;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    
    
}
