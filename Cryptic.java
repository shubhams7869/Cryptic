// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Cryptic {
    public static void main(String[] args) {
        String msg="ShubhamS@=======";
        String secret="Sun==";
        String eMsg="k1I1O%1Ms1N51f1m1H1h1d",dMsg;
        /*
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Message to encrypt: ");
        String msg=input.next();
        System.out.print("Enter secret : ");
        String secret=input.next();
        */
        eMsg=encryptMsg(msg,secret);
        System.out.println("Encrypted message : "+eMsg);
        dMsg=decryptMsg(eMsg,secret);
        System.out.println("Decrypted message : "+dMsg);
    }
    
    public static String encryptMsg(String msg, String secret){
        String ltrlList="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%*-_+=";

        char[] msgChars=msg.toCharArray();
        StringBuilder encr = new StringBuilder();
        char tempChar=0;
        int litInd,msgInd=0,secrInd,secInd=0;
        int tempInd,num,ch;
        //Alphabets [65-90][97-122]
        //Numbers [48-57]
        System.out.println("Encryption started..."+ltrlList.length());
        for(Character c:msgChars){
            //ascii=c;
            secrInd=ltrlList.indexOf(secret.charAt(secInd)); //index of secret char in literal
            //System.out.println("SecId "+secrInd);
            msgInd=ltrlList.indexOf(c); //index of message char in literal
            //System.out.println("MsgId "+msgInd);
            tempInd=secrInd+msgInd;
            //System.out.println("tempInd "+tempInd);
            
            num=tempInd/(ltrlList.length()-1);
            tempChar=Character.forDigit(num,10);
            //System.out.println("msgChar "+c);
            //System.out.println(secret.charAt(secInd));
            //System.out.println("tempChar "+tempChar);
            if(tempChar>'0')encr.append(tempChar);
            ch=tempInd%(ltrlList.length()-1);
            tempChar=ltrlList.charAt(ch);
            //System.out.println("tempChar "+tempChar);
            encr.append(tempChar);
            secInd=secInd<secret.length()-1?secInd+1:0;
        }
        return encr.toString();
    }
    
    public static String decryptMsg(String eMsg, String secret){
        String ltrlList="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%*-_+=";

        char[] eMsgChars=eMsg.toCharArray();
        StringBuilder decr = new StringBuilder();
        char tempChar=0,c;
        int litInd,msgInd=0,secrInd,secInd=0;
        int tempInd=0,num=0,ch;
        //Alphabets [65-90][97-122]
        //Numbers [48-57]
        System.out.println("Decryption started...");
        for(int i=0;i<eMsg.length();i++){
            c=eMsg.charAt(i);
            if(Character.isDigit(c)) {
                num=c-'0';
                if(!Character.isDigit(eMsg.charAt(i+1)))
                    continue;
                else num=0;
            }
            
            //System.out.print(" num"+num);
            tempInd=num*(ltrlList.length()-1);
            
            secrInd=ltrlList.indexOf(secret.charAt(secInd)); //index of secret char in literal
            //System.out.println("SecId"+secrInd);
            msgInd=ltrlList.indexOf(c); //index of message char in literal
            //System.out.println("MsgId"+msgInd);
            tempInd=tempInd+msgInd-secrInd;
            //System.out.print(" tempInd"+tempInd);
            
            tempChar=ltrlList.charAt(tempInd);
            //System.out.print(" msgChar "+c);
            //System.out.print(" "+secret.charAt(secInd));
            //System.out.println(" tempChar "+tempChar);
            decr.append(ltrlList.charAt(tempInd));
            secInd=secInd<secret.length()-1?secInd+1:0;
            num=0;
        }
        return decr.toString();
    }
}
