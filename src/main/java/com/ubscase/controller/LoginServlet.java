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
import java.util.*;

/**
 *
 * @author r128
 */
public class LoginServlet extends org.apache.struts.action.Action {

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
        
        
        ArrayList<String> errorList = new ArrayList<String>();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(!username.equals("admin") || !password.equals("pass")) {
            errorList.add("A valid username/password");
        }
        
        if(errorList.isEmpty()) {
            return mapping.findForward(SUCCESS);
        }
        
        request.setAttribute("errorList", errorList);
        return mapping.findForward(ERROR);
    }
}
