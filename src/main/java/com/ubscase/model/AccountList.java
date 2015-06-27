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
public class AccountList {
    private String username;
    private ArrayList<Account> accountList;
    private AccountDAO accountDAO;
    
    public AccountList(String username) {
        this.username = username;
        accountDAO = new AccountDAO();
    }
    
    public ArrayList<Account> retrieveAccounts() {
        if(accountList == null) {
            accountList = accountDAO.getAccounts(username);  
        }
        return accountList;
    }
}
