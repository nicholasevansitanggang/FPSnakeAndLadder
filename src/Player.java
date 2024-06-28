/**
 * -----------------------------------------------------
 * ES234211 - Programming Fundamental
 * Genap - 2023/2024
 * Group Capstone Project: Snake and Ladder Game
 * -----------------------------------------------------
 * Class    : D
 * Group    : 17
 * Members  :
 * 1. 5026231146 - Nicholas Evan Sitanggang
 * 2. 5026231195 - Ibrahim Amar Alfanani
 * 3. 5026221101 - Rosdiani Adiningsih
 * ------------------------------------------------------
 */
public class Player {
    //name, position
    // rolltheDice()
    // MoveAround()
    private String name;
    private int position;
    Player(String name){
        this.name = name;
        this.position = 0; //constructor (utamanya)
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPosition(int position){
        this.position = position;
    }
    public String getName(){
        return this.name;
    }
    public int getPosition(){
        return this.position;
    }
    public int rollDice(){
        AudioPlayer.playSound("SuaraDadu.wav");
        return (int)(Math.random()*6+1); //6 itu rangenya, 1 itu min angkanya
    }
    public void moveAroundOneDice(int dice1, int boardSize){
        if(this.position + dice1 > boardSize){
            this.position = boardSize - (this.position+dice1)%boardSize; //kalau mau ngubah doang gaperlu return dia returnnya di getPosition
        }
        else{
            this.position += dice1;
        }
    }
    public void moveAroundTwoDice(int dice1, int dice2, int boardSize){
        if(this.position + dice1 + dice2> boardSize){
            this.position = boardSize - (this.position+dice1+dice2)%boardSize; //kalau mau ngubah doang gaperlu return dia returnnya di getPosition
        }
        else{
            this.position += (dice1+dice2);
        }
    }
}
