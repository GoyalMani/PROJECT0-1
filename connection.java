package com.company.bankApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
    // connection object
    static Connection con;
    public static Connection getConnection()
    {
      try{
          String url = "jdbc:mysql://localhost:3306/BANK";
          String username = "root";
          String password=System.getenv("MYVAR");
          con= DriverManager.getConnection(url,username,password);
      }
      catch (Exception e)
      {
          System.out.println("CONNECTION NOT ESTABLISHED");
      }
      return con;
    }

}
