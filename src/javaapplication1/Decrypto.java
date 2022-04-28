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
public class Decrypto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            String input;
            System.out.println("Inserisci pwd di input: ");
            input = scan.nextLine();
            Cripto c = new Cripto(input);
            c.userHandler();      
    }
    
}
