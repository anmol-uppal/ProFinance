package bank.management.system;

import javax.swing.*;//for JFrame
import java.awt.*;//for Color class
import java.awt.event.*;//for Actionlistener interface
import java.sql.*;//for resultset
import java.util.Date;//for date class

public class FastCash extends JFrame implements ActionListener {

    JButton oneHundred, fiveHundred, oneThousand, twoThousand, fiveThousand, tenThousand, back;
    String pinnumber;

    //constructor for the class
    FastCash(String pinnumber) {
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

        //for adding text
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(190, 280, 700, 36);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 17));
        image.add(text);//the text would initially be added on the frame below the image. so text should be added with the help of image obj on the image

        //buttons for action
        oneHundred = new JButton("Rs 100");
        oneHundred.setBounds(170, 415, 150, 30);
        oneHundred.setFont(new Font("Raleway", Font.BOLD, 12));
        oneHundred.addActionListener(this);
        image.add(oneHundred);

        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBounds(355, 415, 150, 30);
        fiveHundred.setFont(new Font("Raleway", Font.BOLD, 12));
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);

        oneThousand = new JButton("Rs 1000");
        oneThousand.setBounds(170, 450, 150, 30);
        oneThousand.setFont(new Font("Raleway", Font.BOLD, 12));
        oneThousand.addActionListener(this);
        image.add(oneThousand);

        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(355, 450, 150, 30);
        twoThousand.setFont(new Font("Raleway", Font.BOLD, 12));
        twoThousand.addActionListener(this);
        image.add(twoThousand);

        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBounds(170, 485, 150, 30);
        fiveThousand.setFont(new Font("Raleway", Font.BOLD, 12));
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        tenThousand = new JButton("Rs 10000");
        tenThousand.setBounds(355, 485, 150, 30);
        tenThousand.setFont(new Font("Raleway", Font.BOLD, 12));
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.setFont(new Font("Raleway", Font.BOLD, 12));
        back.addActionListener(this);
        image.add(back);

        //for coloring the frame
        getContentPane().setBackground(Color.WHITE);

        //setting up the frame
        setSize(900, 900);//length and breadth
        setLocation(350, 5);//changing by default origin position to desired one 350 from left and 10 from top
        setUndecorated(true);

        setVisible(true);//for the visibilty of the frame

    }

    public void actionPerformed(ActionEvent ae) {
        //action on exit button
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);//->when back is clicked transactions frame will open again
        } //dynamically handling other buttons
        else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);//->ae returns obj should be typecasted to JButton

            //establishing connection
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin='" + pinnumber + "'");
                int balance = 0;//initially balance is 0
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }

                }
                //if balance is less than entered withdrawn amount
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;//further transaction would not be allowed
                }
                Date date = new Date();
                String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawl','" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

    public static void main(String[] args) {
        //anonymous obj of the class
        new FastCash("");

    }

}
