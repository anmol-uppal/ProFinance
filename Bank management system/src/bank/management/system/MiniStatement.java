
package bank.management.system;

import javax.swing.*;//for jframe
import java.awt.*;//for color class
import java.sql.*;//for resultset

public class MiniStatement extends JFrame{
    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        
         //setting layout as null bcz bydefault it will set eerything at the centre
        setLayout(null);
        
        JLabel mini=new JLabel();
        add(mini);
        
        JLabel bank=new JLabel("INDIAN NATIONAL BANK");
        bank.setFont(new Font("Raleway",Font.BOLD,18));
        bank.setBounds(80,20,300,20);
        add(bank);
        
        JLabel card=new JLabel();
       card.setFont(new Font("Raleway",Font.BOLD,16));
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
       add(balance); 
        
        try{
            //establishing connection with the db
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from login where pinnumber='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        
    }
        //for displaying all the transactions
        try{
            Conn conn=new Conn();
            int bal=0;
            ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"  + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                        bal += Integer.parseInt(rs.getString("amount"));
                    } else {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your current account balance is Rs " +bal);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
        mini.setBounds(20,140,400,200);
        
        setTitle("Mini-Statement");
        setSize(400,600);
        setLocation(20,20);
        
        //for coloring the frame
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String[] args){
       new MiniStatement(""); 
    }
    
}
