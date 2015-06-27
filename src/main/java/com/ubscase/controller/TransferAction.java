/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubscase.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpSession;
import java.util.*;
import com.ubscase.model.*;

/**
 *
 * @author r128
 */
public class TransferAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        HttpSession session = request.getSession();
        ArrayList<String> errorList = new ArrayList<String>();

        Account account = (Account) session.getAttribute("account");
        String strAmount = request.getParameter("amount");
        Double dblAmount = -1.0;
        try {
            dblAmount = Double.parseDouble(strAmount);

            if (dblAmount > account.getBalance()) {
                errorList.add("Please enter an amount that is not more than your account balance");
            }
        } catch (NumberFormatException e) {
            errorList.add("Please enter a valid amount");
        }

        if (!errorList.isEmpty()) {
            request.setAttribute("errorMsg", errorList);
        } else {
            String trfAccount = request.getParameter("trfAccount");
            String username = (String)session.getAttribute("username");
            AccountList accountList = new AccountList(username);
            TransactionList transactionList = new TransactionList(username);
            
            Account newAccount = accountList.updateAccount(account.getAccountNo(),trfAccount , dblAmount);
            session.setAttribute("account", newAccount);
            
            transactionList.addTransaction(account.getAccountNo(), -dblAmount , "Funds Transfer");
            transactionList.addTransaction(trfAccount, dblAmount , "Funds Transfer");
        }
        
        
        return mapping.findForward(SUCCESS);

    }
}
