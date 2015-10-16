
import java.util.*;
import javax.swing.JLabel;
public class Card{
  private int value;
  private String name;
  private ArrayList<Integer> excluded; //list of player numbers inelligible to be target of the action
  private JLabel cardImage;

  public Card(String name, int value, String desc, boolean selfTarget, String fileLocation){
    this.name = name;
    this.value = value;
    this.setCardImage(GraphicsDraw.importImage(fileLocation));
  }

  public void action(Player activePlayer, PlayersList players, Deck deck){
  }

  public Player selectPlayer(Player activePlayer,  PlayersList players, boolean self){
    excluded = new ArrayList<Integer>();
    for (int i=0; i < players.playersArray.size(); i++){ //prints list of availible targets from array
      if (!players.playersArray.get(i).getActive()){ //checks to see if listed player is active
        System.out.println((i+1) +": player is eliminated");
        excluded.add(i);
      }
      else if (activePlayer.getPlayerNumber() == players.playersArray.get(i).getPlayerNumber()){   // checks to see if you are the listed player
        System.out.println((i+1) +": Yourself");
        if (!self){   //check to see if card can be played on yourself or not
          excluded.add(i);    //adds self as an exluded option if unable to play card on self
        }
      }
      else if (players.playersArray.get(i).getShielded()){ //checks to see if listed player is shielded by handmaiden
        System.out.println((i+1) +": player is protected by a Handmaid");
        excluded.add(i);
      }
      else{
        System.out.println((i+1) +": " + players.playersArray.get(i).getName()); //prints player on list's name
      }

    }
    if (excluded.size() == players.playersArray.size()){
      System.out.println("There is no one to use this card on! and you cannot use it on yourself\n the card is discarded without any effect");
      return activePlayer;
    }
    else{
      return players.playersArray.get(InputCheck.check("choose a target", 1, players.playersArray.size(), excluded)-1);

    }
  }


  public String getName(){
    return name;
  }
  public int getValue(){
    return value;
  }

  public JLabel getCardImage() {
	return cardImage;
  }

  public void setCardImage(JLabel cardImage) {
	this.cardImage = cardImage;
  }
}
