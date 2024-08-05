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
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class tourSummaryController implements Initializable{

	StringBuilder tourSummary = new StringBuilder();
	
	int tourNumber = 1;
		
	player player[] = new player[2];

	private Stage stage;
	private Scene scene; // these are for going to buy process page
	private Parent root;
	
    @FXML
    private Label tourSummaryLabel;

    @FXML
    private Label TOUR;

    @FXML
	private GridPane pane;
	
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

    @FXML
    void passTheTour(ActionEvent event) throws IOException {
    	
    	if(passTheTourButton.getText().equals("go into buying process")) { // no one is dead
    		
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("buyProcess.fxml")); // going into the buy process page
		
		root = loader.load();
		
		
		
		buyProcessController buyProcessController = loader.getController();
		
		buyProcessController.getDatas(player, tourNumber);
		
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene); 
		stage.show();
    	
    	}
    	else { // game end page
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("endTheGame.fxml")); // going into the end the game page
    		
    		root = loader.load();
    		
    		
    		
    		endTheGameController endTheGameController = loader.getController();
    		
    		if(player[0].health >= player[1].health)
    			endTheGameController.getDatas(player[0].name); // player 0 won
    		
    		else
    			endTheGameController.getDatas(player[1].name); // player 1 won
    		
    		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		scene = new Scene(root);
    		stage.setScene(scene); 
    		stage.show();
    	}
    
    }
    
    public void getDatas(player playerX[], int tourNumberX, String tourSummary) {
    	
    	tourNumber = tourNumberX;
    	
    	// passing players infos to labels
    	for(int i = 0; i<2; i++) {
    		
    		player[i] = playerX[i];
    		player[i].mana = tourNumber;
    		playerHealthLabel[i].setText(player[i].name + "'s health:" + player[i].health);
    		playerNameCard[i].setText(player[i].name + "'s deck");
    	}
    	
    	// player 1 starts first
    	
    	TOUR.setText("TOUR " + (tourNumber-1)); // example: when tour 3 ends there will be tour 3 summary text
    	
    	tourSummaryLabel.setText(tourSummary);

    	if((player[0].health <= 0 || player[1].health <= 0) && player[0].health!=player[1].health) // checking to end the game (if they have same hp, 1 more tour gets played)
    		passTheTourButton.setText("end the game");
    	
    	
    	// making decks and their visuals visible
    	
    	for(int i = 0; i<2; i++) {
    		
    		for(int j = 0; j<9; j++) {
    			
    			if(player[i].deck[j]==null); // protection from null pointer exception
    			
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

}
