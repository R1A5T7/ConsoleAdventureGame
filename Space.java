/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author redyr
 */
public class Space implements ToolInt{
    
    private char space[][] = new char[20][20];
    private int[] toolCoordinates = new int[3];
    private int[] resourcesCoordinates = new int[3];
    private int[] playerPosition = new int[2];
    private ArrayList<Character> toolInventory = new ArrayList<>();
    private ArrayList<Boolean> playerHas = new ArrayList<>();
    private int treesInInventory = 0;
    private Random rand;

    public ArrayList<Character> getToolInventory() {
        return toolInventory;
    }

    public void setToolInventory(ArrayList<Character> toolInventory) {
        this.toolInventory = toolInventory;
    }

    public int[] getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int[] playerPosition) {
        this.playerPosition = playerPosition;
    }
    
    public int getToolCoordinates(int i) {
        return toolCoordinates[i];
    }

    public void setToolCoordinates(int[] toolCoordinates) {
        this.toolCoordinates = toolCoordinates;
    }
    
    public Space(){
        this.playerPosition[0] = 10;
        this.playerPosition[1] = 10;
    }
    
    public char[][] buildSpace(){
        
        Random random = new Random();
        int randomPick = random.nextInt(this.space.length - 1) - 1;
        int randomAxe = random.nextInt(this.space.length - 1) - 1;
        int randomHammer = random.nextInt(this.space.length - 1) - 1;
        int randomTree = random.nextInt(this.space.length - 1) - 1;
        int randomTree1 = random.nextInt(this.space.length - 1) - 1;
        while(randomAxe == randomHammer || randomHammer == randomPick || randomAxe == randomPick || randomTree == randomPick || randomTree1 == randomTree){
            randomPick = random.nextInt(this.space.length - 1);
            randomAxe = random.nextInt(this.space.length - 1) - 1;
            randomHammer = random.nextInt(this.space.length - 1) - 1;
            randomTree = random.nextInt(this.space.length - 1) - 1;
            randomTree1 = random.nextInt(this.space.length - 1) - 1;
        }
        this.toolCoordinates[0] = randomPick;
        this.toolCoordinates[1] = randomAxe;
        this.toolCoordinates[2] = randomHammer;
        this.playerHas.add(0, false);
        this.playerHas.add(1, false);
        this.playerHas.add(2, false);
        this.resourcesCoordinates[0] = randomTree;
        this.resourcesCoordinates[1] = randomTree1;
        for(int i = 0; i < this.space.length; i++){
            for(int j = 0; j < this.space[i].length; j++){
                if(j == 0 || j == this.space[i].length - 1){
                    this.space[i][j] = '|';
                }else{
                    this.space[i][j] = '_';
                }
                this.space[randomPick][randomPick] = '>';
//                this.toolCoordinates[0] = randomPick;
                this.space[randomAxe][randomAxe] = 'x';
//                this.toolCoordinates[1] = randomPick;
                this.space[randomHammer][randomHammer] = 'P';
                this.space[randomHammer][randomHammer] = 'P';
//                this.toolCoordinates[2] = randomPick;
                this.space[randomTree1][randomTree1] = 't';
                this.space[randomTree][randomTree] = 'T';
            }
            
            System.out.println("");
        }
            setSpace(this.space);
            return this.space;
    }

    public char[][] getSpace() {
        return this.space;
    }
    
    public String printSpace(){
        for(int i = 0; i < this.space.length; i++){
            for(int j = 0; j < this.space.length; j++){
                
                if(i == this.space.length){
                    System.out.println("");
                }
                System.out.print(this.space[i][j]+" ");
            }
            System.out.println();
            
        }
        return "";
    }
    
    public void isPickable(){
        System.out.println(this.toolCoordinates[0] + " " + this.toolCoordinates[1]+ " " + this.toolCoordinates[2]);
        if(this.playerPosition[0] == this.toolCoordinates[0] && this.playerPosition[1] == this.toolCoordinates[0] && this.playerHas.get(0) != true){
                   toolInventory.add('>');
                   playerHas.set(0, true);
            }
        if(this.playerPosition[0] == this.toolCoordinates[1] && this.playerPosition[1] == this.toolCoordinates[1] && this.playerHas.get(1) != true){
                   toolInventory.add('x');
                   playerHas.set(1, true);
            }
        if(this.playerPosition[0] == this.toolCoordinates[2] && this.playerPosition[1] == this.toolCoordinates[2] && this.playerHas.get(2) != true){
                   playerHas.set(2, true);
                   toolInventory.add('P');
            }
    }
    
    public void move(){
        
        isPickable();
        int choice, blocks;
        int player = 1;
        
        System.out.println("Where would like to go Adventurer?\n1.up\n2.left\n3.right\n4.down\n5.Inventory");
        
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();
        
        if(choice < 5){
            System.out.println("How many blocks?");
            blocks = scan.nextInt();
        }
        else{
            blocks = 5;
        }
        
        System.out.println("You have " + this.treesInInventory);
        switch(choice){
            case 1:
               this.space[this.playerPosition[0]][this.playerPosition[1]] = '_';
               this.space[this.playerPosition[0]-blocks][this.playerPosition[1]] = '1';
               this.playerPosition[0] -= blocks;
               System.out.println(this.playerPosition[0] + " " + this.playerPosition[1]);
               isPickable();
               break;
               case 2:
                this.space[this.playerPosition[0]][this.playerPosition[1]] = '_';
                this.space[this.playerPosition[0]][this.playerPosition[1]-blocks] = '1';
                this.playerPosition[1] -= blocks;
                System.out.println(this.playerPosition[0] + " " + this.playerPosition[1]);
               isPickable();
                break;
               case 3:
                this.space[this.playerPosition[0]][this.playerPosition[1]] = '_';
                this.space[this.playerPosition[0]][this.playerPosition[1]+blocks] = '1';
                this.playerPosition[1] += blocks;
                System.out.println(this.playerPosition[0] + " " + this.playerPosition[1]);
               isPickable();
                break;
               case 4:
                this.space[this.playerPosition[0]][this.playerPosition[1]] = '_';
                this.space[this.playerPosition[0]+blocks][this.playerPosition[1]] = '1';
                this.playerPosition[0] += blocks;
                System.out.println(this.playerPosition[0] + " " + this.playerPosition[1]);
               isPickable();
                break;
               case 5:
                    System.out.println(this.toolInventory);   
                    break;
            
        }
        this.printSpace();
        if(playerHas.get(1) == true){
            System.out.println("\n6.Use");
             switch(choice){
                 case 6:
                     if(isChopable()){
                         this.treesInInventory = rand.nextInt(4 - 2) - 2;
                         System.out.println(this.treesInInventory);
                     }
                }       
            }
    }
    
    public char[][] spawn(){
        this.space[10][10] = '1';
        return this.space;
    }

    public void setSpace(char[][] space) {
        this.space = space;
    }

    @Override
    public boolean isBuildable() {
        return false;
        
    }

    @Override
    public boolean isChopable() {
        
        if(this.playerHas.get(1) == true && this.playerPosition[0] == this.resourcesCoordinates[0] && this.playerPosition[1] == this.resourcesCoordinates[0]){
            
            return true;
        }
        
        return false;
    }

    @Override
    public boolean isDigable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}