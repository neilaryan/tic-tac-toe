import java.util.Scanner;


class PlayingBoard

 public class PlayingBoard {

 private static String[] positions = new String[9];

 private static String[] winPositions = new String[8];

 public static boolean gameWon;

 public static void setWinPositions(){

   //first line horizontal
     if(gameBoard.charAt(23)==gameBoard.charAt(29)){
       if(gameBoard.charAt(23)==gameBoard.charAt(35)){
         gameWon=true;
       }
     }

   //first line vertical
   if(gameBoard.charAt(23)==gameBoard.charAt(63)){
     if(gameBoard.charAt(23)==gameBoard.charAt(103)){
       gameWon=true;
     }
   }

   //second line horizontal
   if(gameBoard.charAt(63)==gameBoard.charAt(69)){
     if(gameBoard.charAt(63)==gameBoard.charAt(75)){
       gameWon=true;
     }
   }

   //second line vertical
   if(gameBoard.charAt(29)==gameBoard.charAt(69)){
     if(gameBoard.charAt(69)==gameBoard.charAt(109)){
       gameWon=true;
     }
   }

   //third line horizontal
   if(gameBoard.charAt(103)==gameBoard.charAt(109)){
     if(gameBoard.charAt(103)==gameBoard.charAt(115)){
       gameWon=true;
     }
   }

   //third line vertical
   if(gameBoard.charAt(35)==gameBoard.charAt(75)){
     if(gameBoard.charAt(35)==gameBoard.charAt(115)){
       gameWon=true;
     }
   }

   //diagonal to the right
   if(gameBoard.charAt(23)==gameBoard.charAt(69)){
     if(gameBoard.charAt(23)==gameBoard.charAt(115)){
       gameWon=true;
     }
   }

   //diagonal to the left
   if(gameBoard.charAt(35)==gameBoard.charAt(69)){
     if(gameBoard.charAt(35)==gameBoard.charAt(103)){
       gameWon=true;
     }
   }
 }

 private static int size=0;

 protected static String board =
      "___________________\n"
     +":  1  :  2  :  3  :\n"
     +"___________________\n"
     +":  4  :  5  :  6  :\n"
     +"___________________\n"
     +":  7  :  8  :  9  :\n"
     +"___________________\n";

 protected static String gameBoard;

 public static String newBoard(){
   gameBoard = board;
     return gameBoard;
 }


 public static boolean checkValidPosition(String position){
   for (int i = 0; i < positions.length; i++){
     if(positions[i].equals(position)){
       return false;
     }
   }
   positions[size]=position;
   size++;
   return true;
 }

public static boolean checkValidNumber(String number){
 if(number.equals("1")){
   return true;
 }

 if(number.equals("2")){
   return true;
 }

 if(number.equals("3")){
   return true;
 }

 if(number.equals("4")){
   return true;
 }

 if(number.equals("5")){
   return true;
 }
 if(number.equals("6")){
   return true;
 }

 if(number.equals("7")){
   return true;
 }

 if(number.equals("8")){
   return true;
 }
 if(number.equals("9")){
   return true;
 }


 return false;
}

 public static String changeBoard(Player player, Scanner scnr, String symbol){
   if(!Player.isTurn){
     return"It is not this players turn.";
   }
   System.out.println("Please type what position you would like to take on the board.");
   String userInput = scnr.next();
   if(!checkValidNumber(userInput)){
     System.out.println("Invalid character, please select a number between 1-9.");
     return changeBoard(player,scnr,symbol);
   }
   if(!checkValidPosition(userInput)){
     System.out.println("Invalid location, please select an open space.");
     return changeBoard(player,scnr,symbol);
   }else{
     gameBoard=gameBoard.replace(userInput,symbol);
   }
   return gameBoard;
 }

 public static void main(String[] args) {
   System.out.println(newBoard());
   Scanner scnr =new Scanner(System.in);
   Player player1 = new Player();
   Player player2 = new Player();
   for (int i = 0; i < positions.length; i++) {
     positions[i]="";
   }
   for (int i = 0; i < 14;i=i+3) {
     player1.setTurn(player1);
     System.out.println(changeBoard(player1, scnr, "X" ));
     setWinPositions();
     if(gameWon){
       System.out.println("We have a winner!: Player 1! (X)");
       break;
     }
     player2.setTurn(player1);
     System.out.println(changeBoard(player2, scnr, "O" ));
     setWinPositions();
     if(gameWon){
       System.out.println("We have a winner:  Player 2!(O)");
       break;
     }
   }
 }
}
