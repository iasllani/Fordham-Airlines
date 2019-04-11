// Copyright © 2019 Ilir Asllani. All rights reserved.

package sprint3;

	import javafx.scene.image.Image;
	import javafx.scene.layout.BackgroundImage;
	import javafx.application.Application;
	import javafx.event.ActionEvent;
	import javafx.geometry.Insets;
	import javafx.geometry.Pos;
	import javafx.stage.Stage;
	import javafx.scene.Scene;
	import javafx.scene.control.*;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;
	import javafx.scene.control.RadioButton;
	import javafx.scene.layout.GridPane;
	import javafx.scene.layout.HBox;
	import javafx.scene.layout.*;

	public class sprint3 extends Application
	{	
		Label laFlight, laLocation, laDestination, laTicket, laSeats, laType, laDepart, laReturn, laInfo, laFullName;
		TextField tfLocation, tfDestination, tfSeats, tfDepart, tfReturn, tfFullName;
		TextArea taInfo;
		Button btnReserve, btnExit;
		
		HBox radios;
		RadioButton rbEcon, rbBusi;
		ToggleGroup seat;
		
		
		@Override
		public void start(Stage primaryStage) 
		{		
			
			// labels for prepared data entries
			laFullName		= new Label("Full Name:  ");
			laFlight 		= new Label("Flight Path    -    ");
			laLocation 		= new Label("Location : ");
			laDestination 	= new Label("  Destination : ");
			laTicket		= new Label("Ticket Type   -    ");
			laSeats 		= new Label("Number of Seats: ");
			laType 			= new Label("  Seat Type: ");
			laDepart 		= new Label("Depart: ");
			laReturn		= new Label("  Return: ");
			laInfo 			= new Label("Ticket Information:  ");
			
			// font for labels from data entries
			laFullName.setStyle("-fx-font-weight: bold");
			laFlight.setStyle("-fx-font-weight: bold");
			laLocation.setStyle("-fx-font-weight: bold");
			laDestination.setStyle("-fx-font-weight: bold");
			laTicket.setStyle("-fx-font-weight: bold");
			laSeats.setStyle("-fx-font-weight: bold");
			laType.setStyle("-fx-font-weight: bold");
			laDepart.setStyle("-fx-font-weight: bold");
			laReturn.setStyle("-fx-font-weight: bold");
			laInfo.setStyle("-fx-font-weight: bold");
						
			// radio button plus hbox and insets
			radios 			= new HBox();
			radios.setPrefWidth(10);
			radios.setSpacing(5);
			radios.setPadding(new Insets(0, 0, 0, 0));
			
			//create toggle group and radio button for seat type
			seat 			= new ToggleGroup();	
			rbEcon 			= new RadioButton("Economy");
			rbEcon.setToggleGroup(seat);
	
			rbBusi 			= new RadioButton("Business");
			rbBusi.setToggleGroup(seat);
			
			radios.getChildren().addAll(rbEcon, rbBusi);
								
			// text fields for data entries that require # entry
			tfFullName	     = new TextField();
			tfLocation		 = new TextField();		
			tfDestination	 = new TextField();
			tfSeats			 = new TextField();
			tfDepart		 = new TextField();
			tfReturn 		 = new TextField();
			
			// set prompt hints for textfields to suggest entry
			tfFullName.setPromptText("John Smith");
			tfLocation.setPromptText("NYC - JFK");	
			tfDestination.setPromptText("LA - LAX");
			tfSeats.setPromptText("2");
			tfDepart.setPromptText("mm/dd/yyyy");
			tfReturn.setPromptText("mm/dd/yyyy");
						
			// text area for ticket information
			taInfo 			= new TextArea();
			taInfo.setEditable(false);
			 				
			// concluding buttons
			btnReserve		= new Button("Reserve");
			btnExit 		= new Button("Exit");     
										
			GridPane root 	= new GridPane();
			root.setAlignment(Pos.CENTER);
			root.setPadding(new Insets(10, 10, 10, 10));
			
			// background image code 
			//Image bg = new Image("/resources/FordhamALbgImg.PNG");
			//ImageView mv = new ImageView(bg);

			root.add(laFullName,     1, 0);
			root.add(tfFullName,     2, 0);
			root.add(laFlight,       0, 1);
			root.add(laLocation,     1, 1);
			root.add(tfLocation,     2, 1);
			root.add(laDestination,  3, 1);
			root.add(tfDestination,  4, 1);
			root.add(laTicket,       0, 2);
			root.add(laSeats,        1, 2);
			root.add(tfSeats,        2, 2);
			root.add(laType,         3, 2);
			root.add(radios,         4, 2);
			root.add(laDepart,       1, 3);
			root.add(tfDepart,       2, 3);
			root.add(laReturn,       3, 3);
			root.add(tfReturn,       4, 3);
			root.add(btnReserve,     3, 4);
			root.add(btnExit,        4, 4);
			root.add(laInfo,         0, 5);
			root.add(taInfo,         2, 5, 4, 2);
			
			//root.getChildren().addAll(mv);
		    // BorderPane bp = new BorderPane();
		    // bp.setCenter(root);
				
			setPreferences();
			assignActions();
			
			//BorderPane bck = new BorderPane();
			//Scene scene = new Scene(bck,400,400);
			Scene scene 	= new Scene(root,800,800);
					
			Image img		= new Image("/resources/FALbgimg.png");
			BackgroundImage bgImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, 
			new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
			root.setBackground(new Background(bgImg));
					
			primaryStage.setTitle("Fordham Airlines");
			primaryStage.setScene(scene);
			primaryStage.setHeight(800);
			primaryStage.setWidth(800);
			primaryStage.setResizable(false);
			primaryStage.show();
		}
		
		// assign action events to controls
		public void assignActions() {
		    	btnExit.setOnAction(e -> btnCode(e));
		    	btnReserve.setOnAction(e -> btnCode(e));
		}
		
		// action codes for data entries and radio button and other controls
		public void btnCode(ActionEvent e) {
			
			// local string variables to store values from gui
			String fullName, location, destination, numSeats, rbSeat, depart, rebound;
			
			
			// storing textfield entries into local variables
			fullName 	= tfFullName.getText();
			location 	= tfLocation.getText();
			destination = tfDestination.getText();
			numSeats 	= tfSeats.getText();
			depart 		= tfDepart.getText();
			rebound 	= tfReturn.getText();	
			
			rbSeat = "";
			
	        // radio button get
			// get info from radio button
	        if(rbEcon.isSelected()) {
	        	rbSeat = "Economy";
	        }
	        
	        if(rbBusi.isSelected()) {
	        	rbSeat = "Business";
	        }
			
			// e is the button that is clicked
	        if(e.getSource() == btnReserve) {
	        	fileIO wrFile = new fileIO();    
	        	wrFile.wrTransactionData("Full Name: " + fullName + "\r\n" + "Departing From: " + location + "			" 
	        	+ "Destination To: " + destination + "\r\n" + "Number of Seats: " + numSeats + 
	        			"			" + "Seat Type: " + rbSeat + "\r\n" + "Depart Date: " + depart + "			" +
	        	"Return Date: " + rebound); 
	        	
	        	
	        	taInfo.setText("Full Name: " + fullName + "\r\n" + "Departing From: " + location + "			" +
	        	"Destination To: " + destination + "\r\n" + "Number of Seats: " + numSeats +
	        			"			        " + "Seat Type: " + rbSeat + "\r\n" + "Depart Date: " 
	        	+ depart + "			" + "Return Date: " + rebound);
	        	
	       
	        }
        	//System.exit(0);	

	        if(e.getSource() == btnExit) {
                System.exit(0);	        	
	        }

	    }
		
	 	// method separates main controls width and height
	    private void setPreferences() 
	    {
	    	laFullName.setPrefWidth(150);
	    	tfFullName.setPrefWidth(150);
	    	laFlight.setPrefWidth(150);
	    	laLocation.setPrefWidth(150);
	    	tfLocation.setPrefWidth(150);
	    	laDestination.setPrefWidth(150);
	    	tfDestination.setPrefWidth(100);
	    	laTicket.setPrefWidth(150);
	    	laSeats.setPrefWidth(150);
	    	tfSeats.setPrefWidth(150);
	    	laType.setPrefWidth(150);
	    	radios.setPrefWidth(150);
	    	laDepart.setPrefHeight(150);
	    	laDepart.setPrefWidth(150);
	    	tfDepart.setPrefWidth(150);	 
	    	laReturn.setPrefWidth(150);
	    	tfReturn.setPrefWidth(150);
	    	laInfo.setPrefWidth(150);
	    	taInfo.setPrefHeight(150);
	    	taInfo.setPrefWidth(150);	 
	    	btnReserve.setPrefWidth(75);
	    	btnExit.setPrefWidth(75);	
	    }
		
		public static void main(String[] args) {
			launch(args);
		}
	}