package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class endTheGameController {

    @FXML
    private Label wonText;

    public void getDatas(String playerName) {
    	wonText.setText(playerName.toUpperCase()+ " HAS WON!");
    }
    
}
	

