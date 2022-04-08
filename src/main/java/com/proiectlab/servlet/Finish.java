/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proiectlab.servlet;

import com.proiectlab.bean.TransactionBean;
import com.proiectlab.bean.TransactionTypeBean;
import com.proiectlab.entity.Transactions;
import com.proiectlab.entity.Users;
import com.proiectlab.patterns.Cart;
import com.proiectlab.patterns.CartType;
import com.proiectlab.patterns.LoggedUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author frati
 */
@WebServlet(name = "Finish", urlPatterns = {"/Finish"})
public class Finish extends HttpServlet {

    @Inject
    TransactionBean transactionBean;

    @Inject
    TransactionTypeBean ttb;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Users user = LoggedUser.getInstance().getLoggedUser();
        CartType type = Cart.getInstance().getCartType();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());

        Transactions currentTransaction = transactionBean.createTransaction(date, ttb.findByName(type.name()), user);
        transactionBean.calculateTotalValue(currentTransaction, Cart.getInstance().getProductsInCart());

        Cart.getInstance().prepareForNewAction();

        response.sendRedirect("http://localhost:8080/ProiectSoftware/Login");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
