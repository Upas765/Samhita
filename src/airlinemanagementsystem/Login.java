/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JButton reset,submit,close;
    JTextField tfusername;
    JPasswordField tpassword;
    
    public Login(){
        getContentPane().setBackground(Color.blue);
        setLayout(null);
        
        JLabel lbusername=new JLabel("User Name");
        lbusername.setBounds(20,20,100,10);
        add(lbusername);
        
        tfusername= new JTextField();
        tfusername.setBounds(130,20,150,10);
        add(tfusername);
        
        JLabel lbpassword=new JLabel("Password");
        lbpassword.setBounds(20,40,100,10);
        add(lbpassword);
        
        tpassword= new JPasswordField();
        tpassword.setBounds(130,40,150,10);
        add(tpassword);
        
        reset=new JButton("Reset");
        reset.setBounds(30, 60, 100, 20);
        reset.addActionListener(this);
        add(reset);
        submit=new JButton("Submit");
        submit.setBounds(150, 60, 100, 20);
        submit.addActionListener(this);
        add(submit);
        close=new JButton("Close");
        close.setBounds(100, 100, 90, 20);
        close.addActionListener(this);
        add(close);
        
        setSize(400,250);
        setLocation(600,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            String username=tfusername.getText();
            String password=tpassword.getText();
            
            try{
                Conn c= new Conn();
                
                String query="select * from login where username= '"+username+"'and password='"+password+"'";
                ResultSet rs=c.s.executeQuery(query);
                
                if(rs.next()){
                    new Home();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()== close){
            setVisible(false);
        }else if(ae.getSource()== reset){
            tfusername.setText("");
            tpassword.setText("");
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
