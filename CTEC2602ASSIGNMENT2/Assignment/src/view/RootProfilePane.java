package view;



import controller.StudentControl;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;


public class RootProfilePane extends BorderPane {

	private CreateProfilePane sp;
	private OverviewResults ors;
	private Mbar mmb;
	private TabPane tabs;
	private Input inp;
	private StudentControl model;

	
	public RootProfilePane() {
		tabs = new TabPane();
		tabs.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE); //don't allow tabs to be closed
		
		mmb = new Mbar();
		
		sp = new CreateProfilePane();
		ors = new OverviewResults();
		inp = new Input();
		Tab t1 = new Tab("Create Profile", sp);
		Tab t2 = new Tab("Input", inp);
		Tab t3 = new Tab("Overview Results", ors);
		
		//add tabs to tab pane
		tabs.getTabs().add(t1);
		tabs.getTabs().add(t2);
		tabs.getTabs().add(t3);
		
		this.setTop(mmb);
		this.setCenter(tabs);
		
		
		this.setStyle("-fx-font: 20px Tahoma");
		
		
		
		
	}

	
	
	public void change(int index) {
		tabs.getSelectionModel().select(index);
	}
	

	public CreateProfilePane getCreateProfilePane() {
		return sp;
	}

	public OverviewResults getOverviewResults() {
		return ors;
	}
	
	
	public Input getInput() {
		return inp;
	}
	
	

	
	
	

	public void setInputAreaText(String string) {
		
		this.setInputAreaText(string);
	}

	

	public Mbar getMbar() {

		return mmb;
	}
	
	

}