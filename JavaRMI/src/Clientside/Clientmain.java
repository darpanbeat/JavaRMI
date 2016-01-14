package Clientside;

import javax.swing.JFrame;

public class Clientmain {
	
		public static void main(String args[]){
			//System.out.println(System.getProperty("java.home"));
			Client v = new Client();
			v.setVisible(true);
			v.setLocation(100, 100);
			v.setSize(500, 500);
			v.setResizable(false);
			v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}


 