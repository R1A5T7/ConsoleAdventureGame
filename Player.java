/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author redyr
 */
public class Player extends Space{
    
    private String name;
    private String Island;
    private ArrayList<String> inventory = new ArrayList<>();
    Space space = new Space();
    private int[] playerPosition = new int[2];

    public int[] getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int[] playerPosition) {
        this.playerPosition = playerPosition;
    }
    
    public Player(String n, String i, ArrayList<String> ts){
        this.name = n;
        this.Island = i;
        this.inventory = ts;
    }
    
        public void move(){
        
        int dimension, blocks;
        int player = 1;
        
        System.out.println("Where would like to go Adventurer?\n1.up\n2.left\n3.right\n4.down");
        
        Scanner scan = new Scanner(System.in);
        dimension = scan.nextInt();
        
        System.out.println("How many blocks?");
        blocks = scan.nextInt();
        
        switch(dimension){
            
        }
        
    }
    
}
