package airlinemanagementsystem;

import java.awt.Color;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.awt.*;

public class JourneyDetails  extends JFrame implements ActionListener{
    JTable table;
    JTextField tfpnr;
    JButton show;
    
    public JourneyDetails(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lbpnr=new JLabel("PNR Details");
        lbpnr.setFont(new Font("Tahoma",Font.BOLD,16));
        lbpnr.setBounds(50, 50, 100, 25);
        add(lbpnr);
        
        tfpnr=new JTextField();
        tfpnr.setBounds(200,50,150,25);
        add(tfpnr);
        
        show=new JButton("Show Details");
        show.setBackground(Color.blue);
        show.setForeground(Color.black);
        show.setBounds(400,50,150,25);
        show.addActionListener(this);
        add(show);
        
        table=new JTable();
        
        JScrollPane jsp=new JScrollPane(table);        
        jsp.setBounds(0, 100, 800, 150);
        jsp.setBackground(Color.black);
        add(jsp);
    
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
}
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn con=new Conn();
            
            ResultSet rs=con.s.executeQuery("Select * from reservation where PNR='"+tfpnr.getText()+"'");
            
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null,"No information found");
                return;
            }
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        new JourneyDetails();
    }
    
}