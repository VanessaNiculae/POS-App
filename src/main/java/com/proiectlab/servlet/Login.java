/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proiectlab.servlet;

import com.proiectlab.bean.ProductBean;
import com.proiectlab.bean.TransactionBean;
import com.proiectlab.bean.UserBean;
import com.proiectlab.entity.Product;
import com.proiectlab.entity.Transactions;
import com.proiectlab.entity.UserType;
import com.proiectlab.entity.Users;
import com.proiectlab.patterns.LoggedUser;
import com.proiectlab.utility.Password;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Inject
    UserBean userBean;

    @Inject
    ProductBean productBean;

    @Inject
    TransactionBean transactionBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (LoggedUser.getInstance().getLoggedUser() != null) {
            redirect(LoggedUser.getInstance().getLoggedUser(), request, response);
        }

        if (request.getParameter("username") == null) {
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        } else {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            
            String hashPass = Password.convertToSha256(password);
            //String hashPass = password;
            Users usero = null;
            try {
                System.out.println("pe aici");
                usero = userBean.getByUsername(username);
                                System.out.println(" si pe aici");

            } catch (Exception ex) {
                request.setAttribute("error_message", "Username sau parola invalide!");
                request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            }

            if (usero.getPassword().equals(hashPass)) {
                if (usero.getIdUserType().getType().equals("PENDING")) {
                    request.setAttribute("error_message", "Username nu este inca acceptat!");
                    request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
                }
                LoggedUser.getInstance().setLoggedUser(usero);
                redirect(usero, request, response);
            } else {
                request.setAttribute("error_message", "Username sau parola invalide!");
                request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            }
        }

    }

    public void redirect(Users user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserType type = user.getIdUserType();

        List<Product> allProducts = productBean.getAllProducts();
        List<Users> allUsers = userBean.getAllUsers();
        List<Transactions> allTransactions = transactionBean.getAllTransactions();

        System.out.println(type.getType());

        if ("CASHIER".equals(type.getType())) {
            
            request.getRequestDispatcher("/WEB-INF/pages/cashier.jsp").forward(request, response);
        } else if ("DIRECTOR".equals(type.getType())) {
            request.setAttribute("allProducts", allProducts);
            request.setAttribute("allUsers", allUsers);

            request.getRequestDispatcher("/WEB-INF/pages/director.jsp").forward(request, response);
        } else if ("ADMIN".equals(type.getType())) {

            request.setAttribute("allProducts", allProducts);
            request.setAttribute("allUsers", allUsers);
            request.setAttribute("allTransactions", allTransactions);

            request.getRequestDispatcher("/WEB-INF/pages/admin.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
