import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;



	public class GreenFelt extends JPanel {
		public static PlayersList players;
		public static Deck deck;
	  public static int playerCount;
	  public static boolean win;
	  public static InputCheck input;
	  public static GraphicsDraw graphicsDraw;

	  private static final long serialVersionUID = 1L;
	  public JFrame mainFrame;
	  public JPanel gameBoard;
	  public JButton dealButton;
	  public JButton chooseButton;
	  private JTextField dialogBox;
	  private JTextField inputBox;
	  GreenFelt(){	//constructor
       deck = new Deck();
       input = new InputCheck();
		   mainFrame = new JFrame();
		   gameBoard = new JPanel();
		   dialogBox = new JTextField();
		   dealButton = new JButton("Next");
		   chooseButton = new JButton("Choose");;
		   graphicsDraw = new GraphicsDraw();
       playerCount = InputCheck.check("How many players?", PlayersList.MINIMUM_PLAYER_COUNT, PlayersList.MAXIMUM_PLAYER_COUNT, null);     //asking for participating PlayersList and sending it to  'players'
       players = new PlayersList(playerCount);

		   mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   mainFrame.setBounds(300, 150, 786, 593);
		   dealButton.setBounds(361, 476, 71, 23);
		   chooseButton.setBounds(268, 448, 80, 23);
		   gameBoard.setLayout(null);
		   gameBoard.setBackground(new Color(39,134,39));
		   gameBoard.add(dealButton);
		   gameBoard.add(chooseButton);
		   mainFrame.getContentPane().add(gameBoard); //adding the panel to the frame

		   JButton button = new JButton("Choose");
		   button.setBounds(442, 448, 80, 23);
		   gameBoard.add(button);

		   dialogBox.setText("How many players? 2-4 players");
		   dialogBox.setBounds(222, 523, 216, 20);
		   gameBoard.add(dialogBox);
		   dialogBox.setColumns(10);

		   inputBox = new JTextField();
		   inputBox.setBounds(466, 523, 86, 20);
		   gameBoard.add(inputBox);
		   inputBox.setColumns(10);

		   mainFrame.setVisible(true);
		  }

			public void playRound(){
		  dealButton.addActionListener(new ActionListener() {// action listener for button
				 public void actionPerformed(ActionEvent arg0) {
					 deck.shuffle();
			   }
			   });

				if (playerCount == PlayersList.PLAYER_COUNT_EXTRA_RULE){    //extra 3 cards shown for 2 players
					for(int i=0; i < Deck.EXTRA_RULE_CARD_COUNT; i++)
					{
						System.out.println("Card shown on table " + deck.shownPile(deck.deal()));
					}
				}
				System.out.println("Burn card: " + deck.getBurnCard().getName());
				for(int i=0; i < playerCount; i++){    // deals out one card per person to start
					players.playersArray.get(i).takeCard(deck.deal());
				}
				while(players.checkActive()){     //starting of player rotation
					Player currentPlayer = players.playersArray.get(players.getTurn());
					currentPlayer.setShieldOff();   //turns off handmaid shield
					if (currentPlayer.getActive()){    //checks if player is still in the round then executes a card deal and play if true
						currentPlayer.takeCard(deck.deal());     //deals the player a second card
						currentPlayer.choosePlay().action(currentPlayer, players, deck);    //forces player to choose which card to play, then executes that cards action
					}
					players.endOfTurn();    //turn order counter

					if (deck.size() == 0){
						System.out.println("You ran out of cards");
						break;
					}
				}
				players.winnerCalc();
				for(int i=0; i < playerCount; i++){
					System.out.println("player " + (1+i) + " score: " + players.playersArray.get(i).getScore());
					if (players.playersArray.get(i).handSize() >=1){
						players.playersArray.get(i).discardCard(0);   //discards remaining card
						}
					players.playersArray.get(i).setActive();    //turns players who were eliminated back on
					players.playersArray.get(i).clearDiscard();   //empties personal discard array
					players.playersArray.get(i).setShieldOff();   //turns off handmaid shield
					// System.out.println("win requirement" + players.getWinRequire());
					if (players.playersArray.get(i).getScore() == players.getWinRequire()){
						System.out.println(players.playersArray.get(i).getName() + " has won the game!");
						LLmain.win = true;

					}
				}
			}
	  }
