package view;


import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Course;
import model.Module;
import model.Name;
import model.StudentProfile;


public class CreateProfilePane extends GridPane {

	private ComboBox<Course> Account;
	private TextField txtPnumber, txtSurname, txtFirstName, txtEmail;
	private DatePicker datepicker;
	private Button btnCreate;
	public StudentProfile model;
	public Name nm;
	private RootProfilePane view;
	private CreateProfilePane sp;
	
	public CreateProfilePane() {
		
		this.setPadding(new Insets(80, 80, 80, 80));
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		this.setStyle("-fx-color: #c3c388");
		
		
		Label lblTitle = new Label("Select Course: ");
		Label lblPnumber = new Label ("Pnumber: ");
		Label lblFirstName = new Label("First name: ");
		Label lblSurname = new Label("Surname: ");
		Label lblEmail = new Label ("Email Address: ");
		Label lblDate = new Label ("Date: ");

		
		Account = new ComboBox<Course>(); 


		txtFirstName = new TextField();
		txtSurname = new TextField();
		txtPnumber = new TextField();
		txtEmail = new TextField();
		datepicker = new DatePicker();
		
		
		

		btnCreate = new Button("Create Account");
		datepicker.setValue(LocalDate.now());
		
		this.add(lblTitle, 0, 0);
		this.add(Account, 1, 0);
		
		this.add(lblPnumber, 0, 1);
		this.add(txtPnumber, 1, 1);
		
		
		this.add(lblFirstName, 0, 2);
		this.add(txtFirstName, 1, 2);

		this.add(lblSurname, 0, 3);
		this.add(txtSurname, 1, 3);
		
		this.add(lblEmail, 0, 4);
		this.add(txtEmail, 1, 4);
		
		this.add(lblDate, 0, 5);
		this.add(datepicker, 1, 5);
			
		this.add(new HBox(), 0, 6);
		this.add(btnCreate, 1, 6);
	}
	
	
	//method to allow the controller to populate the combobox
	public void populateComboBox(Course[] Students) {
		Account.getItems().addAll(Students);
		Account.getSelectionModel().select(0); //select first opponent by default
	}
	
	//methods to retrieve the form selection/input
	public Course getMethod() {
		return Account.getSelectionModel().getSelectedItem();
	}
	
	public Name getNameInput() {
		
			String firstname = txtFirstName.getText();
			String familyname = txtSurname.getText();
			return new Name(firstname,familyname);
	}
	 
	
	public String getPnumberInput() {
		return txtPnumber.getText();
	}
	
	public String getEmailInput() {
		return txtEmail.getText();
	}
	

	
	public  StudentProfile CreateProfiles (){
		
		
		StudentProfile model = new StudentProfile();
		
		model.setCourse(Account.getValue());
		model.setpNumber(txtPnumber.getText());
		
		
		model.setStudentName(new Name(txtFirstName.getText(), txtSurname.getText()));
		model.setEmail(txtEmail.getText());
	
		model.setDate(datepicker.getValue());
		
		
		


		
		
		
		
		
		return model;
		
		
	}

	
	
	public void loadprofile (StudentProfile model) {
		Account.setValue(model.getCourse());
	
		
		txtPnumber.setText(model.getpNumber());
	
		txtFirstName.setText(model.getStudentName().getFirstName());
	
		
		
		txtSurname.setText(model.getStudentName().getFamilyName());
		txtEmail.setText(model.getEmail());
	
		
		datepicker.setValue(model.getDate());
		
		
	}




	
	public void addCreateProfiles(EventHandler<ActionEvent> handler) {
		
		btnCreate.setOnAction(handler);
	
	}
	


}
