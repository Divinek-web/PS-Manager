/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.psmanager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Divine K
 */
public class ScheduleDAO {
    private Connection con;
    public ScheduleDAO() throws SQLException{
        this.con = DBConnection.derbyConnection() ;
    }

      public Schedule saveSchedule(Schedule schedule){
        String insertSQL = "INSERT INTO Schedules (Emp_number, Emp_name,Date,Time) VALUES(?, ?, ?,?)";
        try {
            try (PreparedStatement ps = this.con.prepareStatement(insertSQL)) {

                ps.setString(1, schedule.getEmp_number());
                ps.setString(2, schedule.getEmp_name());
                ps.setString(3, schedule.getDate());
                ps.setString(4, schedule.getTime());
                
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Error with save method");
        }
        return schedule;
    }
      
      public ArrayList<Schedule> getAllSchedule() {
        ArrayList<Schedule> scheduleList = new ArrayList<>();
        String getSchedule = "select * from Schedules";
        try {
            PreparedStatement ps = this.con.prepareStatement(getSchedule);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("Table updated with record: "
                            + rs.getString(1) +"| "+ rs.getString(2)+"| " + rs.getString(3)+"| " + rs.getString(4) );
                    scheduleList.add(new Schedule(rs.getString("Emp_number"),rs.getString("Emp_name"), rs.getString("Date"), rs.getString("Time")));
                }
                rs.close();
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error with getAll method.");
        }
        return scheduleList;
      }
    
       public ArrayList<Schedule> getAllNames() {
        ArrayList<Schedule> nameList = new ArrayList<>();
        String getSchedule = "select * from Schedule";
        try {
            PreparedStatement ps = this.con.prepareStatement(getSchedule);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("Table updated with record: "
                            + rs.getString(1) +"| "+ rs.getString(2)+"| " + rs.getString(3)+"| " + rs.getString(4) );
                    nameList.add(new Schedule(rs.getString("Date"),rs.getString("Time"), rs.getString("Emp_number"), rs.getString("Emp_name")));
                }
                rs.close();
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error with getAllNames method.");
        }
        return nameList;
      }
    
      
      
    public void deleteSchedule(String string){
        String deleteSQL = "DELETE from Schedules where Emp_number = ?";
        try {
            try (PreparedStatement ps = this.con.prepareStatement(deleteSQL)) {
                ps.setString(1, string);

                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error with Delete Method","ERROR",JOptionPane.ERROR_MESSAGE);;
        }
        
    }
    
  public Schedule updateSchedule(Schedule schedule){
         String insertSQL = "UPDATE Schedule SET Emp_name = ?, Date = ?, Time = ?, "
               +"  WHERE Emp_number = ?";
        try {
            PreparedStatement ps = this.con.prepareStatement(insertSQL);
            ps.setString(1, schedule.getEmp_name());
            ps.setString(2, schedule.getDate());
            ps.setString(3, schedule.getTime());
           
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Update method error");
        }

        return schedule;
    }
    }  


