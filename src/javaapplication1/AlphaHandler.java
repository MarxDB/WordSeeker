/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.util.HashMap;
import java.util.HashSet;


/**
 *
 * @author Mars_DB
 */
public class AlphaHandler {
    private HashMap<String, String> alphabets;
    private int nUserAlpha;
    
    public AlphaHandler(){
        this.alphabets = new HashMap();
        this.alphabets.put("AlphaLowers", "abcdefgkhilmnopqrstuvzyxw");
        this.alphabets.put("AlphaUppers", "ABCDEFGKHILMNOPQRSTUVZYXW");
        this.alphabets.put("AlphaDigits", "1234567890");
        this.alphabets.put("AlphaLetters", alphabets.get("AlphaLowers")
                .concat(alphabets.get("AlphaUppers")));
        this.alphabets.put("AlphaTot", alphabets.get("AlphaUppers")
                .concat(alphabets.get("AlphaDigits")));
        this.nUserAlpha = 0;
    }
    
    public void addAlpha(String s){
        this.nUserAlpha++;
        this.alphabets.put("AlphaUser "+this.nUserAlpha, s);        
    }

    public String alphaFinder(String s){
        String alpha = null;        
        
        if(s.chars().anyMatch(Character::isUpperCase) && s.chars().anyMatch(Character::isLowerCase)){
            if(s.chars().anyMatch(Character::isDigit))
                alpha = alphabets.get("AlphaTot");
            else
                alpha = alpha = alphabets.get("AlphaLetters");
        }
        else if(s.chars().anyMatch(Character::isUpperCase))
            alpha = alphabets.get("AlphaUppers");
        else if(s.chars().anyMatch(Character::isLowerCase))
            alpha = alphabets.get("AlphaLowers");
        else
             alpha = alphabets.get("AlphaDigits");
        
        return alpha;
    }
    
    @Override
    public String toString(){
        return "Nome Alfabeto / Simboli\n"+this.alphabets.toString();
    }
}
