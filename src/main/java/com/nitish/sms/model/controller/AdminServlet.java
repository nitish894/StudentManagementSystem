package com.nitish.sms.model.controller;

import com.nitish.sms.model.dao.AdminDAO;
import com.nitish.sms.model.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private AdminDAO adminDAO;

    @Override
    public void init() throws ServletException {
        adminDAO = new AdminDAO();
    }

    @Override
    public void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("login".equals(action)) {

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Admin admin = adminDAO.login(email, password);

            if (admin != null) {

                HttpSession session = request.getSession();
                session.setAttribute("loggedInAdmin", admin);

                response.sendRedirect(
                        request.getContextPath() + "/admin?action=dashboard");

            } else {

                request.setAttribute("errorMessage",
                        "Invalid email or password!");

                request.getRequestDispatcher("/login.jsp")
                        .forward(request, response);
            }

        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("dashboard".equals(action)) {

            HttpSession session = request.getSession(false);

            if (session == null ||
                    session.getAttribute("loggedInAdmin") == null) {

                response.sendRedirect(
                        request.getContextPath() + "/login.jsp");
                return;
            }

            request.getRequestDispatcher("/dashboard.html")
                    .forward(request, response);

        } else if ("logout".equals(action)) {

            HttpSession session = request.getSession(false);

            if (session != null) {
                session.invalidate();
            }

            response.sendRedirect(
                    request.getContextPath() + "/login.jsp");

        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}