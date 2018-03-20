package GameUi;

import javafx.event.ActionEvent;
import game.PawanGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

	@FXML
	public void existHandle(ActionEvent event) {
		javafx.application.Platform.exit();
	}

	public void setGame(PawanGame game) {
		this.game = game;
	}
}
