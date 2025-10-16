/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab211_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Personal
 */
public class Lab211_2 {
   public static  Scanner sc = new Scanner (System.in);
     public static String Name_VALID="[a-zA-Z]+";
     public static String Int_VALID="[0-9]+";
     public static String Class_VALID="[0-9A-Za-z]+";
     public static String Bool_VALID="[YNyn]";
    public static String input(String mes){
     String input ;
        System.out.println(mes);   
     while(true){
       input = sc.nextLine();
       if(input.matches(Name_VALID)){
       return input ;
       
       }else{
           System.out.println("your input is invalid please enter again");
       }
     }
     
     }
     public static float inputDiem(String mes){
     String input ;
          System.out.println(mes);
     while(true){
       input = sc.nextLine();
       if(input.matches(Class_VALID)&& Float.parseFloat(input)<10){
       return Float.parseFloat(input);
       
       }else{
           System.out.println("your input is invalid please enter again");
       }
     }
     
     }

      public static String inputClass(String mes){
     String input ;
          System.out.println(mes);
     while(true){
       input = sc.nextLine();
       if(input.matches(Class_VALID)){
       return input ;
       
       }else{
           System.out.println("your input is invalid please enter again");
       }
     }
     
     }
      public static String inputBo(String mes){
     String input ;
          System.out.println(mes);
     while(true){
       input = sc.nextLine();
       if(input.matches(Bool_VALID)){
       return input ;
       
       }else{
           System.out.println("your input is invalid please enter again");
       }
     }
       
     }
      public static void callOut(ArrayList<Student> s){
      for(int i = 0 ; i<s.size();i++){
          
          System.out.println("\n =====Student "+i+" perform======");
           System.out.println("AVG: "+ s.get(i).getRate() );
          System.out.println("student name: "+s.get(i).getName());
          System.out.println("AVG: "+ s.get(i).getRate() );
          System.out.println("student class "+s.get(i).getClasses());
         
      }
      }
      public static void percent(ArrayList<Student> s){
      int countA =0 ; int countB=0; int countC=0; int countF =0;
      int total = s.size();
      for(int i = 0 ; i<total ;i++){
      switch(s.get(i).getRate()){
          case "A": countA++; break;
            case "B": countB++; break;
        case "C": countC++; break;
        case "F": countF++; break;
      }
      }
      
            System.out.println("\n ======= Static ======");
      System.out.printf(" Total student: %d\n ",total );
     System.out.printf("A: %.2f%% | B: %.2f%% | C: %.2f%% | F: %.2f%%\\n",
       countA*100.0/ total ,
       countB *100.0/total,
      countC*100.0/total,
       countF*100.0/total
       );   
          
      }
      public static float getAV(float a , float b , float c){
      float tb = (a+b+c)/3;
       return tb;
      }
    public static void main(String[] args) {
        ArrayList<Student> lis  =new ArrayList<>();
        int count=0;
        do{
        String name = input("please enter your student name: ");
        float toan = inputDiem("please enter your student Math");
        float ly  = inputDiem("please enter your student physic");
        float hoa = inputDiem("please enter your student chemis");
        float avg = getAV(toan ,  ly , hoa);
       String classes= inputClass("please enter your class") ;
        Student a = new Student(name,classes,avg);
        lis.add(a);
          String yx= inputBo("do you want to enter more student Y/N").toUpperCase();
            if(yx.equalsIgnoreCase("N")){
            break;
            }
            else{
            count++;
            if(count==10){
            break;
            }
            }
        }while(true);
         callOut(lis);
         percent(lis);
    }
    
}
