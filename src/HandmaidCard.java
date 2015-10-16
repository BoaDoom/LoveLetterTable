
public class HandmaidCard extends Card{

public static final String HANDMAID_NAME = "Handmaid";
public static final int HANDMAID_VALUE = 4;
public static final String HANDMAID_DESC = "Handmaid protects you from being effected by any card until your next turn";
public static final boolean HANDMAID_SELF_TARGET = false;
public HandmaidCard(){
    super(HANDMAID_NAME, HANDMAID_VALUE, HANDMAID_DESC, HANDMAID_SELF_TARGET);
  }
  public void action(Player activePlayer,  PlayersList players, Deck deck){
    System.out.println(HANDMAID_DESC);
    activePlayer.setShieldOn();
  }

  // public void action(){
  //
  // }
}
