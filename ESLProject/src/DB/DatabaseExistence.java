/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.File;
import java.net.URL;

/**
 *
 * @author mfh
 */
public class DatabaseExistence {
    
    File database;
    
    public boolean DBExists()
    {
    //database= new File("View/DB/ESLDB.db");
     URL dbadd= getClass().getResource("/View/files/ESLDB.db");
     
    if(true)
        {
            return true;
        }
    
    else 
        {
            return false;
        }
    
    
    }
}
