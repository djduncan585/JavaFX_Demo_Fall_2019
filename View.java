/*
 * Dave Duncan
 * CSC205 Fundamentals of Data Structures
 * Dr. Sandeep Mitra
 * Project 2
 * 12 November 2019
 */

package project2;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.io.*;

/**
 * This is the JavaFX view class defined for this house hunting application.
 * It generates a filled Stage as specified by the Project 2 requirements.
 * Tasty added functionality includes setting the Enter key to find houses,
 * then to randomly bring up other houses from the list of matching houses,
 * removing them from the array for each key press until the array is
 * exhausted.
 * */
public class View extends Application{
	//Variables
	protected static Stage stage;
	protected static TextField minimumPrice;
	protected static TextField maximumPrice;
	protected static TextField minimumArea;
	protected static TextField maximumArea;
	protected static TextField minimumBeds;
	protected static TextField maximumBeds;
	protected static TextArea chosenHome;
	protected static Button findHouse;
	protected static Button findAnotherHouse;
	protected static Button reset;
	
	/**Creates the objects in the View to be utilized.
	 * @param stage The Stage to be generated.*/
	public void start(Stage stage) {
		Controller.sr.setSeed(System.nanoTime()); //Random number generator
		stage = new Stage(StageStyle.DECORATED);
		stage.setTitle("Real Estate Listings");
		stage.setResizable(false);
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
		grid.setVgap(5);
		
		ColumnConstraints column1 = new ColumnConstraints(200);
		ColumnConstraints column2 = new ColumnConstraints(200);
		grid.getColumnConstraints().add(column1);
		grid.getColumnConstraints().add(column2);
		
		Label realEstateListingsLabel = new Label("Real Estate Listings");
		grid.add(realEstateListingsLabel, 0, 0, 2, 1);
		GridPane.setHalignment(realEstateListingsLabel, javafx.geometry.HPos.CENTER);
		Label minimumPriceLabel = new Label("Minimum Price");
		grid.add(minimumPriceLabel, 0, 1);
		GridPane.setHalignment(minimumPriceLabel, javafx.geometry.HPos.CENTER);
		minimumPrice = new TextField();
		grid.add(minimumPrice,  1,  1);
		Label maximumPriceLabel = new Label("Maximum Price");
		grid.add(maximumPriceLabel, 0, 2);
		GridPane.setHalignment(maximumPriceLabel, javafx.geometry.HPos.CENTER);
		maximumPrice = new TextField();
		grid.add(maximumPrice, 1, 2);
		Label minimumAreaLabel = new Label("Minimum Area");
		grid.add(minimumAreaLabel, 0, 3);
		GridPane.setHalignment(minimumAreaLabel, javafx.geometry.HPos.CENTER);
		minimumArea = new TextField();
		grid.add(minimumArea, 1, 3);
		Label maximumAreaLabel = new Label("Maximum Area");
		grid.add(maximumAreaLabel, 0, 4);
		GridPane.setHalignment(maximumAreaLabel, javafx.geometry.HPos.CENTER);
		maximumArea = new TextField();
		grid.add(maximumArea, 1, 4);
		Label minimumBedsLabel = new Label("Minimum Beds");
		grid.add(minimumBedsLabel, 0, 5);
		GridPane.setHalignment(minimumBedsLabel, javafx.geometry.HPos.CENTER);
		minimumBeds = new TextField();
		grid.add(minimumBeds, 1, 5);
		Label maximumBedsLabel = new Label("Maximum Beds");
		grid.add(maximumBedsLabel, 0, 6);
		GridPane.setHalignment(maximumBedsLabel, javafx.geometry.HPos.CENTER);
		maximumBeds = new TextField();
		grid.add(maximumBeds, 1, 6);
		Label chosenHomeLabel = new Label("Chosen Home");
		grid.add(chosenHomeLabel, 0, 7, 2, 1);
		GridPane.setHalignment(chosenHomeLabel, javafx.geometry.HPos.CENTER);
		chosenHome = new TextArea();
		chosenHome.setPrefHeight(80);
		chosenHome.setWrapText(true);
		GridPane.setHalignment(chosenHome, javafx.geometry.HPos.CENTER);
		chosenHome.setEditable(false);
		grid.add(chosenHome, 0, 8, 2, 1);
		findHouse = new Button("Find my dream house!");
		findHouse.setPrefWidth(200);
		findHouse.setOnAction((e) -> Controller.findMyDreamHouse());
		grid.add(findHouse, 0, 9);
		findAnotherHouse = new Button("Not my dream - find me another!");
		findAnotherHouse.setPrefWidth(200);
		findAnotherHouse.setOnAction((e) -> Controller.notMyDreamHouse());
		findAnotherHouse.setDisable(true);
		grid.add(findAnotherHouse, 1, 9);
		reset = new Button("Reset");
		reset.setPrefWidth(200);
		reset.setOnAction((e) -> Controller.resetView());
		grid.add(reset, 0, 10, 2, 1);
		GridPane.setHalignment(reset, javafx.geometry.HPos.CENTER);
		
		Scene scene = new Scene(grid);
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Roboto:700&display=swap");
		File f = new File("src/project2/style.css");
		String fileURI = f.toURI().toString();
		scene.getStylesheets().add(fileURI);
		stage.setScene(scene);
		stage.show();
		
		View.stage = stage;	
	}
	
}
