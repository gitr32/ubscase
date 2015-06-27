/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubscase.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author r128
 */
public class TransactionDAO {
    DataSource datasource;
    public TransactionDAO() {
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
}
