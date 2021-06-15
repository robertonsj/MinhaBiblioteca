/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadostratados;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rober
 */
public class ConexaoJavaBanco {
    
    public Connection getConnection(){
        
        try{
            
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bd_meuslivros","usuario","123");
            
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
    }
    
}
