/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubscase.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author r128
 */
public class TradeDAO {

    DataSource datasource;

    public TradeDAO() {
        try {
            Context ctx = new InitialContext();
            datasource = (DataSource) ctx.lookup("java:comp/env/jdbc/ubscase");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Trade> retrieveTrades(String accountNo) {
        
        ArrayList<Trade> trades = new ArrayList<Trade>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {

            con = datasource.getConnection();

            ps = con.prepareStatement("select * from trades where accountNo = ?");
            ps.setString(1, accountNo);

            rs = ps.executeQuery();
            
            while(rs.next()) {
                int tradeID = rs.getInt("tradeID");
                Date date = rs.getDate("date");
                String symbol = rs.getString("symbol");
                int volume = rs.getInt("volume");
                double price = rs.getDouble("price");
                trades.add(new Trade(tradeID,date,accountNo,symbol,volume,price));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        
        return trades;
    }

    public void addTrade( Date date,String accountNo,String symbol, int volume, double price) {
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = datasource.getConnection();

            ps = con.prepareStatement("insert into trades values (?,?,?,?,?,?)");
            ps.setInt(1, 0);
            ps.setString(2,accountNo);
            ps.setDate(3,date);
            ps.setString(4, symbol);
            ps.setInt(5, volume);
            ps.setDouble(6,price);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
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
