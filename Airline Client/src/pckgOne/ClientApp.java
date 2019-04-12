package pckgOne;

import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.*;
import java.time.format.DateTimeFormatter;



public class ClientApp extends Application
{	
	Label laFlight, laLocation, laDestination, laTicket, laType, laBlank, laBlank2, laBlank3, laDepart, laReturn, laInfo, laFullName, laTotal, laPrice;
	TextField tfFullName;
	TextArea taInfo;
	Button btnReserve, btnExit;
	DatePicker dateDepart, dateReturn;
	
	HBox radios;
	RadioButton rbEcon, rbBusi;
	ToggleGroup seat;
	
	double tickProfit;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
		
	// combo box declaration of string values
	ComboBox<String> cbDepart, cbDestination;
	
	@Override
	public void start(Stage primaryStage) 
	{		
		// labels for prepared data entries
		laBlank			= new Label("\n \n");
		laBlank2		= new Label("\n");
		laBlank3		= new Label("\n");
		laFullName		= new Label("Full Name:  ");
		laFlight 		= new Label("Flight Path    -    ");
		laLocation 		= new Label("Location : ");
		laDestination 	= new Label("  Destination : ");
		laTicket		= new Label("Ticket Type   -    ");
		laType 			= new Label("  Seat Type: ");
		laDepart 		= new Label("Depart: ");
		laReturn		= new Label("  Return: ");
		laInfo 			= new Label("Ticket Information:  ");
		laTotal  		= new Label("Total: $");
		laPrice  		= new Label("0");

		dateDepart    	= new DatePicker();
		dateReturn		= new DatePicker();
		

		// font for labels from data entries
		laFullName.setStyle("-fx-font-weight: bold");
		laFlight.setStyle("-fx-font-weight: bold");
		laLocation.setStyle("-fx-font-weight: bold");
		laDestination.setStyle("-fx-font-weight: bold");
		laTicket.setStyle("-fx-font-weight: bold");
		laType.setStyle("-fx-font-weight: bold");
		laDepart.setStyle("-fx-font-weight: bold");
		laReturn.setStyle("-fx-font-weight: bold");
		laInfo.setStyle("-fx-font-weight: bold");
		laTotal.setStyle("-fx-font-weight: bold");
		laPrice.setStyle("-fx-font-weight: bold");

		
		// radio button plus H box and insets
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
		rbEcon.setSelected(true);

		// text fields for data entries that require # entry
		tfFullName	     = new TextField();
		
		// set prompt hints for text fields to suggest entry
		tfFullName.setPromptText("John Smith");
					
		// text area for ticket information
		taInfo 			= new TextArea();
		taInfo.setEditable(false);
		 				
		// concluding buttons
		btnReserve		= new Button("Reserve");
		btnExit 		= new Button("Exit");     
		
		//--------------------DROP DOWN----------------------
		// strings for drop down box
	
		cbDepart = new ComboBox<>();
		cbDepart.getItems().addAll(
				"NYC - JFK",
				"LA - LAX",
				"ATL - HJAIA",
				"CHI - OHIA"
		);
					
		cbDestination = new ComboBox<>();
		cbDestination.getItems().addAll(
				"NYC - JFK",
				"LA - LAX",
				"ATL - HJAIA",
				"CHI - OHIA"
		);
		
		GridPane root 	= new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(10, 10, 10, 10));

		root.add(laBlank,   		   1, 0);
		root.add(laFullName,   		   1, 1);
		root.add(tfFullName,   		   2, 1);
		root.add(laBlank2,   		   1, 2);
		root.add(laFlight,     		   0, 3);
		root.add(laLocation,   		   1, 3);
		root.add(cbDepart,     		   2, 3);
		root.add(laDestination,		   3, 3);
		root.add(cbDestination,		   4, 3);
		root.add(laBlank3,   		   1, 4);
		root.add(laTicket,    		   0, 5);
		root.add(laType,     	       1, 5);
		root.add(radios,     	       2, 5);
		root.add(laDepart,    		   1, 6);
		root.add(dateDepart,   		   2, 6);
		root.add(laReturn,    		   3, 6);
		root.add(dateReturn,   		   4, 6);
		root.add(btnReserve,   		   3, 7);
		root.add(btnExit,      		   4, 7);
		root.add(laTotal,      		   2, 8);
		root.add(laPrice,      		   4, 8);
		root.add(laInfo,       		   0, 9);
		root.add(taInfo,         2, 9, 4, 2);
			
		setPreferences();
		assignActions();
		
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
	
 	// method separates main controls width and height
    private void setPreferences() 
    {
    	laBlank.setPrefHeight(50);
    	laFullName.setPrefWidth(150);
    	tfFullName.setPrefWidth(150);
    	laFlight.setPrefWidth(150);
    	laLocation.setPrefWidth(150);
    	cbDepart.setPrefWidth(150);
    	laDestination.setPrefWidth(150);
    	cbDestination.setPrefWidth(100);
    	laTicket.setPrefWidth(150);
    	laType.setPrefWidth(150);
    	radios.setPrefWidth(150);
    	laDepart.setPrefHeight(50);
    	laDepart.setPrefWidth(150);
    	cbDepart.setPrefWidth(150);	 
    	laReturn.setPrefWidth(150);
    	cbDestination.setPrefWidth(150);
    	laInfo.setPrefWidth(150);
    	taInfo.setPrefHeight(150);
    	taInfo.setPrefWidth(150);	 
    	btnReserve.setPrefWidth(75);
    	btnExit.setPrefWidth(75);	
    }
	
	// assign action events to controls
	public void assignActions() {
	    	btnExit.setOnAction(e -> btnCode(e));
	    	btnReserve.setOnAction(e -> btnCode(e));
	}
	
	// action codes for data entries and radio button and other controls
	public void btnCode(ActionEvent e) {
		
		// local variables to store values from gui
		String fullName, fromPort, toPort, rbSeat, tickCost, tickInfo;
		boolean rc, validName, validPort, validDate;		// boolean values for user validation functions
		double tickAdd; 		// ticket adder
				
		
		// storing text field entries into local variables
		fullName 	= tfFullName.getText();
		fromPort 	= cbDepart.getValue();
		toPort 		= cbDestination.getValue();
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
        	
        	LocalDate depart = dateDepart.getValue();
        	LocalDate rebound = dateDepart.getValue();   	
        	
        	
        	// check for name validation
        	validName = isNameValid(tfFullName, fullName);
        	if(validName == true) {
        		fullName = tfFullName.getText();
        	}
        	else {
        		fullName = "";
        	}
        	
        	validPort = isPortValid(fromPort, toPort);
        	if(validPort == true) {
        		fromPort 	= cbDepart.getValue();
       			toPort 		= cbDestination.getValue();
        				
       			if(toPort == "NYC - JFK" || toPort == "LA - LAX") {
       				laPrice.setText("250");
      				tickCost = laPrice.getText();
               		tickAdd = Double.parseDouble(tickCost);
               		if(rbSeat == "Business") {
               			tickAdd *= 1.5;
               		}
               		tickProfit += tickAdd;
       			}
       			else {
        			laPrice.setText("150");
        			tickCost = laPrice.getText();
               		tickAdd = Double.parseDouble(tickCost);
               		if(rbSeat == "Business") {
               			tickAdd *= 1.5;
               		}
               		tickProfit += tickAdd;
       			}
       			System.out.println(tickAdd);
       			System.out.println(tickProfit);
        	}
            else {
             	fromPort 	= "";
               	toPort 		= "";
            }
            
        	
        	validDate = isDateValid(depart, rebound, localDate);
        	if(validDate == true) {

        		depart = dateDepart.getValue();
            	rebound = dateDepart.getValue(); 
        	}
        	else {
        		depart = null;
        		rebound = null;
        	}
        	
        	// what we print on the client side for ticket summary
        	taInfo.setText("Full Name: " + fullName + "\n" + "Departing From: " + fromPort + "\n" +
        			"Destination To: " + toPort + "\n" + "Seat Type: " + rbSeat + "\n" + "Depart Date: " 
        			+ depart + "\n" + "Return Date: " + rebound + "\n" + "Price: $" + laPrice.getText());
        	
        	// What to send to our transaction log
        	fileIO wrFile = new fileIO();    
        	wrFile.wrTransactionData("Full Name: " + fullName + "\r\n" + "Departing From: " + fromPort + "\r\n" 
        		+ "Destination To: " + toPort + "\r\n" + "Seat Type: " + rbSeat + "\r\n" + "Depart Date: " 
        		+ depart + "\r\n" + "Return Date: " + rebound); 

        	
        	// what we want to send to the server for ticket summary
        	tickInfo = "Full Name: " + fullName + "\n" + "Departing From: " + fromPort + "\n" 
            		+ "Destination To: " + toPort + "\n" + "Seat Type: " + rbSeat + "\n" + 
        			"Depart Date: " + depart + "\n" + "Return Date: " + rebound + "\n" + "Total: $250"; 
        	
			socketUtils sock = new socketUtils();
			rc = sock.socketConnect();
			
        	if(rc == true) {
        		sock.sendMessage(tickInfo);
        	}
        }

        if(e.getSource() == btnExit) {
            System.exit(0);	        	
        }

    }
    
    // checks if data formats are valid
    private boolean isNameValid(TextField input, String data) {
    	String valid;
    	valid = data.replaceAll("\\s+", "");
    	
   		if (valid.matches("[a-zA-Z]+") == true && valid.length() > 3){
    		return true;
    	}
    	
   		else{
    		AlertBox.display("Error", data + " is not a valid name");
    		return false;
    	}
    }
    
    // checks if ports are same for logical error check
    private boolean isPortValid(String depart, String destination) {
    	if(depart != destination) {
    		return true;
    	}
    	else {
    		AlertBox.display("Error", "Cannot leave and arrive to same port!");
    		return false;
    	}
    }
    
 // checks if date is valid
    private boolean isDateValid(LocalDate depart, LocalDate rebound, LocalDate today) {
    	if (depart.compareTo(today) >= 0){
    		//if(depart.isBefore(rebound)) {
    			return true;
    		//}
    	//	else {
    	//		return false;
    	//	}
    	}
    	else {
    		AlertBox.display("Error", "Invalid, Dates Conflict!");
    		return false;
    	}
    }
           
	public static void main(String[] args) {
		launch(args);
	}

}