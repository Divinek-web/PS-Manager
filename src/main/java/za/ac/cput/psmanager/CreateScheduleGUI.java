/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.psmanager;

/**
 *
 * @author Divine K
 */import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;




public class CreateScheduleGUI extends JFrame implements ActionListener{
    private JFrame mainFrame,saveFrame,updateFrame,deleteFrame,viewFrame;
    private JPanel panelNorth, panelWest,panelCenter,
            panelheading,panelbutton,
            panelmiddle1,panelmiddle2,panelmiddle3,panelmiddle4,panelmiddle5,
            panelSaveHeading,panelSaveInput,panelSaveButton,
            panelUpdateHeading,panelUpdateInput,panelUpdateButton,
            panelDeleteHeading,panelDeleteInput,panelDeleteButton,
            panelViewHeading,panelViewDisplay,panelViewbottom;
    
    //Panel North and West components
    private JLabel lblPicture;
    private JLabel lblCompanyName;
    private JButton btnInventory;
    private JButton btnPersonnel;
    private JButton btnSchedule;
    private JButton btnCriminal;
    private JButton btnJailCell;
    private JPanel  panelBlank1,panelBlank2,panelBlank3,panelBlank4,panelBlank5;
    private Font font1;
    Insets btnInsets = new Insets(5,5,5,5);
   //Panel Center components
   private JLabel  Heading, deleteHeading,saveHeading,updateHeading,viewHeading;
   private JLabel Date,Date2;
   private JTextField txtDate,txtDate2;
   private JLabel Time,Time2;
   private JTextField txtTime,txtTime2;
   private JLabel Emp_number,Emp_number2;
   private JTextField txtEmp_number;
  private JComboBox <String>txtUpdate_Delete2;
   
   private JLabel Emp_name,Emp_name2;
   private JComboBox txtEmp_name;
   private JTextField txtEmp_name2;
   private JLabel Update_Delete,Update_Delete2;
   private JComboBox <String>txtUpdate_Delete;
   

   
  private JButton Insert,Update,Delete,View;
  private JButton saveButton,updateButton,deleteButton,btnSearch;
  private JTextField txtSearch;
  private DefaultTableModel tableModel;
  private JTable tblSchedule;
  private Vector originalTable;
  ArrayList<Schedule> scheduleList = new ArrayList<>();
  ArrayList<Schedule> nameList = new ArrayList<>();

  ScheduleDAO dao;
  Schedule attributes;
  
  
    public CreateScheduleGUI() throws SQLException{
        
     dao= new ScheduleDAO();
    //Main Frame -panel center
   //***********************
       Heading= new JLabel( " SCHEDULE MANAGER",SwingConstants.CENTER);
       Heading .setForeground(Color.yellow);
       Date=new JLabel      ("                                                              Schedule Date:");
       txtDate=new JTextField(10);
       Time=new JLabel      ("                                                              Schedule Time:");
       txtTime=new JTextField(10); 
       Emp_number=new JLabel("                                                       Employee Number:");
       txtEmp_number=new JTextField(10);
       Emp_name=new JLabel  ("                                                         Employee Name:");
       String ListOfName[] = {"Divine", "Esther", "samuel","Faith","Chantal"};  
       txtEmp_name=new  JComboBox(ListOfName);
       txtEmp_name.setSelectedItem(null);
       //combobox for deleteFrame
       Update_Delete=new JLabel("Select Employee Number to Update or Delete");
       txtUpdate_Delete=new JComboBox<String>();
       txtUpdate_Delete.setSelectedItem(null);
       
       // All buttons of maiFrame
        Insert = new JButton("Add");
        Insert.setBackground(Color.blue);
        Insert.setForeground(Color.white);
        
        Update = new JButton("Update");
        Update.setBackground(Color.blue);
        Update.setForeground(Color.white);
        
        Delete = new JButton("Delete");
        Delete.setBackground(Color.blue);
        Delete.setForeground(Color.white);
        
        View = new JButton("View Schedule");
        View.setBackground(Color.YELLOW);
        View.setForeground(Color.blue);
        //All panels of panel center
        panelmiddle1=new JPanel();panelmiddle2=new JPanel();panelmiddle3=new JPanel();panelmiddle4=new JPanel();panelmiddle5=new JPanel();
        panelmiddle1.setBackground(Color.white);
        panelmiddle2.setBackground(Color.white);
        panelmiddle3.setBackground(Color.white);
        panelmiddle4.setBackground(Color.white);
        panelmiddle5.setBackground(Color.white);

        panelbutton=new JPanel();
        panelheading=new JPanel();
        panelheading.setBackground(Color.blue);
        
    //Main Frame - panel north and west
   //*********************************
        mainFrame = new JFrame("PS Manager");
        panelNorth = new JPanel();
        panelNorth.setBackground(new Color(27,78,164));
        panelWest = new JPanel();
        panelWest.setBackground(new Color(27,78,164));
        panelCenter = new JPanel();
        panelCenter.setBackground(Color.WHITE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height * 2 / 3;
        int width = screenSize.width * 2 / 3;
        mainFrame.setPreferredSize(new Dimension(width, height));
        
        font1 = new Font("Impact", Font.PLAIN,40);
        
        lblPicture = new JLabel(new ImageIcon("src/logo.png"),SwingConstants.LEFT);
        lblPicture.setPreferredSize(new Dimension(100,100));
        lblPicture.setOpaque(false);
        
        
        lblCompanyName = new JLabel("PS MANAGER     ");
        lblCompanyName.setFont(font1);
        lblCompanyName.setForeground(new Color(253,245,104));
        
        btnInventory = new JButton("INVENTORY");
        btnInventory.setForeground(Color.BLACK);
        btnInventory.setMargin(btnInsets);


        btnPersonnel = new JButton("PERSONNEL");
        btnPersonnel.setForeground(Color.BLACK);
        btnPersonnel.setMargin(btnInsets);
        
        btnSchedule = new JButton("SCHEDULE");
        btnSchedule.setForeground(Color.BLACK);
        btnSchedule.setMargin(btnInsets);

        btnCriminal = new JButton("CRIMINAL");
        btnCriminal.setForeground(Color.BLACK);
        btnCriminal.setMargin(btnInsets);

        btnJailCell = new JButton("JAIL CELL");
        btnJailCell.setForeground(Color.BLACK);
        btnJailCell.setMargin(btnInsets);
        
        panelBlank1 = new JPanel();
        panelBlank1.setBackground(new Color(27,78,164));
        panelBlank2 = new JPanel();
        panelBlank2.setBackground(new Color(27,78,164));
        panelBlank3 = new JPanel();
        panelBlank3.setBackground(new Color(27,78,164));
        panelBlank4 = new JPanel();
        panelBlank4.setBackground(new Color(27,78,164));
        panelBlank5 = new JPanel();
        panelBlank5.setBackground(new Color(27,78,164));
   //**********************************************end of mainFrame
   //**********************************************
   //Start of saveFrame     
        saveFrame=new JFrame("Add Schedule");
        saveFrame.setPreferredSize(new Dimension(500, 300));
        panelSaveHeading=new JPanel();
        panelSaveHeading.setBackground(Color.blue);
        panelSaveInput=new JPanel();
        panelSaveButton=new JPanel();
       
       saveHeading= new JLabel( "ADD SCHEDULE",SwingConstants.CENTER);
       saveHeading .setForeground(Color.yellow);
       Date=new JLabel      ("Schedule Date:");
       txtDate=new JTextField(10);
       Time=new JLabel      ("Schedule Time:");
       txtTime=new JTextField(10); 
       Emp_number=new JLabel("Employee Number:");
       txtEmp_number=new JTextField(10);
       Emp_name=new JLabel  ("Employee Names:");
         
       txtEmp_name=new  JComboBox<String>();
       txtEmp_name.setSelectedItem(null);
        saveButton = new JButton("Save");
        saveButton.setBackground(Color.white);
        saveButton.setForeground(Color.black);
       
          
    //Start of UpdateFrame    
        panelUpdateHeading=new JPanel();
        panelUpdateHeading.setBackground(Color.blue);
        panelUpdateInput=new JPanel();
        panelUpdateButton=new JPanel();
        
        updateFrame=new JFrame("Update Schedule");
        updateFrame.setPreferredSize(new Dimension(500, 300));
        panelUpdateHeading=new JPanel();
        panelUpdateHeading.setBackground(Color.blue);
       
       
       updateHeading= new JLabel( "UPDATE SCHEDULE",SwingConstants.CENTER);
       updateHeading .setForeground(Color.yellow);
       Date2=new JLabel      ("Schedule Date:");
       txtDate2=new JTextField(10);
       Time2=new JLabel      ("Schedule Time:");
       txtTime2=new JTextField(10); 
       Emp_number2=new JLabel("Employee Number:");
       txtUpdate_Delete2=new  JComboBox<String>();
      

       Emp_name2=new JLabel  ("Employee Names:");
       txtEmp_name2=new  JTextField(10);
      
       updateButton = new JButton("Update");
       updateButton.setBackground(Color.white);
       updateButton.setForeground(Color.black);
       
          
        
    //Start of DeleteFrame
        deleteFrame=new JFrame("Delete Schedule");
        deleteFrame.setPreferredSize(new Dimension(500, 300));
        panelDeleteHeading=new JPanel();
        panelDeleteHeading.setBackground(Color.blue);
        panelDeleteInput=new JPanel();
        panelDeleteButton=new JPanel();
       //combobox for deleteFrame
       deleteHeading= new JLabel( "DELETE SCHEDULE",SwingConstants.CENTER);
       deleteHeading .setForeground(Color.yellow);
       Update_Delete=new JLabel("Select Employee Number to Delete their Schedule");
       txtUpdate_Delete=new JComboBox<String>();
       txtUpdate_Delete.setSelectedItem(null);
        deleteButton = new JButton("Delete");
        deleteButton.setBackground(Color.white);
        deleteButton.setForeground(Color.black);
        
    //Start of View Frame
    
        viewFrame = new JFrame("Display Schedule");
        viewFrame.setPreferredSize(new Dimension(500, 300));
        panelViewHeading = new JPanel();
        panelViewDisplay = new JPanel();
        panelViewbottom = new JPanel();
        viewHeading=new JLabel("SCHEDULE DATABASE");
        tableModel = new DefaultTableModel();
        tblSchedule = new JTable(tableModel);
        btnSearch = new JButton("Search");
        txtSearch = new JTextField();

    }
    
    public void runSheduleGUI2(){
        
    //layouts of  mainFrames 
        mainFrame.add(panelNorth, BorderLayout.NORTH);
        mainFrame.add(panelWest, BorderLayout.WEST);
        mainFrame.add(panelCenter, BorderLayout.CENTER);
        
    // layouts of the main 3 panels
        panelNorth.setLayout(new GridLayout(1,2));
        panelWest.setLayout(new GridLayout(10, 1));
        panelCenter.setLayout(new GridLayout(12, 1));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(20, 40, 4, 40));
      
    //placing components on each panel
        panelNorth.add(lblPicture);
        panelNorth.add(lblCompanyName);
        
        panelWest.add(panelBlank1);
        panelWest.add(btnInventory);
        panelWest.add(panelBlank2);
        panelWest.add(btnCriminal);
        panelWest.add(panelBlank3);
        panelWest.add(btnJailCell);
        panelWest.add(panelBlank4);
        panelWest.add(btnPersonnel);
        panelWest.add(panelBlank5);
        panelWest.add(btnSchedule);
        
        //Components of panel center
        //----------------------------
        
        // 1 heading panel
        panelheading.add(Heading);
        panelheading.setLayout( new GridLayout(2,1));
        //2 button panel
        panelbutton.add (Insert);  panelbutton.add (Update); panelbutton.add (Delete);panelbutton.add (View);
        panelbutton.setLayout(new GridLayout(1,4));
        //3 middle panels(5)
        panelmiddle1.setLayout(new GridLayout(1,2));
        panelmiddle2.setLayout(new GridLayout(1,2));
        panelmiddle3.setLayout(new GridLayout(1,2));
        panelmiddle4.setLayout(new GridLayout(1,2));
        panelmiddle5.setLayout(new GridLayout(1,2));
   
        panelmiddle1.add(Emp_name);panelmiddle1.add(txtEmp_name);
        panelmiddle2.add(Emp_number);panelmiddle2.add(txtEmp_number);
        panelmiddle3.add(Date);panelmiddle3.add(txtDate);
        panelmiddle4.add(Time);panelmiddle4.add(txtTime);
        panelmiddle5.add(Update_Delete);panelmiddle5.add(txtUpdate_Delete);

        //adding the panels in panel center
        panelCenter.add(panelheading);
        panelCenter.add(Box.createRigidArea(new Dimension(10,0)));
        
        panelCenter.add(panelmiddle1);
        panelCenter.add(panelmiddle2); 
        panelCenter.add(panelmiddle3);
        panelCenter.add(panelmiddle4);
        panelCenter.add(Box.createRigidArea(new Dimension(10,0)));
        panelCenter.add(panelmiddle5);
        panelCenter.add(Box.createRigidArea(new Dimension(10,0)));
        panelCenter.add(panelbutton);
       //Closing window
        mainFrame.addWindowListener(new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
             });
        //**********************************
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    
       // Adding ActionListeners
        Insert.addActionListener(this);
        Update.addActionListener(this);
        Delete.addActionListener(this);
        View.addActionListener(this);
       
        btnSchedule.addActionListener(this);
        btnInventory.addActionListener(this);
        btnPersonnel.addActionListener(this);
        btnJailCell.addActionListener(this);
        btnCriminal.addActionListener(this);
        
        txtUpdate_Delete2.addActionListener(this);
        txtEmp_name.addActionListener(this);
        
        //Start of SaveFrame
        saveFrame.add(panelSaveHeading, BorderLayout.NORTH);
        saveFrame.add(panelSaveInput, BorderLayout.CENTER);
        saveFrame.add(panelSaveButton, BorderLayout.PAGE_END);
        
        panelSaveHeading.setLayout(new GridLayout(1,1));
        panelSaveHeading.setBorder(BorderFactory.createEmptyBorder(20, 20, 8, 30));
        panelSaveInput.setLayout(new GridLayout(7,2));
        panelSaveInput.setBorder(BorderFactory.createEmptyBorder(20, 20, 8, 30));
        panelSaveButton.setLayout(new BoxLayout(panelSaveButton, BoxLayout.LINE_AXIS));
        panelSaveButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 200));
        panelSaveButton.add(Box.createHorizontalGlue());
        
        panelSaveHeading.add(saveHeading); 
        panelSaveInput.add(Emp_name);panelSaveInput.add(txtEmp_name);
        panelSaveInput.add(Emp_number);panelSaveInput.add(txtEmp_number);
        panelSaveInput.add(Date);panelSaveInput.add(txtDate);
        panelSaveInput.add(Time);panelSaveInput.add(txtTime);
        panelSaveButton.add(saveButton);
        saveButton.addActionListener(this);
        
      //Start ofUpdateframe
        updateFrame.add(panelUpdateHeading, BorderLayout.NORTH);
        updateFrame.add(panelUpdateInput, BorderLayout.CENTER);
        updateFrame.add(panelUpdateButton, BorderLayout.PAGE_END);
        
        panelUpdateHeading.setLayout(new GridLayout(1,1));
        panelUpdateHeading.setBorder(BorderFactory.createEmptyBorder(20, 20, 8, 30));
        panelUpdateInput.setLayout(new GridLayout(7,2));
        panelUpdateInput.setBorder(BorderFactory.createEmptyBorder(20, 20, 8, 30));
        panelUpdateButton.setLayout(new BoxLayout(panelUpdateButton, BoxLayout.LINE_AXIS));
        panelUpdateButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 200));
        panelUpdateButton.add(Box.createHorizontalGlue());
        
        panelUpdateHeading.add(updateHeading); 
        panelUpdateInput.add(Emp_number2);panelUpdateInput.add(txtUpdate_Delete2);
        panelUpdateInput.add(Emp_name2);panelUpdateInput.add(txtEmp_name2);        
        panelUpdateInput.add(Date2);panelUpdateInput.add(txtDate2);
        panelUpdateInput.add(Time2);panelUpdateInput.add(txtTime2);
        panelUpdateButton.add(updateButton);
        updateButton.addActionListener(this);
        
      //Start of Delete Frame
        
        deleteFrame.add(panelDeleteHeading, BorderLayout.NORTH);
        deleteFrame.add(panelDeleteInput, BorderLayout.CENTER);
        deleteFrame.add(panelDeleteButton, BorderLayout.PAGE_END);
        
        panelDeleteHeading.setLayout(new GridLayout(1,1));
        panelDeleteHeading.setBorder(BorderFactory.createEmptyBorder(20, 20, 8, 30));
        panelDeleteInput.setLayout(new GridLayout(5,2));
        panelDeleteInput.setBorder(BorderFactory.createEmptyBorder(20, 20, 8, 20));
        panelDeleteButton.setLayout(new BoxLayout(panelDeleteButton, BoxLayout.LINE_AXIS));
        panelDeleteButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 200));
        panelDeleteButton.add(Box.createHorizontalGlue());
        
        panelDeleteHeading.add(deleteHeading); 
        panelDeleteInput.add(Update_Delete);panelDeleteInput.add(txtUpdate_Delete);
        panelDeleteButton.add(deleteButton);
        deleteButton.addActionListener(this);
        
       //Start of View Frame
        viewFrame.add(panelViewHeading, BorderLayout.NORTH);
        viewFrame.add(panelViewDisplay, BorderLayout.CENTER);
        viewFrame.add(panelViewbottom, BorderLayout.PAGE_END);
        
        panelViewHeading.setLayout(new GridLayout(1,1));
        panelViewHeading.setBorder(BorderFactory.createEmptyBorder(20, 20, 8, 30));
        panelViewDisplay.setLayout(new GridLayout(1,2));
        panelViewDisplay.setBorder(BorderFactory.createEmptyBorder(20, 20, 8, 20));
        panelViewbottom.setLayout(new BoxLayout(panelViewbottom, BoxLayout.LINE_AXIS));
        panelViewbottom.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 200));
        panelViewbottom.add(Box.createHorizontalGlue());
        
         panelViewHeading.add(viewHeading);
         panelViewDisplay.add(tblSchedule);
         panelViewbottom.add(txtSearch);
         panelViewbottom.add(Box.createRigidArea(new Dimension(10,0)));
         panelViewbottom.add(btnSearch);
         btnSearch.addActionListener(this);
        
        
        tableModel.addColumn("Employee number");
        tableModel.addColumn("Employee names");
        tableModel.addColumn("Date");
        tableModel.addColumn("Time");
       
        panelViewDisplay.add(new JScrollPane(tblSchedule));
        tblSchedule.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = tblSchedule.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(140);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(140);
        columnModel.getColumn(3).setPreferredWidth(140);
       
        
    }
    
  
      @Override
      public void actionPerformed(ActionEvent e)
              
         //Save button
      {if (e.getSource() == saveButton) {
                //NameList ComboBox Update.
                  nameList = dao.getAllNames();
                  txtEmp_name.removeAllItems();
                  for (int i = 0; i < nameList.size(); i++) {
                      String EmployeeName = String.valueOf(nameList.get(i).getTime());
                      txtEmp_name.addItem(EmployeeName+"   "+EmployeeName);}
                  
            String emp_number = txtEmp_number.getText();
            String emp_name = txtEmp_name.getSelectedItem().toString();
            String date = txtDate.getText();
            String time = txtTime.getText();
           
            Schedule component = new Schedule( emp_number, emp_name,date, time);
            attributes = dao.saveSchedule(component);
            
            
             if(attributes!=component){
                JOptionPane.showMessageDialog(null,"Schedule not added","ERROR", JOptionPane.ERROR_MESSAGE);
            }
             else if (attributes.equals(component)){
                JOptionPane.showMessageDialog(null, "Schedule for  "+emp_name+"  saved Successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                txtDate.setText(null);
                txtTime.setText(null);
                txtEmp_number.setText(null);
                txtEmp_name.setSelectedItem(null);
                   
            }
          
           
        }
      //Delete Button
       if(e.getSource() == deleteButton){
        int confirm=JOptionPane.showConfirmDialog(this,"   Delete Schedule?"+"\n"+" Employee number: "+txtUpdate_Delete.getSelectedItem().toString(),"CONFIRM DELETE ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(confirm ==JOptionPane.YES_OPTION){
         dao.deleteSchedule(txtUpdate_Delete.getSelectedItem().toString());
          JOptionPane.showMessageDialog(null,"Schedule for Employee number: "+txtUpdate_Delete.getSelectedItem().toString()+"  Deleted!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
           //ComboBox Update.
            scheduleList = dao.getAllSchedule();
            txtUpdate_Delete.removeAllItems();
            for (int i = 0; i < scheduleList.size(); i++) {
                String EmployeeNumber = String.valueOf(scheduleList.get(i).getEmp_number());
                txtUpdate_Delete.addItem(EmployeeNumber);
                
                 txtUpdate_Delete.setSelectedItem(null);
            }
       }
       // 
        if(confirm ==JOptionPane.NO_OPTION){
        System.out.println("Canceled Delete");
       }
         if(confirm ==JOptionPane.CLOSED_OPTION){
        System.out.println("Canceled Delete");
       }
       }
      //Navigation  buttons
       if(e.getSource() == btnSchedule) {new ScheduleGUI().runSheduleGUI();mainFrame.dispose();}
       if(e.getSource() == btnInventory){}
       if(e.getSource() == btnJailCell){}
       if(e.getSource() == btnCriminal){}
       // Display Save Frame
              if(e.getSource() == Insert){
                  
                  //ComboBox Update.
                  nameList = dao.getAllNames();
                  txtEmp_name.removeAllItems();
                  for (int i = 0; i < nameList.size(); i++) {
                      String EmployeeName = String.valueOf(nameList.get(i).getTime());
                      txtEmp_name.addItem(EmployeeName+"   "+EmployeeName);}
                  
                  saveFrame.pack();
                  saveFrame.setLocationRelativeTo(null);
                  saveFrame.setVisible(true);
              
               }
              
        //Display View frame      
              if(e.getSource() == View){ 
              scheduleList = dao.getAllSchedule();
            tblSchedule.setModel(tableModel);
            tableModel = (DefaultTableModel) tblSchedule.getModel();
            tableModel.setRowCount(0);

            for (int i = 0; i < scheduleList.size(); i++) {
                String number = scheduleList.get(i).getEmp_number();
                String name = scheduleList.get(i).getEmp_name();
                String date = scheduleList.get(i).getDate();
                String time = scheduleList.get(i).getTime();
               
                Object[] scheduleData = {number, name, date, time};
                tableModel.addRow(scheduleData);

                viewFrame.pack();
                viewFrame.setLocationRelativeTo(null);
                viewFrame.setVisible(true);
            }
            originalTable = (Vector) ((DefaultTableModel) tblSchedule.getModel()).getDataVector().clone();

              }
                     
              
        //Display Delete frame      
              if(e.getSource() == Delete){
              
                  //ComboBox Update.
                  scheduleList = dao.getAllSchedule();
                  txtUpdate_Delete.removeAllItems();
                  for (int i = 0; i < scheduleList.size(); i++) {
                      String EmployeeNumber = String.valueOf(scheduleList.get(i).getEmp_number());
                      txtUpdate_Delete.addItem(EmployeeNumber);}
                  
                  deleteFrame.pack();
                  deleteFrame.setLocationRelativeTo(null);
                  deleteFrame.setVisible(true);
              
              }

          // Display update Frame

        if(e.getSource() == Update){
            //ComboBox Update.
                  scheduleList = dao.getAllSchedule();
                  txtUpdate_Delete2.removeAllItems();
                  for (int i = 0; i < scheduleList.size(); i++) {
                      String EmployeeNumber = String.valueOf(scheduleList.get(i).getEmp_number());
                      txtUpdate_Delete2.addItem(EmployeeNumber);}
                  
                  updateFrame.pack();
                  updateFrame.setLocationRelativeTo(null);
                  updateFrame.setVisible(true);
                   txtUpdate_Delete2.setSelectedItem(null);
                  
        } else if (e.getSource() == txtUpdate_Delete2){
            int cmbUpdate = txtUpdate_Delete2.getSelectedIndex();
            if (cmbUpdate != -1) {
                txtEmp_name2.setText(scheduleList.get(cmbUpdate).getEmp_name());
                txtDate2.setText(scheduleList.get(cmbUpdate).getDate());
                txtTime2.setText(scheduleList.get(cmbUpdate).getTime());
                
            }}
        // update button
        else if (e.getSource() == updateButton){
            String number=txtUpdate_Delete2.getSelectedItem().toString();
            String name = txtEmp_name2.getText();
            String date = txtDate2.getText();
            String time = txtTime2.getText();
            

            Schedule component2 = new Schedule(number,name, date, time);
            attributes = dao.updateSchedule(component2);
            JOptionPane.showMessageDialog(null, "Schedule Updated Successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            
             //ComboBox Update.
                  scheduleList = dao.getAllSchedule();
                  txtUpdate_Delete2.removeAllItems();
                  for (int i = 0; i < scheduleList.size(); i++) {
                      String EmployeeNumber = String.valueOf(scheduleList.get(i).getEmp_number());
                      txtUpdate_Delete2.addItem(EmployeeNumber);}
                  
         
            
        }
    }

          
      
      
       public void searchScheduleTable(String search) {

        tableModel = (DefaultTableModel) tblSchedule.getModel();
        tableModel.setRowCount(0);
        for (Object rows : originalTable) {
            Vector rowVector = (Vector) rows;
            for (Object column : rowVector) {
                if (column.toString().toUpperCase().contains(search.toUpperCase())) {
                    tableModel.addRow(rowVector);
                    break;
                }
            }
        }
    }
    
   
    
public static void main(String[] args) throws SQLException  {
        new CreateScheduleGUI().runSheduleGUI2();
    }
    
    
}
