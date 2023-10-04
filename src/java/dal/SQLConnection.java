/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection con = null;
        // sign in driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // url = jdbc:sqlserver:// (+ SERVER NAME) : (+PORT); databaseName="(+DATABASENAME)";
        String url ="jdbc:sqlserver://LAPTOP-OITHJJHR\\DUYQUY:1433;databaseName=PT1_db;";
        //intergratedSecurity=true (if connect with SQL Server by Window Authentication)
        // 
        String user = "sa";String pass = "123456";
        con = DriverManager.getConnection(url, user, pass);
        return con;
    }
    public static Connection getConnection1() throws ClassNotFoundException, SQLException{
        Connection con = null;
        // sign in driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // url = jdbc:sqlserver:// (+ SERVER NAME) : (+PORT); databaseName="(+DATABASENAME)";
        String url ="jdbc:sqlserver://LAPTOP-OITHJJHR\\DUYQUY:1433;databaseName=Workshop1;";
        //intergratedSecurity=true (if connect with SQL Server by Window Authentication)
        // 
        String user = "sa";String pass = "123456";
        con = DriverManager.getConnection(url, user, pass);
        return con;
    }
    public static void main(String[] args) {
        try {
            Connection con = getConnection();
            if(con!=null) System.out.println("Login_Success!");
            else System.out.println("Failed!");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
