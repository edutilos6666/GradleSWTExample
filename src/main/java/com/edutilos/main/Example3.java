package com.edutilos.main;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class Example3 {

	protected Shell shell;
	private Text txtId;
	private Text txtName;
	private Text txtAge;
	private Text txtWage;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Example3 window = new Example3();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(647, 386);
		shell.setText("SWT Application");
		
		Label lblTitle = new Label(shell, SWT.NONE);
		lblTitle.setAlignment(SWT.CENTER);
		lblTitle.setBounds(132, 10, 367, 15);
		lblTitle.setText("Simple Form by Using WindowBuilder");
		
		Label lblId = new Label(shell, SWT.NONE);
		lblId.setBounds(84, 42, 102, 15);
		lblId.setText("Id:");
		
		txtId = new Text(shell, SWT.BORDER);
		txtId.setBounds(332, 42, 205, 21);
		
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setText("Name:");
		lblName.setBounds(84, 85, 102, 15);
		
		txtName = new Text(shell, SWT.BORDER);
		txtName.setBounds(332, 85, 205, 21);
		
		Label lblAge = new Label(shell, SWT.NONE);
		lblAge.setText("Age:");
		lblAge.setBounds(84, 141, 102, 15);
		
		txtAge = new Text(shell, SWT.BORDER);
		txtAge.setBounds(332, 141, 205, 21);
		
		Label lblWage = new Label(shell, SWT.NONE);
		lblWage.setText("Wage:");
		lblWage.setBounds(84, 198, 102, 15);
		
		txtWage = new Text(shell, SWT.BORDER);
		txtWage.setBounds(332, 198, 205, 21);
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setBounds(462, 260, 75, 25);
		btnCancel.setText("Cancel");
		
		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.setBounds(332, 260, 75, 25);
		btnSave.setText("Save");

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
		   
	}
}
