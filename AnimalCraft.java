/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1;

import java.util.Arrays;

/**
 *
 * @author redyr
 */
public class AnimalCraft {
    
    private String hehe[][];
    
    public static void main(String args[]){
        
        
        Space space = new Space();
        
        space.buildSpace();
    
          space.spawn();
          System.out.println("\n" + space.printSpace());
          boolean b = true;
          while(b){
                space.move();
          }
        
    }
    
    
}
