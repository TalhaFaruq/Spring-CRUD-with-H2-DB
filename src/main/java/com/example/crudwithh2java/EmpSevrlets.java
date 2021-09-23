package com.example.crudwithh2java;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class EmpSevrlets extends HttpServlet{
/*
    private static final long serialVersionUID = 1L;
*/
    private  EmpOperations empops;


    public void init() {
        empops = new EmpOperations();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertemp(request, response);
                    break;
                case "/delete":
                    deleteemp(request, response);
                    break;
             case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateemp(request, response);
                    break;
                case "/list":
                    listemp(request, response);
                    break;
                default:
//                    listBook(request, response);
                    System.out.println("No actions");
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listemp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Emp> listUser = empops.listall();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listall.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("newform.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
         Emp existingemp = empops.edit(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editform.jsp");
        request.setAttribute("existingemp",existingemp);
        dispatcher.forward(request, response);
    }

    private void insertemp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String profession = request.getParameter("profession");

        Emp emp = new Emp(name, email, profession);
        empops.insert(emp);

        response.sendRedirect("list");
    }

    private void updateemp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String profession = request.getParameter("profession");

        Emp emp = new Emp(id, name, email, profession);
        empops.update(emp);

        response.sendRedirect("list");
    }

    private void deleteemp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Emp emp = new Emp(id);
        empops.delete(emp);

        response.sendRedirect("list");
    }
}
