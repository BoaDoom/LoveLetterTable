
public class PrincessCard extends Card{

public static final String PRINCESS_NAME = "Princess";
public static final int PRINCESS_VALUE = 8;
public static final String PRINCESS_DESC = "Princess card cannot be discarded at any time\nIf you are ever forced to discard her, you are out of that round";
public static final boolean PRINCESS_SELF_TARGET = false;
public PrincessCard(){
    super(PRINCESS_NAME, PRINCESS_VALUE, PRINCESS_DESC, PRINCESS_SELF_TARGET);
  }
  public void action(Player activePlayer,  PlayersList players, Deck deck){
    System.out.println(PRINCESS_DESC);
    System.out.println(activePlayer.getName() + "You have discarded the Princess, you are elimated from the game");
    activePlayer.eliminate();
  }

  // public void action(){
  //
  // }
}
