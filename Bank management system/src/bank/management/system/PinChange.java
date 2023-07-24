package bank.management.system;

import javax.swing.*;//for JFrame
import java.awt.*;//for image class
import java.awt.event.*;//for actionlistener interface

public class PinChange extends JFrame implements ActionListener {

    JButton change, back;
    JPasswordField pin, repin;
    String pinnumber;

    PinChange(String pinnumber) {
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
        JLabel text = new JLabel("CHANGE YOUR PIN :");
        text.setBounds(250, 300, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 18));
        image.add(text);

        //for adding new pin
        JLabel pintext = new JLabel("Enter New PIN :");
        pintext.setBounds(170, 350, 400, 20);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("system", Font.BOLD, 18));
        image.add(pintext);

        //textfield for new pin
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 17));
        pin.setBounds(340, 350, 165, 20);
        image.add(pin);

        //for re-entering new pin
        JLabel repintext = new JLabel("Re-Enter New PIN :");
        repintext.setBounds(170, 400, 400, 20);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("system", Font.BOLD, 18));
        image.add(repintext);

        //textfield for new pin re-entry
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 17));
        repin.setBounds(340, 400, 165, 20);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.setFont(new Font("Raleway", Font.BOLD, 12));
        change.addActionListener(this);
        image.add(change);

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
        if (ae.getSource() == change) {
            try {
                String newPin = pin.getText();
                String renewPin = repin.getText();

                //if reentered pin does not match the new pin
                if (!newPin.equals(renewPin)) {
                    JOptionPane.showMessageDialog(null, "Re-entered PIN does not match.");
                    return;//no operation would be performed later
                }
                //if new pin is not entered
                if (newPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the new PIN.");
                    return;
                }
                if (renewPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter the new PIN.");
                    return;
                }
                //if pin and repin are correctly entered by the user
                //establish onnection with the db
                Conn conn = new Conn();
                //pin has to be changed in 3 tables so 3 queries will be executed
                String query1 = "update bank set pin='" + renewPin + "' where pin='" + pinnumber + "'";
                String query2 = "update login set pinnumber='" + renewPin + "' where pinnumber='" + pinnumber + "'";
                String query3 = "update signupthree set pinnumber='" + renewPin + "' where pinnumber='" + pinnumber + "'";

                //for executing the queries
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully.");

                setVisible(false);
                new Transactions(renewPin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

}
