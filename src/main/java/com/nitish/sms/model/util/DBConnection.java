package com.nitish.sms.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    //established the connection
    private static final String url="jdbc:mysql://localhost:3306/ student_management_system";
    private static final String name="root";
    private static final String password="password";
//load and register the connection
    public static Connection getConnection(){
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");

          return DriverManager.getConnection(url,name,password);
      }catch (ClassNotFoundException | SQLException e){
        throw new RuntimeException("database connection failed",e);
      }


    }
}
