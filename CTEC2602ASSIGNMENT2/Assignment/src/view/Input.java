package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.layout.HBox;




public class Input extends GridPane {

	


	private TextField CWmark, CWmark2, CWmark3, CWmark4, ExamMark, ExamMark2, ExamMark3, ExamMark4;
	private TextArea modl1, modl2,modl3 ,modl4;
	private Button btnClear;
	private Button  btnSubmit;

	
	public Input(){
		
		this.setPadding(new Insets (35,35,35,35));
		this.setVgap(30);
		this.setHgap(30);
		this.setAlignment(Pos.TOP_CENTER);
		this.setStyle("-fx-color: #c3c388");
		

		CWmark = new TextField();
		CWmark2 = (new TextField());
		CWmark3 = new TextField();
		CWmark4 = new TextField();
		ExamMark = new TextField();
		ExamMark2 = new TextField();
		ExamMark3 = new TextField();
		ExamMark4 = new TextField();
		modl1 = new TextArea();
		modl2 = new TextArea();
		modl3 = new TextArea();
		modl4 = new TextArea();
		
		Label lblModule = new Label("All Modules");;
	
		Label lblCwMark = new Label("Coursework Mark: ");
		String n = new String("Cou");
		Label lblExamMark = new Label("Exam Mark: ");
		Label lblmods = new Label ();
		Label lblmods1 = new Label();
		Label lblmods2 = new Label();
		Label lblmods3 = new Label();
		
		

		btnClear = new Button("Clear");
		
		btnSubmit =  new Button("Submit Marks");
		
			
	
		
		this.add(lblModule, 0, 0);
		
		this.add(lblmods, 0, 1);
		this.add(modl1, 0, 1);
		
		this.add(lblmods1, 0, 2);
		this.add(modl2, 0, 2);
		
		this.add(lblmods2, 0, 3);
		this.add(modl3, 0, 3);
		
		this.add(lblmods3, 0, 4);
		this.add(modl4, 0, 4);
		this.add(lblCwMark, 1, 0);
		this.add(CWmark, 1, 1);
		this.add(CWmark2, 1, 2);
		this.add(CWmark3, 1, 3);
		this.add(CWmark4, 1, 4);
		this.add(lblExamMark, 2, 0);
		this.add(ExamMark, 2, 1);
		this.add(ExamMark2, 2, 2);
		this.add(ExamMark3, 2, 3);
		this.add(ExamMark4, 2, 4);
		this.add(new HBox(), 1, 5);
		this.add(btnSubmit, 0, 5);
		this.add(new HBox(), 2, 5);
		this.add(btnClear, 1, 5);
		
		CWmark.setMaxWidth(50);
		CWmark2.setMaxWidth(50);
		CWmark3.setMaxWidth(50);
		CWmark4.setMaxWidth(50);
		ExamMark.setMaxWidth(50);
		ExamMark2.setMaxWidth(50);
		ExamMark3.setMaxWidth(50);
		ExamMark4.setMaxWidth(50);
		modl1.setMaxSize(350, 20);
		modl2.setMaxSize(350, 20);
		modl3.setMaxSize(350, 20);
		modl4.setMaxSize(350, 20);
		
		
	

	
	}

		
		
		

		public void addClearHandler(EventHandler<ActionEvent> handler) {
			btnClear.setOnAction(handler);
		}
		 
		
        	public void clear() {
    			
        		CWmark.setText("");
        		CWmark2.setText("");
        		CWmark3.setText("");
        		CWmark4.setText("");
        		ExamMark.setText("");
        		ExamMark2.setText("");
        		ExamMark3.setText("");
        		ExamMark4.setText("");
        		
        		
        		
    		}


        

			
			
			

			public void addSubmitHandler(EventHandler<ActionEvent> handler) {
				btnSubmit.setOnAction(handler);
			}





			public void setModule1(String module)
			{
				modl1.setText(module);
				
			}
		
			public void setModule2(String module)
			{
				modl2.setText(module);
				
			}
		
			public void setModule3(String module)
			{
				modl3.setText(module);
				
			}
			public void setModule4(String module)
			{
				modl4.setText(module);
				
			}
			
			
			public void hidexaminput1()
			{
				ExamMark.setVisible(false);
				
			}
			
			public void hidexaminput2()
			{
				ExamMark2.setVisible(false);
				
			}
			
			public void hidexaminput3()
			{
				ExamMark3.setVisible(false);
				
			}
			public void hidexaminput4()
			{
				ExamMark4.setVisible(false);
				
			}
			
			public	String  getCWmark ()
			{
				return CWmark.getText();
				
			}
			
			
			
			public	String  getCWmark2 ()
			{
				return CWmark2.getText();
				
			}
			
			
			public	String  getCWmark3 ()
			{
				return CWmark3.getText();
				
			}
			
			
			
			public	String  getCWmark4 ()
			{
				return CWmark4.getText();
				
			}
			
			
			
			public	String  getExamMark ()
			{
				return ExamMark.getText();
				
			}
			
			
			public	String  getExamMark2 ()
			{
				return ExamMark2.getText();
				
			}
			
			
			public	String  getExamMark3 ()
			{
				return ExamMark3.getText();
				
			}
			
			
			
			public	String  getExamMark4()
			{
				return ExamMark4.getText();
				
			}
			
			
			
			public void setCWmark(String module)
			{
				CWmark.setText(module);
				
			}
			

			public void setCWmark2(String module)
			{
				CWmark2.setText(module);
				
			}
			
			public void setCWmark3(String module)
			{
				CWmark3.setText(module);
				
			}
			
			
			public void setCWmark4(String module)
			{
				CWmark4.setText(module);
				
			}
			
			
			
			public void setExamMark(String module)
			{
				ExamMark.setText(module);
				
			}
			
			public void setExamMark2(String module)
			{
				ExamMark2.setText(module);
				
			}
			
			
			
			public void setExamMark3 (String module)
			{
				ExamMark3.setText(module);
				
			}
			public void setExamMark4(String module)
			{
				ExamMark4.setText(module);
				
			}
			
			
			
		
	}
