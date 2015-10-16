
import java.util.*;
public class BaronCard extends Card{

public static final String BARON_NAME = "Baron";
public static final int BARON_VALUE = 3;
public static final String BARON_DESC = "Baron forces you and another player into a faceoff, showing eachother your cards\nwhichever card is the lowest is out of the round";
public static final boolean BARON_SELF_TARGET = false;
private Player selectedPlayer;
public BaronCard(){
    super(BARON_NAME, BARON_VALUE, BARON_DESC, BARON_SELF_TARGET);
  }
  public void action(Player activePlayer,  PlayersList players, Deck deck){
    new ArrayList<Integer>();
    System.out.println(BARON_DESC);
    selectedPlayer = selectPlayer(activePlayer, players, BARON_SELF_TARGET); //allows for targeting of cards
    if (selectedPlayer.getPlayerNumber() == activePlayer.getPlayerNumber() && !BARON_SELF_TARGET){    //if the only remaining target is self, and self isn't targetable
    }
    else{
      System.out.println("You have a " + activePlayer.getCard());
      System.out.println("and the selected player has a " + selectedPlayer.getCard());
      if (activePlayer.getCard(0).getValue() > selectedPlayer.getCard(0).getValue()){
        System.out.println("Your card is larger. you win and your opponent is knocked out");
        selectedPlayer.eliminate();
      }
      else if (activePlayer.getCard(0).getValue() < selectedPlayer.getCard(0).getValue()){
        System.out.println("Their card is larger. Your opponent wins and you are knocked out");
        activePlayer.eliminate();
      }
      else if (activePlayer.getCard(0).getValue() == selectedPlayer.getCard(0).getValue()){
        System.out.println("You both have the same card, no one is knocked out");
      }
    }
  }

  // public void action(){
  //
  // }
}
