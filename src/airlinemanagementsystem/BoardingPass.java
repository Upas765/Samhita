package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BoardingPass extends JFrame implements ActionListener{
    JLabel tfname,fname,fcode,tfaadhar,source,destination,dcdate,tfnationality;
    JTextField tfpnr;
    JButton fetchButton;
    
    public BoardingPass(){
        getContentPane().setBackground(Color.black);
        setLayout(null);
        
        JLabel heading=new JLabel("Sana Lines Travels");
        heading.setBounds(350, 15, 500, 35);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        heading.setForeground(Color.white);
        add(heading);
        
        JLabel heading1=new JLabel("Wishing you a safe and happy journey.");
        heading1.setBounds(360, 55, 800, 35);
        heading1.setFont(new Font("Tahoma",Font.PLAIN,16));
        heading1.setForeground(Color.white);
        add(heading1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/bplogo.jpg"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lbimage=new JLabel(image);
        lbimage.setBounds(550,40,400,400);
        add(lbimage);
        
        JLabel lbpnr=new JLabel("PNR Number");
        lbpnr.setBounds(40, 100, 150, 25);
        lbpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbpnr.setForeground(Color.white);
        add(lbpnr);
        
        tfpnr=new JTextField();
        tfpnr.setBounds(200, 100, 150, 25);
        add(tfpnr);
        
        fetchButton=new JButton("Enter");
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.MAGENTA);
        fetchButton.setBounds(360,100, 150, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(40, 140, 150, 25);
        lbname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbname.setForeground(Color.white);
        add(lbname);
        
        tfname=new JLabel();
        tfname.setBounds(220,140,150,25);
        tfname.setForeground(Color.magenta);
        add(tfname);
        
        JLabel lbaadhar=new JLabel("Aadhar number");
        lbaadhar.setBounds(40, 180, 150, 25);
        lbaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbaadhar.setForeground(Color.white);
        add(lbaadhar);
        
        tfaadhar=new JLabel();
        tfaadhar.setBounds(220,180,150,25);
        tfaadhar.setForeground(Color.magenta);
        add(tfaadhar);
        
        JLabel lbnationality=new JLabel("Nationality");
        lbnationality.setBounds(40, 220, 150, 25);
        lbnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbnationality.setForeground(Color.white);
        add(lbnationality);
        
        tfnationality=new JLabel();
        tfnationality.setBounds(220,220,150,25);
        tfnationality.setForeground(Color.magenta);
        add(tfnationality);
        
        JLabel lbfname=new JLabel("Flight Name");
        lbfname.setBounds(40, 260, 150, 25);
        lbfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbfname.setForeground(Color.white);
        add(lbfname);
        
        fname=new JLabel();
        fname.setBounds(220,260,150,25);
        fname.setForeground(Color.magenta);
        add(fname);
        
        
        JLabel lbfcode=new JLabel("Flight code");
        lbfcode.setBounds(40, 300, 150, 25);
        lbfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbfcode.setForeground(Color.white);
        add(lbfcode);
        
        fcode=new JLabel();
        fcode.setBounds(220,300,150,25);
        fcode.setForeground(Color.magenta);
        add(fcode);
        
        JLabel lbdate=new JLabel("Date");
        lbdate.setBounds(40, 340, 150, 25);
        lbdate.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbdate.setForeground(Color.white);
        add(lbdate);
        
        dcdate=new JLabel();
        dcdate.setBounds(220,340,150,25);
        dcdate.setForeground(Color.magenta);
        add(dcdate);
        
        JLabel lbsource=new JLabel("Source");
        lbsource.setBounds(40, 380, 150, 25);
        lbsource.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbsource.setForeground(Color.white);
        add(lbsource);
        
        source=new JLabel();
        source.setBounds(220, 380, 150, 25);
        source.setForeground(Color.magenta);
        add(source);
        
        JLabel lbdest=new JLabel("Destination");
        lbdest.setBounds(40, 420, 150, 25);
        lbdest.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbdest.setForeground(Color.white);
        add(lbdest);
        
        destination=new JLabel();
        destination.setBounds(220, 420, 150, 25);
        destination.setForeground(Color.magenta);
        add(destination);
      
        setSize(1000,500);
        setLocation(300,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String pnr=tfpnr.getText();
        
        try{
            Conn con=new Conn();
            
            String query="select * from reservation where PNR='PNR-"+pnr+"'";
            
            ResultSet rs=con.s.executeQuery(query);
            
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                dcdate.setText(rs.getString("flightdate"));
                source.setText(rs.getString("source"));
                destination.setText(rs.getString("destination"));
                fname.setText(rs.getString("flightname"));
                fcode.setText(rs.getString("flightcode"));
                tfaadhar.setText(rs.getString("aadhar"));
                tfnationality.setText(rs.getString("nationality"));
                
            }else{
                JOptionPane.showMessageDialog(null, "Reservation Doesn't Exist.");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new BoardingPass();
    }
}