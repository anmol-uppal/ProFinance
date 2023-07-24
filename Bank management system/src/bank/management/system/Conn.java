package bank.management.system;

import java.sql.*;//for registering driver and sql

public class Conn {
    
    //creating obj for 'Connection' class. With the help of obj we will invoke the method that creates connection
    Connection c;
    //globally declaring a statement
    Statement s;
    
    //default construtoe for the class
    Conn(){
        //MySQL is an external entity for that we may enounter run time errors for5 that we have to use try catch block
        try{
            
            //registering the driver
            //Class.forName(com.mysql.cj.jdbc.driver); -->this is not be coded bcz 'Driver' already exits in the path
            //using obj of 'Connection' class to invoke method
            //c=DriverManager.getConnection("jdbc:mysql//localhost:3306")-->this could also have been coded but it;s already known that mysql works on localhost and 3306 prt number
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root","kushal9013"); //-->its is the connection string
            s=c.createStatement();//obj of 'connection' will be used to invoke the fxn
            
        }
        catch(Exception e){
            //printing the error
            System.out.println(e);
            
        }
    }
    
   
    
}
