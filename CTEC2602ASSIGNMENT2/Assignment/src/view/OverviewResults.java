package view;




import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.StudentProfile;



public class OverviewResults extends GridPane {

	
	


		private TextArea grades;
		private Button btnSaveprint;
		
		public OverviewResults() {
			this.setVgap(30);
			this.setHgap(30);
			this.setAlignment(Pos.CENTER);
			this.setStyle("-fx-color: #c3c388");
			grades = new TextArea("");
			grades.setEditable(false);
			grades.setMaxSize(1000, 1000);
			this.setPadding(new Insets(40, 40, 40, 40));

			this.getChildren().add(grades);
			btnSaveprint = new Button("SaveOverview");
			this.add(new HBox(), 0, 4);
			this.add(btnSaveprint, 0, 4);
		}
		
		
		
		

		public void fill(StudentProfile model) {
			
			grades.clear();
			grades.appendText("Name : " + model.getStudentName().getFullName() + "\nPnumber: " +
			model.getpNumber() + "\nEmail :" +  model.getEmail() + "\nDate: "
 + model.getDate() + "\nCourse :" + model.getCourse().getCourseName() + "\n2nd year" + model.getCourse());
		}






		public void addSaveprintHandler(EventHandler<ActionEvent> handler) {
			btnSaveprint.setOnAction(handler);
		}





		public void setgrades(String ovr) {
			
			grades.setText(ovr);
		}
		
		
	}

	
	

