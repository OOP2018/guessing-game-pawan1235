package GameUi;

import java.util.Observable;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GuessView implements java.util.Observer{

	private Stage stage;
	private Label label;
	private int guess = 0;
	/**
	 * Initialize a CountHintView, which show value of game.
	 */
	public GuessView() {
		initComponents();
	}

	/**
	 * Create UI to show the last number that you guess.
	 */
	private void initComponents() {
		stage = new Stage();
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		label = new Label("   ");
		label.setPrefWidth(144);
		label.setFont(new Font("Arial", 80.0));
		label.setAlignment(Pos.CENTER);
		root.getChildren().add(label);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Guess number");
		stage.sizeToScene();
	}
	
	public void run() {
		stage.show();
		displayGuess();
	}
	
	public void displayGuess() {
		label.setText(String.format("%2d", guess));
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1 != null) {
			guess = (int) arg1;
		}
		displayGuess();
	}

}
