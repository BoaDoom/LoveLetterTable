
import java.util.*;

public class PlayersList
{
  public static final int MINIMUM_PLAYER_COUNT = 2;
  public static final int MAXIMUM_PLAYER_COUNT = 4;
  public static final int PLAYER_COUNT_EXTRA_RULE = 2; //the number of players where an extra set of rules is activated
  private static int totalPlayerNumber; //final player count
  private static int winRequire; //number of round wins to win the game
  private int turnOrder;
  public List<Player> playersArray;

  //constructor
  public PlayersList(int totalPlayerNumber){
    playersArray = new ArrayList<Player>();
    turnOrder = 0;
    PlayersList.totalPlayerNumber = totalPlayerNumber;
    switch (totalPlayerNumber){ //assigns the number of rounds to win the game
      case 2: setWinLimit(7);
      break;
      case 3: setWinLimit(5);
      break;
      case 4: setWinLimit(4);
      break;
    }
    for (int i = 0; i < totalPlayerNumber ; i++){
      playersArray.add(new Player(i));
    }
  }



  //returns true if active players is above miniumum count to continue round
  public boolean checkActive(){
    int activeNumber = 0;
    for(int i=0; i < totalPlayerNumber; i++){ //counts active players
      if (playersArray.get(i).getActive()){
          activeNumber++;
      }
      else{
      }
    }
    if (activeNumber >= MINIMUM_PLAYER_COUNT){ //checks it against minium player count to keep round active
      return true;
    }
    else{
      return false;
    }
  }
  //resets the turn counter to continue the round
  public void endOfTurn(){
    if (turnOrder >= (totalPlayerNumber - 1)){
      this.turnOrder = 0;
    }
    else{
      turnOrder++;

    }
  }

  //calculates the winner based on active players
  public void winnerCalc(){
    ArrayList<Player> finalPlayers = new ArrayList<Player>();
    ArrayList<Player> winnerArray = new ArrayList<Player>();    //makes an array of players and compares subsequent final cards
    for(int i=0; i < playersArray.size(); i++){       //making array list for remaining active players
      if (playersArray.get(i).getActive()){
        finalPlayers.add(playersArray.get(i));
      }
    }
    System.out.println(finalPlayers.size());
    if (finalPlayers.size() == 1){      //if array list of active players is only a size of 1, that player scores a point
      setWinner(finalPlayers.get(0));;
    }
    else{     //if there are multiple pepople still active at the end of the round, compares their last card
      winnerArray.add(finalPlayers.get(0));
      for(int i=1; i < finalPlayers.size(); i++){
        int card1 = winnerArray.get(0).getCard(0).getValue();
        int card2 = finalPlayers.get(i).getCard(0).getValue();
        if (card1 > card2){
          System.out.println("first card is larger");
        }
        else if (card1 < card2){
          winnerArray.clear();
          winnerArray.add(finalPlayers.get(i));
          System.out.println("second card is larger");
        }
        else if (card1 == card2){
          System.out.println("cards are equal");
          winnerArray.add(finalPlayers.get(i));
        }
      }
      if (winnerArray.size() == 1){      //if array list of players with top card is only a size of 1, that player scores a point
        setWinner(winnerArray.get(0));
      }
      else{     //if winner array is larger than one, then there was a tie in card value
        ArrayList<Player> runOffArray = new ArrayList<Player>();    //makes an array of players and compares total discard value
        runOffArray.add(winnerArray.get(0));
        System.out.println("There was a tie in the final cards!");
        for(int i=1; i < winnerArray.size(); i++){
          int discard1 = runOffArray.get(0).totalOfDiscard();
          int discard2 = winnerArray.get(i).totalOfDiscard();
          if (discard1 > discard2){
            System.out.println("first discard pile is larger");
          }
          else if (discard1 < discard2){
            runOffArray.clear();
            runOffArray.add(winnerArray.get(i));
            System.out.println("second discard pile is larger");
          }
          else if (discard1 == discard2){
            System.out.println("discards are equal");
            runOffArray.add(winnerArray.get(i));
          }
        }
        if (runOffArray.size() == 1){      //if array list of players with top card is only a size of 1, that player scores a point
          setWinner(runOffArray.get(0));
        }
        else{
          System.out.println("An exact tie. Wow. Everyone gets points");
          for (int i=0; i < runOffArray.size(); i++){
            setWinner(runOffArray.get(i));
          }
        }

      }
    }

  }

  //returns the active player number whos turn it is
  public int getTurn(){
    return turnOrder;
  }
  public int getWinRequire(){
    return winRequire;
  }

  //sets who last won a round
  public void setWinner(Player winningPlayer){
    winningPlayer.scorePoint();   //scores the player a point
    // lastWinner = winningPlayer;   //sets last winner as last winning player
    turnOrder = winningPlayer.getPlayerNumber();

  }

  //returns the total int length of player array
  public int getTotalPlayers(){
    return totalPlayerNumber;
  }

  //sets points required to win
  public void setWinLimit(int number){
    winRequire = number;
  }
}
