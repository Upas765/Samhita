
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    JTextField tfname,tfnationality,tfaadhar,tfaddress,tfphone;
    JRadioButton rbmale,rbfemale;
    
    public AddCustomer(){
        getContentPane().setBackground(Color.green);
        setLayout(null);
        
        JLabel heading=new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(240, 40, 500, 40);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        heading.setForeground(Color.red);
        add(heading);
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(60, 120, 150, 25);
        lbname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbname);
        
        tfname=new JTextField();
        tfname.setBounds(220,120,150,25);
        add(tfname);
        
        JLabel lbnationality=new JLabel("Nationality");
        lbnationality.setBounds(60, 170, 150, 25);
        lbnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbnationality);
        
        tfnationality=new JTextField();
        tfnationality.setBounds(220,170,150,25);
        add(tfnationality);
        
        JLabel lbaadhar=new JLabel("Aadhar Number");
        lbaadhar.setBounds(60, 220, 150, 25);
        lbaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(220,220,150,25);
        add(tfaadhar);
        
        JLabel lbaddress=new JLabel("Address");
        lbaddress.setBounds(60, 270, 150, 25);
        lbaddress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbaddress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(220,270,150,25);
        add(tfaddress);
        
        JLabel lbgender=new JLabel("Gender");
        lbgender.setBounds(60, 320, 150, 25);
        lbgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbgender);
        
        ButtonGroup genderGroup=new ButtonGroup();
        
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(220,320,70,25);
        rbmale.setBackground(Color.green);
        add(rbmale);
        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(300,320,70,25);
        rbfemale.setBackground(Color.green);
        add(rbfemale);
        
        genderGroup.add(rbmale);
        genderGroup.add(rbfemale);
        
        JLabel lbphone=new JLabel("Phone Number");
        lbphone.setBounds(60, 370, 150, 25);
        lbphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(220,370,150,25);
        add(tfphone);
        
        JButton save=new JButton("Save");
        save.setBackground(Color.black);
        save.setForeground(Color.white);
        save.setBounds(140,450,100,40);
        save.addActionListener(this);
        add(save);
        
        ImageIcon Image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/icon3.jpg"));
        JLabel lbimage=new JLabel(Image);
        lbimage.setBounds(380,100,450,390);
        add(lbimage);
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String name=tfname.getText();
        String nationality=tfnationality.getText();
        String phone=tfphone.getText();
        String address=tfaddress.getText();
        String aadhar=tfaadhar.getText();
        String gender=null;
        if(rbmale.isSelected()){
            gender="Male";
        }
        else{
            gender="Female";
        }
        
        try{
            Conn con=new Conn();
            
            String query="insert into passenger values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+aadhar+"','"+gender+"')";
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Added Successfully!");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }    
}
