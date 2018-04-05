package gameui;

import javafx.event.ActionEvent;
import game.PawanGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * The main GUI for GuessingGame
 * 
 * @author Pawan Intawongsa
 *
 */
public class GameController {
	@FXML
	Label Lebel;
	@FXML
	Label hintLabel;
	@FXML
	TextField inputText;
	@FXML
	Button guessButton;
	@FXML
	Button existButton;

	PawanGame game;
	private boolean End = false;
	
	/**
	 * When the user press guessButton it will run GuessingGame
	 * @param event
	 * 				is when user press GuessButton
	 */
	@FXML
	public void guessHandle(ActionEvent event) {
		try {
			int guessNum = Integer.parseInt(inputText.getText().trim());
			End = game.guess(guessNum);
			if (End) {
				Lebel.setText("Correct !!!");
				hintLabel.setText(String.format("The Answer is %d", guessNum));
			}
		} catch (NumberFormatException e) {
			hintLabel.setText("Invalid Number");
			hintLabel.setStyle("-fx-text-fill: red");
			guessButton.setText("Invalid Number");
			guessButton.setStyle("-fx-text-fill: red");
		}
		hintLabel.setText(this.game.getMessage());
		inputText.clear();
	}

	/**
	 * Close all GUI of GussingGame
	 * @param event
	 * 				is when user press ExistButton
	 */
	@FXML
	public void existHandle(ActionEvent event) {
		javafx.application.Platform.exit();
	}

	/**
	 * Set game for GameController
	 * @param game
	 * 				is Class of Game that extends NumberGame that we want to set
	 */
	public void setGame(PawanGame game) {
		this.game = game;
	}
}
