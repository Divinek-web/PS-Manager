/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.psmanager;

/**
 *
 * @author Divine K
 */
public class Schedule {
    private  String Date;
    private  String Time;
    private  String Emp_number;
    private String Emp_name;

    public Schedule(String Date, String Time, String Emp_number, String Emp_name) {
        this.Date = Date;
        this.Time = Time;
        this.Emp_number = Emp_number;
        this.Emp_name = Emp_name;
    }

    @Override
    public String toString() {
        return "Schedule{" + "Date=" + Date + ", Time=" + Time + ", Emp_number=" + Emp_number + ", Emp_name=" + Emp_name + '}';
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getEmp_number() {
        return Emp_number;
    }

    public void setEmp_number(String Emp_number) {
        this.Emp_number = Emp_number;
    }

    public String getEmp_name() {
        return Emp_name;
    }

    public void setEmp_name(String Emp_name) {
        this.Emp_name = Emp_name;
    }
    
    
    
}
