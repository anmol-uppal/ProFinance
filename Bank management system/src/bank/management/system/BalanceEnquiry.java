package bank.management.system;

import javax.swing.*;//for jframe
import java.awt.event.*;//for actionlistener interface
import java.awt.*;//for image class
import java.sql.*;//for resultset

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;

        //setting layout as null bcz bydefault it will set eerything at the centre
        setLayout(null);

        //setting up the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.setFont(new Font("Raleway", Font.BOLD, 12));
        back.addActionListener(this);
        image.add(back);

//connection has been made inside the constructor bcz we want to get the balance on the frame on not after button clicking operation
        Conn c = new Conn();
        int balance = 0;//balance available outside try catch block
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin='" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //for adding text
        JLabel text = new JLabel("Your Current Account Balance Is Rs :" +balance);
        text.setBounds(150, 300, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 18));
        image.add(text);


        //for coloring the frame
        getContentPane().setBackground(Color.WHITE);

        //setting up the frame
        setSize(900, 900);//length and breadth
        setLocation(350, 5);//changing by default origin position to desired one 350 from left and 10 from top
        setUndecorated(true);

        setVisible(true);//for the visibilty of the frame

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

}
