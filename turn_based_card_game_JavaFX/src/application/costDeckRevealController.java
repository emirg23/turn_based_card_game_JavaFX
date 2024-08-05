package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class costDeckRevealController implements Initializable { // this class is a pop up page that comes up when a cost gets selected and button "reveal deck" gets pressed

	int calledCost;
		
	@FXML
	private GridPane pane;
	
	@FXML
	private Label firstCardName;

	@FXML
	private Label firstCardClass;
    
	@FXML
	private Label firstCardSpeciality;
	
	@FXML
	private Label firstCardHP;

	@FXML
	private Label firstCardAD;
	
	@FXML
	private Label secondCardName;
	
	@FXML
	private Label secondCardClass;
	
	@FXML
	private Label secondCardSpeciality;
	
	@FXML
	private Label secondCardHP;
	
	@FXML
	private Label secondCardAD;
	
	@FXML
	private Label thirdCardName;
	
	@FXML
	private Label thirdCardClass;
	
	@FXML
	private Label thirdCardSpeciality;
	
	@FXML
	private Label thirdCardHP;
	
	@FXML
	private Label thirdCardAD;
	
	@FXML
	private Label fourthCardName;
	
	@FXML
	private Label fourthCardClass;
	
	@FXML
	private Label fourthCardSpeciality;
	
	@FXML
	private Label fourthCardHP;

	@FXML
    private Label fourthCardAD;

    @FXML
	private Label fifthCardName;

	@FXML
	private Label fifthCardClass;

    @FXML
    private Label fifthCardSpeciality;

    @FXML
    private Label fifthCardHP;

    @FXML
    private Label fifthCardAD;

    @FXML
	public List<Label> cardNameLabels = new ArrayList<>();
    
    @FXML
	public List<Label> cardClassLabels = new ArrayList<>();
    
    @FXML
	public List<Label> cardSpecialityLabels = new ArrayList<>();
    
    @FXML
	public List<Label> cardHPLabels = new ArrayList<>();
    
    @FXML
	public List<Label> cardADLabels = new ArrayList<>();

    @FXML
    public Label xCostCards;
    
    public void costSetIntData(int cost) { // will be used in buy process page to get the integer data of the cost selection
		
	 	calledCost = cost; // setting int for revealing cost deck
	 	
    	xCostCards.setText(calledCost + " COST CARDS");
    	

    }
    
    public void deckSetListData(List<Object> List) { // will be used in buy process page to get the deck data of the specific cost integer , which we got in costSentIntData
    	
    	
    	for(int i = 0; i<5;i++) { // 5 cards each cost
    		
    		cardNameLabels.get(i).setText(((card)List.get((calledCost-1)*5+i)).name); // card name information
    		cardClassLabels.get(i).setText(((List.get((calledCost-1)*5+i)).getClass()).getSimpleName()); // card class information
    		cardSpecialityLabels.get(i).setText(((card)List.get((calledCost-1)*5+i)).description); //card speciality information (if no speciality, it's just empty)

    		if(((List.get((calledCost-1)*5+i).getClass().equals(spell.class)))) { // if spell, health points and attack damage information gets erased
    			cardHPLabels.get(i).setVisible(false);
    			cardADLabels.get(i).setVisible(false);
    		}
    		else {
    			cardHPLabels.get(i).setText("Health Points:"+((creature)List.get((calledCost-1)*5+i)).health); // health points information
    			cardADLabels.get(i).setText("Attack Damage:"+((creature)List.get((calledCost-1)*5+i)).attackDamage); // attack damage information
    		}
    		
    	}
    
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { // making these so different conditions has shortcut as list.get()
		
		// background color
		Color colorValue = Color.valueOf("#8ae485"); // light blue
		pane.setBackground(new Background(new BackgroundFill(colorValue, null, null)));		
		
		cardNameLabels = List.of(firstCardName, secondCardName, thirdCardName, fourthCardName, fifthCardName);
	    cardClassLabels = List.of(firstCardClass, secondCardClass, thirdCardClass, fourthCardClass, fifthCardClass);
	    cardSpecialityLabels = List.of(firstCardSpeciality, secondCardSpeciality, thirdCardSpeciality, fourthCardSpeciality, fifthCardSpeciality);
	    cardHPLabels = List.of(firstCardHP, secondCardHP, thirdCardHP, fourthCardHP, fifthCardHP);
	    cardADLabels = List.of(firstCardAD, secondCardAD, thirdCardAD, fourthCardAD, fifthCardAD);
		
	}

}
