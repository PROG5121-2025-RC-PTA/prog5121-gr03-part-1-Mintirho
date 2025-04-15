/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatbot_prog;



import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_la
 */
public class Chatbot_prog {

    /**
     *
     * @param args
     */
    public static void main(String[] args)  {
   
               //user registration for cellPhone number
         String CellPhonenumber = JOptionPane.showInputDialog(null,"Eneter your CellPhone Numebr: (+27)");
           if(CellPhonenumber == null || CellPhonenumber.trim().isEmpty()){
             JOptionPane.showMessageDialog(null,"You have to enter a  username to register");
             return;
            
           }
          if (!isValidPhonenumber(CellPhonenumber)){
            JOptionPane.showMessageDialog(null,"CellPhonenumber Registed");   
        }
          else{
                 JOptionPane.showInputDialog(null,"Invalid South African phone number. It should start with +27 followed by 9 digits.");
              }
          //user registration for username
       String username = JOptionPane.showInputDialog(null,"Enter your Username");  
        if (username == null || username.trim().isEmpty()){
             JOptionPane.showMessageDialog(null,"You have to enter a  username to register");
             return ;
         }
         if(!isusernamecorrect(username)){
            JOptionPane.showMessageDialog(null,"Username Registed");
         }
         else
         {
               JOptionPane.showMessageDialog(null,"Invalid username. It should be between 5 to 10 characters.");  
         }
        //user registration for Password
        String Password = JOptionPane.showInputDialog(null,"Enter your Password");   
            if (Password == null || Password.trim().isEmpty()){
             JOptionPane.showMessageDialog(null,"You must have a password to register");
             return;
            }
            if(!ispasswordcorrect(Password)){
               JOptionPane.showMessageDialog(null,"Password Registed ");
        }
            else{
                  JOptionPane.showMessageDialog(null,"Invalid password. Password should be at least 8 characters, 1 Number and 1 Special Character"); 
                }        
       //tells user that they are registed
        JOptionPane.showMessageDialog(null,"You have been Registed successfuly " + username);
        loginUser(username,Password,CellPhonenumber);  
       }       
    
   public static void loginUser(String username,String Password,String CellPhonenumber){
       boolean isloggedin =false;
       
       //allows the user to login after registration
       username= JOptionPane.showInputDialog(null,"Enter your Username to login"); 
       Password= JOptionPane.showInputDialog(null,"Enter your Password to login"); 
       if(username!= null && username.equals(username)&&Password != null && Password.equals(Password)){
           int attempts = 1;
           //gives the user a chance to retry
           while(attempts < 3 &&!isloggedin){
               JOptionPane.showMessageDialog(null,"Username or password is incorrect login,Try again");
               
           Password= JOptionPane.showInputDialog(null,"Enter your Password to login");   
           username= JOptionPane.showInputDialog(null,"Enter your Username to login");
           
           if(username!= null && username.equals(username)&& Password!= null && Password.equals(Password)){
               isloggedin =true;
           }
           attempts++;
           }
       }else{
           isloggedin = true;
       }
       if(isloggedin){
           JOptionPane.showMessageDialog(null,"Username and Password is correct");
           JOptionPane.showMessageDialog(null,"Welcome to the chatbot! "+ username);
       }
       else{
           JOptionPane.showMessageDialog(null,"You have made too many attempts. Access is denied. ");
       }
   }
       // Validate username (between 5 to 20 characters)
    public static boolean isusernamecorrect(String username) {
        if(username==null)return false;
        
        username = username.trim();
           return username.length() >= 3 && username.matches("[_]");
        }
       
    
    // Validate password (at least 8 characters, 1 Number and 1 Special Character)
    public static boolean ispasswordcorrect(String Password) {
        if(Password.length()<8){
          return false;  
        }
        boolean ContainsDigit = false;
        boolean ContainsSpecialCharacter = false;
        
       for(char character: Password.toCharArray()){ 
           if(Character.isDigit(character)){
              ContainsDigit = true; 
           }
           else if(!Character.isLetter(character)) {
               ContainsSpecialCharacter = true;
           }  
       }
       return ContainsDigit && ContainsSpecialCharacter;
    }

    // Validate South African phone number (+27 followed by 9 digits)
    public static boolean isValidPhonenumber(String CellPhoneNumber) {
        String regex = "^\\+27\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(CellPhoneNumber);
        return matcher.matches();
       }

        }
    


    
    


