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
public class Ladder {
    private int bottomPosition;
    private int topPosition;
    public Ladder(int t, int b){
        this.topPosition = t;
        this.bottomPosition = b;
    }
    public void setTopPosition(int t){
        this.topPosition = t;
    }

    public void setBottomPosition(int b) {
        this.bottomPosition = b;
    }

    public int getTopPosition() {
        return this.topPosition;
    }

    public int getBottomPosition() {
        return this.bottomPosition;
    }
}
