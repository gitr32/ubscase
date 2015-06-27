/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubscase.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.util.*;

/**
 *
 * @author r128
 */
public class AccountDAO {
    DataSource datasource;
    public AccountDAO() {
         try {
            Context ctx = new InitialContext();
            datasource = (DataSource) ctx.lookup("java:comp/env/jdbc/ubscase");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Account> getAccounts(String username) {
        
        ArrayList<Account> accounts = new ArrayList<Account>();
        User returnUser = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            con = datasource.getConnection();

            ps = con.prepareStatement("select * from account where username=?");
            ps.setString(1, username);
            rs = ps.executeQuery();

            while(rs.next()) {
                String accountNo = rs.getString("accountNo");
                double balance = rs.getDouble("balance");
                accounts.add(new Account(accountNo, balance));
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return accounts;
    }
    
    public void updateAccounts(Account account1, Account account2, double amount) {
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try {

            con = datasource.getConnection();
            
            ps = con.prepareStatement("update account set balance=? where accountNo=?");
            ps.setDouble(1, account1.getBalance());
            ps.setString(2, account1.getAccountNo());
            ps.addBatch();
            ps.setDouble(1, account2.getBalance());
            ps.setString(2, account2.getAccountNo());
            ps.addBatch();
            ps.executeBatch();

            
        } catch (Exception e) {

        } finally {
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
