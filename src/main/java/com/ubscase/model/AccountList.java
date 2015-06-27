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
        return accountDAO.getAccounts(username);
    }

    public Account retrieveAccountByNo(String accountNo) {
        Account returnAccount = null;
        accountList = accountDAO.getAccounts(username);
        for (Account a : accountList) {
            if (a.getAccountNo().equals(accountNo)) {
                returnAccount = a;
            }
        }

        return returnAccount;
    }

    public Account updateAccount(String accNo1, String accNo2, double amount) {
        Account account1 = retrieveAccountByNo(accNo1);
        Account account2 = retrieveAccountByNo(accNo2);

        double balance1 = account1.getBalance();
        double balance2 = account2.getBalance();

        balance1 -= amount;
        balance2 += amount;

        account1.setBalance(balance1);
        account2.setBalance(balance2);

        accountDAO.updateAccounts(account1, account2, amount);
        return account1;
    }
}
