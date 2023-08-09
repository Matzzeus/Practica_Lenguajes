/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectolenguajes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author matzeus
 */

public class OpenFile {
    
     static void openFile(){
        JFileChooser upload = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("txt","txt");
        upload.setFileFilter(filtro);
        upload.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        upload.showOpenDialog(null);        
        FileReader fr = null;
        try{
            File file = upload.getSelectedFile();
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String text = "";
            String line;                     
            while((line = br.readLine()) != null){                
                text += line + "\n";
            }            
            System.out.println("text");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo");     
        }
        finally{
                try{if(fr!=null){
                    fr.close();
                    }
                }catch(Exception ex){
                    ex.printStackTrace(System.out);
                }                
            }
    }
    
}
    
    
    

