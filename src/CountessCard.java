
public class CountessCard extends Card{

public static final String COUNTESS_NAME = "Countess";
public static final int COUNTESS_VALUE = 7;
public static final String COUNTESS_DESC = "Countess cannot be in a hand with either the Prince or King\nIf she is ever in your hand with either of them, you are forced to discard the Countess";
public static final boolean COUNTESS_SELF_TARGET = false;
public CountessCard(){
    super(COUNTESS_NAME, COUNTESS_VALUE, COUNTESS_DESC, COUNTESS_SELF_TARGET);
  }
  public void action(Player activePlayer,  PlayersList players, Deck deck){
    System.out.println(COUNTESS_DESC);
    System.out.println("The Countess leaves your hand without effect");
  }

  public static boolean checkCard(int card1, int card2){ //checks to see if countess and king/prince are in the same hand
    //System.out.println("("+card1+"=="+CountessCard.COUNTESS_VALUE+") || ("+card2+"=="+CountessCard.COUNTESS_VALUE+") && ((("+card1+"=="+KingCard.KING_VALUE+") || ("+card2+"=="+KingCard.KING_VALUE+")) || (("+card1+"=="+PrinceCard.PRINCE_VALUE+") || ("+card2+"=="+PrinceCard.PRINCE_VALUE+")))");
    return (((card1 == CountessCard.COUNTESS_VALUE) || (card2 == CountessCard.COUNTESS_VALUE))
    && (((card1 == KingCard.KING_VALUE) || (card2 == KingCard.KING_VALUE))
    || ((card1 == PrinceCard.PRINCE_VALUE) || (card2 == PrinceCard.PRINCE_VALUE))));
  }
  public static int findCountess(Card card1, Card card2){   //performed after countess king/prince check, returns the countess card
    if (card1.getValue() == CountessCard.COUNTESS_VALUE){
      return 1;
    }
    else {
      return 2;
    }
  }
  // public void action(){
  //
  // }
}
