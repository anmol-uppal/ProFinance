package bank.management.system;

import javax.swing.*;//for the JFrame class that is inside the extended package of java
import java.awt.*; //for the 'Image' class
import java.awt.event.*; //for the ActionListner interface
import java.sql.*;//for Resultset datatype

public class Login extends JFrame implements ActionListener {

    //globally declaring the buttons so that they can  be used outside the constructor as well
    JButton login, clear, signup;
    //globally decalring the textfield as well to use them outside the constructor
     JTextField cardtf;
     JPasswordField pintf;

    //class constructor would be invoked by the anonymous obj
    Login() {
        setLayout(null);//by default the BorderLayout will override the Bounds fxn and align the component in centre so it has to be set null

        //for setting the icon for the bank
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/p1.jpg")); //image fetched from the folder
        //for scaling image to perfect dimensions
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        //Image cannot be added to label as it is. it has to be converted to imageIcon again
        ImageIcon i3 = new ImageIcon(i2);

        //icon cannot be placed on frame as it as it has to be passed to JLabel
        JLabel label = new JLabel(i3);
        //for setting the accurate position for the icon
        label.setBounds(70, 10, 150, 150);//left,top,height,width
        //now add fxn is used to add the icon on the frame by passing label to it
        add(label);

        //for changing the color of the frame
        getContentPane().setBackground(Color.WHITE);

        //for welcoming the user to the ATM
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Oswald", Font.BOLD, 38));
        text.setBounds(300, 70, 400, 40);
        add(text);

        //label for the card number
        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 31));
        cardno.setBounds(95, 155, 400, 40);
        add(cardno);

        //textfield for cardno entry
         cardtf = new JTextField();
        cardtf.setBounds(325, 155, 325, 40);
        cardtf.setFont(new Font("Arial",Font.PLAIN,18));
        add(cardtf);

        //label for the pin
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 31));
        pin.setBounds(242, 225, 400, 40);
        add(pin);

        //textfield for pin
         pintf = new JPasswordField();
        pintf.setBounds(325, 225, 325, 40);
        pintf.setFont(new Font("Arial",Font.PLAIN,18));
        add(pintf);

        //button for the 'SIGN IN'
        login = new JButton("SIGN IN");
        login.setBounds(325, 275, 162, 40);
        login.setBackground(new Color(2, 21, 38));
        login.setForeground(Color.WHITE);
        login.addActionListener(this); //for performing action on click of the button
        add(login);

        //button for 'CLEAR'
        clear = new JButton("CLEAR");
        clear.setBounds(490, 275, 162, 40);
        clear.setBackground(new Color(2, 21, 38));
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this); //for performing action on click of the button
        add(clear);

        //button for 'SIGN UP'
        signup = new JButton("SIGN UP");
        signup.setBounds(410, 318, 162, 40);
        signup.setBackground(new Color(2, 21, 38));
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this); //for performing action on click of the button
        add(signup);

        //for the frame creation
        setSize(800, 480);//length is 800 and breadth is 480

        //for unhidding the frame from the user
        setVisible(true);

        //for having the frame to open from particular location
        setLocation(350, 200);//350 from left and 200 from the top

        //for setting the title of the frame
        setTitle("AUTOMATED TELLER MACHINE");
    }

    //overridding the abstract method of the inteface
    //it will show what actions will be performed when a button is clicked
    @Override
    public void actionPerformed(ActionEvent ae) {
        //differntiating ehich particular button has been clicked
        //if 'CLEAR' is clicked
        if(ae.getSource()==clear){
            //passing empty string to setText fxn that sets the textfield as empty when button is clicked
            cardtf.setText("");
            pintf.setText("");
        }
         //if 'LOGIN' is clicked
        else if(ae.getSource()==login){
            //to establish connection make obj of Conn class
            Conn conn=new Conn();
            //fetching values from text fiels
            String cardnumber=cardtf.getText();
            String pinnumber=pintf.getText();//-->this method has been deprecated for the password text field
            String query="select * from login where cardnumber='"+cardnumber+"' and pinnumber='"+pinnumber+"'";
            //db is external entity to hit on it use try catch
            try{
                //for DDL command use 'executeQuery' command
               ResultSet rs= conn.s.executeQuery(query);//->it has to return data that would be stored in resultset datatype that comes under java sql package
               //if the data has been fetched
               if(rs.next()){
                   setVisible(false);//close the login frame id data is fetched
                   //openeing the transaction frame 
                   new Transactions(pinnumber).setVisible(true);
               }
               //incase the data does not matche then a dialog box has to pop up
               else{
                JOptionPane.showMessageDialog(null,"Incorrect CardNumber or Pin");
                        }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
         //if 'SIGNUP' is clicked
        else if(ae.getSource()==signup){
            //to close the current frame
            setVisible(false);
            //to open up the sign up page we will make use of the obj of he signup1 class
            new Signup1().setVisible(true);
                    
        }

    }

    public static void main(String[] args) {
        new Login();//anonymous object of JFrame class

    }

}
