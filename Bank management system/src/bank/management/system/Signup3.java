package bank.management.system;

import javax.swing.*;//for JFrame class
import java.awt.*;//for font
import java.awt.event.*;//for actionlistener interface
import java.util.*;//for random class

public class Signup3 extends JFrame implements ActionListener {

    //globally declaring the radiobuttons
    JRadioButton savingAcc, fdAcc, currentAcc, rdAcc;

    //globally declaring the checkboxes
    JCheckBox atmCard, internetBanking, mobileBanking, emailAlert, chequeBook, eStatement, declaration;
    
    //globally declaring the buttons
    JButton submit,cancel;
    
    String formno;

    //constructor for the class
    Signup3(String formno) {
        this.formno=formno;

        //setting layout as null bcz bydefault it will set eerything at the centre
        setLayout(null);

        //for setting the icon for the bank
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/p1.jpg")); //image fetched from the folder
        //for scaling image to perfect dimensions
        Image i2 = i1.getImage().getScaledInstance(145, 145, Image.SCALE_DEFAULT);
        //Image cannot be added to label as it is. it has to be converted to imageIcon again
        ImageIcon i3 = new ImageIcon(i2);
        //icon cannot be placed on frame as it as it has to be passed to JLabel
        JLabel label = new JLabel(i3);
        //for setting the accurate position for the icon
        label.setBounds(8, 10, 150, 150);//left,top,height,width
        //now add fxn is used to add the icon on the frame by passing label to it
        add(label);

        JLabel accountDetails = new JLabel("Page 3 : Acccount Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 25));
        accountDetails.setBounds(275, 55, 400, 33);
        add(accountDetails);

        //label for asking account type of the user
        JLabel type = new JLabel("Account Type : ");
        type.setFont(new Font("Raleway", Font.PLAIN, 25));
        type.setBounds(150, 150, 200, 33);
        add(type);

        //radiobutton for account types
        savingAcc = new JRadioButton("Saving Account");
        savingAcc.setBounds(375, 150, 175, 33);
        savingAcc.setFont(new Font("Raleway", Font.PLAIN, 20));
        savingAcc.setBackground(Color.white);
        add(savingAcc);

        //radiobutton for account types
        fdAcc = new JRadioButton("Fixed Deposit Account");
        fdAcc.setBounds(550, 150, 300, 33);
        fdAcc.setFont(new Font("Raleway", Font.PLAIN, 20));
        fdAcc.setBackground(Color.white);
        add(fdAcc);

        //radiobutton for account types
        currentAcc = new JRadioButton("Current Account");
        currentAcc.setBounds(375, 200, 175, 33);
        currentAcc.setFont(new Font("Raleway", Font.PLAIN, 20));
        currentAcc.setBackground(Color.white);
        add(currentAcc);

        //radiobutton for account types
        rdAcc = new JRadioButton("Recurring Deposit Account");
        rdAcc.setBounds(550, 200, 300, 33);
        rdAcc.setFont(new Font("Raleway", Font.PLAIN, 20));
        rdAcc.setBackground(Color.white);
        add(rdAcc);

        //for onlu one selection of the radiobutton ButtonGroup class is used
        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(savingAcc);
        groupAccount.add(fdAcc);
        groupAccount.add(currentAcc);
        groupAccount.add(rdAcc);

        //label for card number
        JLabel cardno = new JLabel("Card Number : ");
        cardno.setFont(new Font("Raleway", Font.PLAIN, 25));
        cardno.setBounds(150, 255, 200, 33);
        add(cardno);

        JLabel cardDetail = new JLabel("(16 Digit Card Number)");
        cardDetail.setFont(new Font("Raleway", Font.PLAIN, 14));
        cardDetail.setBounds(150, 280, 200, 25);
        add(cardDetail);

        //label for dummy card number
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184 ");
        number.setFont(new Font("Raleway", Font.PLAIN, 25));
        number.setBounds(375, 255, 300, 33);
        add(number);

        //label for PIN
        JLabel pinno = new JLabel("PIN : ");
        pinno.setFont(new Font("Raleway", Font.PLAIN, 25));
        pinno.setBounds(150, 335, 200, 33);
        add(pinno);

        JLabel pinDetail = new JLabel("(4 Digit PIN)");
        pinDetail.setFont(new Font("Raleway", Font.PLAIN, 14));
        pinDetail.setBounds(150, 360, 200, 25);
        add(pinDetail);

        //label for dummy card number
        JLabel pinNumber = new JLabel("XXXX ");
        pinNumber.setFont(new Font("Raleway", Font.PLAIN, 25));
        pinNumber.setBounds(375, 335, 300, 33);
        add(pinNumber);

        //label for asking the type of services client want
        JLabel services = new JLabel("Services Required : ");
        services.setFont(new Font("Raleway", Font.PLAIN, 25));
        services.setBounds(150, 415, 300, 33);
        add(services);

        //checkboxes for the services
        atmCard = new JCheckBox("ATM Card");
        atmCard.setFont(new Font("Raleway", Font.PLAIN, 20));
        atmCard.setBackground(Color.WHITE);
        atmCard.setBounds(375, 415, 150, 33);
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setFont(new Font("Raleway", Font.PLAIN, 20));
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setBounds(550, 415, 200, 33);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setFont(new Font("Raleway", Font.PLAIN, 20));
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setBounds(375, 450, 175, 33);
        add(mobileBanking);

        emailAlert = new JCheckBox("Email Alert");
        emailAlert.setFont(new Font("Raleway", Font.PLAIN, 20));
        emailAlert.setBackground(Color.WHITE);
        emailAlert.setBounds(550, 450, 200, 33);
        add(emailAlert);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setFont(new Font("Raleway", Font.PLAIN, 20));
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setBounds(375, 485, 170, 33);
        add(chequeBook);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setFont(new Font("Raleway", Font.PLAIN, 20));
        eStatement.setBackground(Color.WHITE);
        eStatement.setBounds(550, 485, 200, 33);
        add(eStatement);

        declaration = new JCheckBox("I hereby declare that all the filled information is correct.");
        declaration.setFont(new Font("Raleway", Font.PLAIN, 16));
        declaration.setBackground(Color.WHITE);
        declaration.setBounds(150, 530, 800, 18);
        add(declaration);
        
        
         //for a button 'SUBMIT'
        submit = new JButton("SUBMIT");
        submit.setBounds(200, 630, 162, 40);
        submit.setFont(new Font("Raleway",Font.PLAIN,23));
        submit.setBackground(new Color(2, 21, 38));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        
         //for a button 'CANCEL'
        cancel = new JButton("CANCEL");
        cancel.setBounds(500, 630, 162, 40);
        cancel.setFont(new Font("Raleway",Font.PLAIN,23));
        cancel.setBackground(new Color(2, 21, 38));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        //for coloring the frame
        getContentPane().setBackground(Color.WHITE);

        //setting up the frame
        setSize(850, 820);//length and breadth
        setLocation(350, 10);//changing by default origin position to desired one 350 from left and 10 from top
        setTitle("NEW ACCOUNT APPLICATION PAGE 3 ");

        setVisible(true);//for the visibilty of the frame

    }
    
    //overriding the abstract method of the interface
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            //for the type of the account
            String accountType=null;
            if(savingAcc.isSelected()){
                accountType="Saving Account";
            }
            else if(fdAcc.isSelected()){
                accountType="Fixed Deposit Account";
            }
             else if(currentAcc.isSelected()){
                accountType="current Account";
            }
             else  if(rdAcc.isSelected()){
                accountType="Recurring Deposit Account";
            }
            
            //for generating 16 digit random card number
            Random random=new Random();
            String cardnumber=""+Math.abs((random.nextLong()%90000000L) + 5040936000000000L);
            String pinnumber=""+Math.abs((random.nextLong()%9000L) + 1000L);
            
            //for various services
            String facility="";
            if(atmCard.isSelected()){
                facility = facility  + "Atm card";
            }
            else if(internetBanking.isSelected()){
                facility = facility + "Internet Banking";
            }
            else if(mobileBanking.isSelected()){
                facility = facility + "Mobile Banking";
            }
            else if(emailAlert.isSelected()){
                facility = facility + "Email Alert";
            }
            else if(chequeBook.isSelected()){
                facility = facility + "Cheque Book";
            }
            else if(eStatement.isSelected()){
                facility = facility + "E-Statement";
            }
            
            //now we have to make connection with the db but db is an external entity for that run tine errors acn occur and they should be handled using try catch block
            try{
                //validation for field
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Mandatory");
                }
                else{
                    Conn conn = new Conn();
                    String query1="Insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"', '"+facility+"')";  
                    //String query1 = "INSERT INTO signupthree (formno, accountType, cardnumber, pinnumber, facility) VALUES ('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "', '" + facility + "')";
                    String query2 ="Insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    //at last we have to let the client know that all the data has been successfully added to the db
                    JOptionPane.showMessageDialog(null, "Card Number : " +cardnumber+ "\n PIN: "+pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            }
            catch(Exception e){
               System.out.println(e);
            
            }
            
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
             new Login().setVisible(true);//->login class will be opened
                    
            
             
        }
        
    }

    public static void main(String[] args) {
        new Signup3("");//anonymous obj of the class
    }

}
