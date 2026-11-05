package com.nitish.sms.model.util;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        System.out.println("programs started");
        try{
            System.out.println("try ro connect to it");
            Connection con=DBConnection.getConnection();
            System.out.println("database connection successful");
            con.close();
        }catch (Exception e){
            System.out.println("database connection failed");
            e.getMessage();
        }
    }
}
