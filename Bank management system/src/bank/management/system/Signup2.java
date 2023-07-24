package bank.management.system;

import javax.swing.*;//for the JFrame class
import java.awt.*;//for the Color class
//import java.util.*;//for the Random class
//import com.toedter.calendar.JDateChooser;//for choosing date for date of birth
import java.awt.event.*;//for the ActionListener interface

public class Signup2 extends JFrame implements ActionListener {

    //globally declaring the variables to be used outside the constructor
    long random;

    //globally decalring the textfield for their use outside of the constructer
    JTextField  pantf, aadhartf;

    //globally decalring button
    JButton next1;

    //globally declaring the radiobuttons as well
    JRadioButton syes, sno, eayes, eano;

    

    //globally decalring the JComboBox
    JComboBox religion, category, income, education, occupation;
    
    //globally declaring the primary key
    String formno;

    //constructor to contain code for deasign of the frame
    Signup2(String formno) {
    //default constructor is chnanged to parametrized one 
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

        //label for the additional details of the user
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 25));
        additionalDetails.setBounds(275, 55, 400, 33);
        add(additionalDetails);

        //label for asking religion of the user
        JLabel rel = new JLabel("Religion : ");
        rel.setFont(new Font("Raleway", Font.PLAIN, 25));
        rel.setBounds(150, 150, 200, 33);
        add(rel);

        //dropdown for religion
        String valReligion[] = {"Hindu", "Sikh", "Muslim", "Christian", "Jain", "Other"};
        religion = new JComboBox(valReligion);
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        religion.setBounds(355, 150, 300, 33);
        religion.setBackground(Color.WHITE);
        add(religion);

        //label for asking category of the user
        JLabel cat = new JLabel("Category : ");
        cat.setFont(new Font("Raleway", Font.PLAIN, 25));
        cat.setBounds(150, 200, 200, 33);
        add(cat);

        //dropdown for category
        String valCategory[] = {"General", "OBC", "SC", "ST", "Jain", "Oher"};
        category = new JComboBox(valCategory);
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setBounds(355, 200, 300, 33);
        category.setBackground(Color.WHITE);
        add(category);

        //label for asking income of the user
        JLabel inc = new JLabel("Income : ");
        inc.setFont(new Font("Raleway", Font.PLAIN, 25));
        inc.setBounds(150, 250, 200, 33);
        add(inc);

        //dropdown for income
        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(355, 250, 300, 33);
        income.setBackground(Color.WHITE);
        add(income);

        //label for asking education of the user
        JLabel edc = new JLabel("Educational ");
        edc.setFont(new Font("Raleway", Font.PLAIN, 25));
        edc.setBounds(150, 313, 200, 33);
        add(edc);

        //label for asking qualification of the user
        JLabel qual = new JLabel("Qualification : ");
        qual.setFont(new Font("Raleway", Font.PLAIN, 25));
        qual.setBounds(150, 350, 200, 33);
        add(qual);

        //dropdown for educational qualifications
        String educationValues[] = {"Non-Graduation", "Graduation", "Post-Graduation", "Doctrate", "Others"};
        education = new JComboBox(educationValues);
        education.setFont(new Font("Raleway", Font.BOLD, 18));
        education.setBounds(355, 348, 300, 33);
        education.setBackground(Color.WHITE);
        add(education);

        //label for asking occupation of the user
        JLabel occ = new JLabel("Occupation : ");
        occ.setFont(new Font("Raleway", Font.PLAIN, 25));
        occ.setBounds(150, 400, 200, 33);
        add(occ);

        //dropdown for occupation
        String occcupationValues[] = {"Salaried", "Self-Emplpoyed", "Business-man", "Student", "Retired", "Other"};
        occupation = new JComboBox(occcupationValues);
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setBounds(355, 400, 300, 33);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        //label for asking PAN number of the user
        JLabel pan = new JLabel("PAN Number : ");
        pan.setFont(new Font("Raleway", Font.PLAIN, 25));
        pan.setBounds(150, 450, 200, 33);
        add(pan);

        //textfield for address
        pantf = new JTextField();
        pantf.setFont(new Font("Raleway", Font.BOLD, 23));
        pantf.setBounds(355, 450, 300, 33);
        add(pantf);

        //label for asking Aadhar number of the user
        JLabel aadhar = new JLabel("Aadhar Number : ");
        aadhar.setFont(new Font("Raleway", Font.PLAIN, 25));
        aadhar.setBounds(150, 500, 200, 33);
        add(aadhar);

        //textfield for city
        aadhartf = new JTextField();
        aadhartf.setFont(new Font("Raleway", Font.BOLD, 18));
        aadhartf.setBounds(355, 500, 300, 33);
        add(aadhartf);

        //label for asking if the user is senior citizen
        JLabel seniorCitizen = new JLabel("Senior Citizen : ");
        seniorCitizen.setFont(new Font("Raleway", Font.PLAIN, 25));
        seniorCitizen.setBounds(150, 550, 200, 33);
        add(seniorCitizen);

        //adding radiobuttons for yes
        syes = new JRadioButton("Yes");
        syes.setBounds(355, 550, 100, 33);
        syes.setFont(new Font("Raleway", Font.PLAIN, 23));
        syes.setBackground(Color.white);
        add(syes);

        //adding radiobuttons for No
        sno = new JRadioButton("No");
        sno.setBounds(450, 550, 100, 33);
        sno.setFont(new Font("Raleway", Font.PLAIN, 23));
        sno.setBackground(Color.white);
        add(sno);

        //for making only one selection for two radiobuttons 'ButtonGroup' class is used.
        ButtonGroup sGroup = new ButtonGroup();
        sGroup.add(syes);
        sGroup.add(sno);

        //label for asking if he already has any existing account
        JLabel existAcc = new JLabel("Existing Acc : ");
        existAcc.setFont(new Font("Raleway", Font.PLAIN, 25));
        existAcc.setBounds(150, 600, 200, 33);
        add(existAcc);

        //adding radiobuttons for yes
        eayes = new JRadioButton("Yes");
        eayes.setBounds(355, 600, 100, 33);
        eayes.setFont(new Font("Raleway", Font.PLAIN, 23));
        eayes.setBackground(Color.white);
        add(eayes);

        //adding radiobuttons for No
        eano = new JRadioButton("No");
        eano.setBounds(450, 600, 100, 33);
        eano.setFont(new Font("Raleway", Font.PLAIN, 23));
        eano.setBackground(Color.white);
        add(eano);

        //for making only one selection for two radiobuttons 'ButtonGroup' class is used.
        ButtonGroup eaGroup = new ButtonGroup();
        eaGroup.add(eayes);
        eaGroup.add(eano);

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
        setTitle("NEW ACCOUNT APPLICATION PAGE 2 ");
        setVisible(true);//for the visibilty of the frame
    }

    //overriding te abstract method of the interface
    public void actionPerformed(ActionEvent ae) { //-->ae is the obj of class 'ActionEvent'
        //only string datatype can be stored in db
        
        String strReligion = (String)religion.getSelectedItem();//-->it will return obj so it has to be typecasted to string
        String strCategory = (String)category.getSelectedItem();
        String strIncome = (String)income.getSelectedItem();
        String strEducation = (String)education.getSelectedItem();
        String strOccupation = (String)occupation.getSelectedItem();
        
        //from the radiobuttons only one selection has to be made
        String seniorCitizen = null;//initially setting t6he gender to null
        //if yes is selected
        if (syes.isSelected()) {
           seniorCitizen = "Yes";
        } //if no is selected
        else if (sno.isSelected()) {
            seniorCitizen = "No";
        }
       
        //radiobuttons for existing account
        String existAcc = null;
        if (eayes.isSelected()) {
            existAcc = "Yes";
        } else if (eano.isSelected()) {
            existAcc = "No";
        } 
        String strPan = pantf.getText();
        String strAadhar = aadhartf.getText();
       

        //since db is an external entity which mean that there may occur runtime error
        try {
            
                Conn c = new Conn();
                String query = "Insert into signuptwo values('" + formno + "','" + strReligion + "','" + strCategory + "','" + strIncome + "','" + strEducation + "','" + strOccupation + "','" + strPan + "','" + strAadhar + "','" + existAcc + "','" + seniorCitizen + "')";
                //the above query will be executed with the help of statement 's' obj created in 'Conn' class
                c.s.executeUpdate(query);//-->executeUpadte is DML command and query is passed as parameter
                
                //signup3 obj
                setVisible(false);
                new Signup3(formno).setVisible(true);
            }
           

        catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void main(String[] args) {

        new Signup2("");//-->empty string has to be passed 

    }

}
