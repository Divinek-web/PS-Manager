/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.psmanager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
/**
 *
 * @author Divine K
 */
public class ScheduleDAO {
    
    public Schedule save (Schedule schedule )throws SQLException
    
  {
      String insertSQL= "INSERT INTO schedule(Date,Time,Emp_number,Emp_name)"+"VALUES('%s','%s','%s','%s')";
      Connection con = DBConnection.derbyConnection();
      Statement statement = con.createStatement();
      insertSQL=String.format(insertSQL, schedule.getDate(),schedule.getTime()
              ,schedule.getEmp_number(),schedule.getEmp_name());
      statement.executeUpdate(insertSQL);
      return schedule;
      
  }
    
}

