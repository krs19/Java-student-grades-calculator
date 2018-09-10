package view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;


	
	
	
	public class Mbar extends MenuBar {

		//declared for access throughout class, as handlers are now attached via methods
		private MenuItem Load, Save, Exit, About;

		

		public Mbar() {      

			
			Menu menus;
			this.setStyle("-fx-color: #c3c388");

		
			menus = new Menu("_File");

			
			Load = new MenuItem("_Load Saved Data");
			Load.setAccelerator(KeyCombination.keyCombination("SHORTCUT+f"));
			menus.getItems().add(Load);
			
			
			Save = new MenuItem("_Save Data");
			Save.setAccelerator(KeyCombination.keyCombination("SHORTCUT+S"));
	
			menus.getItems().add(Save);
		
			

		


			Exit = new MenuItem("Exit");
			Exit.setAccelerator(KeyCombination.keyCombination("SHORTCUT+X"));
			menus.getItems().add(Exit);
			
		
			
			this.getMenus().add(menus);


			menus = new Menu("_Help");

	
			About = new MenuItem("_About");
			About.setAccelerator(KeyCombination.keyCombination("SHORTCUT+A"));
			menus.getItems().add(About);
			

			this.getMenus().add(menus); 
		}

	    
	    
	  
public void addLoadHandler (EventHandler<ActionEvent> handler){
			
			Load.setOnAction(handler);
		}

		
		public void addAboutHandler (EventHandler<ActionEvent> handler){
			
			About.setOnAction(handler);
		}


	public void addExitHandler (EventHandler<ActionEvent> handler){
			
		Exit.setOnAction(handler); 
		}
		
public void addSaveHandler (EventHandler<ActionEvent> handler){
			
			Save.setOnAction(handler);
		}
	
		
	
	
	
}