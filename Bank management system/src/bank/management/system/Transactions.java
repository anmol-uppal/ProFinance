
package bank.management.system;

import javax.swing.*;//for JFrame
import java.awt.*;//for Color class
import java.awt.event.*;//for Actionlistener interface



public class Transactions extends JFrame implements ActionListener{
     JButton deposit,withdraw,fastCash,miniStatement,pinChange,balanceEnquiry,exit;
     String pinnumber;
    //constructor for the class
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        
         //setting layout as null bcz bydefault it will set eerything at the centre
        setLayout(null);
        
        //setting up the image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900 , Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        //for adding text
        JLabel text=new JLabel("PLEASE SELECT THE TRANSACTION");
        text.setBounds(190,280,700,36);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,17));
        image.add(text);//the text would initially be added on the frame below the image. so text should be added with the help of image obj on the image
        
        //buttons for action
        deposit=new JButton("DEPOSIT");
        deposit.setBounds(170,415,150,30);
        deposit.setFont(new Font("Raleway",Font.BOLD,12));
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdraw=new JButton("WITHDRAW");
        withdraw.setBounds(355,415,150,30);
        withdraw.setFont(new Font("Raleway",Font.BOLD,12));
         withdraw.addActionListener(this);
        image.add(withdraw);     
        
        fastCash=new JButton("FASTCASH");
        fastCash.setBounds(170,450,150,30);
        fastCash.setFont(new Font("Raleway",Font.BOLD,12));
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement=new JButton("MINI-STATEMENT");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.setFont(new Font("Raleway",Font.BOLD,12));
         miniStatement.addActionListener(this);
        image.add(miniStatement); 
        
        
        pinChange=new JButton("PIN-CHANGE");
        pinChange.setBounds(170,485,150,30);
        pinChange.setFont(new Font("Raleway",Font.BOLD,12));
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry=new JButton("BALANCE ENQUIRY");
        balanceEnquiry.setBounds(355,485,150,30);
        balanceEnquiry.setFont(new Font("Raleway",Font.BOLD,12));
         balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry); 
        
        exit=new JButton("EXIT");
        exit.setBounds(355,520,150,30);
        exit.setFont(new Font("Raleway",Font.BOLD,12));
         exit.addActionListener(this);
        image.add(exit); 

        
        //for coloring the frame
        getContentPane().setBackground(Color.WHITE);

        //setting up the frame
        setSize(900, 900);//length and breadth
        setLocation(350, 5);//changing by default origin position to desired one 350 from left and 10 from top
        setUndecorated(true);

        setVisible(true);//for the visibilty of the frame
    
    }
    
    public void actionPerformed(ActionEvent ae){
        //action on exit button
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if (ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastCash){
             setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinChange){
             setVisible(false);
            new PinChange(pinnumber).setVisible(true);
            
        }
        else if (ae.getSource()==balanceEnquiry){
             setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if (ae.getSource()==miniStatement){
            
            new MiniStatement(pinnumber).setVisible(true);
        }
    
    }
    
    
    public static void main(String[] args){
        //anonymous obj of the class
        new Transactions("");
        
    }
    
}
