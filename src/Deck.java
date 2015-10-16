
import java.util.*;

public class Deck{

  public static final int GUARD_NUMBER = 5;
  //public static final int PRIEST_NUMBER = 2;
  // public static final int BARON_NUMBER = 2;
  // public static final int HANDMAID_NUMBER = 2;
  // public static final int PRINCE_NUMBER = 2;
  // public static final int KING_NUMBER = 1;
  // public static final int COUNTESS_NUMBER = 1;
  // public static final int PRINCESS_NUMBER = 1;
  public static final int EXTRA_RULE_CARD_COUNT = 3;
  private ArrayList<Card> cards;
  private ArrayList<Card> discards;
  private ArrayList<Card> twoPlayerBurn;
  private Card burnCard;


  public Deck(){
    cards = new ArrayList<Card>();
    discards = new ArrayList<Card>();
    twoPlayerBurn = new ArrayList<Card>();
    for (int i=0; i < GUARD_NUMBER; i++){
      cards.add(new GuardCard());
    }
    // for (int i=0; i < PRIEST_NUMBER; i++){
    //   cards.add(new PriestCard());
    // }
    // for (int i=0; i < BARON_NUMBER; i++){
    //   cards.add(new BaronCard());
    // }
    // for (int i=0; i < HANDMAID_NUMBER; i++){
    //   cards.add(new HandmaidCard());
    // }
    // for (int i=0; i < PRINCE_NUMBER; i++){
    //   cards.add(new PrinceCard());
    // }
    // for (int i=0; i < KING_NUMBER; i++){
    //   cards.add(new KingCard());
    // }
    // for (int i=0; i < COUNTESS_NUMBER; i++){
    //   cards.add(new CountessCard());
    // }
    // for (int i=0; i < PRINCESS_NUMBER; i++){
    //   cards.add(new PrincessCard());
    // }
  }
  //returns the top card of the deck, removing it from the deck and placing it in discards
  public Card deal(){
    Card card = cards.remove(0);
    discards.add(card);
    System.out.println("dealt a card: " + card.getName());
    return card;
  }


  public void shuffle(){
    Random ran = new Random();
    getTotalCardNumber();
    ArrayList<Card> tempDeck = new ArrayList<Card>();
    int sizeOfDiscard = discards.size();
    for (int i=0; i < (sizeOfDiscard); i++){ //takes cards from the discard array and puts them ontop of the card deck
      cards.add(discards.remove(0));
    }
    int sizeOfCards = cards.size();
    for (int i=0; i < (sizeOfCards); i++){ //takes all the cards and shuffles them together randomly
      Card card = cards.remove(ran.nextInt(cards.size()));
      tempDeck.add(card);
      //System.out.println("shuffled card: " + tempDeck.get(i).getName());    //for checking the cards being dealt
    }
    cards = tempDeck;
    burnCard = deal();


  }

  public int getTotalCardNumber(){
    int deckSize = cards.size() + discards.size();
    return deckSize;
  }

  public int size(){
    return cards.size();
  }

  public String getCardName(int cardNumber){
    Card card = cards.get(cardNumber);
    String cardName = card.getName();
    return cardName;
  }

  public String shownPile(Card card){
    twoPlayerBurn.add(card);
    String cardName = card.getName();
    return cardName;
  }

  public Card getBurnCard(){
    return burnCard;
  }

}
