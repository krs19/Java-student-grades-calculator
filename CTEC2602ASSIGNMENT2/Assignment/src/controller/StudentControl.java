package controller;


	
	
	
	
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import model.Course;
import model.Module;
import model.Name;

import model.StudentProfile;
import view.Input;
import view.Mbar;
import view.OverviewResults;
import view.RootProfilePane;
import view.CreateProfilePane;



public class StudentControl {

	//fields to be used throughout the class
	private RootProfilePane view;
	private CreateProfilePane sp;
	private OverviewResults ors;
	private StudentProfile model;
	private Input inp;
	private Course[] courses;
	private Mbar mmb;
	private Name nm;
	private Module mod;
	private ObjectInputStream os;

	public StudentControl(RootProfilePane view, StudentProfile model) {
		//initialise model and view fields
		this.model = model;
		this.view = view;
		sp = view.getCreateProfilePane();
		ors = view.getOverviewResults();
		inp = view.getInput();
		mmb = view.getMbar();
		courses = this.setandgetCourses();
		
		
		sp.populateComboBox(courses);
		
		this.attachEventHandlers();
		
	}
		
		
		
		private void attachEventHandlers() {
		
			
			inp.addClearHandler(e -> inp.clear());
			mmb.addLoadHandler(new LoadHandler());
			mmb.addSaveHandler(new SaveHandler());
			mmb.addExitHandler(e -> System.exit(0));
			mmb.addAboutHandler(new AboutHandler());
			sp.addCreateProfiles(new CreateProfiles());
			inp.addSubmitHandler(new SubmitHandler());
			ors.addSaveprintHandler(new SaveprintHandler());
		}
		
	

	
	private Course[] setandgetCourses()   {
				Module ctec2121 = new Module("CTEC2121", "Organisations, Project Managemen & Research", true);
				Module ctec2122 = new Module("CTEC2122", "Forensics and Security", false);
				Module ctec2602 = new Module("CTEC2602", "OO Software Design and Development", false);
				Module ctec2701 = new Module("CTEC2701", "Multi-tier Web Applications", true);
				Module ctec2901 = new Module("CTEC2901", "Data Structures and Algorithms", false);
				Module lawg2003 = new Module("LAWG2003", "Issues in Criminal Justice", false);
				Module ctec2903 = new Module("CTEC2903", "System Defence Strategies", true);
				Course compSci = new Course("Computer Science");
				compSci.addModule(ctec2121);
				compSci.addModule(ctec2602);
				compSci.addModule(ctec2701);
				compSci.addModule(ctec2901);
				Course softEng = new Course("Software Engineering");
				softEng.addModule(ctec2121);
				softEng.addModule(ctec2602);
				softEng.addModule(ctec2701);
				softEng.addModule(ctec2901);
				Course compSecu = new Course("Computer Security");
				compSecu.addModule(ctec2121);
				compSecu.addModule(ctec2122);
				compSecu.addModule(ctec2701);
				compSecu.addModule(ctec2903);
				Course forenComp = new Course("Forensic Computing");
				forenComp.addModule(ctec2121);
				forenComp.addModule(ctec2122);
				forenComp.addModule(ctec2701);
				forenComp.addModule(lawg2003);
				Course[] courses = new Course[4];
				courses[0] = compSci;
				courses[1] = softEng;
				courses[2] = compSecu;
				courses[3] = forenComp;
				
				return courses;
				
				
				}

	
	

	
	
	private class CreateProfiles implements EventHandler<ActionEvent> {
		
		public void handle(ActionEvent e){
			
			{
				
	            	model = sp.CreateProfiles();
	            	model.getCourse();
	                model.getpNumber();
	                model.getStudentName();
	                model.getEmail();
	                model.getDate();
	                model.getCourse().getModulesOnCourse();
	         
	                
	                
	                
	                view.change(1);
	                
	 
	          
	                
	                
	                Iterator<Module> it = model.getCourse().getModulesOnCourse().iterator();
	                Module allmodules;
	                Integer counting = 1;
	                while (it.hasNext()) {
	 
	                    allmodules = it.next();
	                    if (counting == 1) {

	                        inp.setModule1(allmodules.getModuleName());
	                  
	                        if (allmodules.isCwkOnly())
	                            inp.hidexaminput1();
	 
	                    } else if (counting == 2) {
	                       
	                        inp.setModule2(allmodules.getModuleName());
	                        if (allmodules.isCwkOnly())
	                            inp.hidexaminput2();
	 
	                    } else if (counting == 3) {
	                 
	                        inp.setModule3(allmodules.getModuleName());
	                        if (allmodules.isCwkOnly())
	                            inp.hidexaminput3();
	 
	                    } else if (counting == 4) {
	           
	                        inp.setModule4(allmodules.getModuleName());
	                       
	                        if (allmodules.isCwkOnly())
	                          inp.hidexaminput4();
	                    }
	                    counting++;
	                   
	                }
	               
	            } 
	        }
	    }
			
		
		
	
	
	private class SaveHandler implements EventHandler<ActionEvent> {
		
		public void handle(ActionEvent e) {
			//save the data model
			String filename = model.getpNumber() + ".dat";
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));) {

			
					oos.writeObject(model);
				

				oos.writeObject(model);
				oos.flush();
				oos.flush();

			
			}
			catch (IOException ioExcep){
				System.out.println("ERROR, NOT SAVED");
			}
		}
	}




	                       

	  private class AboutHandler implements EventHandler<ActionEvent> {

			public void handle(ActionEvent e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("About StudentProfile");
				alert.setHeaderText(null);
				alert.setContentText("Version 1.0 of StudentProfile creator");
				alert.showAndWait();
			}
		}
	  
	  
	


      
		private class LoadHandler implements EventHandler<ActionEvent> {

			public void handle(ActionEvent e) {
				
				
			
				
				TextInputDialog dia = new TextInputDialog();
				dia.setTitle("Input");
				dia.setHeaderText(null);
				dia.setContentText("File Name");
				Optional<String> FileName = dia.showAndWait();
			     if (FileName.isPresent()) {
					try {
						ObjectInputStream our = new ObjectInputStream(new FileInputStream(FileName.get()));
						try {
							model = (StudentProfile) our.readObject();
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						}
					} catch (IOException e1) {
						System.out.println("Error loading.");
					}            	
				}
			}
		
		

			
		

		}
		

        private class SubmitHandler implements EventHandler<ActionEvent> {
public void handle(ActionEvent e) {
// Entering marks is mandatory
Integer flag = 0;
if (inp.getExamMark() == null || inp.getExamMark2() == null || inp.getExamMark3() == null || inp.getExamMark4() == null || inp.getCWmark() == null || inp.getCWmark2() == null || inp.getCWmark3() == null || inp.getCWmark4() == null) {
flag = 1;
}
if (flag == 0) {

// Add marks to model
Iterator<Module> it = model.getCourse().getModulesOnCourse().iterator();
Module allmodules;
Integer count = 1;
String module1 = "";
String module2 = "";
String module3 = "";
String module4 = "";
while (it.hasNext()) {

	allmodules = it.next();
	if (count == 1) {
		allmodules.setCwkMark(Integer.parseInt(inp.getCWmark()));
		module1 = "\nCode: " + allmodules.getModuleCode() + " | Coursework: " + allmodules.getCwkMark();
		if (!allmodules.isCwkOnly()) {
			allmodules.setExamMark(Integer.parseInt(inp.getExamMark()));
			module1 += " | Exam: " + allmodules.getExamMark();
		}

		if (allmodules.requireResit())
			module1 += " | FAIL";
		else
			module1 += " | PASS";

	} else if (count == 2) {
		allmodules.setCwkMark(Integer.parseInt(inp.getCWmark2()));
		module2 = "\nCode: " + allmodules.getModuleCode() + " | Coursework: " + allmodules.getCwkMark();
		if (!allmodules.isCwkOnly()) {
			allmodules.setExamMark(Integer.parseInt(inp.getExamMark2()));
			module2 += " | Exam: " + allmodules.getExamMark();
		}

		if (allmodules.requireResit())
			module2 += " | FAIL";
		else
			module2 += " | PASS";
	} else if (count == 3) {
		allmodules.setCwkMark(Integer.parseInt(inp.getCWmark3()));
		module3 = "\nCode: " + allmodules.getModuleCode() + " | Coursework: " + allmodules.getCwkMark();
		if (!allmodules.isCwkOnly()) {
			allmodules.setExamMark(Integer.parseInt(inp.getExamMark3()));
			module3 += " | Exam: " + allmodules.getExamMark();
		}

		if (allmodules.requireResit())
			module3 += " | FAIL";
		else
			module3 += " | PASS";

	} else if (count == 4) {
		allmodules.setCwkMark(Integer.parseInt(inp.getCWmark4()));
		module4 = "\nCode: " + allmodules.getModuleCode() + " | Coursework: " + allmodules.getCwkMark();
		if (!allmodules.isCwkOnly()) {
			allmodules.setExamMark(Integer.parseInt(inp.getExamMark4()));
			module4 += " | Exam: " + allmodules.getExamMark();
		}

		if (allmodules.requireResit())
			module4 += " |FAIL";
		else
			module4 += " | PASS";

	}
	count++;
}
view.change(2);
String ovr;

ovr = "Name: " + model.getStudentName().getFullName();
ovr += "\nP-Number: " + model.getpNumber();
ovr += "\nEmail: " + model.getEmail();
ovr += "\nDate: " + model.getDate();
ovr += "\nCourse: " + model.getCourse().getCourseName();
ovr += "\n\n Second Year Adverage:";
ovr += "\n====================";
ovr += module1 + module2 + module3 + module4;
ovr += "\n====================";
ovr += "\nCredits Passed: " + model.getCourse().creditsPassed();
ovr += "\nTotal Adverage Mark:" + model.getCourse().yearAverageMark();

ors.setgrades(ovr);


}
}
}

  	  private class SaveprintHandler implements EventHandler<ActionEvent> {

  			public void handle(ActionEvent e) {
  				Alert alert = new Alert(AlertType.INFORMATION);
  				alert.setTitle("About StudentProfile");
  				alert.setHeaderText(null);
  				alert.setContentText("File Saved");
  				alert.showAndWait();
  			}
  		}
  	  
        
        
        
}
	