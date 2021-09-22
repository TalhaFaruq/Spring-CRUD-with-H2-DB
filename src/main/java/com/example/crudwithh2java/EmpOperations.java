package com.example.crudwithh2java;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "helloServlet", value = "/hello-servlet")

public class EmpOperations extends HttpServlet implements EmpInterface {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
    }

    public void destroy() {
    }

    private Connection jdbcConnection;

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection("jdbc:h2:~/tdb", "talha", "");
        }
    }

    @Override
    public boolean insert(Emp emp) throws SQLException {
        String query = "Insert into users (name, email, profession) values (?, ?, ?)";

        connect();

        PreparedStatement preparedStatement = jdbcConnection.prepareStatement(query);
        preparedStatement.setString(1, emp.getName());
        preparedStatement.setString(2, emp.getEmail());
        preparedStatement.setString(3, emp.getProfession());
        if (preparedStatement.executeUpdate() > 0) {
            preparedStatement.close();
            jdbcConnection.close();
            return true;
        } else return false;
    }

    @Override
    public ArrayList<Emp> listall() throws SQLException {
        String query = "Select * from users"; //Query for showing all data
        ArrayList<Emp> Empdata = new ArrayList<Emp>();

        connect(); //For Connection

        Statement statement = jdbcConnection.createStatement(); //for statement of query
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String profession = resultSet.getString("profession");
            Empdata.add(new Emp(id, name, email, profession));
        }
        return Empdata; //The Arraylist has all the values of table
    }

    @Override
    public boolean update(Emp emp) throws SQLException {
        String query = "UPDATE users SET name = ?, email = ?, profession = ? where id is = ?";
        connect();

        PreparedStatement preparedStatement = jdbcConnection.prepareStatement(query);
        preparedStatement.setString(1, emp.getName());
        preparedStatement.setString(2, emp.getEmail());
        preparedStatement.setString(3, emp.getProfession());
        preparedStatement.setInt(4, emp.getId());
        if (preparedStatement.executeUpdate() > 0) {
            preparedStatement.close();
            jdbcConnection.close();
            return true;
        } else return false;
    }

    @Override
    public boolean delete(Emp emp) throws SQLException {
        String query = "Delete from users where id = ?"; //Query for showing all data

        connect();

        PreparedStatement preparedStatement = jdbcConnection.prepareStatement(query);
        preparedStatement.setInt(1, emp.getId());
        if (preparedStatement.executeUpdate() > 0) {
            preparedStatement.close();
            jdbcConnection.close();
            return true;
        } else return false;
    }
}
