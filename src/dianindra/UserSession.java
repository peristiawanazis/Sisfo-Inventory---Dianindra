/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dianindra;

/**
 *
 * @author user
 */
public class UserSession {
    
   private static String userLogin; 
   private static String id;
    
    public static void setUserLogin(String userLogin) { 
        UserSession.userLogin = userLogin; 
        
    } 
     public static void setUserId(String id) { 
        UserSession.id = id; 
        
    } 
    
    public static String getUserLogin() { 
        return userLogin; 
    } 
    
     public static String getIdLogin() { 
        return id; 
    } 

} 
