
package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener{
    
    public Home(){
        
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/icon4.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1600,800);
        add(image);
        
        JLabel heading= new JLabel("SanaLines Welcomes you.");
        heading.setBounds(550, 50, 800, 100);
        heading.setForeground(Color.red);
        heading.setFont(new Font("Tahoma",Font.BOLD,36));
        image.add(heading);
        
        JMenuBar menubar=new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details=new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails=new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails=new JMenuItem("Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);

        JMenuItem bookFlight=new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);

        JMenuItem journeyDetails=new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem cancelFlight=new JMenuItem("Cancel Flight");
        cancelFlight.addActionListener(this);
        details.add(cancelFlight);
        
        JMenu ticket=new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingPass=new JMenuItem("Boarding Pass");
        ticket.add(boardingPass);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String text=ae.getActionCommand();
        
        if(text.equals("Customer Details")){
            new AddCustomer();
        }
        else if(text.equals("Flight Details")){
            new FlightInfo();
        }
        else if(text.equals("Book Flight")){
            new BookFlight();
        }
        else if(text.equals("Journey Details")){
            new JourneyDetails();
        }
        else if(text.equals("Cancel Flight")){
            new CancelTicket();
        }
        
    }
    
    public static void main(String[] args){
        new Home();
    }
}
