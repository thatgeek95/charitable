package com.charitable.frontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

public class ViewController1 implements Initializable {

    @FXML
	ComboBox location_importance;
    @FXML TextField zip_code;
    @FXML TextField state;
    @FXML ComboBox size_importance;
    @FXML ComboBox size_selected;
    @FXML Button continue_button;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//System.out.println("Something has been initialized!");
		continue_button.setOnAction(this::handleButtonAction);
	}
	
	@FXML
    private void handleButtonAction(ActionEvent e) {
    	//System.out.println("Button pushed!");
		Button b = (Button)e.getSource();
        if(b == continue_button) {
        	//Get all the input!
        	int locimport = location_importance.getSelectionModel().getSelectedIndex();
        	String zipcode = zip_code.getText();
        	//System.out.println("Zipcode is" + zipcode);
        	
        	int sizeimport = size_importance.getSelectionModel().getSelectedIndex();
        	int size = size_selected.getSelectionModel().getSelectedIndex();
        	
        	String state_id = state.getText();
        	
        	Main.user.setSize(size_selected.getSelectionModel().getSelectedItem().toString(), sizeimport);
        	Main.user.setLoc(zipcode, locimport, state_id);
        	
        	Stage stage; 
            Parent root = null;
            stage=(Stage) b.getScene().getWindow();
            try {
				root = FXMLLoader.load(getClass().getResource("UI-scene2.fxml"));
			} catch (IOException e1) { 
				e1.printStackTrace();
			}
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
	
	/*
	public static void setData(){

		location_importance.getItems().clear();

		location_importance.getItems().addAll(
		            "0",
		            "1",
		            "2",
		            "3",
		            "4",
		            "5");

	}
	*/

}