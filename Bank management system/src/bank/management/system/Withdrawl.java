package bank.management.system;

import java.awt.Color;
import javax.swing.*;//for JFrame
import java.awt.*;//for image class
import java.awt.event.*;//for actionListener interface
import java.util.*;//for Date class

public class Withdrawl extends JFrame implements ActionListener {

    JButton withdraw, back;
    JTextField amount;
    String pinnumber;

    //construcor of the class
    Withdrawl(String pinnumber) {
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
        JLabel text = new JLabel("Enter the amount you want to withdraw :");
        text.setBounds(166, 300, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 18));
        image.add(text);//the text would initially be added on the frame below the image. so text should be added with the help of image obj on the image

        //for textfield to enter the amount of money to be deposited
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 19));
        amount.setBounds(175, 350, 320, 25);
        image.add(amount);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.setFont(new Font("Raleway", Font.BOLD, 12));
        withdraw.addActionListener(this);
        image.add(withdraw);

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

    //overriding the abstract method of the interface
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            //fetch amount deposited
            String number = amount.getText();
            Date date = new Date();
            //if client enters no money to be deposited
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the ampount you want to withdraw");
            } //if client has money to be deposited
            else {
                try {
                    //establish connection
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawl','" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                } catch (Exception e) {
                    System.out.println(e);
                }

            }

        } else if (ae.getSource() == back) {
            //on the click of the back button the frame of the transcation class should open agsin
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        }

    }

    public static void main(String[] args) {

        //anonymous obj for the class
        new Withdrawl("");
    }

}
