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
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class SnakeAndLadder {
    private ArrayList<Player> players; //Player ambil dari class player, dia berarti arraylistnya jenis player, kalau biasanya bisa int, atau string
    private ArrayList<Snake> snakes;
    private ArrayList<Ladder> ladders;
    private int boardSize;
    private int gameStatus;
    private int nowPlaying;
    public SnakeAndLadder(int s){
        this.boardSize = s;
        this.players = new ArrayList<Player>();
        this.snakes = new ArrayList<Snake>();
        this.ladders = new ArrayList<Ladder>();
        this.gameStatus = 0;
    }

    public void setBoardSize(int s) {
        this.boardSize = s;
    }
    public void setGameStatus(int s){
        this.gameStatus = s;
    }
    public void addPlayer(Player p){
        this.players.add(p);
    }
    public void addSnake(Snake s){
        this.snakes.add(s);
    }

    public void addLadder(Ladder l){
        this.ladders.add(l);
    }
    public void addLadders(int [][] l){
        for(int r = 0; r < l.length; r++){ //banyak ladder
            Ladder ladder = new Ladder(l[r][1], l[r][0]); //1 itu kolom yg mendefinisikan top dari lasdder, 0 itu bottom
            this.ladders.add(ladder);
        }
    }
    public void addSnakes(int [][] s){
        for(int r= 0; r < s.length; r++){ //snakes
            Snake snake = new Snake(s[r][0], s[r][1]); //1 itu kolom yg mendefinisikan head dari snakes, 0 itu tail
            this.snakes.add(snake);
        }
    }
    public int getGameStatus() {
        return this.gameStatus;
    }

    public int getBoardSize(){
        return this.boardSize;
    }
    public ArrayList<Snake> getSnakes(){
        return this.snakes;
    }
    public ArrayList<Ladder> getLadders() {
        return this.ladders;
    }
    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    public void initiateGame(){
        if(boardSize == 100){ //tambahan evan
            int [][] l = {
                    {2,23},
                    {8,24},
                    {20,77},
                    {32,68},
                    {41,79},
                    {74,88},
                    {82,100},
                    {85,95}
            };
            addLadders(l);
            int [][] s = {
                    {5,47},
                    {9,29},
                    {15,39},
                    {25,97},
                    {33,53},
                    {37,62},
                    {54,86},
                    {70,92}
            };
            addSnakes(s);
        }
        if(boardSize == 81){ //tambahan evan
            int [][] l = {
                    {4,32},
                    {17,36},
                    {20,77},
                    {27,48},
                    {54,74},
                    {63,80}
            };
            addLadders(l);
            int [][] s = {
                    {12,21},
                    {34,43},
                    {15,39},
                    {25,97},
                    {35,76}
            };
            addSnakes(s);
        }
        if(boardSize == 64){ //tambahan evan
            int [][] l = {
                    {15,35},
                    {7,39},
                    {41,61},
                    {28,47},
                    {2,14},
                    {47,50}
            };
            addLadders(l);
            int [][] s = {
                    {3,21},
                    {17,47},
                    {27,63}
            };
            addSnakes(s);
        }
        if(boardSize == 49){ //tambahan evan
            int [][] l = {
                    {5,20},
                    {13,28},
                    {19,32},
                    {34,36},
                    {40,47}
            };
            addLadders(l);
            int [][] s = {
                    {4,12},
                    {16,25},
                    {22,33},
                    {29,45},
                    {27,38}
            };
            addSnakes(s);
        }
        if(boardSize == 36){ //tambahan evan
            int [][] l = {
                    {3,16},
                    {7,20},
                    {24,34},
                    {28,31}
            };
            addLadders(l);
            int [][] s = {
                    {5,9},
                    {12,13},
                    {14,22},
                    {23,27},
            };
            addSnakes(s);
        }
        if(boardSize == 25){ //tambahan evan
            int [][] l = {
                    {3,7},
                    {9,20},
                    {13,24},
                    {18,21}
            };
            addLadders(l);
            int [][] s = {
                    {2,10},
                    {5,14},
                    {15,17},
                    {20,23}
            };
            addSnakes(s);
        }
    }
    public void movePlayerAroundOneDice(Player p, int dice){
        p.moveAroundOneDice(dice, this.boardSize);
        for(Ladder l : this.ladders){
            if(p.getPosition() == l.getBottomPosition()){
                System.out.println(GREEN+p.getName()+ " you got Ladder from: " + l.getBottomPosition() + " to "+ l.getTopPosition()+RESET);
                AudioPlayer.playSound("tangga.wav");
                p.setPosition(l.getTopPosition());
            }
        }
        for(Snake s : this.snakes){
            if(p.getPosition() == s.getHeadPosition()){
                System.out.println(RED+p.getName()+ " you got head Snake from: " + s.getHeadPosition() + " slide to " + s.getTailPosition()+RESET);
                AudioPlayer.playSound("ular.wav");
                p.setPosition(s.getTailPosition());
            }
        }
        if(p.getPosition() == this.boardSize){
            this.gameStatus = 2;
        }
    }
    public void movePlayerAroundTwoDice(Player p, int dice1, int dice2){
        p.moveAroundTwoDice(dice1, dice2, this.boardSize);
        for(Ladder l : this.ladders){
            if(p.getPosition() == l.getBottomPosition()){
                System.out.println(GREEN+p.getName()+ " you got Ladder from: " + l.getBottomPosition() + " to "+ l.getTopPosition()+RESET);
                AudioPlayer.playSound("tangga.wav");
                p.setPosition(l.getTopPosition());
            }
        }
        for(Snake s : this.snakes){
            if(p.getPosition() == s.getHeadPosition()){
                System.out.println(RED+p.getName()+ " you got head Snake from: " + s.getHeadPosition() + " slide to " + s.getTailPosition()+RESET);
                AudioPlayer.playSound("ular.wav");
                p.setPosition(s.getTailPosition());
            }
        }
        if(p.getPosition() == this.boardSize){
            this.gameStatus = 2;
        }
    }
    public Player getWhoseTurn(){
        if(this.gameStatus == 0){
            this.gameStatus = 1;
            double r = Math.random();
            if(r <= 0.5) {
                this.nowPlaying = 0;
                return this.players.get(0);
            }
            else {
                this.nowPlaying = 1;
                return this.players.get(1);
            }
        }
        else{
            if (this.nowPlaying == 0) {
                this.nowPlaying = 1;
                return this.players.get(1);
            }
            else {
                this.nowPlaying = 0;
                return this.players.get(0);
            }
        }
    }
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
    public void play(){
        Scanner read = new Scanner(System.in);
        AudioPlayer.playbackSound("backSound.wav");
        System.out.println("Hello Welcome to Snake And Ladder game!");
        System.out.println("Please press enter to start the game!");
        System.out.println(BLUE+"==============================================="+RESET);
        String enter0 = read.nextLine();
        if(enter0.isEmpty()){
            System.out.println("Choose the number of Players: " +"\n" + "1. One Player" + "\n" + "2. Two Player");
            System.out.print("Your choice : ");
            AudioPlayer.playSound("select player.wav");
            String pilihanPlayer = read.nextLine();
            System.out.println(BLUE+"==============================================="+RESET);
            try{
                if(pilihanPlayer.equals("One Player") || pilihanPlayer.equals("1") || pilihanPlayer.equals("One")){ //pilihan vs AI
                    System.out.println("Now, please choose the board size: " +"\n" + "1. 5x5" + "\n" + "2. 6x6" + "\n" + "3. 7x7" + "\n" + "4. 8x8" + "\n" + "5. 9x9" + "\n" + "6. 10x10");
                    AudioPlayer.playSound("choose board.wav");
                    try{
                        System.out.print("Your choice (number of option): ");
                        int arrayOption [] = {1,2,3,4,5,6};
                        int choose = read.nextInt();
                        System.out.println(BLUE+"==============================================="+RESET);
                        if(choose == arrayOption[0]){
                            setBoardSize(25);
                        }
                        else if (choose == arrayOption[1]){
                            setBoardSize(36);
                        }
                        else if (choose == arrayOption[2]){
                            setBoardSize(49);
                        }
                        else if (choose == arrayOption[3]){
                            setBoardSize(64);
                        }
                        else if (choose == arrayOption[4]){
                            setBoardSize(81);
                        }
                        else if (choose == arrayOption[5]){
                            setBoardSize(100);
                        }
                        else {
                            throw new IndexOutOfBoundsException (RED+"You can only input a number from 1 to 6."+RESET); //dia throw ke catch
                        }
                    }catch(InputMismatchException e){
                        System.out.println(RED+"It's not a number. You can only input a number from 1 to 6."+RESET);
                        AudioPlayer.playSound("inputsalah.wav");
                        return;
                    }catch (IndexOutOfBoundsException r){ //nangkap throw di else
                        System.out.println(r.getMessage());
                        AudioPlayer.playSound("inputsalah.wav");
                        return;
                    }
                    try{
                        int numOfRound [] = {1,3,5};
                        System.out.print("Thank you for choosing the board size."+"\n"+
                                BLUE+"This game is using Best Of Game System." +
                                "\n"+"For example you chooose Best Of 3 Games, so you need 2 games to win."+RESET+
                                "\n"+"Now, please choose how many Best of Games do want to play " +
                                "and remember you can only input with a odd number (only 1,3,5)."+"\n"+"Please input here: " );
                        AudioPlayer.playSound("choose round.wav");
                        int roundPlay = read.nextInt();
                        System.out.println(BLUE+"==============================================="+RESET);
                        boolean isRound = false;
                        for(int i=0;i<numOfRound.length;i++){
                            if(roundPlay == numOfRound[i]){
                                isRound = true;
                                break;
                            }
                        }
                        if(!isRound){
                            throw new IllegalArgumentException(RED+"You can only choose number 1, 3, or 5."+RESET);
                        }
                        read.nextLine();
                        System.out.println("Okay, you will play this game for " + roundPlay +" times. Enjoy!");
                        System.out.print("Please enter your name: ");
                        AudioPlayer.playSound("Enter Player 1.wav");
                        String player1 = read.nextLine();
                        System.out.println(BLUE+"==============================================="+RESET);
                        String player2 = "Computer";
                        Player p1 = new Player(player1);
                        Player p2 = new Player(player2);
                        addPlayer(p1);
                        addPlayer(p2);
                        int player1Poin = 0;
                        int player2Poin = 0;
                        try{
                            System.out.println("Select the number of dice do you want: " + "\n" + "1. One Dice" + "\n" + "2. Two Dice");
                            System.out.print("Choose the option (number of option): ");
                            AudioPlayer.playSound("choose dice.wav");
                            int arrayOption [] = {1,2};
                            int diceplay = read.nextInt();
                            boolean isDice = false;
                            for(int i=0;i<arrayOption.length;i++){
                                if(diceplay == arrayOption[i]){
                                    isDice = true;
                                    break;
                                }
                            }
                            if(!isDice){
                                throw new IllegalArgumentException(RED+"You can only input a number from 1 to 2."+RESET);
                            }
                            read.nextLine();
                            System.out.println("You choose " + diceplay + " dice");
                            AudioPlayer.playSound("Lets Start.wav");
                            for(int i = 0; i < roundPlay; i++){
                                System.out.println(PURPLE+"==============================================="+RESET);
                                p1.setPosition(0);
                                p2.setPosition(0);
                                int round = i+1;
                                setGameStatus(1);
                                if(diceplay == arrayOption[0]){
                                    initiateGame();
                                    Player playerInTurn;
                                    do {
                                        playerInTurn = getWhoseTurn();
                                        System.out.println("Player in turn: " + playerInTurn.getName());
                                        System.out.println(playerInTurn.getName() + " please press enter to roll the dice!");
                                        String enter = read.nextLine();
                                        int dice1 = 0;
                                        if(enter.isEmpty()){
                                            dice1= playerInTurn.rollDice();
                                            System.out.println("Dice Number: " + dice1); //tambahan evan
                                            movePlayerAroundOneDice(playerInTurn, dice1); // blom ke run
                                            if(p1.getPosition() == p2.getPosition()){ //tambahan evan
                                                System.out.println("Your Position: " + playerInTurn.getPosition());
                                                playerInTurn.setPosition(0);
                                                System.out.println(RED+"Oh no, you got the same position with another player. Your position will be reset to 0."+RESET);
                                                AudioPlayer.playSound2("PosisiSama.wav");
                                            }
                                            System.out.println("New Position: " + playerInTurn.getPosition());
                                        }
                                        System.out.println(PURPLE+"==============================================="+RESET);

                                    } while (getGameStatus() != 2);
                                    System.out.println(BLUE+"==============================================="+RESET);
                                    System.out.println(YELLOW+"The winner of round " + round +" is: " + playerInTurn.getName()+RESET);
                                    AudioPlayer.playSound("menangronde.wav");
                                    System.out.println(BLUE+"==============================================="+RESET);
                                    if(p1 == playerInTurn){
                                        player1Poin++;
                                        AudioPlayer.playSound("playeronewin.wav");
                                    } else if (p2 == playerInTurn) {
                                        player2Poin++;
                                        AudioPlayer.playSound("youlose.wav");
                                    }
                                }
                                else if(diceplay == arrayOption[1]){
                                    initiateGame();
                                    Player playerInTurn;
                                    do {
                                        playerInTurn = getWhoseTurn();
                                        System.out.println("Player in turn: " + playerInTurn.getName());
                                        System.out.println(playerInTurn.getName() + " please press enter to roll the dice!");
                                        String enter = read.nextLine();
                                        int dice1 = 0;
                                        int dice2 = 0;
                                        int totaldice = 0;
                                        if(enter.isEmpty()){
                                            dice1= playerInTurn.rollDice();
                                            System.out.println("Dice 1 Number: " + dice1); //tambahan evan
                                            dice2 = playerInTurn.rollDice();
                                            System.out.println("Dice 2 Number: " + dice2);
                                            totaldice = dice1 + dice2;
                                            System.out.println("Your move based on 2 dices: " + totaldice);
                                            movePlayerAroundTwoDice(playerInTurn, dice1, dice2); // blom ke run
                                            if(p1.getPosition() == p2.getPosition()){ //tambahan evan
                                                System.out.println("Your Position: " + playerInTurn.getPosition());
                                                playerInTurn.setPosition(0);
                                                System.out.println(RED+"Oh no, you got the same position with another player. Your position will be reset to 0."+RESET);
                                                AudioPlayer.playSound2("PosisiSama.wav");
                                            }
                                            System.out.println("New Position: " + playerInTurn.getPosition());
                                            if(dice1 == dice2 && getGameStatus() != 2){//tambahan evan
                                                dice1 = 0;
                                                dice2 = 0;
                                                totaldice = 0;
                                                System.out.println(CYAN+"You got the same value of Dices. It's your turn again!! " + playerInTurn.getName() + " please press enter again to roll the dice!"+RESET);
                                                AudioPlayer.playSound("double.wav");
                                                String enter2 = read.nextLine();
                                                dice1= playerInTurn.rollDice();
                                                System.out.println("Dice 1 Number: " + dice1); //tambahan evan
                                                dice2 = playerInTurn.rollDice();
                                                System.out.println("Dice 2 Number: " + dice2);
                                                totaldice = dice1 + dice2;
                                                System.out.println("Your move based on 2 dices: " + totaldice);
                                                movePlayerAroundTwoDice(playerInTurn, dice1, dice2); // blom ke run
                                                if(p1.getPosition() == p2.getPosition()){ //tambahan evan
                                                    System.out.println("Your Position: " + playerInTurn.getPosition());
                                                    playerInTurn.setPosition(0);
                                                    System.out.println(RED+"Oh no, you got the same position with another player. Your position will be reset to 0."+RESET);
                                                    AudioPlayer.playSound2("PosisiSama.wav");
                                                }
                                                System.out.println("New Position: " + playerInTurn.getPosition());
                                            }
                                            System.out.println(PURPLE+"==============================================="+RESET);
                                        }

                                    } while (getGameStatus() != 2);
                                    System.out.println(BLUE+"==============================================="+RESET);
                                    System.out.println(YELLOW+"The winner of round " + round +" is: " + playerInTurn.getName()+RESET);
                                    AudioPlayer.playSound("menangronde.wav");
                                    System.out.println(BLUE+"==============================================="+RESET);
                                    if(p1 == playerInTurn){
                                        player1Poin++;
                                        AudioPlayer.playSound("playeronewin.wav");
                                    } else if (p2 == playerInTurn) {
                                        player2Poin++;
                                        AudioPlayer.playSound("playertwowin.wav");
                                    }
                                }
                                if(player1Poin == 2 && roundPlay == 3){ //cek untuk 3 ronde player 1
                                    setGameStatus(2);
                                    System.out.println(GREEN+"The winner of this game is: " + p1.getName() + " with score " + player1Poin + "-" +player2Poin+RESET);
                                    AudioPlayer.playSound2("MenangGame.wav");
                                    break;
                                }
                                else if(player2Poin == 2 && roundPlay == 3){ //cek untuk 3 ronde player 2
                                    setGameStatus(2);
                                    System.out.println(GREEN+"The winner of this game is: " + p2.getName() + " with score " + player2Poin + "-" +player1Poin+RESET);
                                    AudioPlayer.playSound2("MenangGame.wav");
                                    break;
                                }
                                else if(player1Poin == 1 && roundPlay == 1) { //cek untuk 1 ronde player 1
                                    setGameStatus(2);
                                    System.out.println(GREEN+"The winner of this game is: " + p1.getName() + " with score " + player1Poin + "-" + player2Poin+RESET);
                                    AudioPlayer.playSound2("MenangGame.wav");
                                    break;
                                }
                                else if(player2Poin == 1 && roundPlay == 1) { //cek untuk 1 ronde player 2
                                    setGameStatus(2);
                                    System.out.println(GREEN+"The winner of this game is: " + p2.getName() + " with score " + player2Poin + "-" + player1Poin+RESET);
                                    AudioPlayer.playSound2("MenangGame.wav");
                                    break;
                                }
                                else if(player1Poin == 3 && roundPlay == 5){ //cek untuk 5 ronde player 1
                                    setGameStatus(2);
                                    System.out.println(GREEN+"The winner of this game is: " + p1.getName() + " with score " + player1Poin + "-" +player2Poin+RESET);
                                    AudioPlayer.playSound2("MenangGame.wav");
                                    break;
                                }
                                else if(player2Poin == 3 && roundPlay == 5){ //cek untuk 5 ronde player 2
                                    setGameStatus(2);
                                    System.out.println(GREEN+"The winner of this game is: " + p2.getName() + " with score " + player2Poin + "-" +player1Poin+RESET);
                                    AudioPlayer.playSound2("MenangGame.wav");
                                    break;
                                }
                            }
                        }catch(InputMismatchException a){
                            System.out.println(RED+"It's not a number. You can only input a number from 1 to 2."+RESET);
                            AudioPlayer.playSound("inputsalah.wav");
                            return;
                        }catch (IllegalArgumentException b){
                            System.out.println(b.getMessage());
                            AudioPlayer.playSound("inputsalah.wav");
                            return;
                        }
                    }catch (InputMismatchException e){
                        System.out.println(RED+"It's not a number. You can only choose number 1, 3, or 5."+RESET);
                        AudioPlayer.playSound("inputsalah.wav");
                        return;
                    }catch (IllegalArgumentException r){
                        System.out.println(r.getMessage());
                        AudioPlayer.playSound("inputsalah.wav");
                        return;
                    }

                } else if (pilihanPlayer.equals("Two Player") || pilihanPlayer.equals("2") || pilihanPlayer.equals("Two")) { //vs player
                    System.out.println("Now, please choose the board size: " +"\n" + "1. 5x5" + "\n" + "2. 6x6" + "\n" + "3. 7x7" + "\n" + "4. 8x8" + "\n" + "5. 9x9" + "\n" + "6. 10x10");
                    AudioPlayer.playSound("choose board.wav");
                    try{
                        System.out.print("Your choice (number of option): ");
                        int arrayOption [] = {1,2,3,4,5,6};
                        int choose = read.nextInt();
                        System.out.println(BLUE+"==============================================="+RESET);
                        if(choose == arrayOption[0]){
                            setBoardSize(25);
                        }
                        else if (choose == arrayOption[1]){
                            setBoardSize(36);
                        }
                        else if (choose == arrayOption[2]){
                            setBoardSize(49);
                        }
                        else if (choose == arrayOption[3]){
                            setBoardSize(64);
                        }
                        else if (choose == arrayOption[4]){
                            setBoardSize(81);
                        }
                        else if (choose == arrayOption[5]){
                            setBoardSize(100);
                        }
                        else {
                            throw new IndexOutOfBoundsException (RED+"You can only input a number from 1 to 6."+RESET); //dia throw ke catch
                        }
                    }catch(InputMismatchException e){
                        System.out.println(RED+"It's not a number. You can only input a number from 1 to 6."+RESET);
                        AudioPlayer.playSound("inputsalah.wav");
                        return;
                    }catch (IndexOutOfBoundsException r){ //nangkan throw di else
                        System.out.println(r.getMessage());
                        AudioPlayer.playSound("inputsalah.wav");
                        return;

                    }
                    try{
                        int numOfRound [] = {1,3,5};
                        System.out.print("Thank you for choosing the board size."+"\n"+
                                BLUE+"This game is using Best Of Game System." +
                                "\n"+"For example you chooose Best Of 3 Games, so you need 2 games to win."+RESET+
                                "\n"+"Now, please choose how many Best of Games do want to play " +
                                "and remember you can only input with a odd number (only 1,3,5)."+"\n"+"Please input here: " );
                        AudioPlayer.playSound("choose round.wav");
                        int roundPlay = read.nextInt();
                        System.out.println(BLUE+"==============================================="+RESET);
                        boolean isRound = false;
                        for(int i=0;i<numOfRound.length;i++){
                            if(roundPlay == numOfRound[i]){
                                isRound = true;
                                break;
                            }
                        }
                        if(!isRound){
                            throw new IllegalArgumentException(RED+"You can only choose number 1, 3, or 5."+RESET);
                        }
                        read.nextLine();
                        System.out.println("Okay, you will play this game for " + roundPlay +" times. Enjoy!");
                        System.out.print("Please enter player 1: ");
                        AudioPlayer.playSound("Enter Player 1.wav");
                        String player1 = read.nextLine();
                        System.out.println(BLUE+"==============================================="+RESET);
                        System.out.print("Please enter player 2: ");
                        AudioPlayer.playSound("Enter Player 2.wav");
                        String player2 = read.nextLine();
                        System.out.println(BLUE+"==============================================="+RESET);
                        Player p1 = new Player(player1);
                        Player p2 = new Player(player2);
                        addPlayer(p1);
                        addPlayer(p2);
                        int player1Poin = 0;
                        int player2Poin = 0;
                        try{
                            System.out.println("Select the number of dice do you want: " + "\n" + "1. One Dice" + "\n" + "2. Two Dice");
                            System.out.print("Choose the option (number of option): ");
                            AudioPlayer.playSound("choose dice.wav");
                            int arrayOption [] = {1,2};
                            int diceplay = read.nextInt();
                            System.out.println(BLUE+"==============================================="+RESET);
                            boolean isDice = false;
                            for(int i=0;i<arrayOption.length;i++){
                                if(diceplay == arrayOption[i]){
                                    isDice = true;
                                    break;
                                }
                            }
                            if(!isDice){
                                throw new IllegalArgumentException(RED+"You can only input a number from 1 to 2."+RESET);
                            }
                            read.nextLine();
                            System.out.println("You choose " + diceplay + " dice");
                            AudioPlayer.playSound("Lets Start.wav");
                            for(int i = 0; i < roundPlay; i++){
                                p1.setPosition(0);
                                p2.setPosition(0);
                                System.out.println(PURPLE+"==============================================="+RESET);
                                int round = i+1;
                                setGameStatus(1);
                                if(diceplay == arrayOption[0]){
                                    initiateGame();
                                    Player playerInTurn;
                                    do {
                                        playerInTurn = getWhoseTurn();
                                        playerInTurn.setPosition(0);
                                        System.out.println("Player in turn: " + playerInTurn.getName());
                                        System.out.println(playerInTurn.getName() + " please press enter to roll the dice!");
                                        String enter = read.nextLine();
                                        int dice1 = 0;
                                        if(enter.isEmpty()){
                                            dice1= playerInTurn.rollDice();
                                            System.out.println("Dice Number: " + dice1); //tambahan evan
                                            movePlayerAroundOneDice(playerInTurn, dice1); // blom ke run
                                            if(p1.getPosition() == p2.getPosition()){ //tambahan evan
                                                System.out.println("Your Position: " + playerInTurn.getPosition());
                                                playerInTurn.setPosition(0);
                                                System.out.println(RED+"Oh no, you got the same position with another player. Your position will be reset to 0."+RESET);
                                                AudioPlayer.playSound2("PosisiSama.wav");
                                            }
                                            System.out.println("New Position: " + playerInTurn.getPosition());
                                        }
                                        System.out.println(PURPLE+"==============================================="+RESET);

                                    } while (getGameStatus() != 2);
                                    System.out.println(BLUE+"==============================================="+RESET);
                                    System.out.println(YELLOW+"The winner of round " + round +" is: " + playerInTurn.getName()+RESET);
                                    AudioPlayer.playSound("menangronde.wav");
                                    System.out.println(BLUE+"==============================================="+RESET);
                                    if(p1 == playerInTurn){
                                        player1Poin++;
                                        AudioPlayer.playSound("playeronewin.wav");
                                    } else if (p2 == playerInTurn) {
                                        player2Poin++;
                                        AudioPlayer.playSound("playertwowin.wav");
                                    }
                                }
                                else if(diceplay == arrayOption[1]){
                                    initiateGame();
                                    Player playerInTurn;
                                    do {
                                        playerInTurn = getWhoseTurn();
                                        System.out.println("Player in turn: " + playerInTurn.getName());
                                        System.out.println(playerInTurn.getName() + " please press enter to roll the dice!");
                                        String enter = read.nextLine();
                                        int dice1 = 0;
                                        int dice2 = 0;
                                        int totaldice = 0;
                                        if(enter.isEmpty()){
                                            dice1= playerInTurn.rollDice();
                                            System.out.println("Dice 1 Number: " + dice1); //tambahan evan
                                            dice2 = playerInTurn.rollDice();
                                            System.out.println("Dice 2 Number: " + dice2);
                                            totaldice = dice1 + dice2;
                                            System.out.println("Your move based on 2 dices: " + totaldice);
                                            movePlayerAroundTwoDice(playerInTurn, dice1, dice2); // blom ke run
                                            if(p1.getPosition() == p2.getPosition()){ //tambahan evan
                                                System.out.println("Your Position: " + playerInTurn.getPosition());
                                                playerInTurn.setPosition(0);
                                                System.out.println(RED+"Oh no, you got the same position with another player. Your position will be reset to 0."+RESET);
                                                AudioPlayer.playSound2("PosisiSama.wav");
                                            }
                                            System.out.println("New Position: " + playerInTurn.getPosition());
                                            if(dice1 == dice2 && getGameStatus() != 2){//tambahan evan
                                                dice1 = 0;
                                                dice2 = 0;
                                                totaldice = 0;
                                                System.out.println(CYAN+"You got the same value of Dices. It's your turn again!! " + playerInTurn.getName() + " please press enter again to roll the dice!"+RESET);
                                                AudioPlayer.playSound("double.wav");
                                                String enter2 = read.nextLine();
                                                dice1= playerInTurn.rollDice();
                                                System.out.println("Dice 1 Number: " + dice1); //tambahan evan
                                                dice2 = playerInTurn.rollDice();
                                                System.out.println("Dice 2 Number: " + dice2);
                                                totaldice = dice1 + dice2;
                                                System.out.println("Your move based on 2 dices: " + totaldice);
                                                movePlayerAroundTwoDice(playerInTurn, dice1, dice2); // blom ke run
                                                if(p1.getPosition() == p2.getPosition()){ //tambahan evan
                                                    System.out.println("Your Position: " + playerInTurn.getPosition());
                                                    playerInTurn.setPosition(0);
                                                    System.out.println(RED+"Oh no, you got the same position with another player. Your position will be reset to 0."+RESET);
                                                    AudioPlayer.playSound2("PosisiSama.wav");
                                                }
                                                System.out.println("New Position: " + playerInTurn.getPosition());
                                            }
                                            System.out.println(PURPLE+"==============================================="+RESET);
                                        }

                                    } while (getGameStatus() != 2);
                                    System.out.println(BLUE+"==============================================="+RESET);
                                    System.out.println(YELLOW+"The winner of round " + round +" is: " + playerInTurn.getName()+RESET);
                                    AudioPlayer.playSound("menangronde.wav");
                                    System.out.println(BLUE+"==============================================="+RESET);
                                    if(p1 == playerInTurn){
                                        player1Poin++;
                                        AudioPlayer.playSound("playeronewin.wav");
                                    } else if (p2 == playerInTurn) {
                                        player2Poin++;
                                        AudioPlayer.playSound("playertwowin.wav");
                                    }
                                }
                                if(player1Poin == 2 && roundPlay == 3){ //cek untuk 3 ronde player 1
                                    setGameStatus(2);
                                    System.out.println(GREEN+"The winner of this game is: " + p1.getName() + " with score " + player1Poin + "-" +player2Poin+RESET);
                                    AudioPlayer.playSound2("MenangGame.wav");
                                    break;
                                }
                                else if(player2Poin == 2 && roundPlay == 3){ //cek untuk 3 ronde player 2
                                    setGameStatus(2);
                                    System.out.println(GREEN+"The winner of this game is: " + p2.getName() + " with score " + player2Poin + "-" +player1Poin+RESET);
                                    AudioPlayer.playSound2("MenangGame.wav");
                                    break;
                                }
                                else if(player1Poin == 1 && roundPlay == 1) { //cek untuk 1 ronde player 1
                                    setGameStatus(2);
                                    System.out.println(GREEN+"The winner of this game is: " + p1.getName() + " with score " + player1Poin + "-" + player2Poin+RESET);
                                    AudioPlayer.playSound2("MenangGame.wav");
                                    break;
                                }
                                else if(player2Poin == 1 && roundPlay == 1) { //cek untuk 1 ronde player 2
                                    setGameStatus(2);
                                    System.out.println(GREEN+"The winner of this game is: " + p2.getName() + " with score " + player2Poin + "-" + player1Poin+RESET);
                                    AudioPlayer.playSound2("MenangGame.wav");
                                    break;
                                }
                                else if(player1Poin == 3 && roundPlay == 5){ //cek untuk 5 ronde player 1
                                    setGameStatus(2);
                                    System.out.println(GREEN+"The winner of this game is: " + p1.getName() + " with score " + player1Poin + "-" +player2Poin+RESET);
                                    AudioPlayer.playSound2("MenangGame.wav");
                                    break;
                                }
                                else if(player2Poin == 3 && roundPlay == 5){ //cek untuk 5 ronde player 2
                                    setGameStatus(2);
                                    System.out.println(GREEN+"The winner of this game is: " + p2.getName() + " with score " + player2Poin + "-" +player1Poin+RESET);
                                    AudioPlayer.playSound2("MenangGame.wav");
                                    break;
                                }
                            }
                        }catch(InputMismatchException a){
                            System.out.println(RED+"It's not a number. You can only input a number from 1 to 2."+RESET);
                            AudioPlayer.playSound("inputsalah.wav");
                            return;
                        }catch (IllegalArgumentException b){
                            System.out.println(b.getMessage());
                            AudioPlayer.playSound("inputsalah.wav");
                            return;
                        }
                    }catch (InputMismatchException e){
                        System.out.println(RED+"It's not a number. You can only choose number 1, 3, or 5."+RESET);
                        AudioPlayer.playSound("inputsalah.wav");
                        return;
                    }catch (IllegalArgumentException r){
                        System.out.println(r.getMessage());
                        AudioPlayer.playSound("inputsalah.wav");
                        return;
                    }
                }
                else{
                    throw new IllegalArgumentException(RED+"Only input based on the option!"+RESET);
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                AudioPlayer.playSound("inputsalah.wav");
                return;
            }
        }
        else{
            System.out.println(RED+"You must press enter!"+RESET);
            AudioPlayer.playSound("inputsalah.wav");
        }
    }
}
