package client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author Tyler Spencer
 * @version 0.1
 * 
 * A basic javafx application to take a user input of a number in
 * kilograms and tell the user what their value is is pounds
 *
 *
 */

public class UI extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button btn1 = new Button("Convert");

		TextField input = new TextField("0");
		input.setMaxWidth(60);
		
		Text text = new Text();
		Text text1 = new Text("Please enter a number in kilograms below");
		
		/**  
		 * This is the event handler that will take the user input as an integer
		 * If the user input is not a number it will print an error message
		 * It then takes the user input and performs the calculation to convert it
		 * to pounds and prints out the new value in pounds
		 **/
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				int kg;
				try{
				kg = Integer.parseInt(input.getText());	
				}catch (NumberFormatException e){
					text1.setText("That is not a number, please enter a number");
					return;
				}
				
				int lbs = (int) (kg / 0.45359237);
				text.setText(kg + " kilograms is equal to " + lbs + " pounds");
			}
			
		});
		
		/** this is the vBox that holds the text, button and text field */
		VBox vbox = new VBox();
		vbox.getChildren().addAll(text1, input, btn1, text);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(100, 100, 100, 100));
		vbox.setSpacing(25);

		Group root = new Group();
		root.getChildren().add(vbox);
		
		Scene scene = new Scene(root, 400, 300);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Weight Converter");
        primaryStage.show();
	}

}
