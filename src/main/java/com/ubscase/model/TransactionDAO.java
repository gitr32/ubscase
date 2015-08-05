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
import java.util.Calendar;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Date;

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
    
    public ArrayList<Transaction> retrieveTransactions(String accountNo){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
        
        try {

            con = datasource.getConnection();

            ps = con.prepareStatement("select * from transaction where accountNo = ? and order by transdate desc");
            ps.setString(1, accountNo);
            rs = ps.executeQuery();
             
            while(rs.next()) {
                int transID = rs.getInt("transID");
                Date date = rs.getDate("transDate");
                double amount = rs.getDouble("amount");
                String purpose = rs.getString("purpose");
                transactionList.add(new Transaction(transID,accountNo,date,amount,purpose));
            }
        } catch (Exception e) {
            
        } finally {
            if(rs != null) {
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
        
        return transactionList;
    }
    
    
    
    public void addTransaction(String accountNo, Date date, double amount, String purpose){
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try {

            con = datasource.getConnection();

            ps = con.prepareStatement("insert into transaction values (?,?,?,?,?)");
            ps.setInt(1, 0);
            ps.setString(2, accountNo);
            ps.setDate(3,date);
            ps.setDouble(4, amount);
            ps.setString(5, purpose);
            ps.executeUpdate();

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
