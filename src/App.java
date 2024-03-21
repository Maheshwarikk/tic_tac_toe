import java.util.Scanner;

import game.Board;
import game.Game;
import game.Player;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("First Project -> Tic Tac Toe");

         Board b = new Board(3,'-');
        
        //  b.printBoardConfig();

         Scanner scn = new Scanner(System.in);
         System.out.println("Enter name for Player 1:");
         String nameP1 = scn.nextLine();
 
         System.out.println("Enter age for Player 1:");
         int ageP1 = scn.nextInt();
         scn.nextLine(); // Consume newline
 
         System.out.println("Enter symbol for Player 1:");
         char symbolP1 = scn.nextLine().charAt(0);
 
         Player P1 = new Player();
         P1.set_player_details(nameP1, ageP1, symbolP1);
         P1.get_player_details();
 
         // Getting details for Player 2
         System.out.println("Enter name for Player 2:");
         String nameP2 = scn.nextLine();
 
         System.out.println("Enter age for Player 2:");
         int ageP2 = scn.nextInt();
         scn.nextLine(); // Consume newline
 
         System.out.println("Enter symbol for Player 2:");
         char symbolP2 = scn.nextLine().charAt(0);
 
         Player P2 = new Player();
         P2.set_player_details(nameP2, ageP2, symbolP2);
         P2.get_player_details();
 
         scn.close(); // Closing scanner

         Player[] players = {P1, P2}; // Array of players
         
         Game game = new Game(players, b);
         game.play(); 
         
     }
    }
       

   
         


    

