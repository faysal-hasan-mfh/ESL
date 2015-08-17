/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author mfh
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author faysal
 */
public class CreateDatabase {
    
    
    
    Connection c = null;
    Statement stmt = null;
    CreateFolder createFolder=new CreateFolder();
    DatabaseExistence databaseExist=new DatabaseExistence();
    
    
    public void createDatabaseMethod()
    
    {
        
        boolean folderExist=createFolder.FolderExist();
        boolean dbExist=databaseExist.DBExists();
    
        if(folderExist &&(!dbExist)){
        
        
                 try {
                     
                     Class.forName("org.sqlite.JDBC");
                     c = DriverManager.getConnection("jdbc:sqlite:c://ESL/ESLDB.db");
      
      
                      System.out.println("Opened database successfully");
                      JOptionPane.showMessageDialog(null, "Database Successfully Created...", "Database Info : ", JOptionPane.INFORMATION_MESSAGE);
    
      
                      stmt = c.createStatement();
     
                      
                      String sql = "CREATE TABLE ESL " +
                                   "(id INT PRIMARY KEY," + 
                                   " serial INTEGER,"+
                                   "type TEXT,"+
                                   "bangla TEXT,"+
                                   "english TEXT)";  
      
                      
                 stmt.executeUpdate(sql);
                 
                 System.out.println("Table created successfully");
             
                 
             
                 stmt.close();
                 c.close();
                 
                 System.out.println("Connection Closed.............");
      
        } 
                 
                 catch ( Exception e ) {
                                        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                                        System.out.println("From CreateDatabase");
                                        JOptionPane.showMessageDialog(null, "problem... in creating Database....", "Error..", JOptionPane.ERROR_MESSAGE);   
                                        if(dbExist)
                                          JOptionPane.showMessageDialog(null, "Database is already EXISTED.......!", "Error..", JOptionPane.ERROR_MESSAGE);   
                                        System.exit(0);
                                        }
                 
    
    
   
        
        }
        
        
     else
    {
        if(folderExist==false)
          JOptionPane.showMessageDialog(null, "sorry.. file path is not existed...", "Error..", JOptionPane.ERROR_MESSAGE);   
        else if (dbExist==true)
        {
         JOptionPane.showMessageDialog(null, "sorry.. database is already existed...", "Error..", JOptionPane.ERROR_MESSAGE);
        }
    }
        
        
        
        
   }
    
   
    public static void main(String arg[]){
    
    CreateDatabase obj =new CreateDatabase();
    obj.createDatabaseMethod();
    }
     
     
}
