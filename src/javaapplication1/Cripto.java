/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author studente
 */
public class Cripto {
    private int pwdStringIndex;
    private final Scanner scan;
    final private String input;
    private boolean ctrlWhile;
    
    public Cripto(String input){
        this.input = input;
        this.scan = new Scanner(System.in);
        this.pwdStringIndex = 0;
        this.ctrlWhile = false;
    }
    
    public void toCrypt(){
        StringBuffer sb = new StringBuffer("a");        
        String pwdRange = null;
        long stopTime;
        
        System.out.println("1) OnlyAlpha\n2) OnlyNumbers\n3) Mix");       
        int check = scan.nextInt();

        switch(check){
            case 1:
                pwdRange = "abcdefghilmnopqrstuvzxyjABCDEFGHILMNOPQRSTUVZXYJ";
                System.out.println(""+pwdRange);
                break;
        case 2:
                pwdRange = "1234567890";
                System.out.println(""+pwdRange);
                break;
        case 3:
                pwdRange = "abcdefghilmnopqrstuvzxyjABCDEFGHILMNOPQRSTUVZXYJ1234567890";
                System.out.println(""+pwdRange.toString());
                break;
        }        

        System.out.println("alfabeto lunghezza: "+(pwdRange.length()));

        long startTime = System.currentTimeMillis();
        System.out.println("Attendere..");
        while(!ctrlWhile){            
            for(int i = 0; i < pwdRange.length(); i++){
                sb.setCharAt(this.pwdStringIndex, pwdRange.charAt(i));
                
                if(sb.toString().equals(this.input)){
                    stopTime = System.currentTimeMillis();
                    System.out.println("Trovato! "+sb.toString()+"\nTempo impiegato: "+(stopTime - startTime)+" millisec");
                    ctrlWhile = true;
                    break;
                }
            }
            sb = rec(sb, pwdRange, sb.length()-1, startTime);
            if(sb.toString().equals(this.input)){
                    break;
                }
        }
    }

    private StringBuffer rec(StringBuffer sb, String pwdRange, int i, long startTime){
            
        if(sb.charAt(i) == pwdRange.charAt(pwdRange.length()-1)){
            sb.setCharAt(i, pwdRange.charAt(0));
            if(sb.toString().equals(this.input)){
                    long stopTime = System.currentTimeMillis();
                    System.out.println("Trovato! "+sb.toString()+"\nTempo impiegato: "+(stopTime - startTime)+" millisec");
                    ctrlWhile = true;
                }
            if(i >= 1)
                sb = rec(sb, pwdRange, i-1, startTime);
            else{
                sb.append(pwdRange.charAt(0));
                if(sb.toString().equals(this.input)){
                    long stopTime = System.currentTimeMillis();
                    System.out.println("Trovato! "+sb.toString()+"\nTempo impiegato: "+(stopTime - startTime)+" millisec");
                    ctrlWhile = true;
                }
                this.pwdStringIndex++;
            }                
        }else{
            sb.setCharAt(i, pwdRange.charAt(pwdRange.indexOf(sb.charAt(i))+1));
            if(sb.toString().equals(this.input)){
                long stopTime = System.currentTimeMillis();
                System.out.println("Trovato! "+sb.toString()+"\nTempo impiegato: "+(stopTime - startTime)+" millisec");
                ctrlWhile = true;
            }
        }
        return sb;
    }
}
