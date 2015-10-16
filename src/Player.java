
import java.util.*;

public class Player{
  private boolean active;
  private boolean shielded;
  private int score;
  private int playerNumber;
  private String playerName;
  private ArrayList<Card> currentHand;
  private ArrayList<Card> discardPile;

  public Player(int playerNumber){
    active = true;
    score = 0;
    this.playerName = "Player Number " + (playerNumber + 1);
    this.playerNumber = playerNumber;
    currentHand = new ArrayList<Card>();
    discardPile = new ArrayList<Card>();
  }


  public Card choosePlay(){
    System.out.println("===============================");
    System.out.println(playerName + " it is your turn");
    System.out.println("Card 1: " + getCard(0).getName());
    System.out.println("Card 2: " + getCard(1).getName());

    if(CountessCard.checkCard(currentHand.get(0).getValue(), currentHand.get(1).getValue()))
      {
      return discardCard(CountessCard.findCountess(currentHand.get(0), currentHand.get(1)));
      }
    else{
      return discardCard(InputCheck.check("Choose which card to play, the remainder will be kept", 1, 2, null)-1);
    }
  }


  public Card discardCard(int cardChoice){
    Card card = currentHand.remove(cardChoice);
    System.out.println("Discarded: " + card.getName());
    discardPile.add(card);
    return card;
  }

  public Card discardCard(){
    return currentHand.remove(0);
  }

  public void takeCard(Card card){
    currentHand.add(card);
  }


  public boolean getActive(){
    if (active){
      return true;
    }
    else{
      return false;
    }
  }

  public void setActive(){
    active = true;
  }

  public void eliminate(){
    active = false;
  }
  public void scorePoint(){
    score++;
  }
  public int getScore(){
    return score;
  }

  public String getName(){
    return playerName;
  }

  public int getPlayerNumber(){
    return playerNumber;
  }

  public Card getCard(int num){
    return currentHand.get(num);
  }
  public String getCard(){
    return currentHand.get(0).getName();
  }

  public void setShieldOn(){
    shielded = true;
  }
  public void setShieldOff(){
    shielded = false;
  }
  public boolean getShielded(){
    if (shielded){
      return true;
    }
    else{
      return false;
    }
  }

  public void clearDiscard(){
    discardPile.clear();
  }
  public int totalOfDiscard(){
    int total = 0;
    for(int i=0; i < discardPile.size(); i++){
      total += discardPile.get(i).getValue();
    }
    return total;
  }
  public int handSize()
  {
	  return currentHand.size();
  }



}
