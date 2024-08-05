package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class attackPhaseController implements Initializable{

	player player[] = new player[2];
	
	//cards
	
	//cost 1 
	spell miss = new spell(1,"empty",1,"miss");
				
	creature scarecrow = new creature(1,"",2,"scarecrow",0,2);
		
	creature minion = new creature(1,"",3,"minion",1,1);
				
	creature cannibal = new creature(1,"",4,"cannibal",2,1);
				
	creature bleeder = new creature(1,"every tour he lives, attack damage goes up by 1",5,"bleeder",1,2);
					
	//cost 2
	spell stick = new spell(2,"1 damage to your own, 2 damage to your enemy card",1,"stick");
				
	spell quarters = new spell(2,"turn one of your cards to soldier",2,"quarters");
				
	spell carnival = new spell(2,"create 3 minions",3,"carnival");
				
	spell fireball = new spell(2,"give 2 damage to a unit",4,"fire ball");
				
	creature soldier = new creature(2,"",5,"soldier",3,3);
				
	//cost 3
	creature sword = new creature(3,"",1,"sword",5,2);
				
	creature crib = new creature(3,"every tour the crib stands, 2 minion spawns.",2,"crib",0,6);
				
	creature wolf = new creature(3,"",3,"wolf",4,4);
				
	creature chef = new creature(3,"every tour end chef stands, the player gains 3 health",4,"chef",1,4);
					
	spell training = new spell(3,"every creature in your deck gains 3 attack damage",5,"training");
				
	//cost 4
	spell armor = new spell(4,"makes one of your cards gain 10 health",1,"armor");
				
	spell meteor = new spell(4,"makes any card you choose dead",2,"meteor");
				
	spell fireballs = new spell(4,"summons 3 fireballs",3,"fireballs");
				
	creature golem = new creature(4,"makes it's health 2x every tour. (if the health passes 50, the game ends)",4,"golem",2,5);
				
	spell fullmoon = new spell(4,"summons 3 wolfes.",5,"fullmoon");
				
	//cost 5		
	creature knight = new creature(5,"",1,"knight",6,6);
				
	creature asya = new creature(5,"every tour asya starts the tour with the same hp as tour number",2,"asya",6,4);
				
	spell apocalypse = new spell(5,"destroy every card in other players hand including spells",3,"apocalypse");
				
	creature ditto = new creature(5,"every tour ditto stands, ditto clones himself",4,"ditto",2,4);
				
	creature emirg = new creature(5,"regens the player 5, kills every card the summoning player has and comes with 4 soldiers",5,"emirg",15,15);
		
	boolean alreadyPassedTour = false; // to see if it's already passed a turn in this tour
	
	StringBuilder tourSummary = new StringBuilder();
	
	List<Integer> usedAttackerIndex = new ArrayList<>();
	
    @FXML
    private Label attackPhaseInformation;
    
    private Stage stage;
	private Scene scene; // these are for going to buy process page
	private Parent root;

	int tourNumber = 1;

	int currentTourPlayer = 0; // player index for player[playerTourPlayer], if 0 then it is player 1, if 1 then it is player 2. (player 1 stars first)
	
	@FXML
	private GridPane pane;
	
	@FXML
    private ChoiceBox<?> costOptions;

    @FXML
    private Label p1Card1AD;

    @FXML
    private Label p1Card1HP;

    @FXML
    private Line p1Card1HPADSplitter;

    @FXML
    private Button p1Card1InteractionButton;

    @FXML
    private Label p1Card1Name;

    @FXML
    private Label p1Card1Spell;

    @FXML
    private Line p1Card1Stick;

    @FXML
    private Line p1Card1Stick2;

    @FXML
    private Label p1Card2AD;

    @FXML
    private Label p1Card2HP;

    @FXML
    private Line p1Card2HPADSplitter;

    @FXML
    private Button p1Card2InteractionButton;

    @FXML
    private Label p1Card2Name;

    @FXML
    private Label p1Card2Spell;

    @FXML
    private Line p1Card2Stick;

    @FXML
    private Line p1Card2Stick2;

    @FXML
    private Label p1Card3AD;

    @FXML
    private Label p1Card3HP;

    @FXML
    private Line p1Card3HPADSplitter;

    @FXML
    private Button p1Card3InteractionButton;

    @FXML
    private Label p1Card3Name;

    @FXML
    private Label p1Card3Spell;

    @FXML
    private Line p1Card3Stick;

    @FXML
    private Line p1Card3Stick2;

    @FXML
    private Label p1Card4AD;

    @FXML
    private Label p1Card4HP;

    @FXML
    private Line p1Card4HPADSplitter;

    @FXML
    private Button p1Card4InteractionButton;

    @FXML
    private Label p1Card4Name;

    @FXML
    private Label p1Card4Spell;

    @FXML
    private Line p1Card4Stick;

    @FXML
    private Line p1Card4Stick2;

    @FXML
    private Label p1Card5AD;

    @FXML
    private Label p1Card5HP;

    @FXML
    private Line p1Card5HPADSplitter;

    @FXML
    private Button p1Card5InteractionButton;

    @FXML
    private Label p1Card5Name;

    @FXML
    private Label p1Card5Spell;

    @FXML
    private Line p1Card5Stick;

    @FXML
    private Line p1Card5Stick2;

    @FXML
    private Label p1Card6AD;

    @FXML
    private Label p1Card6HP;

    @FXML
    private Line p1Card6HPADSplitter;

    @FXML
    private Button p1Card6InteractionButton;

    @FXML
    private Label p1Card6Name;

    @FXML
    private Label p1Card6Spell;

    @FXML
    private Line p1Card6Stick;

    @FXML
    private Line p1Card6Stick2;

    @FXML
    private Label p1Card7AD;

    @FXML
    private Label p1Card7HP;

    @FXML
    private Line p1Card7HPADSplitter;

    @FXML
    private Button p1Card7InteractionButton;

    @FXML
    private Label p1Card7Name;

    @FXML
    private Label p1Card7Spell;

    @FXML
    private Line p1Card7Stick;

    @FXML
    private Line p1Card7Stick2;

    @FXML
    private Label p1Card8AD;

    @FXML
    private Label p1Card8HP;

    @FXML
    private Line p1Card8HPADSplitter;

    @FXML
    private Button p1Card8InteractionButton;

    @FXML
    private Label p1Card8Name;

    @FXML
    private Label p1Card8Spell;

    @FXML
    private Line p1Card8Stick;

    @FXML
    private Line p1Card8Stick2;

    @FXML
    private Label p1Card9AD;

    @FXML
    private Label p1Card9HP;

    @FXML
    private Line p1Card9HPADSplitter;

    @FXML
    private Button p1Card9InteractionButton;

    @FXML
    private Label p1Card9Name;

    @FXML
    private Label p1Card9Spell;

    @FXML
    private Line p1Card9Stick;

    @FXML
    private Line p1Card9Stick2;

    @FXML
    private Label p2Card1AD;

    @FXML
    private Label p2Card1HP;

    @FXML
    private Line p2Card1HPADSplitter;

    @FXML
    private Button p2Card1InteractionButton;

    @FXML
    private Label p2Card1Name;

    @FXML
    private Label p2Card1Spell;

    @FXML
    private Label p2Card2AD;

    @FXML
    private Label p2Card2HP;

    @FXML
    private Line p2Card2HPADSplitter;

    @FXML
    private Button p2Card2InteractionButton;

    @FXML
    private Label p2Card2Name;

    @FXML
    private Label p2Card2Spell;

    @FXML
    private Label p2Card3AD;

    @FXML
    private Label p2Card3HP;

    @FXML
    private Line p2Card3HPADSplitter;

    @FXML
    private Button p2Card3InteractionButton;

    @FXML
    private Label p2Card3Name;

    @FXML
    private Label p2Card3Spell;

    @FXML
    private Label p2Card4AD;

    @FXML
    private Label p2Card4HP;

    @FXML
    private Line p2Card4HPADSplitter;

    @FXML
    private Button p2Card4InteractionButton;

    @FXML
    private Label p2Card4Name;

    @FXML
    private Label p2Card4Spell;

    @FXML
    private Label p2Card5AD;

    @FXML
    private Label p2Card5HP;

    @FXML
    private Line p2Card5HPADSplitter;

    @FXML
    private Button p2Card5InteractionButton;

    @FXML
    private Label p2Card5Name;

    @FXML
    private Label p2Card5Spell;

    @FXML
    private Label p2Card6AD;

    @FXML
    private Label p2Card6HP;

    @FXML
    private Line p2Card6HPADSplitter;

    @FXML
    private Button p2Card6InteractionButton;

    @FXML
    private Label p2Card6Name;

    @FXML
    private Label p2Card6Spell;

    @FXML
    private Label p2Card7AD;

    @FXML
    private Label p2Card7HP;

    @FXML
    private Line p2Card7HPADSplitter;

    @FXML
    private Button p2Card7InteractionButton;

    @FXML
    private Label p2Card7Name;

    @FXML
    private Label p2Card7Spell;

    @FXML
    private Label p2Card8AD;

    @FXML
    private Label p2Card8HP;

    @FXML
    private Line p2Card8HPADSplitter;

    @FXML
    private Button p2Card8InteractionButton;

    @FXML
    private Label p2Card8Name;

    @FXML
    private Label p2Card8Spell;

    @FXML
    private Label p2Card9AD;

    @FXML
    private Label p2Card9HP;

    @FXML
    private Line p2Card9HPADSplitter;

    @FXML
    private Button p2Card9InteractionButton;

    @FXML
    private Label p2Card9Name;

    @FXML
    private Label p2Card9Spell;

    @FXML
    private Button passTheTourButton;

    @FXML
    private Label player1Health;

    @FXML
    private Label player1NameCards;

    @FXML
    private Label player2Health;

    @FXML
    private Label player2NameCards;

    @FXML
    private Label playerAttackTurn;

    @FXML
    public List<Label>[] deckCardName = new ArrayList[2];
    
    @FXML
    public List<Label>[] deckCardSpellText = new ArrayList[2];
    
    @FXML
    public List<Label>[] deckCardHP = new ArrayList[2];
    
    @FXML
    public List<Label>[] deckCardAD = new ArrayList[2];
    
    @FXML
    public List<Line>[] deckHPADSplitter = new ArrayList[2];
    
    @FXML
    public List<Button>[] deckInteractionButton = new ArrayList[2];
    
    @FXML
    public Label playerHealthLabel[] = new Label[2];
    
    @FXML
    public Label playerNameCard[] = new Label[2];
    
    
    //
    
    
    public void getDatas(player playerX[], int tourNumberX) {
    	
    	tourNumber = tourNumberX;
    	currentTourPlayer = (tourNumber+1)%2; // player index for player[playerTourPlayer], if 0 then it is player 1, if 1 then it is player 2
    	
    	// passing players infos to labels
    	for(int i = 0; i<2; i++) {
    		
    		player[i] = playerX[i];
    		playerHealthLabel[i].setText(player[i].name + "'s health:" + player[i].health);
    		playerNameCard[i].setText(player[i].name + "'s deck");
    		
    		for(int j = 0; j<9; j++) {
    			if(player[i].deck[j]!=null)
    				deckInteractionButton[i].get(j).setText("attack"); // making every button "attack"
    		}
    		
    	}
    	
    	// player 1 starts first
    	
    	playerAttackTurn.setText(player[currentTourPlayer].name.toUpperCase()+"'S");
    	attackPhaseInformation.setText(player[currentTourPlayer].name+" can select a card and use");
    	
    	for(int i = 0; i<9; i++) {
    		
    		if(player[currentTourPlayer].deck[i]!=null) {
    			deckInteractionButton[currentTourPlayer].get(i).setText("use"); // current players buttons getting changed
    			deckInteractionButton[currentTourPlayer].get(i).setVisible(true); 
    		}
    		
    	}
    	
    	// making decks and their visuals visible
    	
    	for(int i = 0; i<2; i++) {
    		
    		for(int j = 0; j<9; j++) {
    			
    			if(player[i].deck[j]==null);  // protection from nullpointer exception
    			
    			else if(player[i].deck[j].getClass()==creature.class) {
    				
    				deckHPADSplitter[i].get(j).setVisible(true);
    				
    				deckCardAD[i].get(j).setText(String.valueOf(((creature)player[i].deck[j]).attackDamage));
    				deckCardAD[i].get(j).setVisible(true);
    				
    				deckCardHP[i].get(j).setText(String.valueOf(((creature)player[i].deck[j]).health));
    				deckCardHP[i].get(j).setVisible(true);
    				
    				deckCardName[i].get(j).setText(player[i].deck[j].name);
    				deckCardName[i].get(j).setVisible(true);
    				
    			}
    			
    			else if(player[i].deck[j].getClass()==spell.class) {
    				
    				deckCardSpellText[i].get(j).setVisible(true);
    				
    				deckCardName[i].get(j).setText(player[i].deck[j].name);
    				deckCardName[i].get(j).setVisible(true);
    				
    			}
    			
    		}
    		
    	}
    	
    }
    
    
    @FXML
    void passTheTour(ActionEvent event) throws IOException {
    	
    	
    	if(passTheTourButton.getText()=="end the game") { // ending the game whether it's ending the tour or passing turn from player X to player Y
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("endTheGame.fxml")); // going into end the game page
    		
    		root = loader.load();
    		
    		
    		
    		endTheGameController endTheGameController = loader.getController();
    		
    		if(player[0].health > player[1].health)
    			endTheGameController.getDatas(player[0].name);
    		
    		else
    			endTheGameController.getDatas(player[1].name);
    		
    		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		scene = new Scene(root);
    		stage.setScene(scene); 
    		stage.show();
    		
    	}
    	
    	usedAttackerIndex.clear(); // since we pass the tour, used index should be usable again for next player
    	
    	if(!alreadyPassedTour) { // changing the current player
    		
    		for(int i = 0; i<9; i++) {
    			
    			if(player[currentTourPlayer].deck[i]!=null) { // attack button for attack receiver
    				
    				deckInteractionButton[currentTourPlayer].get(i).setText("attack");
    				deckInteractionButton[currentTourPlayer].get(i).setVisible(false);
    			}
    			
    		}
    		
    		if(currentTourPlayer==0) 
    			currentTourPlayer=1;
    		
    		else
    			currentTourPlayer=0;
    		
    		playerAttackTurn.setText(player[currentTourPlayer].name.toUpperCase()+"'S");
        	
    		attackPhaseInformation.setText(player[currentTourPlayer].name+" can select a card and use");
        	
        	
    		for(int i = 0; i<9; i++) {
    			
    			if(player[currentTourPlayer].deck[i]!=null) { // use button for attacker
    				
    				deckInteractionButton[currentTourPlayer].get(i).setText("use");
    				deckInteractionButton[currentTourPlayer].get(i).setVisible(true);
    			}
    			
    		}
    		
    		
    		alreadyPassedTour = true; // there is no more turn passing 
    		
    		passTheTourButton.setText("end tour");
    	
    	}
    	else { // there is no turns to be passed so ending the tour
    		
    		tourNumber++; 
    		checkCreatureSpeciality(); 
    		
    		
    		if(tourSummary.length() == 0) { // buy process page if there is no summary text to display
    			
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("buyProcess.fxml")); // going into the buy process page
    			
    			root = loader.load();
    			
    			
    			
    			buyProcessController buyProcessController = loader.getController();
    			
    			buyProcessController.getDatas(player, tourNumber);
    			
    			stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    			scene = new Scene(root);
    			stage.setScene(scene); 
    			stage.show();
    		}
    		
    		else { // tour summary 

    	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("tourSummary.fxml")); // going into the buy process page
    			
    			root = loader.load();
    			
    			
    			
    			tourSummaryController tourSummaryController = loader.getController();
    			
    			tourSummaryController.getDatas(player, tourNumber, String.valueOf(tourSummary));
    			
    			stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    			scene = new Scene(root);
    			stage.setScene(scene); 
    			stage.show();
    		}
    		
		}
    
    }
    
    
    public void deckInteractionButton(ActionEvent event, int buttonIndex) { // method for 18 button right beside the cards
    	
    	int opponentIndex = (currentTourPlayer+1)%2;
    	
    	player currentPlayer = player[currentTourPlayer];
    	
    	player opponentPlayer = player[opponentIndex];
    	
    	Button clickedButton = deckInteractionButton[currentTourPlayer].get(buttonIndex);
    	
    	Button opponentClickedButton = deckInteractionButton[opponentIndex].get(buttonIndex);
    	
    	List<Button> currentPlayerButtons = deckInteractionButton[currentTourPlayer];
    	
    	List<Button> opponentPlayerButtons = deckInteractionButton[opponentIndex];
    	
    	card usedCard = player[currentTourPlayer].deck[buttonIndex];
    	
    	Label usedCardHPLabel = deckCardHP[currentTourPlayer].get(buttonIndex);
    	
    	Label usedCardADLabel = deckCardAD[currentTourPlayer].get(buttonIndex);
    	
    	Label usedCardNameLabel = deckCardName[currentTourPlayer].get(buttonIndex); 
    	
    	// these are for better readability
    	
    	
    	if(clickedButton.getText()=="use" && clickedButton.isVisible()) { // USE BUTTON
    		
    		attackPhaseInformation.setText(currentPlayer.name+" selected "+ usedCard.name);
    		
    		passTheTourButton.setVisible(false);
    		
    		
    		if(usedAttackerIndex.size()>0) { // checking to see if last selected card is a spell that applies to teammates (getting use button twice in a row so requires some lines)
    			
    			int lastSelectedCardIndex = usedAttackerIndex.get(usedAttackerIndex.size()-1);
    			
    			if(currentPlayer.deck[lastSelectedCardIndex]!=null && currentPlayer.deck[lastSelectedCardIndex].name=="armor") { // armor
    				
    				((creature) usedCard).health+= 10;
    				
    				attackPhaseInformation.setText(usedCard.name + " gained 10 health points!");
    				
    				usedCardHPLabel.setText( String.valueOf(((creature) usedCard).health) );
    				
    				passTheTourButton.setVisible(true);
    				
    				for(int i = 0; i<9; i++) {
    					
    					if(currentPlayer.deck[i]!=null && !(usedAttackerIndex.contains(i))) 
    						currentPlayerButtons.get(i).setVisible(true);
    					
    					else
    						currentPlayerButtons.get(i).setVisible(false);
    				}
    				
    				cardGetsDestroyed(currentTourPlayer, currentPlayer.deck, lastSelectedCardIndex);
    				
    				return;
    			}
    			
    			else if(currentPlayer.deck[lastSelectedCardIndex]!=null && currentPlayer.deck[lastSelectedCardIndex].name=="quarters") { // quarters
    				
    				attackPhaseInformation.setText(usedCard.name + " is now a "+soldier.name+"!");
    				
    				currentPlayer.deck[buttonIndex] = copyCard(soldier);
    				
    				usedCardHPLabel.setText(String.valueOf(soldier.health));
    				usedCardADLabel.setText(String.valueOf(soldier.attackDamage));
    				usedCardNameLabel.setText(soldier.name);
    				
    				passTheTourButton.setVisible(true);
    				
    				for(int i = 0; i<9; i++) {
    					
    					if(currentPlayer.deck[i]!=null && !(usedAttackerIndex.contains(i))) 
    						currentPlayerButtons.get(i).setVisible(true);
    					
    					else
    						currentPlayerButtons.get(i).setVisible(false);
    				}
    				
    				cardGetsDestroyed(currentTourPlayer, currentPlayer.deck, lastSelectedCardIndex);
    				
    				return;
    			}
    			
    			else if(currentPlayer.deck[lastSelectedCardIndex]!=null && currentPlayer.deck[lastSelectedCardIndex].name=="stick") { // stick friend creature attack
    					
    				StringBuilder stickInformation = new StringBuilder();

    				((creature) usedCard).health -= 1;
    				
	    				if(((creature)usedCard).health > 0) { // stick attacks own creature
	    					
	    					stickInformation.append(usedCard.name + " lost 1 health point \n");
	        				usedCardHPLabel.setText( String.valueOf(((creature) usedCard).health) );
	    				
	    				}
	    				else { // stick kills own creature
	    					stickInformation.append(usedCard.name + " got killed by stick \n");
	    					cardGetsDestroyed(currentTourPlayer, currentPlayer.deck, buttonIndex);
	    				}
	    				
	    				
	    				
	    				if(doesThisDeckContainCreature(opponentPlayer.deck)) { // opponent has creature
	    					
	    					stickInformation.append("select one of your opponents creatures to deal 2 damage");
	    					
		    				for(int i = 0; i<9; i++) { // getting buttons ready to attack player
		    					
		    					currentPlayerButtons.get(i).setVisible(false); // current players use buttons disappear
		    					
		    					if(opponentPlayer.deck[i]!=null && opponentPlayer.deck[i].getClass()==creature.class)
		    						opponentPlayerButtons.get(i).setVisible(true); // attack buttons get visible
		    					
		    				}
	    				}
	    				
	    				else { // opponent has no creature so attacking player
	    					
	    					opponentPlayer.health -= 2; // stick has 2 damage, attacking the player
	    					
	    					stickInformation.append("since the opponent has no creatures, you are attacking the player with stick "
	    					+ "\nnew "+opponentPlayer.name+" health:"+ opponentPlayer.health);
	    				
	    					playerHealthLabel[opponentIndex].setText(player[opponentIndex].name+"'s health:"+player[opponentIndex].health);
	    					
	    					cardGetsDestroyed(currentTourPlayer, currentPlayer.deck, lastSelectedCardIndex); // stick
	    					
	    					passTheTourButton.setVisible(true);
	    					
	    					for(int i = 0; i<9; i++) { // back to normal use buttons
	    		    			
	    		    			if(currentPlayer.deck[i]!=null && !(usedAttackerIndex.contains(i))) 
	    		    				currentPlayerButtons.get(i).setVisible(true);
	    		    			else
	    		    				currentPlayerButtons.get(i).setVisible(false);
	    		    			
	    		    			opponentPlayerButtons.get(i).setVisible(false);
	    		    			
	    		    		}
	    					
	    				}
	    				
	    			attackPhaseInformation.setText(String.valueOf(stickInformation));	
    				
    				return;
    			}
    			
    		
    		}
    		
    		usedAttackerIndex.add(buttonIndex); // adding used index so in the same tour player will not be able to use same card
    		
    		if(usedCard.getClass()==creature.class) { // the card to use is creature
    			
    			
    			creature attacker = (creature) usedCard;
    			
    			if(!doesThisDeckContainCreature(opponentPlayer.deck)) { // opponent doesn't have creature so attacking player
    				
    				attackPhaseInformation.setText(opponentPlayer.name+" has no creature so you are attacking directly to the player ");
    				
    				
    				opponentPlayer.health -= attacker.attackDamage;
    				
    				playerHealthLabel[opponentIndex].setText(opponentPlayer.name + "'s health:" + opponentPlayer.health);
    				
    				passTheTourButton.setVisible(true);
    				
    				clickedButton.setVisible(false);
    			}
    			else { // opponent has creature
    				
    				for(int i = 0; i<9; i++) {
    					currentPlayerButtons.get(i).setVisible(false);
    					
    					if(opponentPlayer.deck[i]!=null && opponentPlayer.deck[i].getClass()==creature.class) // only creatures are attackable
    						opponentPlayerButtons.get(i).setVisible(true);
    					
    				}
    				
    			}
    			
    		}
    		else { // the card to use is spell
    			passTheTourButton.setVisible(true);
    			checkWhichSpellToUse(player, currentTourPlayer, player[currentTourPlayer].deck, buttonIndex);
    			
    		}
    		
    	}
    	
    	// ATTACK BUTTON
    	else if(opponentClickedButton.getText()=="attack" && opponentClickedButton.isVisible()) {
    		
    		
    		
    		int lastSelectedCardIndex = usedAttackerIndex.get(usedAttackerIndex.size()-1);
    		
    		if(currentPlayer.deck[lastSelectedCardIndex]!=null && currentPlayer.deck[lastSelectedCardIndex].name=="stick") { // stick enemy creature attack
    		
				checkWhichSpellToAttackWith(currentTourPlayer, currentPlayer.deck ,buttonIndex,lastSelectedCardIndex);
					
				passTheTourButton.setVisible(true);
			
				return;
    		
    		}
    		
    		if(currentPlayer.deck[lastSelectedCardIndex].getClass()==spell.class) // the card you are attacking with is spell 
    			checkWhichSpellToAttackWith( currentTourPlayer, currentPlayer.deck, buttonIndex, lastSelectedCardIndex);
    		
    		
    		else // the card you are attacking with is creature
    			attack((creature)currentPlayer.deck[lastSelectedCardIndex], opponentIndex, opponentPlayer.deck, buttonIndex);
    		
    		passTheTourButton.setVisible(true);
    		
    		for(int i = 0; i<9; i++) {
    			
    			if(currentPlayer.deck[i]!=null && !(usedAttackerIndex.contains(i))) 
    				currentPlayerButtons.get(i).setVisible(true);
    			
    			opponentPlayerButtons.get(i).setVisible(false);
    			
    		}
    	}
    	
    	if((player[0].health <= 0 || player[1].health <= 0) && player[0].health!=player[1].health) // checking to end the game (if they have same hp, 1 more tour gets played)
    		passTheTourButton.setText("end the game");
    
    	
    }
    
    
    public static boolean doesThisDeckContainCreature(card deck[]) { // checking if a deck only contains spells/nulls (there is nothing to attack)
		
		for(int i = 0; i<9; i++){
			
			if(deck[i] != null && deck[i].getClass().equals(creature.class))
				return true;
			
		}
		return false; // if we get out of the for() block without returning, that means we got no card except nulls/spells so it's not an attackable deck
	
	}
    

    public void checkCreatureSpeciality() {
		
		for(int i = 0; i<2; i++) { // i for player[0] and player[1] index
			
			
			for(int l = 0; l<9; l++) { // l for checking every spot in player deck
				
				if((player[i].deck[l]!=null && player[i].deck[l].getClass()==creature.class))// it is a creature
					checkIfCreatureHasSpeciality(i, l);
			
			}
		
			creatureDitto(i); // gets applied just one time to prevent cloned dittos to clone again and again 9 times at the same turn
		
		}
	
	}
    
    
    public  void creatureDitto(int playerIndex) {
    	
    	player dittoPlayer = player[playerIndex];
    	
    	int dittoNumberPlayerHas = 0;  // we need to do this so ditto clones doesnt clone in the same tour leading to infinity
    	
    	for(int k = 0; k<9; k++) { // checking for dittos
    		if(dittoPlayer.deck[k]!=null && dittoPlayer.deck[k].name==ditto.name)
    			dittoNumberPlayerHas++;
    	}
    	
    	if(dittoNumberPlayerHas>0) {
    		
    		int emptySpots = 0;
    		
    		for(int s = 0; s<9; s++) { // checking for how many empty spots are there
    			
    			if(dittoPlayer.deck[s]==null)
    				emptySpots++;
    			
    		}
    		
    		if(emptySpots==0) 
    			tourSummary.append("there is no empty spots in "+dittoPlayer.name+"'s deck to clone ditto\n");
    		
    		else if(emptySpots<dittoNumberPlayerHas) // example: 5 dittos, 3 empty spots, only 3 more clons of ditto
    			tourSummary.append(dittoPlayer.name+"'s dittos cloned and now there are "+emptySpots+" more dittos\n");
    		
    		else // normal condition
    			tourSummary.append(dittoPlayer.name+"'s dittos cloned and now there are "+dittoNumberPlayerHas+" more dittos\n");
    		
    		drawMultipleCreatures(playerIndex, ditto, dittoNumberPlayerHas);
    	}
    }
    
    
    public void checkIfCreatureHasSpeciality(int playerIndex,int creatureIndex) {
		
		String x = player[playerIndex].deck[creatureIndex].name; // creature name == x
		
		if(x==bleeder.name) 
			creatureBleeder(playerIndex, creatureIndex);
		
		else if(x==crib.name)
			creatureCrib(playerIndex);

		else if(x==chef.name)
			creatureChef(playerIndex);

		else if(x==golem.name)
			creatureGolem(player, playerIndex, creatureIndex);

		else if(x==asya.name)
			creatureAsya(player[playerIndex], creatureIndex);

		
	}
    
    
    public void creatureBleeder(int playerIndex, int creatureIndex) {
    	
    	creature bleeder = (creature)player[playerIndex].deck[creatureIndex];
    	
    	bleeder.attackDamage++; // bleeders attack damage goes up by one every tour it stands
    	
    	deckCardAD[playerIndex].get(creatureIndex).setText(String.valueOf(bleeder.attackDamage));
    	
    	tourSummary.append(player[playerIndex].name+"'s bleeder gained 1 attack damage."
    			+ "\nnew bleeder attack damage:" + ((creature) player[playerIndex].deck[creatureIndex]).attackDamage+"\n");
    }

    
    public void creatureCrib(int playerIndex) {
		
    	player cribPlayer =player[playerIndex];
		int emptySpots = 0;
		
		for(int s = 0; s<9; s++) { // checking for how many empty spots are there
			
			if(cribPlayer.deck[s]==null)
				emptySpots++;
			
		}
		
		if(emptySpots==0);
		
		else if(emptySpots<2) // example: 2 crib spawns, 1 empty spots, only 1 more minion
			tourSummary.append("crib spawned "+emptySpots+" minions for "+cribPlayer.name+"!\n");
	
		else // normal condition
			tourSummary.append("crib spawned 2 minions for "+cribPlayer.name+"!\n");
		
		drawMultipleCreatures(playerIndex, minion, 2); // pulling 2 minions anyways if there is no spot, no problem
	

	}
    
    
    public void creatureChef(int playerIndex) {
		
    	player healingPlayer = player[playerIndex];
		
		healingPlayer.health = healingPlayer.health + 3; // chef heals the player 3 points every tour
		playerHealthLabel[playerIndex].setText(healingPlayer.name+"'s health:"+healingPlayer.health);
		
		tourSummary.append(healingPlayer.name+"'s chef cooked and healed the player 3 points.\nnew player health:"+healingPlayer.health+"\n");	
	
    }
    
    
    public void creatureGolem(player player[], int playerIndex, int creatureIndex) {
    	
    	creature thisGolem = (creature) player[playerIndex].deck[creatureIndex];
    	
    	int k = (playerIndex+1)%2; // opponent player index 
    	
    	thisGolem.health =  thisGolem.health*2;// golems health point multiplies by 2 every tour it stands
    	
    	deckCardHP[playerIndex].get(creatureIndex).setText(String.valueOf(thisGolem.health));
    	
    	tourSummary.append(player[playerIndex].name+"'s golem got harder 2 times!"
    			+ "\nnew golem health point:" + ((creature) player[playerIndex].deck[creatureIndex]).health+"\n");
    	
    	if(thisGolem.health>50){ // golem reached over 50 health points
    		
    		tourSummary.append("golem met the condition of over 50 HPs and smashed "+player[k].name+"\n");
    		player[k].health = 0;
    	}
    }
    
    
    public void creatureAsya(player player, int creatureIndex) {
    	
		((creature) player.deck[creatureIndex]).health =  tourNumber;// asya health point equals to playing tour number every tour it stands
		
		tourSummary.append(player.name+"'s asya health points equals to tour number."
		+ "\nnew asya health point:" + ((creature) player.deck[creatureIndex]).health+"\n");
		
	}
    
    
    public void checkWhichSpellToAttackWith(int playerIndex,card deck[],int buttonIndex,int usedIndex) {
		

		
    	String x = deck[usedIndex].name; // spell name == x
		
    	if(x==stick.name)
			spellStickAttack(playerIndex, buttonIndex);
		
		else if(x==fireball.name)
			spellFireballAttack(playerIndex, buttonIndex);
		
		else if(x==meteor.name)
			spellMeteorAttack(playerIndex,buttonIndex);
		
		cardGetsDestroyed(playerIndex, deck, usedIndex); // we used the spell
		
		
    }


	public void checkWhichSpellToUse(player player[],int playerIndex,card deck[],int spellIndex) { // comparing every spell to selected spell till it's found for its' method
		
		String x = deck[spellIndex].name; // spell name == x
		
		
		if(x==stick.name)
			spellStick(playerIndex, spellIndex);
		
		else if(x==quarters.name) 
			spellQuarters(playerIndex, spellIndex); //
		
		else if(x==carnival.name)
			spellCarnival(deck, playerIndex, spellIndex); //
		
		else if(x==fireball.name)
			spellFireball(playerIndex, deck, spellIndex); //
		
		else if(x==training.name)
			spellTraining(player[playerIndex], playerIndex, spellIndex); //
		
		else if(x==armor.name)
			spellArmor(playerIndex, spellIndex); //
		
		else if(x==meteor.name)
			spellMeteor(playerIndex); //
		
		else if(x==fireballs.name)
			spellFireballs(deck, playerIndex, spellIndex); //
		
		else if(x==fullmoon.name)
			spellFullmoon(deck, playerIndex, spellIndex); //
		
		else if(x==apocalypse.name)
			spellApocalypse(playerIndex, spellIndex); //
		
	}
    
	
	public void spellStick(int playerIndex,int spellIndex) {
		
		int opponentIndex = (playerIndex+1)%2; // the opponent player index
		
		
		if(doesThisDeckContainCreature(player[playerIndex].deck)) { // the card stick requires friendly creature
			
			passTheTourButton.setVisible(false);
			
			attackPhaseInformation.setText("select one of your creatures to make it lose 1 health point");
			
			for(int i = 0; i<9; i++) {
					
				if(player[playerIndex].deck[i]!=null && player[playerIndex].deck[i].getClass()==creature.class)
					deckInteractionButton[playerIndex].get(i).setVisible(true);
					
				else
					deckInteractionButton[playerIndex].get(i).setVisible(false);
	
			}
			
		}
		
		else {  // no creatures in deck
			attackPhaseInformation.setText("there is no creature in your deck so you can't use stick");
			drawSpell(currentTourPlayer,spellIndex,stick);
			usedAttackerIndex.remove(Integer.valueOf(spellIndex));
		
		}
		
	}
	
	
	public void spellStickAttack(int playerIndex, int buttonIndex) {
		
		int k = (playerIndex+1)%2; // opponent index
		
		creature attackReceiver = ((creature)player[k].deck[buttonIndex]);
		
		if(attackReceiver.health>2) {
			
			attackReceiver.health -= 2;
			
			attackPhaseInformation.setText(attackReceiver.name+" lost 2 health points");
			deckCardHP[k].get(buttonIndex).setText(String.valueOf(attackReceiver.health));
		}
		else {
			attackPhaseInformation.setText(attackReceiver.name + " got killed by stick");
			cardGetsDestroyed(k, player[k].deck, buttonIndex);
		}

		
		for(int i = 0; i<9; i++) { // getting back to normal use buttons
			
			if(player[playerIndex].deck[i]!=null && !(usedAttackerIndex.contains(i))) 
				deckInteractionButton[playerIndex].get(i).setVisible(true);
			
			deckInteractionButton[k].get(i).setVisible(false);
			
		}
		
	}
	
	
	public void spellQuarters(int playerIndex, int spellIndex) {
    	
		
		if(doesThisDeckContainCreature(player[playerIndex].deck)) { //  the card armor gives 10 HPs to creatures, so we need creatures
			
			passTheTourButton.setVisible(false);
			
			attackPhaseInformation.setText("select one of your cards to make it a soldier");
			
			for(int i = 0; i<9; i++) {
				
				if(player[playerIndex].deck[i]!=null && player[playerIndex].deck[i].getClass()==creature.class)
					deckInteractionButton[playerIndex].get(i).setVisible(true);
				else
					deckInteractionButton[playerIndex].get(i).setVisible(false);
			}
			
		}
		else {  // no creatures in deck
			attackPhaseInformation.setText("there is no creature in your deck so you can't use quarters");
			drawSpell(currentTourPlayer,spellIndex,quarters);
			usedAttackerIndex.remove(Integer.valueOf(spellIndex));
		
		}
		
	}
	

	public void spellCarnival(card deck[], int playerIndex, int spellIndex) {
		cardGetsDestroyed(playerIndex, deck, spellIndex);
		drawMultipleCreatures(playerIndex, minion, 3); // 3 minions
		attackPhaseInformation.setText("you summoned 3 minions!");
		
	}
	
	
	public void spellFireball(int playerIndex, card deck[], int buttonIndex) {
		
		int k = (playerIndex+1)%2; // the opponent player index
		
		if(doesThisDeckContainCreature(player[k].deck)) { // there is creature in opponent deck
			
			attackPhaseInformation.setText("select one creature of your opponent to make it lose 2 health points");
			
			for(int i = 0; i<9; i++) {
				
				deckInteractionButton[currentTourPlayer].get(i).setVisible(false); // current players use buttons disappear
				
				if(player[k].deck[i]!=null && player[k].deck[i].getClass()==creature.class)
					deckInteractionButton[k].get(i).setVisible(true); // attack buttons get visible
				
			}
			
		}
		
		else { // no creatures in opponent deck, so attacking the player 
			player[k].health -= 2; // fireball has 2 damage, attacking the player
			
			attackPhaseInformation.setText("since the opponent has no creatures, you are attacking the player. \nnew "+player[k].name+" health:"+ player[k].health);
			playerHealthLabel[k].setText(player[k].name+"'s health:"+player[k].health);
			
			cardGetsDestroyed(playerIndex, deck, buttonIndex);
		}
		
	}
	
	
	public void spellFireballAttack(int playerIndex, int buttonIndex) {
		
		int k = (playerIndex+1)%2; // opponent index
		
		creature attackReceiver = ((creature)player[k].deck[buttonIndex]);
		
		if(attackReceiver.health>2) {
			
			attackReceiver.health -= 2;
			
			attackPhaseInformation.setText(attackReceiver.name+" lost 2 health points");
			deckCardHP[k].get(buttonIndex).setText(String.valueOf(attackReceiver.health));
		}
		else {
			attackPhaseInformation.setText(attackReceiver.name + " got killed by fireball");
			cardGetsDestroyed(k, player[k].deck, buttonIndex);
		}
		
	}
	
	
    public void spellTraining(player player, int playerIndex, int spellIndex) {
		
    	cardGetsDestroyed(playerIndex, player.deck, spellIndex);
		
		for(int i = 0; i<9;i++) { // searching deck for cards to make them gain 3 attack damages
			
			if(player.deck[i]!=null && player.deck[i].getClass()==creature.class){ // found creature
				
				((creature) player.deck[i]).attackDamage = ((creature) player.deck[i]).attackDamage + 3;
				
				deckCardAD[playerIndex].get(i).setText(String.valueOf(((creature)player.deck[i]).attackDamage));
				
				attackPhaseInformation.setText(player.name + "trained his cards and made them gain 3 attack damages!");
			}
		
		}
	}
	
	
    public void spellArmor(int playerIndex, int spellIndex) {
    	
		
		if(doesThisDeckContainCreature(player[playerIndex].deck)) { //  the card armor gives 10 HPs to creatures, so we need creatures
			
			passTheTourButton.setVisible(false);
			
			attackPhaseInformation.setText("select one of your cards to make it gain 10 health points");
			
			for(int i = 0; i<9; i++) {
				
				if(player[playerIndex].deck[i]!=null && player[playerIndex].deck[i].getClass()==creature.class)
					deckInteractionButton[playerIndex].get(i).setVisible(true);
				
				else
					deckInteractionButton[playerIndex].get(i).setVisible(false);
			}
		
			
			
		}
		else {  // no creatures in deck
			attackPhaseInformation.setText("there is no creature in your deck so you can't use armor");
			drawSpell(currentTourPlayer,spellIndex,armor);
			usedAttackerIndex.remove(Integer.valueOf(spellIndex));
		
		}
		
	}
	
	
	public void spellMeteor(int playerIndex) {
		
		int k = (playerIndex+1)%2; // the opponent player index
		
		if(doesThisDeckContainCreature(player[k].deck)) { // there is creature in opponent deck
			
			attackPhaseInformation.setText("select one card of your opponent to destroy it");
			
			passTheTourButton.setVisible(false);
			
			for(int i = 0; i<9; i++) {
			
				deckInteractionButton[currentTourPlayer].get(i).setVisible(false); // current players use buttons disappear
					
				if(player[k].deck[i]!=null && player[k].deck[i].getClass()==creature.class)
					deckInteractionButton[k].get(i).setVisible(true); // attack buttons get visible
					
			}
					
		}
		else  // no creatures in opponent deck, so cannot use meteor
			attackPhaseInformation.setText("since the opponent has no creatures, you can't use meteor");
		
	}
	
	
	public void spellMeteorAttack(int playerIndex, int buttonIndex) {
    	
    	int k = (playerIndex+1)%2; // opponent index
    	
    	creature attackReceiver = ((creature)player[k].deck[buttonIndex]);
		
    	attackPhaseInformation.setText(attackReceiver.name + " got killed by meteor");
    	
    	cardGetsDestroyed(k, player[k].deck, buttonIndex);
    	

    }
	
	
	public void spellFireballs(card deck[], int playerIndex, int spellIndex) {
		cardGetsDestroyed(playerIndex, deck, spellIndex);		
		drawMultipleSpells(playerIndex, fireball, 3); // 3 fireballs
		attackPhaseInformation.setText("you pulled 3 fireballs!");
		
	}
	
	
	public void spellFullmoon(card deck[], int playerIndex, int spellIndex) { 
		cardGetsDestroyed(playerIndex, deck, spellIndex);
		drawMultipleCreatures(playerIndex, wolf, 3); // 3 wolves
		attackPhaseInformation.setText("you summoned 3 wolves!");
		
	}
	
	
	public void spellApocalypse(int playerIndex, int spellIndex) {
		cardGetsDestroyed(playerIndex, player[playerIndex].deck, spellIndex);
		
		int k = (playerIndex+1)%2; // the opponent player index

		for(int i = 0; i<9; i++) // making null every opponent card
			cardGetsDestroyed(k, player[k].deck, i);
		
		attackPhaseInformation.setText("apocalypse destroyed every card of " + player[k].name);
		
	}
    
    
	public void cardGetsDestroyed(int playerIndex, card deck[], int deckIndex) {	// can be applied to spell or creature 
		deck[deckIndex]=null;
		
		// setting visual values right
		
		
		deckHPADSplitter[playerIndex].get(deckIndex).setVisible(false);
		
		deckCardAD[playerIndex].get(deckIndex).setText("");
		deckCardAD[playerIndex].get(deckIndex).setVisible(false);
		
		deckCardHP[playerIndex].get(deckIndex).setText("");
		deckCardHP[playerIndex].get(deckIndex).setVisible(false);
		
		deckCardName[playerIndex].get(deckIndex).setText("");
		deckCardName[playerIndex].get(deckIndex).setVisible(false);
		
		deckCardSpellText[playerIndex].get(deckIndex).setVisible(false);
		
		deckInteractionButton[playerIndex].get(deckIndex).setText("");
		deckInteractionButton[playerIndex].get(deckIndex).setVisible(false);
		
	}
	
	
    public void attack(creature attacker, int receiverPlayerIndex, card[] defenderDeck, int defenderIndex) { // creatures attacking each other
    	
        creature defender = (creature) defenderDeck[defenderIndex];
        
        if (attacker.attackDamage >= defender.health) { // enough damage to kill
        	
            attackPhaseInformation.setText(attacker.name + " attacked " + defender.name + " and killed it");
            cardGetsDestroyed(receiverPlayerIndex, defenderDeck, defenderIndex);
        } 
        else { // not enough damage to kill
            defender.health -= attacker.attackDamage;
            attackPhaseInformation.setText(attacker.name + " attacked " + defender.name + " and " + 
            defender.name + "'s new health is " + defender.health);
            
            deckCardHP[receiverPlayerIndex].get(defenderIndex).setText(String.valueOf(defender.health));
        }
    }

    
    public void drawMultipleCreatures(int playerIndex, creature creature, int numberOfTimes) { 
		for (int p = 0; p < numberOfTimes; p++) {
	       
			for (int k = 0; k < 9; k++) { // finding empty spot in deck and putting creature
	            
				if (player[playerIndex].deck[k] == null) {
					drawCreature(playerIndex, k, creature);
					break;
				}
	       
			}
	       
		}
		
	}
	
	
	public void drawCreature(int playerIndex, int deckIndex, creature creature) { // creatures and spells has different lines and labels for visual so they have different methods
		player[playerIndex].deck[deckIndex] = copyCard(creature);
		usedAttackerIndex.remove(Integer.valueOf(deckIndex));
		
		// setting visual values right
		
		deckHPADSplitter[playerIndex].get(deckIndex).setVisible(true);
			
		deckCardAD[playerIndex].get(deckIndex).setText(String.valueOf(((creature)player[playerIndex].deck[deckIndex]).attackDamage));
		deckCardAD[playerIndex].get(deckIndex).setVisible(true);
			
		deckCardHP[playerIndex].get(deckIndex).setText(String.valueOf(((creature)player[playerIndex].deck[deckIndex]).health));
		deckCardHP[playerIndex].get(deckIndex).setVisible(true);
	
		deckCardName[playerIndex].get(deckIndex).setText(player[playerIndex].deck[deckIndex].name);
		deckCardName[playerIndex].get(deckIndex).setVisible(true);
	
		deckInteractionButton[playerIndex].get(deckIndex).setText("use");
		deckInteractionButton[playerIndex].get(deckIndex).setVisible(true);
		
	}
	
	
	public void drawMultipleSpells(int playerIndex, spell spell, int numberOfTimes) { 
		for (int p = 0; p < numberOfTimes; p++) {
			
			for (int k = 0; k < 9; k++) { // finding empty spot in deck and putting creature
				
				if (player[playerIndex].deck[k] == null) {
					drawSpell(playerIndex, k, spell);
					break;
				}
				
			}
			
		}
		
	}
	
	
	public void drawSpell(int playerIndex, int deckIndex, spell spell) { // creatures and spells has different lines and labels for visual so they have different methods
		player[playerIndex].deck[deckIndex] = copyCard(spell);
		usedAttackerIndex.remove(Integer.valueOf(deckIndex));
		
		// setting visual values right
		
		deckCardSpellText[playerIndex].get(deckIndex).setVisible(true);
		
		deckCardName[playerIndex].get(deckIndex).setText(player[playerIndex].deck[deckIndex].name);
		deckCardName[playerIndex].get(deckIndex).setVisible(true);
	
		deckInteractionButton[playerIndex].get(deckIndex).setText("use");
		deckInteractionButton[playerIndex].get(deckIndex).setVisible(true);

	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// background color
		Color colorValue = Color.valueOf("#b0dcf2"); // light blue
		pane.setBackground(new Background(new BackgroundFill(colorValue, null, null)));		
		
		// making these so different conditions has shortcut as list.get()
		// 0 for player1, 1 for player2
		playerNameCard[0] = player1NameCards;
		playerNameCard[1] = player2NameCards;

		playerHealthLabel[0] = player1Health;
		playerHealthLabel[1] = player2Health;
		
		deckInteractionButton[0] = new ArrayList<>(Arrays.asList(p1Card1InteractionButton, p1Card2InteractionButton, p1Card3InteractionButton, p1Card4InteractionButton, p1Card5InteractionButton, p1Card6InteractionButton, p1Card7InteractionButton, p1Card8InteractionButton, p1Card9InteractionButton));
		deckInteractionButton[1] = new ArrayList<>(Arrays.asList(p2Card1InteractionButton, p2Card2InteractionButton, p2Card3InteractionButton, p2Card4InteractionButton, p2Card5InteractionButton, p2Card6InteractionButton, p2Card7InteractionButton, p2Card8InteractionButton, p2Card9InteractionButton));

		deckCardName[0] = new ArrayList<>(Arrays.asList(p1Card1Name, p1Card2Name, p1Card3Name, p1Card4Name, p1Card5Name, p1Card6Name, p1Card7Name, p1Card8Name, p1Card9Name));
		deckCardName[1] = new ArrayList<>(Arrays.asList(p2Card1Name, p2Card2Name, p2Card3Name, p2Card4Name, p2Card5Name, p2Card6Name, p2Card7Name, p2Card8Name, p2Card9Name));

		deckCardSpellText[0] = new ArrayList<>(Arrays.asList(p1Card1Spell, p1Card2Spell, p1Card3Spell, p1Card4Spell, p1Card5Spell, p1Card6Spell, p1Card7Spell, p1Card8Spell, p1Card9Spell));
		deckCardSpellText[1] = new ArrayList<>(Arrays.asList(p2Card1Spell, p2Card2Spell, p2Card3Spell, p2Card4Spell, p2Card5Spell, p2Card6Spell, p2Card7Spell, p2Card8Spell, p2Card9Spell));

		deckCardHP[0] = new ArrayList<>(Arrays.asList(p1Card1HP, p1Card2HP, p1Card3HP, p1Card4HP, p1Card5HP, p1Card6HP, p1Card7HP, p1Card8HP, p1Card9HP));
		deckCardHP[1] = new ArrayList<>(Arrays.asList(p2Card1HP, p2Card2HP, p2Card3HP, p2Card4HP, p2Card5HP, p2Card6HP, p2Card7HP, p2Card8HP, p2Card9HP));

		deckCardAD[0] = new ArrayList<>(Arrays.asList(p1Card1AD, p1Card2AD, p1Card3AD, p1Card4AD, p1Card5AD, p1Card6AD, p1Card7AD, p1Card8AD, p1Card9AD));
		deckCardAD[1] = new ArrayList<>(Arrays.asList(p2Card1AD, p2Card2AD, p2Card3AD, p2Card4AD, p2Card5AD, p2Card6AD, p2Card7AD, p2Card8AD, p2Card9AD));

		deckHPADSplitter[0] = new ArrayList<>(Arrays.asList(p1Card1HPADSplitter, p1Card2HPADSplitter, p1Card3HPADSplitter, p1Card4HPADSplitter, p1Card5HPADSplitter, p1Card6HPADSplitter, p1Card7HPADSplitter, p1Card8HPADSplitter, p1Card9HPADSplitter));
		deckHPADSplitter[1] = new ArrayList<>(Arrays.asList(p2Card1HPADSplitter, p2Card2HPADSplitter, p2Card3HPADSplitter, p2Card4HPADSplitter, p2Card5HPADSplitter, p2Card6HPADSplitter, p2Card7HPADSplitter, p2Card8HPADSplitter, p2Card9HPADSplitter));

		for(int i = 0; i<2; i++) {
			
			for (int j = 0; j < 9.; j++) {
				int buttonIndex = j;
				deckInteractionButton[i].get(j).setOnAction(event -> deckInteractionButton(event, buttonIndex));
			}
		
		}
	}

	
	public creature copyCard(creature sample) {//method to use drawed cards as a cloned one so the card's itself is not touched and drawable again
		String sampleName = sample.name;
		String sampleDescription = sample.description;
		int sampleUniqueness = sample.uniqueness;
		int sampleCost = sample.cost;
		int sampleAttackDamage = sample.attackDamage;
		int sampleHealth = sample.health;
		return new creature(sampleCost,sampleDescription,sampleUniqueness,sampleName,sampleAttackDamage,sampleHealth);
			
	}
		
	
	public spell copyCard(spell sample) {//method to use drawed cards as a cloned one so the card's itself is not touched and drawable again
		String sampleName = sample.name;
		String sampleDescription = sample.description;
		int sampleUniqueness = sample.uniqueness;
		int sampleCost = sample.cost;
		return new spell(sampleCost,sampleDescription,sampleUniqueness,sampleName);
			
	}
	
	
}
