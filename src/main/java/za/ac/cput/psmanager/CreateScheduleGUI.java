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


public class CreateScheduleGUI extends JFrame implements ActionListener{
    private JFrame mainFrame;
    private JPanel panelNorth, panelWest,panelCenter,panelheading,panelbutton,panelmiddle1,panelmiddle2,panelmiddle3,panelmiddle4;
    
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
    private JLabel Heading;
    private JLabel Date;
    private JTextField txtDate;
   private JLabel Time;
   private JTextField txtTime;
   private JLabel Emp_number;
  private JTextField txtEmp_number;
  private JLabel Emp_name;
  private JTextField txtEmp_name;
  
  private JButton Insert,Update,Delete,View;
  
  ScheduleDAO dao;
  Schedule attributes;
   
   

    
    

    public CreateScheduleGUI(){
        dao= new ScheduleDAO();
       Heading= new JLabel( "Create Schedule",SwingConstants.CENTER);
       Date=new JLabel("Date:");
       txtDate=new JTextField(10);
       txtDate.setText("eg: 8 june 2021");
       Time=new JLabel("Time:");
       txtTime=new JTextField(10); 
       txtTime.setText("eg: 08:30:10");

       Emp_number=new JLabel("Employee Number:");
       txtEmp_number=new JTextField(10);
       txtEmp_number.setText("eg: 111111");
       Emp_name=new JLabel("Employee name:");
       txtEmp_name=new JTextField(10);
       txtEmp_name.setText("eg: Divine Lemba");
       
         Insert = new JButton("Insert");
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
        
        panelmiddle1=new JPanel();panelmiddle2=new JPanel();panelmiddle3=new JPanel();panelmiddle4=new JPanel();
        panelbutton=new JPanel();
        panelheading=new JPanel();
        
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
        
        
    }
    
    public void runSheduleGUI(){
        
        panelNorth.setLayout(new GridLayout(1,2));
        panelWest.setLayout(new GridLayout(10, 1));
        panelCenter.setLayout(new GridLayout(10, 1));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 8, 30));
   
        
        
        mainFrame.add(panelNorth, BorderLayout.NORTH);
        mainFrame.add(panelWest, BorderLayout.WEST);
        mainFrame.add(panelCenter, BorderLayout.CENTER);
        
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
        
        
        panelheading.add(Heading);
        panelheading.setLayout( new GridLayout(1,1));
        panelbutton.add (Insert);  panelbutton.add (Update); panelbutton.add (Delete);panelbutton.add (View);
        panelbutton.setLayout(new GridLayout(1,4));
        panelmiddle1.setLayout(new GridLayout(2,2));
        panelmiddle2.setLayout(new GridLayout(2,2));
        panelmiddle3.setLayout(new GridLayout(2,2));
        panelmiddle4.setLayout(new GridLayout(2,2));



        panelmiddle1.add(Date);panelmiddle1.add(txtDate);
        panelmiddle2.add(Time);panelmiddle2.add(txtTime);
        panelmiddle3.add(Emp_number);panelmiddle3.add(txtEmp_number);
        panelmiddle4.add(Emp_name);panelmiddle4.add(txtEmp_name);
        
        
        panelCenter.add(panelheading);
        
        panelCenter.add(panelmiddle1);
        panelCenter.add(panelmiddle2);
        panelCenter.add(panelmiddle3); 
        panelCenter.add(panelmiddle4);
       
        panelCenter.add(panelbutton);
       

        
        
      
        




        
        mainFrame.addWindowListener(new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    });
        
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    
        
        Insert.addActionListener(this);
        Update.addActionListener(this);
        Delete.addActionListener(this);
        View.addActionListener(this);
       

    
        
    
        
    }
      @Override
      public void actionPerformed(ActionEvent e)
      {if (e.getSource() == Insert) {
            String date = txtDate.getText();
            String time = txtTime.getText();
            String emp_number = txtEmp_number.getText();
            String emp_name = txtEmp_name.getText();
           
            Schedule component = new Schedule(date, time, emp_number, emp_name);
          try {
              attributes = dao.save(component);
          } catch (SQLException ex) {
              Logger.getLogger(CreateScheduleGUI.class.getName()).log(Level.SEVERE, null, ex);
          }
            
            if (attributes.equals(component)){
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
            }else{
                JOptionPane.showMessageDialog(null,"Data not added");
            }
        }
       
      }
    
   
    
public static void main(String[] args) {
        new CreateScheduleGUI().runSheduleGUI();
    }
    
    
}
