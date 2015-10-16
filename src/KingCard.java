
import java.util.*;
public class KingCard extends Card{

public static final String KING_NAME = "King";
public static final int KING_VALUE = 6;
public static final String KING_DESC = "King lets you see switch with another player\nSelect another player to switch cards\nYou cannot select yourself";
public static final boolean KING_SELF_TARGET = false;
private Player selectedPlayer;
public KingCard(){
    super(KING_NAME, KING_VALUE, KING_DESC, KING_SELF_TARGET);
  }
  public void action(Player activePlayer,  PlayersList players, Deck deck){
    new ArrayList<Integer>();
    System.out.println(KING_DESC);
    selectedPlayer = selectPlayer(activePlayer, players, KING_SELF_TARGET); //allows for targeting of cards
    if (selectedPlayer.getPlayerNumber() == activePlayer.getPlayerNumber() && !KING_SELF_TARGET){    //if the only remaining target is self, and self isn't targetable
    }
    else{     //swaps cards
      Card tempCard = selectedPlayer.discardCard();
      selectedPlayer.takeCard(activePlayer.discardCard());
      System.out.println(selectedPlayer.getName() + " you now have a " + selectedPlayer.getCard());
      activePlayer.takeCard(tempCard);
      System.out.println(activePlayer.getName() + " you now have a " + activePlayer.getCard());
    }
  }

  // public void action(){
  //
  // }
}
