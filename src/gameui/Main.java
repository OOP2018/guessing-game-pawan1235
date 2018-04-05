package gameui;

import java.net.URL;

import game.GameConsole;
import game.PawanGame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Main class to run GuessingGame GUI
 * @author Pawan Intawongsa
 *
 */
public class Main  extends Application{

	/**
	 * Initiate the GUI for GuessingGame
	 */
	@Override
	public void start(Stage stage) throws Exception {
		PawanGame game = new PawanGame(100);
		try {
			URL url = getClass().getResource("GameUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: GameUI.fxml");
				Platform.exit();
			}
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();

			GameController control = loader.getController();
			control.setGame(game);
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.sizeToScene();
			stage.setTitle("Click Counter");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		GameConsole console = new GameConsole(game);
		game.addObserver(console);

		CountView count = new CountView(game);
		game.addObserver(count);
		count.run();

		GuessView guess = new GuessView();
		game.addObserver(guess);
		guess.run();

	}
	/**
	 * Run the GussingGame GUI
	 * @param args
	 * 	
	 */
	public static void main(String[] args) {
		launch(args);
	}	

}
