import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PizzaOrderDriver extends Application {
	public void start(Stage primarystage) {
		PizzaOrderPane pane = new PizzaOrderPane();
		pane.setAlignment(Pos.CENTER);

		Scene scene = new Scene(pane, 500, 500);

		primarystage.setTitle("PIZZA TIME");
		primarystage.setScene(scene);
		primarystage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
