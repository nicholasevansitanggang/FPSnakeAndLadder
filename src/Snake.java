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
public class Snake {
    private int tailPosition;
    private int headPosition;
    Snake(int t, int h){
        this.tailPosition = t;
        this.headPosition = h;
    }
    public void setTailPosition(int t){
        this.tailPosition = t;
    }
    public void setHeadPosition(int h){
        this.headPosition = h;
    }
    public int getHeadPosition() {
        return headPosition;
    }
    public int getTailPosition() {
        return tailPosition;
    }
}
