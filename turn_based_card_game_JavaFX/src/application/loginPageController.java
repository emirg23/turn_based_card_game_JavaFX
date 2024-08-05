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
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class loginPageController implements Initializable{

	
	private Stage stage;
	private Scene scene; // these are for going to next page buy process
	private Parent root;
	
	player player[] = new player[2]; 
	
	@FXML
	private GridPane pane;
	
	@FXML
    private TextField player1NameField;

    @FXML
    private TextField player2NameField;

    @FXML
    private Button startTheGameButton;

    @FXML
    void StartTheGame(ActionEvent event) throws IOException{
    	
    	if(player1NameField.getText().replaceAll(" ", "")!="" && player2NameField.getText().replaceAll(" ", "")!="") { // requiring to input some value for text field not counting space (" ")
    		
    		String player1Name = player1NameField.getText();
    		player[0] = new player(player1Name); // player 1 by input 1
    		
    		String player2Name = player2NameField.getText();
    		player[1] = new player(player2Name); // player 2 by input 2

    		
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("buyProcess.fxml")); // going into the buy process page
    		root = loader.load();
    		
    		
    		buyProcessController gamePageController = loader.getController();
    		
    		gamePageController.player1SetNameData(player[0].name); // passing player 1 info to buy process page
    		gamePageController.player2SetNameData(player[1].name); // passing player 2 info to buy process page

    		
    		
    		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		scene = new Scene(root);
    		stage.setScene(scene); 
    		stage.show();
    		
    	
    	}
    
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// background color
		Color colorValue = Color.valueOf("#b0dcf2"); // light blue
        pane.setBackground(new Background(new BackgroundFill(colorValue, null, null)));		
	}

}