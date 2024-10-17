package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class CancelTicket extends JFrame implements ActionListener{
    JLabel tfname,fname,fcode,cancelno,source,destination,dcdate;
    JTextField tfpnr;
    JButton fetchButton,flight;
    
    public CancelTicket(){
        getContentPane().setBackground(Color.green);
        setLayout(null);
        
        Random r=new Random();
        
        JLabel heading=new JLabel("Cancel Flight");
        heading.setBounds(200, 15, 500, 35);
        heading.setFont(new Font("Tahoma",Font.BOLD,26));
        heading.setForeground(Color.red);
        add(heading);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/images.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lbimage=new JLabel(image);
        lbimage.setBounds(400,40,400,400);
        add(lbimage);
        
        JLabel lbpnr=new JLabel("PNR Number");
        lbpnr.setBounds(40, 60, 150, 25);
        lbpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbpnr);
        
        tfpnr=new JTextField();
        tfpnr.setBounds(200, 60, 150, 25);
        add(tfpnr);
        
        fetchButton=new JButton("Show details");
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.MAGENTA);
        fetchButton.setBounds(100,100, 150, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(40, 140, 150, 25);
        lbname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbname);
        
        tfname=new JLabel();
        tfname.setBounds(220,140,150,25);
        add(tfname);
        
        JLabel lbcancelno=new JLabel("Cancellation Number");
        lbcancelno.setBounds(40, 180, 150, 25);
        lbcancelno.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbcancelno);
        
        cancelno=new JLabel(""+r.nextInt(1000000));
        cancelno.setBounds(220,180,150,25);
        add(cancelno);
  
        JLabel lbfname=new JLabel("Flight Name");
        lbfname.setBounds(40, 220, 150, 25);
        lbfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbfname);
        
        fname=new JLabel();
        fname.setBounds(220,220,150,25);
        add(fname);
        
        
        JLabel lbfcode=new JLabel("Flight code");
        lbfcode.setBounds(40, 260, 150, 25);
        lbfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbfcode);
        
        fcode=new JLabel();
        fcode.setBounds(220,260,150,25);
        add(fcode);
        
        JLabel lbdate=new JLabel("Date");
        lbdate.setBounds(40, 300, 150, 25);
        lbdate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbdate);
        
        dcdate=new JLabel();
        dcdate.setBounds(220,300,150,25);
        add(dcdate);
        
        JLabel lbsource=new JLabel("Source");
        lbsource.setBounds(40, 340, 150, 25);
        lbsource.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbsource);
        
        source=new JLabel();
        source.setBounds(220, 340, 150, 25);
        add(source);
        
        JLabel lbdest=new JLabel("Destination");
        lbdest.setBounds(40, 380, 150, 25);
        lbdest.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbdest);
        
        destination=new JLabel();
        destination.setBounds(220, 380, 150, 25);
        add(destination);
        
        flight=new JButton("Cancel");
        flight.setBackground(Color.black);
        flight.setForeground(Color.white);
        flight.setBounds(120,430,150,40);
        flight.addActionListener(this);
        add(flight);
        
        setSize(800,550);
        setLocation(450,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetchButton){
        String pnr=tfpnr.getText();
        
        try{
            Conn con=new Conn();
            
            String query="select * from reservation where PNR='PNR-"+pnr+"'";
            ResultSet rs= con.s.executeQuery(query);
            
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                dcdate.setText(rs.getString("flightdate"));
                source.setText(rs.getString("source"));
                destination.setText(rs.getString("destination"));
                fname.setText(rs.getString("flightname"));
                fcode.setText(rs.getString("flightcode"));
            }else{
                JOptionPane.showMessageDialog(null, "Reservation Doesn't Exist.");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        
        else if(ae.getSource()==flight){
        String name=tfname.getText();
        String pnr=tfpnr.getText();
        String cancel=cancelno.getText();
        String code=fcode.getText();
        String date=dcdate.getText();
        
        try{
            Conn con=new Conn();
            
            String query="insert into cancel values('"+pnr+"','"+name+"','"+cancel+"','"+code+"','"+date+"')";
            con.s.executeUpdate(query);
            
            con.s.executeUpdate("delete from reservation where PNR='PNR-"+pnr+"'");
            
            JOptionPane.showMessageDialog(null, "Ticket canceled");
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    }
    
    public static void main(String[] args){
        new CancelTicket();
    }    
}