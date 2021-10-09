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
import java.util.ArrayList;
import javax.swing.*;


public class ScheduleGUI extends JFrame implements ActionListener{
    private JFrame mainFrame;
    private JPanel panelNorth, panelWest,panelCenter;
    
    private JLabel lblPicture;
    
    private JLabel lblCompanyName;
    
    private JButton btnInventory;
    private JButton btnPersonnel;
    private JButton btnSchedule;
    private JButton btnCriminal;
    private JButton btnJailCell;
    
    private JPanel  panelBlank1,panelBlank2,panelBlank3,panelBlank4,panelBlank5;
    
    
    private Font font1;
    private Font font2;
    
    Insets btnInsets = new Insets(5,5,5,5);
    
     private JLabel lbltitle;
     public JButton btnCreate;
     public JButton btnView;
     public JButton btnHelp;
    
     private JLabel lblempty;
 
  
    public ScheduleGUI(){
       // components of panel center
       
        lblempty=new JLabel();
        lbltitle= new JLabel( "SCHEDULE MANAGER",SwingConstants.CENTER);
        lbltitle.setFont(font2);
        
         btnCreate = new JButton("Create+");
         btnCreate.setBackground(Color.blue);
         btnCreate.setForeground(Color.white);
         btnCreate.setActionCommand("create");
         
        btnView= new JButton("View Schedule");
        btnView.setBackground(Color.blue);
        btnView.setForeground(Color.white);
        
        btnHelp = new JButton("Help");
        btnHelp.setBackground(Color.blue);
        btnHelp.setForeground(Color.white);
        
        //components of panel North and West
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
        font2 = new Font("Impact", Font.BOLD,45);

        
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
        panelCenter.setLayout(new GridLayout(8, 6));
   
        
        
        mainFrame.add(panelNorth, BorderLayout.NORTH);
        mainFrame.add(panelWest, BorderLayout.WEST);
        mainFrame.add(panelCenter, BorderLayout.CENTER);
        //panel north
        panelNorth.add(lblPicture);
        panelNorth.add(lblCompanyName);
        //panel west
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
        //panel center
        panelCenter.add(lbltitle);
        panelCenter.add(lblempty);
        panelCenter.add(btnCreate);
        
        panelCenter.add(btnView);
        panelCenter.add(btnHelp);
        
      
       
        mainFrame.addWindowListener(new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    });
        
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    
        
        btnCreate.addActionListener(new ActionListener(){
    
        
      @Override
      public void actionPerformed(ActionEvent e)
      {try{
          if(e.getSource()==btnCreate){
              
            new CreateScheduleGUI().runSheduleGUI2();
            mainFrame. dispose();
          
          
          
          }
      }
          catch(Exception ex){
                  ex.printStackTrace();}
          }
    });
       
      }
    
   
    
public static void main(String[] args) {
       new ScheduleGUI().runSheduleGUI();
       

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}