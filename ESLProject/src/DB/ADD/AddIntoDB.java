/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.ADD;

import DB.Info.GetInfo;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author mfh
 */
public class AddIntoDB {
    
      Connection c = null;
      Statement stmt = null;
    
    public void InsertToDB(String type, String bangla, String english){
    
    
      GetInfo getInfo=new GetInfo();
        
        int lastID= getInfo.LastID();
        int lastSerial= getInfo.LastSerial();
        System.out.println("Last Id is: "+lastID);
        System.out.println("Last Serial is: "+lastSerial);

         
        try {
      
            URL dbadd= getClass().getResource("/View/files/ESLDB.db");
            Class.forName("org.sqlite.JDBC");
    
            c = DriverManager.getConnection("jdbc:sqlite::resource:"+dbadd);
            c.setAutoCommit(false);
            System.out.println("Opened ESL..insert... database successfully");

              stmt = c.createStatement();
              
              
              
              
             String sql = "INSERT INTO ESL (id,serial,type,bangla,english) " +
                   "VALUES (?,?,?,?,?);"; 
             
             PreparedStatement pst= c.prepareStatement(sql);
             
             pst.setInt(1,++lastID);
             pst.setInt(2,++lastSerial);
             pst.setString(3,type);
             pst.setString(4,bangla);
             pst.setString(5,english);
            
             
              pst.executeUpdate();
      
              
              
              stmt.close();
      
              
              c.commit();
      
              
              c.close();
    } 
        
        catch ( Exception e ) {
      
            System.err.println( e.getClass().getName() + ": " + e.getMessage()+"add into db" );
      
            System.exit(0);
    }
        
        
    System.out.println(" Records created successfully");
  //  JOptionPane.showMessageDialog(null, "Successfully added to DB..", "Insertion Info:", JOptionPane.OK_OPTION);
}
    
    public static void main(String ar[])
    {
        AddIntoDB object=new AddIntoDB();
        
        object.InsertToDB("words", "ফয়সাল হাসান", "md. faysal hasan");
    
    }
}
