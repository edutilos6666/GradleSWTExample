package com.edutilos.main;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

public class Example2 {
   public static void main(String [] args) {
	  new Example2().test11();  
   }
   
   
   
   
   /*
    * CTabFolder and CTabItem 
    */
   private void test11() {
	   Display display = new Display(); 
	   Shell shell = new Shell(display); 
	   shell.setLayout(new GridLayout());
	   
	   CTabFolder folder = new CTabFolder(shell, SWT.BOTTOM); 
	   GridData dataFolder = new GridData(SWT.FILL, SWT.FILL, true, true); 
	   folder.setSelectionBackground(display.getSystemColor(SWT.COLOR_BLUE));
	   folder.setSelectionForeground(display.getSystemColor(SWT.COLOR_WHITE));
	   
	   for(int i=0; i< 5; ++i) {
		   CTabItem item = new CTabItem(folder, SWT.NONE); 
		   item.setText("Tab "+i);
		   Text txt = new Text(folder , SWT.BORDER); 
		   txt.setText("Text "+ i);
		   item.setControl(txt);
	   }
	   shell.pack();
	   shell.open();
	   while(!shell.isDisposed()) {
		   if(!display.readAndDispatch())
			   display.sleep(); 
	   }
	   
	   shell.dispose();
   }
   
   
   /*
    * testing Tree 
    */
   private void test10() {
	   Display display = new Display(); 
	   Shell shell = new Shell(display); 
	   shell.setLayout(new GridLayout());
	   
	   Tree tree = new Tree(shell, SWT.NONE); 
	   GridData dataTree  = new GridData(SWT.FILL, SWT.FILL, true, true); 
	   tree.setLayoutData(dataTree);
	   
	   for(int i= 0; i< 10; ++i) {
		   TreeItem parentItem = new TreeItem(tree, SWT.NONE); 
		   parentItem.setText(String.valueOf(i));
		   
		   for(int j=0; j< 5; ++j) {
			   TreeItem childItem = new TreeItem(parentItem , SWT.NONE); 
			   childItem.setText(new StringBuilder().append(i).append(" ").append(j).toString());
		   }
	   }
	   
	   
	   shell.open();
	   
	   while(!shell.isDisposed()) {
		   if(!display.readAndDispatch())
			   display.sleep(); 
	   }
	   
	   shell.dispose();
	   
   }
   
   /*
    * testing Table 
    */
   private void test9()  {
	   Display display = new Display(); 
	   Shell shell = new Shell(display); 
	   shell.setLayout(new GridLayout());
	   
	   
	   Table table = new Table(shell, 
			   SWT.MULTI| SWT.FULL_SELECTION| SWT.BORDER); 
	   
	   GridData dataTable = new GridData(SWT.FILL, SWT.FILL, true, true);
	   dataTable.heightHint = 200; 
	   table.setLayoutData(dataTable);
	   table.setHeaderVisible(true);
	  // table.setLinesVisible(true);
	   
	   String[] headers = {
			   "Id", "Name", "Age", "Wage", "Active"
	   }; 
	   
	   for(int i=0; i< headers.length; ++i) {
		   TableColumn col = new TableColumn(table, SWT.NONE); 
		   col.setText(headers[i]);
	   }
	   
	   List<Person> all = Arrays.asList(
			   new Person(1L , "foo", 10 , 100.0, true),
			   new Person(2L , "bar", 20 , 200.0, false), 
			   new Person(3L , "bim", 30 , 300.0, true), 
			   new Person(4L , "pako", 40 , 400.0, false) 
			   ); 
	   
	   
	   for(Person p: all) {
		   TableItem item = new TableItem(table, SWT.NONE); 
		   item.setText(0, String.valueOf(p.getId()));
		   item.setText(1, p.getName());
		   item.setText(2, String.valueOf(p.getAge()));
		   item.setText(3, String.valueOf(p.getWage()));
		   item.setText(4, String.valueOf(p.isActive()));
	   }
	   
	   for(int i=0; i< headers.length; ++i) {
		   table.getColumn(i).pack();
	   }
	   
	   
	   shell.open();
	   while(!shell.isDisposed()) {
		   if(!display.readAndDispatch())
			   display.sleep(); 
	   }
	   shell.dispose();
	   
   }
   
   
   /*
    * MenuBar example 
    */
   private void test8() { 
	   Display display = new Display(); 
	   Shell shell = new Shell(display); 
	   
	   //menubar 
	   Menu menuBar = new Menu(shell, SWT.BAR); 
	   //File 
	   MenuItem menuFileHeader = new MenuItem(menuBar, SWT.CASCADE);
	   menuFileHeader.setText("File");
	   menuFileHeader.setAccelerator(SWT.ALT| 'F');
	   Menu menuFile = new Menu(shell, SWT.DROP_DOWN); 
	   menuFileHeader.setMenu(menuFile);
	   MenuItem itemNew = new MenuItem(menuFile, SWT.PUSH); 
	   itemNew.setText("New");
	   MenuItem itemOpen = new MenuItem(menuFile, SWT.PUSH); 
	   itemOpen.setText("Open..."); 
	   MenuItem itemSave = new MenuItem(menuFile, SWT.PUSH); 
	   itemSave.setText("Save");
	   MenuItem itemSaveAs = new MenuItem(menuFile, SWT.PUSH); 
	   itemSaveAs.setText("Save As...");
	   new MenuItem(menuFile, SWT.SEPARATOR);
	   MenuItem itemPageSetup = new MenuItem(menuFile, SWT.PUSH); 
	   itemPageSetup.setText("Page Setup...");
	   MenuItem itemPrint = new MenuItem(menuFile, SWT.PUSH); 
	   itemPrint.setText("Print...");
	   new MenuItem(menuFile, SWT.SEPARATOR); 
	   MenuItem itemExit = new MenuItem(menuFile, SWT.PUSH); 
	   itemExit.setText("Exit"); 

	   
	   //Edit 
	   MenuItem menuEditHeader = new MenuItem(menuBar, SWT.CASCADE); 
	   menuEditHeader.setText("Edit");
	   menuEditHeader.setAccelerator(SWT.ALT|'E');
	   Menu  menuEdit = new Menu(shell, SWT.DROP_DOWN); 
	   menuEditHeader.setMenu(menuEdit);
	   MenuItem itemUndo = new MenuItem(menuEdit , SWT.PUSH); 
       itemUndo.setText("Undo"); 
       new MenuItem(menuEdit , SWT.SEPARATOR);
	   MenuItem itemCut = new MenuItem(menuEdit , SWT.PUSH);
	   itemCut.setText("Cut");
	   MenuItem itemCopy = new MenuItem(menuEdit , SWT.PUSH);
	   itemCopy.setText("Copy");
	   MenuItem itemPaste = new MenuItem(menuEdit , SWT.PUSH);
	   itemPaste.setText("Paste");
	   MenuItem itemDelete = new MenuItem(menuEdit , SWT.PUSH);
	   itemDelete.setText("Delete");
	   new MenuItem(menuEdit , SWT.SEPARATOR); 
	   MenuItem itemFind = new MenuItem(menuEdit , SWT.PUSH);
	   itemFind.setText("Find...");
	   MenuItem itemFindNext = new MenuItem(menuEdit , SWT.PUSH);
	   itemFindNext.setText("Find Next"); 
	   MenuItem itemReplace = new MenuItem(menuEdit , SWT.PUSH);
	   itemReplace.setText("Replace...");
	   MenuItem itemGoTo = new MenuItem(menuEdit , SWT.PUSH);
	   itemGoTo.setText("Go To...");
	   new MenuItem(menuEdit , SWT.SEPARATOR); 
	   MenuItem itemSelectAll = new MenuItem(menuEdit , SWT.PUSH);
	   itemSelectAll.setText("Select All");
	   MenuItem itemTimeDate = new MenuItem(menuEdit , SWT.PUSH);
	   itemTimeDate.setText("Time/Date");
	   itemTimeDate.setAccelerator(SWT.MOD1+ 'A');
	   shell.setMenuBar(menuBar);
	   
	   
	   itemSelectAll.addListener(SWT.Selection, l-> {
		   System.out.println("itemSelectAll was selected.");
	   });
	   
	   shell.open();
	   
	   while(!shell.isDisposed())  {
		   if(!display.readAndDispatch())
			   display.sleep(); 
	   }
	   
	   shell.dispose();
   }
   
   
   
   /*
    * StackLayout example
    */
   private void test7()  {
	   Display display = new Display(); 
	   Shell shell = new Shell(display); 
	   FillLayout mainLayout = new FillLayout(); 
	   mainLayout.type = SWT.VERTICAL; 
	   shell.setLayout(mainLayout);
	   
	   Composite composite = new Composite(shell, SWT.NONE); 
	   StackLayout layoutComposite =new StackLayout(); 
	   composite.setLayout(layoutComposite);
	   Button buttons[] = new Button[10]; 
	   for(int i=0; i< buttons.length; ++i) {
		   buttons[i] = new Button(composite , SWT.PUSH); 
		   buttons[i].setText("Button "+ i);
	   }
	   
	   layoutComposite.topControl = buttons[0]; 
	   composite.layout();
	   
	   final int index[] = new int[1]; 
	   
	   Button btnGo = new Button(shell, SWT.PUSH); 
	   btnGo.setText("Next Stack Widget");
	   btnGo.addListener(SWT.Selection, l-> {
		   index[0] = (index[0]+1)%10; 
		   layoutComposite.topControl = buttons[index[0]]; 
		   composite.layout();
	   });
	   
	   shell.open(); 
	   while(!shell.isDisposed()) {
		   if(!display.readAndDispatch())
			   display.sleep(); 
	   }
	   
	   shell.dispose();
   }
   
   
   /*
    * 
    * SimpleForm with FillLayout 
    */
   
   private void test6() {
	   Display display = new Display(); 
	   Shell shell = new Shell(display); 
	   FillLayout mainLayout = new FillLayout(); 
	   mainLayout.type = SWT.VERTICAL; 
	   shell.setLayout(mainLayout);
	   
	   //id 
	   Composite compositeId = new Composite(shell, SWT.NONE); 
	   FillLayout layoutId = new FillLayout(); 
	   layoutId.type = SWT.HORIZONTAL; 
	   compositeId.setLayout(layoutId);
	   Label lblId = new Label(compositeId, SWT.NONE);
	   lblId.setText("Id: ");
	   Text txtId = new Text(compositeId, SWT.NONE); 
	   
	   //name 
	   Composite compositeName = new Composite(shell, SWT.NONE); 
	   FillLayout layoutName = new FillLayout(); 
	   layoutName.type = SWT.HORIZONTAL; 
	   compositeName.setLayout(layoutName);
	   Label lblName = new Label(compositeName, SWT.NONE); 
	   lblName.setText("Name: ");
	   Text txtName = new Text(compositeName, SWT.NONE); 
	   
	   //age 
	   Composite compositeAge =new Composite(shell, SWT.NONE); 
	   FillLayout layoutAge = new FillLayout(); 
	   layoutAge.type = SWT.HORIZONTAL; 
	   compositeAge.setLayout(layoutAge);
	   Label lblAge = new Label(compositeAge, SWT.NONE); 
	   lblAge.setText("Age: ");
	   Text txtAge = new Text(compositeAge, SWT.NONE); 
	   
	   //wage 
	   Composite compositeWage =new Composite(shell, SWT.NONE); 
	   FillLayout layoutWage = new FillLayout(); 
	   layoutWage.type = SWT.HORIZONTAL; 
	   compositeWage.setLayout(layoutWage);
	   Label lblWage = new Label(compositeWage, SWT.NONE); 
	   lblWage.setText("Wage: ");
	   Text txtWage = new Text(compositeWage, SWT.NONE); 
	   
	   //buttons 
	   Composite compositeButtons = new Composite(shell, SWT.NONE); 
	   FillLayout layoutButtons = new FillLayout(); 
	   layoutButtons.type = SWT.HORIZONTAL; 
	   compositeButtons.setLayout(layoutButtons);
	   Button btnSave = new Button(compositeButtons, SWT.PUSH | SWT.CENTER); 
	   btnSave.setText("Save");
	   Button btnCancel = new Button(compositeButtons, SWT.PUSH| SWT.CENTER);
	   btnCancel.setText("Cancel");
	   
	   //events 
	   btnSave.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				 try {
					 long id = Long.parseLong(txtId.getText()); 
					 String name = txtName.getText(); 
					 int age = Integer.parseInt(txtAge.getText()); 
					 double wage = Double.parseDouble(txtWage.getText()); 
					 final String newline = System.getProperty("line.separator"); 
					 StringBuilder builder = new StringBuilder(); 
					 builder.append("Id = ").append(id).append(newline)
					 .append("Name = ").append(name).append(newline)
					 .append("Age = ").append(age).append(newline)
					 .append("Wage = ").append(wage).append(newline); 
					 MessageBox msgBox = new MessageBox(shell); 
					 msgBox.setText("Information");
					 msgBox.setMessage(builder.toString());
					 msgBox.open(); 
				 } catch(Exception ex){
					 MessageBox msgBox = new MessageBox(shell);
					 msgBox.setText("Error");
					 msgBox.setMessage(ex.getMessage());
					 msgBox.open(); 
				 }
			}
			   
		   });
		   
		   btnCancel.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
				   txtId.setText("");
				   txtName.setText("");
				   txtAge.setText("");
				   txtWage.setText(""); 
				}
				   
			   });
	   
	   
	   shell.open(); 
	   while(!shell.isDisposed()) {
		   if(!display.readAndDispatch())
			   display.sleep(); 
	   }
	   
	   shell.dispose(); 
   }
   
   
   /*
    * FillLayout test 
    */
   private void test5() {
	   Display display = new Display(); 
	   Shell shell = new Shell(display); 
	   FillLayout mainLayout = new FillLayout(); 
	   mainLayout.type = SWT.VERTICAL; 
	   shell.setLayout(mainLayout);
	   
	   Button btnCheck = new Button(shell, SWT.CHECK); 
	   btnCheck.setText("Button Check");
	   /*
	    *  @see SWT#ARROW
 * @see SWT#CHECK
 * @see SWT#PUSH
 * @see SWT#RADIO
 * @see SWT#TOGGLE
 * @see SWT#FLAT
 * @see SWT#UP
 * @see SWT#DOWN
 * @see SWT#LEFT
 * @see SWT#RIGHT
 * @see SWT#CENTER
 * @see Widget#checkSubclass
 * @see Widget#getStyle
	    */
	   Button btnPush = new Button(shell, SWT.PUSH); 
	   btnPush.setText("Button Push");
	   Button btnRadio = new Button(shell, SWT.RADIO); 
	   btnRadio.setText("Button Radio");
	   Button btnToggle = new Button(shell, SWT.TOGGLE); 
	   btnToggle.setText("Button Toggle");
	   Button btnFlat = new Button(shell, SWT.FLAT); 
	   btnFlat.setText("Button Flat");
	   Button btnUp = new Button(shell, SWT.UP); 
	   btnUp.setText("Button Up");
	   Button btnDown = new Button(shell, SWT.DOWN); 
	   btnDown.setText("Button Down");
	   Button btnLeft = new Button(shell, SWT.LEFT); 
	   btnLeft.setText("Button Left");
	   Button btnRight = new Button(shell, SWT.RIGHT); 
	   btnRight.setText("Button Right");
	   Button btnCenter = new Button(shell, SWT.CENTER); 
	   btnCenter.setText("Button Center");
	   
	   shell.open();
	   
	   while(!shell.isDisposed()) {
		   if(!display.readAndDispatch())
			   display.sleep(); 
	   }
	   
	   shell.dispose();
   }
   
   
   /*
    * Simple Form with FormLayout 
    */
   
   private void test4() {
	   Display display = new Display(); 
	   Shell shell = new Shell(display); 
	   FormLayout mainLayout = new FormLayout(); 
	   shell.setLayout(mainLayout);
	   
	   //title 
	   Label lblTitle = new Label(shell, SWT.NONE);
	   lblTitle.setText("Simple Form by using FormLayout");
	   FormData dataTitle = new FormData(); 
	   dataTitle.left = new FormAttachment(0 , 0); 
	   lblTitle.setLayoutData(dataTitle);
	   //id 
	   Label lblId = new Label(shell, SWT.NONE); 
	   lblId.setText("Id: "); 
	   FormData dataLblId = new FormData(); 
	   dataLblId.left= new FormAttachment(0, 0); 
	   dataLblId.top = new FormAttachment(lblTitle); 
	   lblId.setLayoutData(dataLblId);
	   Text txtId = new Text(shell, SWT.NONE); 
	   FormData dataTxtId = new FormData(); 
	   dataTxtId.left = new FormAttachment(lblId); 
	   dataTxtId.top = new FormAttachment(lblTitle); 
	   txtId.setLayoutData(dataTxtId);
	   //name 
	   Label lblName = new Label(shell, SWT.NONE); 
	   lblName.setText("Name: "); 
	   FormData dataLblName = new FormData(); 
	   dataLblName.left = new FormAttachment(0, 0); 
	   dataLblName.top = new FormAttachment(lblId); 
	   lblName.setLayoutData(dataLblName);
	   Text txtName = new Text(shell, SWT.NONE); 
	   FormData dataTxtName = new FormData(); 
	   dataTxtName.left = new FormAttachment(lblName);
	   dataTxtName.top = new FormAttachment(txtId); 
	   txtName.setLayoutData(dataTxtName);
	   //age 
	   Label lblAge = new Label(shell, SWT.NONE);
	   lblAge.setText("Age: ");
	   FormData dataLblAge = new FormData(); 
	   dataLblAge.left = new FormAttachment(0, 0); 
	   dataLblAge.top = new FormAttachment(lblName); 
	   lblAge.setLayoutData(dataLblAge);
	   Text txtAge = new Text(shell, SWT.NONE); 
	   FormData dataTxtAge = new FormData(); 
	   dataTxtAge.left = new FormAttachment(lblAge); 
	   dataTxtAge.top = new FormAttachment(txtName); 
	   txtAge.setLayoutData(dataTxtAge);
	   //wage 
	   Label lblWage = new Label(shell, SWT.NONE); 
	   lblWage.setText("Wage: ");
	   FormData dataLblWage = new FormData(); 
	   dataLblWage.left = new FormAttachment(0 , 0); 
	   dataLblWage.top = new FormAttachment(lblAge); 
	   lblWage.setLayoutData(dataLblWage);
	   Text txtWage = new Text(shell, SWT.NONE); 
	   FormData dataTxtWage = new FormData(); 
	   dataTxtWage.left = new FormAttachment(lblWage); 
	   dataTxtWage.top = new FormAttachment(txtAge); 
	   txtWage.setLayoutData(dataTxtWage);
	   //buttons 
	   Button btnSave = new Button(shell, SWT.NONE); 
	   btnSave.setText("Save");
	   FormData dataBtnSave = new FormData(); 
	   dataBtnSave.left = new FormAttachment(0 , 0); 
	   dataBtnSave.top = new FormAttachment(lblWage); 
	   btnSave.setLayoutData(dataBtnSave);
	   Button btnCancel = new Button(shell, SWT.NONE);
	   btnCancel.setText("Cancel");
	   FormData dataBtnCancel = new FormData(); 
	   dataBtnCancel.left = new FormAttachment(btnSave); 
	   dataBtnCancel.top = new FormAttachment(txtWage); 
	   btnCancel.setLayoutData(dataBtnCancel);
	   
	   //events 
	   btnSave.addSelectionListener(new SelectionAdapter() {

		@Override
		public void widgetSelected(SelectionEvent e) {
			 try {
				 long id = Long.parseLong(txtId.getText()); 
				 String name = txtName.getText(); 
				 int age = Integer.parseInt(txtAge.getText()); 
				 double wage = Double.parseDouble(txtWage.getText()); 
				 final String newline = System.getProperty("line.separator"); 
				 StringBuilder builder = new StringBuilder(); 
				 builder.append("Id = ").append(id).append(newline)
				 .append("Name = ").append(name).append(newline)
				 .append("Age = ").append(age).append(newline)
				 .append("Wage = ").append(wage).append(newline); 
				 MessageBox msgBox = new MessageBox(shell); 
				 msgBox.setText("Information");
				 msgBox.setMessage(builder.toString());
				 msgBox.open(); 
			 } catch(Exception ex){
				 MessageBox msgBox = new MessageBox(shell);
				 msgBox.setText("Error");
				 msgBox.setMessage(ex.getMessage());
				 msgBox.open(); 
			 }
		}
		   
	   });
	   
	   btnCancel.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
			   txtId.setText("");
			   txtName.setText("");
			   txtAge.setText("");
			   txtWage.setText(""); 
			}
			   
		   });
	   
	  
	   
	   shell.open();
	   
	   while(!shell.isDisposed()) {
		   if(!display.readAndDispatch())
			   display.sleep(); 
	   }
	   
	   shell.dispose(); 
   }
   
   
   /*
    * Creating simple form using RowLayout only 
    */
   private void test3() {
	   Display display = new Display(); 
	   Shell shell = new Shell(display); 
	   RowLayout mainLayout = new RowLayout(); 
	   mainLayout.type = SWT.VERTICAL; 
	   shell.setLayout(mainLayout);
	   
	   //title 
	   Label lblTitle = new Label(shell, SWT.NONE); 
	   lblTitle.setText("Simple Form by using RowLayout");
	   
	   //id 
	   Composite compositeId = new Composite(shell, SWT.NONE); 
	   RowLayout layoutId = new RowLayout(); 
	   layoutId.type = SWT.HORIZONTAL; 
	   compositeId.setLayout(layoutId);
	   Label lblId = new Label(compositeId, SWT.NONE); 
	   lblId.setText("Id: ");
	   Text txtId = new Text(compositeId , SWT.NONE); 
	   
	   //name 
	   Composite compositeName = new Composite(shell,SWT.NONE); 
	   RowLayout layoutName = new RowLayout(); 
	   layoutName.type = SWT.HORIZONTAL; 
	   compositeName.setLayout(layoutName);
	   Label lblName = new Label(compositeName, SWT.NONE);
	   lblName.setText("Name: ");
	   Text txtName = new Text(compositeName, SWT.NONE);
	   
	   //age 
	   Composite compositeAge = new Composite(shell, SWT.NONE); 
	   RowLayout layoutAge = new RowLayout(); 
	   layoutAge.type = SWT.HORIZONTAL; 
	   compositeAge.setLayout(layoutAge);
	   Label lblAge = new Label(compositeAge, SWT.NONE); 
	   lblAge.setText("Age: ");
	   Text txtAge = new Text(compositeAge, SWT.NONE);
	   
	   //wage 
	   Composite compositeWage = new Composite(shell, SWT.NONE); 
	   RowLayout layoutWage = new RowLayout(); 
	   layoutWage.type = SWT.HORIZONTAL; 
	   compositeWage.setLayout(layoutWage);
	   Label lblWage = new Label(compositeWage, SWT.NONE); 
	   lblWage.setText("Wage: ");
	   Text txtWage = new Text(compositeWage, SWT.NONE); 
	   
	   //buttons 
	   Composite compositeButtons = new Composite(shell, SWT.NONE); 
	   RowLayout layoutButtons =new RowLayout(); 
	   layoutButtons.type = SWT.HORIZONTAL; 
	   compositeButtons.setLayout(layoutButtons);
	   Button btnSave = new Button(compositeButtons, SWT.PUSH); 
	   btnSave.setText("Save");
	   Button btnCancel = new Button(compositeButtons, SWT.PUSH); 
	   btnCancel.setText("Cancel");
	   
	   //events 
	   btnSave.addSelectionListener(new SelectionAdapter() {

		@Override
		public void widgetSelected(SelectionEvent e) {
			 try {
				 long id = Long.parseLong(txtId.getText()); 
				 String name = txtName.getText(); 
				 int age = Integer.parseInt(txtAge.getText()); 
				 double wage = Double.parseDouble(txtWage.getText()); 
				 final String newline = System.getProperty("line.separator"); 
				 StringBuilder builder = new StringBuilder(); 
				 builder.append("Id = ").append(id).append(newline)
				 .append("Name = ").append(name).append(newline)
				 .append("Age = ").append(age).append(newline)
				 .append("Wage = ").append(wage).append(newline); 
				 MessageBox msgBox = new MessageBox(shell); 
				 msgBox.setText("Information");
				 msgBox.setMessage(builder.toString());
				 msgBox.open(); 
			 } catch(Exception ex){
				 MessageBox msgBox = new MessageBox(shell);
				 msgBox.setText("Error");
				 msgBox.setMessage(ex.getMessage());
				 msgBox.open(); 
			 }
		}
		   
	   });
	   
	   btnCancel.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
			   txtId.setText("");
			   txtName.setText("");
			   txtAge.setText("");
			   txtWage.setText(""); 
			}
			   
		   });
	   
	   
	   
	   shell.open();
	   
	   while(!shell.isDisposed()) {
		   if(!display.readAndDispatch()) display.sleep(); 
	   }
	   
	   shell.dispose();
   }
   
   
   
   /*
    * testing Composite and RowLayout 
    */
   
   private void test2()  {
	   Display display = new Display(); 
	   Shell shell = new Shell(display); 
	   RowLayout mainLayout = new RowLayout();
	   mainLayout.type= SWT.VERTICAL; 
	   mainLayout.marginBottom = 10 ;
	   mainLayout.marginTop = 10 ; 
	   mainLayout.marginLeft = 10 ; 
	   mainLayout.marginRight = 10 ; 
	   shell.setLayout(mainLayout);
	   
	   //3 Composites 
	   Composite composite1 = new Composite(shell, SWT.NONE);
	   RowLayout layoutComposite1 = new RowLayout(); 
	   layoutComposite1.type = SWT.HORIZONTAL; 
	   composite1.setLayout(layoutComposite1);
	   
	   Button btn1 = new Button(composite1, SWT.PUSH);
	   btn1.setText("Button 1");
	   Button btn2 = new Button(composite1, SWT.PUSH);
	   btn2.setText("Button 2");
	   Button btn3 = new Button(composite1, SWT.PUSH); 
	   btn3.setText("Button 3");
	   
	   //second composite 
	   Composite composite2 = new Composite(shell, SWT.NONE); 
	   RowLayout layoutComposite2 =new RowLayout(); 
	   layoutComposite2.type  = SWT.HORIZONTAL; 
	   composite2.setLayout(layoutComposite2);
	   Button btn4 = new Button(composite2, SWT.PUSH); 
	   btn4.setText("Button 4"); 
	   Button btn5 = new Button(composite2, SWT.PUSH); 
	   btn5.setText("Button 5");
	   Button btn6 = new Button(composite2 , SWT.PUSH); 
	   btn6.setText("Button 6");
	   
	   //third composite 
	   Composite composite3 = new Composite(shell, SWT.NONE); 
	   RowLayout layoutComposite3 = new RowLayout(); 
	   layoutComposite3.type = SWT.HORIZONTAL; 
	   composite3.setLayout(layoutComposite3); 
	   Button btn7 = new Button(composite3 , SWT.PUSH);
	   btn7.setText("Button 7");
	   Button btn8 = new Button(composite3, SWT.PUSH); 
	   btn8.setText("Button 8");
	   Button btn9 = new Button(composite3 , SWT.PUSH); 
	   btn9.setText("Button 9");
	   
	   shell.open(); 
	   while(!shell.isDisposed()) {
		   if(!display.readAndDispatch()) 
			   display.sleep(); 
	   }
	   
	   shell.dispose();
   } 
   
   
   /*
    * Simple Form by using 
    * Display 
    * Shell 
    * GridLayout 
    * Label 
    * Text 
    * Button 
    * Button#addSelectionListener()
    */
   private void test1() {
	 Display display = new Display();
	 Shell shell = new Shell(display);
	 shell.setSize(new Point(400, 400));
	 shell.setLocation(new Point(10, 10)); 
	 
	 //simple form 
	 GridLayout mainLayout = new GridLayout(); 
	 mainLayout.numColumns = 2 ; 
	 shell.setLayout(mainLayout);
	 //title 
	 Label lblTitle = new Label(shell, SWT.NONE);
	 lblTitle.setText("Person Details");
	 Label lbLTitleEmpy = new Label(shell, SWT.NONE); 
     //id 
	 Label lblId = new Label(shell, SWT.NONE); 
	 lblId.setText("Id: ");
	 Text txtId = new Text(shell, SWT.LEFT);
	 //name 
	 Label lblName = new Label(shell , SWT.NONE); 
	 lblName.setText("Name: "); 
	 Text txtName = new Text(shell, SWT.LEFT);
	 //age 
	 Label lblAge = new Label(shell, SWT.NONE); 
	 lblAge.setText("Age: ");
	 Text txtAge = new Text(shell, SWT.LEFT); 
	 //wage 
	 Label lblWage = new Label(shell, SWT.NONE); 
	 lblWage.setText("Wage: ");
	 Text txtWage = new Text(shell, SWT.LEFT); 
	 //buttons 
	 Button btnSave = new Button(shell, SWT.PUSH); 
	 btnSave.setText("Save");
	 Button btnCancel = new Button(shell, SWT.PUSH); 
	 btnCancel.setText("Cancel");
	 
	 btnSave.addSelectionListener(new SelectionAdapter() {

		@Override
		public void widgetSelected(SelectionEvent e) {
			try  {
		   long id = Long.parseLong(txtId.getText()); 
		   String name = txtName.getText(); 
		   int age = Integer.parseInt(txtAge.getText()); 
		   double wage = Double.parseDouble(txtWage.getText());
		   String newline = System.getProperty("line.separator");  
		   StringBuilder builder =new StringBuilder(); 
		   builder.append("id = ").append(id).append(newline)
		   .append("name = ").append(name).append(newline)
		   .append("age = ").append(age).append(newline)
		   .append("wage = ").append(wage).append(newline); 
			MessageBox msgBox = new MessageBox(shell);
			msgBox.setText("Title");
			msgBox.setMessage(builder.toString()); 
			msgBox.open(); 
		   
			} catch(Exception ex) {
				MessageBox msgBox = new MessageBox(shell);
				msgBox.setText("Error");
				msgBox.setMessage(ex.getMessage());
				msgBox.open(); 
			}
		}
	    
	 });
	 
	 btnCancel.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				super.widgetSelected(e);
			}
		    
		 });
	 shell.open();
	 while(!shell.isDisposed()) {
		 if(!display.readAndDispatch()) display.sleep(); 
	 }
	 
	 shell.dispose();

   }
}
