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
import com.ubscase.model.*;
import java.util.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author r128
 */
public class ValidationAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

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
        
        String validCode = request.getParameter("code");
        
        if(validCode.equals("123456")) {
            HttpSession session = request.getSession();
            String username = (String)session.getAttribute("username");
            AccountList accounts = new AccountList(username);
            ArrayList<Account> accountList = accounts.retrieveAccounts();

            if(!accountList.isEmpty()) {
                Account account = accountList.get(0);
                session.setAttribute("account",account);
            }
            
            return mapping.findForward(SUCCESS);
        }
        request.setAttribute("errorMsg", "Please enter the code sent to your mobile phone");
        return mapping.findForward(ERROR);
    }
}
