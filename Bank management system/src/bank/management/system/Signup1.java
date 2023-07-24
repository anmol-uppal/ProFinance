package bank.management.system;

import javax.swing.*;//for the JFrame class
import java.awt.*;//for the Color class
import java.util.*;//for the Random class
import com.toedter.calendar.JDateChooser;//for choosing date for date of birth
import java.awt.event.*;//for the ActionListener interface

public class Signup1 extends JFrame implements ActionListener {

    //globally declaring the variables to be used outside the constructor
    long random;

    //globally decalring the textfield for their use outside of the constructer
    JTextField nametf, fnametf, emailtf, addresstf, citytf, statetf, pinCodetf;

    //globally decalring button
    JButton next1;

    //globally declaring the radiobuttons as well
    JRadioButton male, female, single, married, other;

    //decalrinf date chooser
    JDateChooser dateChooser;

    //constructor to contain code for deasign of the frame
    Signup1() {

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

        //for creating any 4 digit6 random number we will make use of the  Random class that comes under 'util' package
        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L + 1000L);

        //for the heading of the frame that says 'APPLICATION FORM NO:____'
        //we will make use of the label for the heading
        JLabel formno = new JLabel("APPLICATION FORM NO : " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 35));
        formno.setBounds(160, 10, 600, 40);
        add(formno);

        //label for the personal details of the user
        JLabel personDetails = new JLabel("Page 1 : Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 25));
        personDetails.setBounds(275, 55, 400, 33);
        add(personDetails);

        //label for asking name of the user
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.PLAIN, 25));
        name.setBounds(150, 150, 200, 33);
        add(name);

        //textfield for name
        nametf = new JTextField();
        nametf.setFont(new Font("Raleway", Font.BOLD, 23));
        nametf.setBounds(355, 150, 300, 33);
        add(nametf);

        //label for asking Father's name of the user
        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway", Font.PLAIN, 25));
        fname.setBounds(150, 200, 200, 33);
        add(fname);

        //textfield for father's name
        fnametf = new JTextField();
        fnametf.setFont(new Font("Raleway", Font.BOLD, 23));
        fnametf.setBounds(355, 200, 300, 33);
        add(fnametf);

        //label for asking date of Birth of the user
        JLabel dob = new JLabel("Date Of Birth : ");
        dob.setFont(new Font("Raleway", Font.PLAIN, 25));
        dob.setBounds(150, 250, 200, 33);
        add(dob);

        //adding calendar for chossing dob
        dateChooser = new JDateChooser();
        dateChooser.setBounds(355, 250, 300, 33);
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 23));
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        //label for asking gender of the user
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.PLAIN, 25));
        gender.setBounds(150, 300, 200, 33);
        add(gender);

        //adding radiobuttons for male
        male = new JRadioButton("Male");
        male.setBounds(355, 300, 100, 33);
        male.setFont(new Font("Raleway", Font.PLAIN, 18));
        male.setBackground(Color.white);
        add(male);

        //adding radiobuttons for Female
        female = new JRadioButton("Female");
        female.setBounds(450, 300, 100, 33);
        female.setFont(new Font("Raleway", Font.PLAIN, 18));
        female.setBackground(Color.white);
        add(female);

        //for making only one selection for two radiobuttons 'ButtonGroup' class is used. you have to group the genders and pass radiobuttons to the object of 'ButtonGroup'
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        //label for asking email address of the user
        JLabel email = new JLabel("Email Address : ");
        email.setFont(new Font("Raleway", Font.PLAIN, 25));
        email.setBounds(150, 350, 200, 33);
        add(email);

        //textfield for email
        emailtf = new JTextField();
        emailtf.setFont(new Font("Raleway", Font.BOLD, 18));
        emailtf.setBounds(355, 350, 300, 33);
        add(emailtf);

        //label for asking marital status of the user
        JLabel mstatus = new JLabel("Marital Status : ");
        mstatus.setFont(new Font("Raleway", Font.PLAIN, 25));
        mstatus.setBounds(150, 400, 200, 33);
        add(mstatus);

        //adding radiobuttons for single
        single = new JRadioButton("Single");
        single.setBounds(355, 400, 100, 33);
        single.setFont(new Font("Raleway", Font.PLAIN, 18));
        single.setBackground(Color.white);
        add(single);

        //adding radiobuttons for married
        married = new JRadioButton("Married");
        married.setBounds(450, 400, 120, 33);
        married.setFont(new Font("Raleway", Font.PLAIN, 18));
        married.setBackground(Color.white);
        add(married);

        //adding radiobuttons for other(divorced,widow)
        other = new JRadioButton("Other");
        other.setBounds(565, 400, 450, 33);
        other.setFont(new Font("Raleway", Font.PLAIN, 18));
        other.setBackground(Color.white);
        add(other);

        //for making only one selection for two radiobuttons 'ButtonGroup' class is used. you have to group the genders and pass radiobuttons to the object of 'ButtonGroup'
        ButtonGroup mstatusGroup = new ButtonGroup();
        mstatusGroup.add(single);
        mstatusGroup.add(married);
        mstatusGroup.add(other);

        //label for asking address of the user
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.PLAIN, 25));
        address.setBounds(150, 450, 200, 33);
        add(address);

        //textfield for address
        addresstf = new JTextField();
        addresstf.setFont(new Font("Raleway", Font.BOLD, 18));
        addresstf.setBounds(355, 450, 300, 33);
        add(addresstf);

        //label for asking city of the user
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.PLAIN, 25));
        city.setBounds(150, 500, 200, 33);
        add(city);
        
        
        //textfield for city
        citytf = new JTextField();
        citytf.setFont(new Font("Raleway", Font.BOLD, 18));
        citytf.setBounds(355, 500, 300, 33);
        add(citytf);


        

        //label for asking state of the user
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.PLAIN, 25));
        state.setBounds(150, 550, 200, 33);
        add(state);

        //textfield for state
        statetf = new JTextField();
        statetf.setFont(new Font("Raleway", Font.BOLD, 18));
        statetf.setBounds(355, 550, 300, 33);
        add(statetf);

        //label for asking PIN code of the user
        JLabel pinCode = new JLabel("PIN Code : ");
        pinCode.setFont(new Font("Raleway", Font.PLAIN, 25));
        pinCode.setBounds(150, 600, 200, 33);
        add(pinCode);

        //textfield for pinCode
        pinCodetf = new JTextField();
        pinCodetf.setFont(new Font("Raleway", Font.BOLD, 18));
        pinCodetf.setBounds(355, 600, 300, 33);
        add(pinCodetf);

        //for a button 'NEXT' that takes user to the next page
        next1 = new JButton("NEXT");
        next1.setBounds(490, 655, 162, 40);
        next1.setFont(new Font("Raleway",Font.PLAIN,23));
        next1.setBackground(new Color(2, 21, 38));
        next1.setForeground(Color.WHITE);
        next1.addActionListener(this);
        add(next1);

        //for coloring the frame
        getContentPane().setBackground(Color.WHITE);

        //setting up the frame
        setSize(850, 800);//length and breadth
        setLocation(350, 10);//changing by default origin position to desired one 350 from left and 10 from top
        setTitle("NEW ACCOUNT APPLICATION PAGE 1 ");
        setVisible(true);//for the visibilty of the frame
    }

    //overriding te abstract method of the interface
    @Override
    public void actionPerformed(ActionEvent ae) { //-->ae is the obj of class 'ActionEvent'
        //only string datatype can be stored in db
        String formno = "" + random;
        String name = nametf.getText();//-->getText fxn helps to fetch the data
        String fname = fnametf.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        //from the radiobuttons only one selection has to be made
        String gender = null;//initially setting t6he gender to null
        //if male is selected
        if (male.isSelected()) {
            gender = "Male";
        } //if female is selected
        else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailtf.getText();
        //radiobuttons for marital status
        String mstatus = null;
        if (single.isSelected()) {
            mstatus = "Single";
        } else if (married.isSelected()) {
            mstatus = "Married";
        } else if (other.isSelected()) {
            mstatus = "Other";
        }
        String address = addresstf.getText();
        String city = citytf.getText();
        String state = statetf.getText();
        String pinCode = pinCodetf.getText();

        //since db is an external entity which mean that there may occur runtime error
        try {
            //adding validation if some textfield is not filled
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is mandatory");//-->a pop will open showing the msg if name is empty string
            }
            //creating obj of 'Conn' class for establishing connection with db is nametf is filled
            else{
                Conn c=new Conn();
                String query="Insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+mstatus+"','"+address+"','"+city+"','"+state+"','"+pinCode+"')";
                //the above query will be executed with the help of statement 's' obj created in 'Conn' class
                c.s.executeUpdate(query);//-->executeUpadte is DML command and query is passed as parameter
                
                setVisible(false);
                //formno has been made the primary key
                new Signup2(formno).setVisible(true);//-->formno is passed to the obj of the signup2 class bcz it has to be unique
            }
            if(fname.equals("")){
                JOptionPane.showMessageDialog(null," Father's Name is mandatory");
            }
            if(email.equals("")){
                JOptionPane.showMessageDialog(null,"email is mandatory");
            }
            if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is mandatory");
            }
            if(city.equals("")){
                JOptionPane.showMessageDialog(null,"City is mandatory");
            }
            if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State is mandatory");
            }
            if(pinCode.equals("")){
                JOptionPane.showMessageDialog(null,"PIN Code is mandatory");
            }
            if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date Of Birth is mandatory");
            }
            if(mstatus.equals("")){
                JOptionPane.showMessageDialog(null,"Marital Status is mandatory");
            }
             if(gender.equals("")){
                JOptionPane.showMessageDialog(null,"Gender is mandatory");
            }

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void main(String[] args) {
        //creating anonymous object of the lass that will invoke the constructor 
        new Signup1();
    }

}
