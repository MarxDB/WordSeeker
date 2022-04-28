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
    private final AlphaHandler alphaH;
    private final Scanner scan;
    final private String input;
    private boolean ctrlWhile;
    
    public Cripto(String input){
        this.input = input;
        this.scan = new Scanner(System.in);
        this.pwdStringIndex = 0;
        this.ctrlWhile = false;
        this.alphaH = new AlphaHandler();
    }
    
    public void userHandler(){
        String pwdRange = null;
        int ctrlInput = 0;
        String check;
        
        System.out.println("Vuoi inserire un alphabeto in particolare?(si/no)");       
        check = scan.nextLine();
        
        do{
            if(ctrlInput == 1){
                System.out.println("Inserimento non corretto, ripetere: ");
                check = scan.nextLine();
            }

            switch(check.charAt(0)){
                case 's':
                    System.out.println("Inserisci: ");
                    pwdRange = scan.nextLine();
                    this.alphaH.addAlpha(pwdRange);
                    ctrlInput = 0;
                break;
                case 'n':                    
                    pwdRange = this.alphaH.alphaFinder(input);
                    System.out.println("Sono nel caso n");
                    ctrlInput = 0;
                break;
                default:
                    ctrlInput = 1;
                break;
            }
                                                        // pulizia del buffer?
        }while(ctrlInput == 1);
        System.out.println("Alfabeto di riferimento: "+pwdRange);
        System.out.println("Attendere..");
        toCrypt(pwdRange);      
    }
    
    private void toCrypt(String pwdRange){
        StringBuffer sb = new StringBuffer("a");        
        long stopTime;
        long startTime = System.currentTimeMillis();        

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
