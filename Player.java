class Player
public class Player {
 protected static boolean isTurn;
 public Player(){
   isTurn=false;
 }

 public boolean setTurn(Player player) {
   isTurn=true;
   return isTurn;
 }
 public static String checkTurn() {
   if (isTurn) {
     return "It is currently this players turn";
   }
   return "It is not this players turn";
 }
}

