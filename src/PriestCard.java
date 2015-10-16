
import java.util.*;
public class PriestCard extends Card{

public static final String PRIEST_NAME = "Priest";
public static final int PRIEST_VALUE = 2;
public static final String PRIEST_DESC = "Priest lets you see another players' card\nSelect another player to see their card\nYou cannot select yourself";
public static final boolean PRIEST_SELF_TARGET = false;
private Player selectedPlayer;
public PriestCard(){
    super(PRIEST_NAME, PRIEST_VALUE, PRIEST_DESC, PRIEST_SELF_TARGET);
  }
  public void action(Player activePlayer,  PlayersList players, Deck deck){
    new ArrayList<Integer>();
    System.out.println(PRIEST_DESC);
    selectedPlayer = selectPlayer(activePlayer, players, PRIEST_SELF_TARGET); //allows for targeting of cards
    if (selectedPlayer.getPlayerNumber() == activePlayer.getPlayerNumber() && !PRIEST_SELF_TARGET){    //if the only remaining target is self, and self isn't targetable
    }
    else{
      System.out.println("The selected player has a " + selectedPlayer.getCard(0).getName());
    }
  }

  // public void action(){
  //
  // }
}
