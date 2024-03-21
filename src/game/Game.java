package game;
import game.Player;
import game.Board;


import java.util.Scanner;

public class Game {
   Player [] players;
   Board board;
   int turn;
   int no_of_moves;
   boolean gameOver;
   String zero;
   String cross;


    public Game(Player[] players, Board board){
        this.players = players;
        this.board = board;
        this.turn = 0;
        this.no_of_moves = 0;
        this.gameOver= false;

        StringBuilder z= new StringBuilder();
        StringBuilder c= new StringBuilder();

        for(int i=0; i<board.size;i++){
            z.append('0');
            c.append('X');
        }

        this.zero = z.toString();
        this.cross = c.toString();

    }


    public void printBoardConfig(){
        int sz = this.board.size;
        for(int i=0; i<sz; i++){
          for(int j=0;j<sz;j++){
            System.out.print(board.matrix[i][j] + " ");
          }
          System.out.println();
        }
    }

    public void play(){
        printBoardConfig();
        int sz = board.size;

        while(!gameOver){
          no_of_moves++;
          int idx = gatIndex();

          int row = idx/sz;
          int col = idx % sz;

          board.matrix[row][col] = players[turn].getplayersSymbol();

          if (no_of_moves >= sz*sz){
            System.out.println("Game Draw");
            return;
          }

          if(no_of_moves >= 2*sz-1 && checkCombinations() == true){
            gameOver = true;
            printBoardConfig();
            System.out.println("Winner is:" + players[turn].getPlayerName());
            return;
          }

          turn = (turn + 1) % 2;
          printBoardConfig();
        }
    }

    public int gatIndex(){
      while (true) {
        
        System.out.println("Player:" + players[turn].getPlayerName() +  "give one postion");
        Scanner scn = new Scanner(System.in);
        int pos = scn.nextInt()-1;
        

        int sz = board.size;

        int row = pos/sz;
        int col = pos%sz;

        // checking for invalid position

        if(row <0 || row>=sz || col < 0 || col >= sz ){
           System.out.println("Invalid position");
              continue;
        }

        //// checking for valid position
         if(board.matrix[row][col] != '-'){
            System.out.println("Position already occupied");
            continue;
         }

         return pos;
      }
        
    }

    public boolean checkCombinations(){
      int sz = board.size;

      //rowise

      for(int i=0;i<sz;i++){
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<sz ; j++){
          sb.append(board.matrix[i][j]);
        }

        String pattern = sb.toString();
        if (pattern.equals(zero) || pattern.equals(cross)){
          return true;
        }
      }

      


      //columwise 
      for(int i=0;i<sz;i++){
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<sz ; j++){
          sb.append(board.matrix[j][i]);
        }

        String pattern = sb.toString();
        if (pattern.equals(zero) || pattern.equals(cross)){
          return true;
        }
      }

      
    // for diagonal

    int i=0,j=0;
    StringBuilder sb = new StringBuilder();

    while (i<sz) {
      sb.append(board.matrix[i][j]);
      i++;
      j++;
    }

    String pattern = sb.toString();
    if (pattern.equals(zero) || pattern.equals(cross)){
      return true;
    }

    //anti diagonal 
    i=0;
    j=sz-1;
    sb = new StringBuilder();

    while(i<sz){
      sb.append(board.matrix[i][j]);
      i++;
      j--;
    }

     pattern =    sb.toString();
     if(pattern.equals(zero) || pattern.equals(cross)){
      return true;
     }
      return false;
    }
   
}
