package com.suryasoft.nirikshak.util;
import java.util.*;

class Cryptic {

    static String ltrlList="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%*-_+=.,";
    
    public static void main(String[] args) {
        String eMsg,dMsg;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Message to encrypt: ");
        String msg=input.next();
        System.out.print("Enter secret : ");
        String secret=input.next();
        input.close();
        eMsg=encryptMsg(msg,secret);
        System.out.println("Encrypted message : "+eMsg);
        dMsg=decryptMsg(eMsg,secret);
        System.out.println("Decrypted message : "+dMsg);
    }
    
    public static String encryptMsg(String msg, String secret){

        char[] msgChars=msg.toCharArray();
        StringBuilder encr = new StringBuilder();
        char tempChar=0;
        int msgInd=0,secrInd,secInd=0;
        int tempInd,num,ch;

        System.out.println("Encryption started..."+ltrlList.length());
        for(Character c:msgChars){
            secrInd=ltrlList.indexOf(secret.charAt(secInd)); //index of secret char in ltrlList
            msgInd=ltrlList.indexOf(c); //index of message char in ltrlList
            
            tempInd=secrInd+msgInd; //index of encrypted char in ltrlList
            
            ch=tempInd%(ltrlList.length()-1);
            tempChar=ltrlList.charAt(ch);
            encr.append(tempChar); // Adds the ecrypted char to the Final String
            
            secInd=secInd<secret.length()-1?secInd+1:0;
        }
        return encr.toString();
    }
    
    public static String decryptMsg(String eMsg, String secret){
        StringBuilder decr = new StringBuilder();
        char tempChar=0,c;
        int msgInd=0,secrInd,secInd=0;
        int tempInd=0;
        //Alphabets [65-90][97-122]
        //Numbers [48-57]
        System.out.println("Decryption started...");
        for(int i=0;i<eMsg.length();i++){
            c=eMsg.charAt(i);
            
            secrInd=ltrlList.indexOf(secret.charAt(secInd)); //index of secret char in literal
            msgInd=ltrlList.indexOf(c); //index of message char in literal

            tempInd=msgInd<secrInd?(ltrlList.length()-1)+msgInd-secrInd:msgInd-secrInd;
            
            tempChar=ltrlList.charAt(tempInd);
            decr.append(tempChar);
            secInd=secInd<secret.length()-1?secInd+1:0;
        }
        return decr.toString();
    }
}
