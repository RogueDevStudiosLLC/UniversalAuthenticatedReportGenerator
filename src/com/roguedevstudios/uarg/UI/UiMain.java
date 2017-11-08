package com.roguedevstudios.uarg.UI;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;


final class UiMainView extends Application
{
	public static void main(String[] args) 
	{
		Application.launch(UiMainView.class, (java.lang.String[])null);
		
		
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		try 
		{
			FXMLLoader.load(UiMainView.class.getResource("UITEST.fxml"));
		Scene scene = new Scene(page);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Company Name");
		primaryStage.show();
		}
		catch (Exception e)
		{
			Logger.getLogger(UiMainView.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
}
