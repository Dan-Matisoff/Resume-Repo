import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * A program that allows the user to order a fake pizza
 * 
 * @author 23dmatisoff
 *
 */

public class PizzaOrderPane extends VBox {
	private double cost = 12.00;
	private Text text = new Text("Total Cost: " + cost + "\nFor a plain pizza.\nThank you for your order.");
	private RadioButton redButton, blueButton, purpleButton, greenButton, goldButton, pinkButton;
	private CheckBox onions, broccoli, pepperoni, pineapple, mushrooms, peppers, basil;

	public PizzaOrderPane() {

		ToggleGroup colour = new ToggleGroup(); // Radio Button Toggle Group

		redButton = new RadioButton("Red"); // Red Button
		redButton.setToggleGroup(colour);
		redButton.setOnAction(this::processRadioButton);
		redButton.setSelected(true);
		setStyle("-fx-background-color: crimson"); // Set Style due to the button not
													// initially running the event command

		blueButton = new RadioButton("Blue"); // Blue Button
		blueButton.setToggleGroup(colour);
		blueButton.setOnAction(this::processRadioButton);

		purpleButton = new RadioButton("Purple"); // Purple Button
		purpleButton.setToggleGroup(colour);
		purpleButton.setOnAction(this::processRadioButton);

		greenButton = new RadioButton("Green"); // Green Button
		greenButton.setToggleGroup(colour);
		greenButton.setOnAction(this::processRadioButton);

		goldButton = new RadioButton("Gold"); // Gold Button
		goldButton.setToggleGroup(colour);
		goldButton.setOnAction(this::processRadioButton);

		pinkButton = new RadioButton("Pink"); // Pink Button
		pinkButton.setToggleGroup(colour);
		pinkButton.setOnAction(this::processRadioButton);

		// put them all in an HBox
		HBox radioBox = new HBox(redButton, blueButton, purpleButton, greenButton, goldButton, pinkButton); // Place
																											// buttons
																											// in box

		// Separate the background changer from the Pizza Buttons and such
		Text separator = new Text("==========================================");

		onions = new CheckBox("onions"); // Onions
		onions.setOnAction(this::processCheckbox);

		broccoli = new CheckBox("broccoli"); // broccoli
		broccoli.setOnAction(this::processCheckbox);

		pepperoni = new CheckBox("pepperoni"); // pepperoni
		pepperoni.setOnAction(this::processCheckbox);

		pineapple = new CheckBox("pineapple"); // pineapple
		pineapple.setOnAction(this::processCheckbox);

		mushrooms = new CheckBox("mushrooms"); // mushrooms
		mushrooms.setOnAction(this::processCheckbox);

		peppers = new CheckBox("peppers"); // peppers
		peppers.setOnAction(this::processCheckbox);

		basil = new CheckBox("basil"); // basil
		basil.setOnAction(this::processCheckbox);

		VBox innerVBox = new VBox(onions, broccoli, pepperoni, pineapple, mushrooms, peppers, basil);

		HBox innerHBox = new HBox(innerVBox, text);
		// innerHBox.getChildren().add(innerVBox);

		getChildren().addAll(radioBox, separator, innerHBox);
	}

	public void processRadioButton(ActionEvent event) {
		if (redButton.isSelected()) {
			setStyle("-fx-background-color: crimson");
		} else if (blueButton.isSelected()) {
			setStyle("-fx-background-color: blue");
		} else if (purpleButton.isSelected()) {
			setStyle("-fx-background-color: darkviolet");
		} else if (goldButton.isSelected()) {
			setStyle("-fx-background-color: darkGoldenRod");
		} else if (pinkButton.isSelected()) {
			setStyle("-fx-background-color: deepPink");
		} else {
			setStyle("-fx-background-color: forestgreen");
		}
	}

	public void processCheckbox(ActionEvent event) {
		cost = 12.00;
		String toppings = "";
		if (onions.isSelected()) {
			cost += .75;
			toppings += "Onions, ";
		}
		if (broccoli.isSelected()) {
			cost += .75;
			toppings += "Broccoli, ";
		}
		if (pepperoni.isSelected()) {
			cost += .75;
			toppings += "Pepperoni, ";
		}
		if (mushrooms.isSelected()) {
			cost += .75;
			toppings += "Mushrooms, ";
		}
		if (pineapple.isSelected()) {
			cost += .75;
			toppings += "Pineapple, ";
		}
		if (peppers.isSelected()) {
			cost += .75;
			toppings += "Peppers, ";
		}
		if (basil.isSelected()) {
			cost += .75;
			toppings += "Basil, ";
		}

		if (cost > 12.00) {
			text.setText(
					"Total Cost: " + cost + "\nYour Toppings: " + toppings + "and Cheese.\nThank you for your order.");
		} else {
			text.setText("Total Cost: " + cost + "\nFor a plain pizza.\nThank you for your order.");
		}
	}
}
