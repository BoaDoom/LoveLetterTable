
import java.util.*;
public class PrinceCard extends Card{

public static final String PRINCE_NAME = "Prince";
public static final int PRINCE_VALUE = 5;
public static final String PRINCE_DESC = "Prince forces a player of your choosing to discard their current hand and draw a new card.\nYou can target yourself";
public static final boolean PRINCE_SELF_TARGET = true;
private Player selectedPlayer;
public PrinceCard(){
    super(PRINCE_NAME, PRINCE_VALUE, PRINCE_DESC, PRINCE_SELF_TARGET);
  }
  public void action(Player activePlayer,  PlayersList players, Deck deck){
    new ArrayList<Integer>();
    System.out.println(PRINCE_DESC);
    selectedPlayer = selectPlayer(activePlayer, players, PRINCE_SELF_TARGET); //allows for targeting of cards
    System.out.println(selectedPlayer.getName() + " has discarded a " + selectedPlayer.getCard(0).getName());
      if (selectedPlayer.getCard(0).getValue() == PrincessCard.PRINCESS_VALUE){
        selectedPlayer.getCard(0).action(selectedPlayer, players, deck);
        selectedPlayer.discardCard(0);
      }
      else{
        selectedPlayer.discardCard(0);
        if (deck.size() == 0){
            System.out.println("There were no more cards to draw from, player recieves burn card");
            selectedPlayer.takeCard(deck.getBurnCard());
          }
          else{
            selectedPlayer.takeCard(deck.deal());
          }
      }
  }

  // public void action(){
  //
  // }
}
