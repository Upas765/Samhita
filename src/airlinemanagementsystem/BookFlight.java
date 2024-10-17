
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
    JLabel tfname,tfnationality,tfaddress,labelgender,fname,fcode;
    JTextField tfaadhar;
    JButton bookflight,fetchButton,flight;
    Choice source,destination;
    JDateChooser dcdate;
    
    public BookFlight(){
        getContentPane().setBackground(Color.green);
        setLayout(null);
        
        JLabel heading=new JLabel("Book Flight");
        heading.setBounds(240, 40, 500, 40);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        heading.setForeground(Color.red);
        add(heading);
        
        JLabel lbaadhar=new JLabel("Aadhar Number");
        lbaadhar.setBounds(60, 120, 150, 25);
        lbaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(220, 120, 150, 25);
        add(tfaadhar);
        
        fetchButton=new JButton("Fetch user");
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.MAGENTA);
        fetchButton.setBounds(380, 120, 100, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(60, 170, 150, 25);
        lbname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbname);
        
        tfname=new JLabel();
        tfname.setBounds(220,170,150,25);
        add(tfname);
        
        JLabel lbnationality=new JLabel("Nationality");
        lbnationality.setBounds(60, 220, 150, 25);
        lbnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbnationality);
        
        tfnationality=new JLabel();
        tfnationality.setBounds(220,220,150,25);
        add(tfnationality);
        
        JLabel lbaddress=new JLabel("Address");
        lbaddress.setBounds(60, 270, 150, 25);
        lbaddress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbaddress);
        
        tfaddress=new JLabel();
        tfaddress.setBounds(220,270,150,25);
        add(tfaddress);
        
        JLabel lbgender=new JLabel("Gender");
        lbgender.setBounds(60, 320, 150, 25);
        lbgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbgender);
        
        labelgender=new JLabel();
        labelgender.setBounds(220, 320, 150, 25);
        //labelgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelgender);
        
        JLabel lbsource=new JLabel("Source");
        lbsource.setBounds(60, 370, 150, 25);
        lbsource.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbsource);
        
        source=new Choice();
        source.setBounds(220, 370, 150, 25);
        add(source);
        
        JLabel lbdest=new JLabel("Destination");
        lbdest.setBounds(60, 420, 150, 25);
        lbdest.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbdest);
        
        destination=new Choice();
        destination.setBounds(220, 420, 150, 25);
        add(destination);
        
        try{
            Conn con=new Conn();
            String query="Select * from flight";
            ResultSet rs=con.s.executeQuery(query);
            
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        flight=new JButton("Check flight");
        flight.setBackground(Color.black);
        flight.setForeground(Color.white);
        flight.setBounds(140,450,150,40);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lbfname=new JLabel("Flight Name");
        lbfname.setBounds(60, 520, 150, 25);
        lbfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbfname);
        
        fname=new JLabel();
        fname.setBounds(220,520,150,25);
        add(fname);
        
        JLabel lbfcode=new JLabel("Flight code");
        lbfcode.setBounds(60, 570, 150, 25);
        lbfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbfcode);
        
        fcode=new JLabel();
        fcode.setBounds(220,570,150,25);
        add(fcode);
        
        JLabel lbdate=new JLabel("Date");
        lbdate.setBounds(60, 620, 150, 25);
        lbdate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbdate);
        
        dcdate=new JDateChooser();
        dcdate.setBounds(220,620,150,25);
        add(dcdate);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/icon.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000, 800, Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lbimage=new JLabel(image);
        lbimage.setBounds(500,0,1100,800);
        add(lbimage);
        
        bookflight=new JButton("Book flight");
        bookflight.setBackground(Color.black);
        bookflight.setForeground(Color.white);
        bookflight.setBounds(140,700,150,40);
        bookflight.addActionListener(this);
        add(bookflight);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetchButton){
        String aadhar=tfaadhar.getText();
        
        try{
            Conn con=new Conn();
            
            String query="select * from passenger where aadhar='"+aadhar+"'";
            ResultSet rs= con.s.executeQuery(query);
            
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfaddress.setText(rs.getString("address"));
                labelgender.setText(rs.getString("gender"));
            }else{
                JOptionPane.showMessageDialog(null, "User Doesn't exist.");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        
        else if(ae.getSource()==flight){
        String src=source.getSelectedItem();
        String dest=destination.getSelectedItem();
        
        try{
            Conn con=new Conn();
            
            String query="select * from flight where source='"+src+"'and destination='"+dest+"'";
            ResultSet rs= con.s.executeQuery(query);
            
            if(rs.next()){
                fname.setText(rs.getString("f_name"));
                fcode.setText(rs.getString("f_code"));
            }else{
                JOptionPane.showMessageDialog(null, "No flight found.");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        
        else{
            Random random=new Random();
            
            String name= tfname.getText();
            String nationality=tfnationality.getText();
            String flightname=fname.getText();
            String flightcode=fcode.getText();
            String aadhar= tfaadhar.getText();
            
            String src= source.getSelectedItem();
            String dest=destination.getSelectedItem();
            String fdate= ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            
            try{
            Conn con=new Conn();
            
            String query="insert into reservation values('PNR-"+random.nextInt(100000)+"','TIC-"+random.nextInt(10000)+"','"+aadhar+"','"+name+"','"+nationality+"','"+flightname+"','"+flightcode+"','"+src+"','"+dest+"','"+fdate+"')";
            con.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Ticket booked successfully.");
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
            
        }
    }
    
    public static void main(String[] args){
        new BookFlight();
    }    
}