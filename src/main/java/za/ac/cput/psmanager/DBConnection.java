/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.psmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Divine K
 */
public class DBConnection {
    
    public static Connection derbyConnection() throws SQLException{
    
        String url="jdbc:derby://localhost:1527/PsManagerDb";
        String user="Divine";
        String password="divine";
        return DriverManager.getConnection(url,user,password);
    }
    
}
