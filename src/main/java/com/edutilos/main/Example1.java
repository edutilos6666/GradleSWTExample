package com.edutilos.main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Example1 {
	private static  Button btn1, btn2 , btn3; 
	
  public static void main(String[] args) {
      Display display = new Display(); 
      Shell shell = new Shell(display); 
      shell.setSize(400, 400);
      shell.setLocation(10, 10);
      
      RowLayout mainLayout = new RowLayout(); 
      shell.setLayout(mainLayout);

      btn1 = new Button(shell , SWT.PUSH);
      btn1.setText("Button 1");
      btn2 = new Button(shell, SWT.PUSH); 
      btn2.setText("Button 2");
      btn3 = new Button(shell, SWT.PUSH); 
      btn3.setText("Button 3");
      
      registerEvents(btn1);
      registerEvents(btn2);
      registerEvents(btn3);
      
      //shell.pack();
      shell.open(); 
      while(!shell.isDisposed()) {
    	  if(!display.readAndDispatch()) display.sleep(); 
      }
      
      shell.dispose(); 
 }
  
  private static void registerEvents(Button btn) {
	 btn.addSelectionListener(new SelectionAdapter() {

		@Override
		public void widgetSelected(SelectionEvent e) {
			Button btn2 = (Button)e.widget; 
		   System.out.println(btn2.getText()+ " was selected.");
		}
		  
	});
  }
}
