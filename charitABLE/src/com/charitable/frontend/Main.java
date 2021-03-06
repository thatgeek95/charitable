package com.charitable.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

import com.charitable.backend.Charity;
import com.charitable.backend.UserPrefs;


public class Main extends Application {
	
	public static UserPrefs user = new UserPrefs();
	public static Charity[] final_charities = new Charity[5];
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("UI-scene1.fxml"));

			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root,651,475);
			primaryStage.setScene(scene);
			primaryStage.setTitle("charitABLE");
			primaryStage.setResizable(false);
			primaryStage.show();
			//ViewController1.setData();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
