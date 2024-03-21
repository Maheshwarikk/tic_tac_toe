package game;

public class Player{
    private 
    String name;
    char symbol;
    int age;
    public String players;
     
   public void set_player_details(String name, int age, char symbol){
     this.name = name;
     this.symbol = symbol;
     this.age = age;
   };

   public void get_player_details(){
     
    System.out.println("player name: " + this.name);
    System.out.println("player  age: " + this.age);
    System.out.println("player symbol: " + this.symbol);

   }

   public String getPlayerName(){
       return this.name;
   
   }

   public char getplayersSymbol(){
     return this.symbol;
   }
  };



