/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopstock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class DatabaseConnection {
    public static Connection con;
    
    Connection connection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=STOCKDATABASE;user=sa;password=shawon420";
            con=DriverManager.getConnection(url);
            Statement st=con.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        return con;
    }
    
}



