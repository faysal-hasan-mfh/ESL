/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author mfh
 */
public class CreateFolder {
    
     boolean folder;
     File fl;
     private boolean FolderCreation()
     {
         // creating file folder..............
         fl=new File("C://ESL");
        // ensuring ..... folder is created or not......................
        boolean isPathCreated=fl.mkdir();
        // sending the confirmation.......................
        if(isPathCreated)
        {
        JOptionPane.showMessageDialog(null, "FILE FOLDER SUCCESSFULLY CREATED...", "FILE PATH CREATED..", JOptionPane.INFORMATION_MESSAGE);
        folder=true;
        return folder;
        }
        else
        {           
         FolderExist();
         JOptionPane.showMessageDialog(null, "Something Wrong !", "FILE Folder Not Created !", JOptionPane.INFORMATION_MESSAGE);
         folder=false;
         return folder;
        }

     }
     
     // Please call file folder creation method before call fileexist method.............
     
     public boolean FolderExist()
    {
        // creating file folder..............
        fl=new File("C://ESL");
        boolean isPathCreated=fl.exists();
        // sending the confirmation.......................
        
        if(isPathCreated)
        {
        JOptionPane.showMessageDialog(null, "Folder exists.....", "Folder exists...", JOptionPane.INFORMATION_MESSAGE);
        folder=true;
        return folder;
        }
        else
        {
         JOptionPane.showMessageDialog(null, "Something Wrong !", "FILE Folder Not Exists !", JOptionPane.INFORMATION_MESSAGE);
         folder=false;
         return folder;
        }
    }
     
     
     public static void main(String arg[])
     {
     
         CreateFolder object=new CreateFolder();
         
         
         object.FolderCreation();
         object.FolderExist();
     
     }
}
