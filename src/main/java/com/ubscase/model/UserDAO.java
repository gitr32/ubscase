/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubscase.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author r128
 */
public class UserDAO {

    DataSource datasource;

    public UserDAO() {
        try {
            Context ctx = new InitialContext();
            datasource = (DataSource) ctx.lookup("java:comp/env/jdbc/ubscase");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        
        User returnUser = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            con = datasource.getConnection();

            ps = con.prepareStatement("select * from user where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new User(username, password);
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
        return returnUser;

    }
}
