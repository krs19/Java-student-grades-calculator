package Main;


import controller.StudentControl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.StudentProfile;
import view.RootProfilePane;


public class LoadApp extends Application{

	
	
	private RootProfilePane view;

	@Override
	public void init()  {
		//create model and view and pass their references to the controller
		StudentProfile model = new StudentProfile();
		view = new RootProfilePane();
		new StudentControl(view,model);	
	}
		@Override
		public void start(Stage stage) throws Exception{
			stage.setMinWidth(700); //sets min width and height for the stage window
			stage.setMinHeight(700);
			stage.setTitle("Student Profile");
			stage.setScene(new Scene(view));
			stage.show();
			stage.getStyle();
			
		}

		public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	
}
