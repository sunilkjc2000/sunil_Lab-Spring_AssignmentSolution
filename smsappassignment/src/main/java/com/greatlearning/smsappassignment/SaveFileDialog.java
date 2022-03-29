package com.greatlearning.smsappassignment;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SaveFileDialog  {

	public static File createWindow() {
		
		System.setProperty("java.awt.headless", "false");
	      JFrame frame = new JFrame("Swing Tester");
	      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      File file = createUI(frame);
	      
	      frame.setSize(560, 200);      
	      frame.setLocationRelativeTo(null);  
	      frame.setVisible(false);
	      frame.dispose();
	      
	      return file;
	   }

	   private static File createUI(final JFrame frame){  

	     JFileChooser fileChooser = new JFileChooser();
	     fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	     File file = null;
	     
	     frame.setVisible(false);
	     frame.setVisible(true);
	     frame.toFront();
	     frame.setState(JFrame.NORMAL);
	     int option = fileChooser.showSaveDialog(frame);
	     if(option == JFileChooser.APPROVE_OPTION){
	        file = fileChooser.getSelectedFile();
	               
	     }
	     if(file == null)
	    	 JOptionPane.showMessageDialog(frame, "No report file provided as input");
	     return file;
	   }  
}
