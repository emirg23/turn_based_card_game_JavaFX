package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class buyProcessController implements Initializable{

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
			
		//deck of cards by costs ----> deck.get( cost*5  +  rarity )
			
	List<Object> deck = new ArrayList<>(Arrays.asList(
			miss, scarecrow, minion, cannibal, bleeder,
		    stick, quarters, carnival, fireball, soldier,
		    sword, crib, wolf, chef, training,
		    armor, meteor, fireballs, golem, fullmoon,
		    knight, asya, apocalypse, ditto, emirg
			));	
			
			//
	
	Integer[] costNumbers = {1,2,3,4,5};
	
	private Stage stage;
	private Scene scene; // these are for making a pop up page of cost deck reveal and going to attack phase page
	private Parent root;
	
	int cost;
	
	int tourNumber = 1; // goes up by one every time attack phase ends up
	
	int currentTourPlayer = 0; // player index for player[playerTourPlayer], if 0 then it is player 1, if 1 then it is player 2. (player 1 stars first)
	
	boolean alreadyPassedTour = false; // to see if it's already passed a turn in this tour
	
	@FXML
	private GridPane pane;
	
	@FXML
    private Label buyingPhaseInformation;
	
    @FXML
    private Label p1Card1AD;

    @FXML
    private Label p1Card1HP;

    @FXML
    private Line p1Card1HPADSplitter;

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
    private Label p2Card9Name;

    @FXML
    private Label p2Card9Spell;
    
    @FXML
    private Button passTheTourButton;

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
	private Label player1Mana;
	
	@FXML
	private Label player1NameCards;

	@FXML
	private Label player2Mana;

	@FXML
	private Label player2NameCards;

	@FXML
	private Label playerBuyingTurn;    

	@FXML
	private ChoiceBox<Integer> costOptions;
	
	@FXML
	private Label playerManaLabel[] = new Label[2];
	
	@FXML
	private Label playerDeckName[] = new Label[2];
 

	public void player1SetNameData(String playerName) { // getting playerName from log in page
		player[0] = new player(playerName);
		player[0].mana = tourNumber; 
	    
		currentTourPlayer = 0; // player 1 starts the game first
		playerBuyingTurn.setText(playerName.toUpperCase()+"'S"); // player 1 starts the game first
		buyingPhaseInformation.setText(playerName+" can choose cost and buy a card"); // player 1 starts the game first

	    playerManaLabel[0].setText(player[0].name+"'s mana:"+player[0].mana); // player 1's mana: X
	    playerDeckName[0].setText(player[0].name+"'s deck"); // player 1's deck

	}
    
	
	public void player2SetNameData(String playerName) { // getting playerName from log in page
		player[1] = new player(playerName);
		player[1].mana = tourNumber;

	    playerManaLabel[1].setText(player[1].name+"'s mana:"+player[1].mana);  // player 2's mana: X
	    playerDeckName[1].setText(player[1].name+"'s deck");  // player 2's deck
	    	
	}
	
	
	@FXML
	void buyCard(ActionEvent event) {
		cost = costOptions.getValue(); // choice box
	    
		if(player[currentTourPlayer].mana>=cost) // enough mana
	    	drawCard(currentTourPlayer, player, cost);
	    	
	    else // not enough mana
	    	buyingPhaseInformation.setText(player[currentTourPlayer]+" doesn't have "+cost+" mana");
	    	
	}
	    
	
public void getDatas(player playerX[], int tourNumberX) {
    	tourNumber = tourNumberX;
    	currentTourPlayer = (tourNumber+1)%2; // player index for player[playerTourPlayer], if 0 then it is player 1, if 1 then it is player 2
    	// passing players infos to labels
    	for(int i = 0; i<2; i++) {
    		player[i] = playerX[i];
    		player[i].mana = tourNumber;
    		playerManaLabel[i].setText(player[i].name + "'s mana:" + player[i].mana);
    		playerDeckName[i].setText(player[i].name + "'s deck");
    	}
    	
    	// player 1 starts first
    	
    	playerBuyingTurn.setText(player[currentTourPlayer].name.toUpperCase()+"'S");
    	buyingPhaseInformation.setText(player[currentTourPlayer].name+" can choose cost and buy a card");

    	

    	
    	
    	// making decks and their visuals visible
    	
    	for(int i = 0; i<2; i++) {
    		
    		for(int j = 0; j<9; j++) {
    			
    			if(player[i].deck[j]==null); // protection from nullpointer exception
    			
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
		
		if(!alreadyPassedTour) { // if this tour no turns passed, other player gets the turn
    		// changing the current player
			if(currentTourPlayer==0)
				currentTourPlayer=1;
			
			else
				currentTourPlayer=0;
		
			alreadyPassedTour=true; // there is no more turn passing (directly going into attack phase)
			passTheTourButton.setText("go into attack phase");
			
		}
		
		else { // there is no turns to be passed so going into attack phase
			FXMLLoader loader = new FXMLLoader(getClass().getResource("attackPhase.fxml")); // going into the buy process page
    		
			root = loader.load();
    		
			
    		
    		attackPhaseController attackPhaseController = loader.getController();
    		
    		attackPhaseController.getDatas(player, tourNumber);
    		
    		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		scene = new Scene(root);
    		stage.setScene(scene); 
    		stage.show();
			
    		return;
		}
		
		playerBuyingTurn.setText(player[currentTourPlayer].name.toUpperCase()+"'S"); // PLAYER 	Y'S BUYING TURN
		buyingPhaseInformation.setText(player[currentTourPlayer].name+" can choose cost and buy a card"); // player Y can choose cost and buy a card

	}
	    
	    
	@FXML
	void revealDeck(ActionEvent event) throws IOException {
		cost = costOptions.getValue(); // getting value for cost deck reveal page
	        
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("costDeckReveal.fxml")); // getting the cost deck reveal pop up page
	    Parent root = loader.load();
	        
	    costDeckRevealController costDeckRevealController = loader.getController();
	        
	    costDeckRevealController.costSetIntData(cost); // method in costDeckRevealController class
	    costDeckRevealController.deckSetListData(deck); // method in costDeckRevealController class
	        
	    Stage stage = new Stage();
	    stage.setTitle(cost + " cost cards");
	    stage.setResizable(false);
	    stage.setScene(new Scene(root));  	
	    stage.show();
	    
	}


	
	
		
	public void drawCard(int playerIndex, player player[], int cost) {// drawing card random of 5 rarity in one of 5 costs
			
		Random random = new Random();
			
		player[playerIndex].mana = player[playerIndex].mana-cost; // charging the player
		
		int rarity = random.nextInt(5); // random rarity of 5
				
			
		for(int i = 0; i<9; i++) { // checking for empty spot in players deck to put card

			if(player[playerIndex].deck[i] == null) { // empty spot


				if((cost==1&&rarity==0)) { // if card 'miss' gets drawen, it do not get into deck
					buyingPhaseInformation.setText(player[currentTourPlayer]+" pulled miss...");
					break;
				}
					
				if((cost==5&&rarity==4)) { // if card 'emirg' gets drawen, its' method gets applied because of its' speciality (the method includes pulling emirg too so we can break)
					pulledEmirg(player, playerIndex);
					break;
				}
					
				if(deck.get((cost-1)*5+rarity).getClass().equals(spell.class)) // spell
					drawSpell(playerIndex, i, (spell)deck.get((cost-1)*5+rarity));
				
				else // creature
					drawCreature(playerIndex, i, (creature)deck.get((cost-1)*5+rarity));
				
				break;
					
			}
			else if(i==8) { // no empty spots has been found till the end of for() block
				buyingPhaseInformation.setText("there is no empty spot in your deck so you can't draw card");
				player[playerIndex].mana = player[playerIndex].mana+cost; // mana refund before mana label text so there is no difference in mana
					
			}
				
		}
		playerManaLabel[playerIndex].setText(player[playerIndex].name+"'s mana:"+player[playerIndex].mana);
	
	}
	
	
	public void pulledEmirg(player player[], int playerIndex) { // emirg heals the player 5 points, kills every creature besides soldier and emirg, (you can have multiple emirgs) and spawns 4 soldiers
		player[playerIndex].health = player[playerIndex].health + 5;
		
		for(int i = 0; i<9; i++) { // killing every creatures besides emirg and soldiers (if emirg/soldier was pulled before, they are not gonna get killed)
			
			if(player[playerIndex].deck[i]==null); // protection from null exception
			
			else if(player[playerIndex].deck[i].getClass()==creature.class && !(player[playerIndex].deck[i].name==emirg.name || player[playerIndex].deck[i].name==soldier.name)) 
				cardGetsDestroyed(player,playerIndex,i);
			
		}
		
		drawSpecificCreature(player, playerIndex, emirg, 1); // 1 emirg
		drawSpecificCreature(player, playerIndex, soldier, 4); // 4 soldiers
		buyingPhaseInformation.setText(player[playerIndex].name+" pulled emirg and healed the "+player[playerIndex].name
		+" 5 points. he came with 4 soldiers of his and killed every creature in "+player[playerIndex].name+"'s deck besides them");

	}
	
	
	public void drawCreature(int playerIndex, int deckIndex, creature creature) { // creatures and spells has different lines and labels for visual so they have different methods
		player[playerIndex].deck[deckIndex] = copyCard(creature);
		
		// setting visual values right
		
		deckHPADSplitter[playerIndex].get(deckIndex).setVisible(true);
			
		deckCardAD[playerIndex].get(deckIndex).setText(String.valueOf(((creature)player[playerIndex].deck[deckIndex]).attackDamage));
		deckCardAD[playerIndex].get(deckIndex).setVisible(true);
			
		deckCardHP[playerIndex].get(deckIndex).setText(String.valueOf(((creature)player[playerIndex].deck[deckIndex]).health));
		deckCardHP[playerIndex].get(deckIndex).setVisible(true);
	
		deckCardName[playerIndex].get(deckIndex).setText(player[playerIndex].deck[deckIndex].name);
		deckCardName[playerIndex].get(deckIndex).setVisible(true);
	
		buyingPhaseInformation.setText(player[currentTourPlayer]+" pulled "+ player[currentTourPlayer].deck[deckIndex].name+"!");

	}
	
	
	public void drawSpell(int playerIndex, int deckIndex, spell spell) { // creatures and spells has different lines and labels for visual so they have different methods
		player[playerIndex].deck[deckIndex] = copyCard(spell);
		
		// setting visual values right
		
		deckCardSpellText[playerIndex].get(deckIndex).setVisible(true);
		
		deckCardName[playerIndex].get(deckIndex).setText(player[playerIndex].deck[deckIndex].name);
		deckCardName[playerIndex].get(deckIndex).setVisible(true);
	
		buyingPhaseInformation.setText(player[currentTourPlayer]+" pulled "+ player[currentTourPlayer].deck[deckIndex].name+"!");
	
	}
	
	
	public void cardGetsDestroyed(player player[],int playerIndex, int deckIndex) {	// can be applied to spell or creature 
		player[playerIndex].deck[deckIndex]=null;
		
		// setting visual values right
		
		deckHPADSplitter[playerIndex].get(deckIndex).setVisible(false);

		deckCardAD[playerIndex].get(deckIndex).setText("");
		deckCardAD[playerIndex].get(deckIndex).setVisible(false);
		
		deckCardHP[playerIndex].get(deckIndex).setText("");
		deckCardHP[playerIndex].get(deckIndex).setVisible(false);

		deckCardName[playerIndex].get(deckIndex).setText("");
		deckCardName[playerIndex].get(deckIndex).setVisible(false);

		deckCardSpellText[playerIndex].get(deckIndex).setVisible(false);
		
	}
	
	
	public void drawSpecificCreature(player player[], int playerIndex, creature creature, int numberOfTimes) { 
		   
		for (int p = 0; p < numberOfTimes; p++) {
	       
			for (int k = 0; k < 9; k++) { // finding empty spot in deck and putting creature
	            
				if (player[playerIndex].deck[k] == null) {
					drawCreature(playerIndex, k, creature);
					break;
				}
	       
			}
	       
		}
		
	}
	
	
	public void drawSpecificSpell(player player[], int playerIndex, spell spell, int numberOfTimes) { 
		   
		for (int p = 0; p < numberOfTimes; p++) {
	       
			for (int k = 0; k < 9; k++) { // finding empty spot in deck and putting creature
	            
				if (player[playerIndex].deck[k] == null) {
					drawSpell(playerIndex, k, spell);
					break;
				}
	       
			}
	       
		}
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// background color
		Color colorValue = Color.valueOf("#b0dcf2"); // light blue
		pane.setBackground(new Background(new BackgroundFill(colorValue, null, null)));		
		
		costOptions.getItems().addAll(costNumbers); // this is for the choice box containing 5 elements
		
		// making these so different conditions has shortcut as list.get()
		// 0 for player1, 1 for player2
		playerManaLabel[0] = player1Mana;
		playerManaLabel[1] = player2Mana;
		
		playerDeckName[0] = player1NameCards;
		playerDeckName[1] = player2NameCards;

		
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
