/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg011;

import java.util.Scanner;

/**
 *
 * @author Personal
 */
public class Main {
   
public static Scanner sc = new Scanner (System.in);
 public static final String Binary_VALID = "-?[01]+";
  public static final String Decimal_VALID = "-?[0-9]+";
   public static final String Hexa_VALID = "-?[0-9A-Fa-f]+";
   public static int parseBinary(String s){
       if(s== null){
       throw new IllegalArgumentException("need to have number");
       }
   int n = 0 ; 
       for(int i = 0 ; i<s.length();i++){
   if(s.charAt(s.length()-1-i)=='1'){
   n +=(int) Math.pow(2,i);
   }
   }
   
   return n ; 
   }
   public static int parseBinaryNeg(String s){
   if( s== null){
   throw new IllegalArgumentException ("you need to start negative with - and 1");
   }
   int n = 0 ; 
   String neg = s.substring(1);
   for(int i = 0 ; i<neg.length();i++){
   if(neg.charAt(neg.length()-1-i)=='1')
   n+= (int) Math.pow(2, i);
   }
   return -n;
   }
public static int checkBinary(){

    System.out.println(" Enter number Binary: ");
     String inputBinary ;
     while(true){
     inputBinary = sc.nextLine().trim();
     if(inputBinary.matches(Binary_VALID) && !inputBinary.startsWith("-") ){
         try{
         int decimal  = parseBinary(inputBinary);
          return decimal ;
         } catch(NumberFormatException e) {
         System.err.println("the binary number is too long or not invalid");
         }
        
     }
     if(inputBinary.matches(Binary_VALID)&& inputBinary.startsWith("-")){
      try{
         int decimal  = parseBinaryNeg(inputBinary);
          return decimal ;
         } catch(NumberFormatException e) {
         System.err.println("the binary number is too long or not invalid");
         }
     
     
     }
     else{
         System.out.println("  MUSt Enter  0 or 1 ");
         System.out.println("please enter  ");
     }    
     }
}
     public static int checkDecimal(){
   
    
    System.out.println(" Enter number Binary: ");
     String inputDecimal ;
     while(true){
    inputDecimal = sc.nextLine().trim();
     if(inputDecimal.matches(Decimal_VALID) && !inputDecimal.startsWith("-") ){
     try{
      int decimal  = Integer.parseInt(inputDecimal,10);
      return decimal;
     
     }  catch(NumberFormatException e){
         System.err.println(" the decimal number is too long");
     
     }                                                                    
     
     }
     if(inputDecimal.matches(Decimal_VALID) && inputDecimal.startsWith("-") ){
     try{
      int decimal  = Integer.parseInt(inputDecimal.substring(1),10);
      return decimal*(-1);
     
     }  catch(NumberFormatException e){
         System.err.println(" the decimal number is too long");
     
     }                                                                    
     
     }
     
     else{
         System.out.println("  MUSt Enter  number 0-9");
         System.out.println("please enter  ");
     }
     }
     

}
     public static int checkHexa(){
         System.out.println(" please enter your hexadecimal number");
        while(true){
        String input = sc.nextLine().toUpperCase();
        if(input.matches(Decimal_VALID)&& !input.startsWith("-")){
        try{
        int decimal = Integer.parseInt(input,16);
        return decimal;
        }catch(NumberFormatException e){
            System.err.println("your number over flows");
        }
        }
        if(input.matches(Decimal_VALID)&& input.startsWith("-")){
        try{
        int decimal = Integer.parseInt(input.substring(1),16);
        return -decimal;
        }catch(NumberFormatException e){
            System.err.println("your number over flows");
        }
        }else{
            System.out.println("your binary number just 0-1");
            System.out.println("please enter again");
        }
        }     
     }
     public static String  outBinary(int n  ){
      StringBuilder sb = new StringBuilder();
      if(n ==0 ){
      return "0";
      }
      if(n>0){
      while(n>0){
      int a = n%2;
      sb.append(a);
      n = n/2;
      }
      return sb.reverse().toString() ;
      }
      int x = -(n+1);
      if(x ==0 ){
      sb.append('0');
      }else{
      while(x>0){
      
      }
      }
     }
     public static int outDecimal (int n ){
     return n ;
     
     }
     public static String outHexa(int n ){
     return Integer.toHexString(n).toUpperCase();
     
     }
    public static void main(String[] args) {
        // TODO code application logic here
        String choice  ;
        int n = 0 ;
        do{
            System.out.println("====Change base number======");
            System.out.println(" 1 : binary");
            System.out.println("2: decimal");
            System.out.println("3: hexadecimal ");
            System.out.println("4: exit ");
            System.out.println("choose input base (1-3) or exit (4)");
            choice = sc.nextLine();
            int a = Integer.parseInt(choice);
             switch(a){
                case 1 :
                
                n = checkBinary();
                break ; 
                case 2 :
                
                n = checkDecimal();
                break;
                case 3 :
               
                n = checkHexa();
                break;
                case 4:
              return ;  
                default:
                    System.out.println("ban da nhap sai chuong trinh se khoi dong lau  ");
                    break;
             }
             System.out.println("choose output base (1-3) or exit (4)");
             String outChoice = sc.nextLine();
             int b = Integer.parseInt(outChoice);
            switch(b){
                case 1 :
                    System.out.println("out put binary is"+ outBinary(n));
               
                break ; 
                case 2 :
              System.out.println("out put decimal is"+ outDecimal(n));
                break;
                case 3 :
                 System.out.println("out put hexadecimal  is"+ outHexa(n));
                break;
                case 4:
                return ;    
                default:
                    System.out.println("ban da nhap sai chuong trinh se khoi dong lai  ");
                    break;
            }
             }while(true);
        }
    }
    

