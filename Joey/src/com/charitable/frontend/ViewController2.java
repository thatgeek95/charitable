package com.charitable.frontend;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ViewController2 implements Initializable{

    @FXML ListView listoftypes;
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
        	Stage stage; 
            Parent root = null;
            stage=(Stage) b.getScene().getWindow();
            try {
				root = FXMLLoader.load(getClass().getResource("UI-scene3.fxml"));
			} catch (IOException e1) { 
				e1.printStackTrace();
			}
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }


}
