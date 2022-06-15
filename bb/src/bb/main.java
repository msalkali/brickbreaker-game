package bb;


import javax.swing.*;

public class main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Break Breaker Project");
		
		ObjectAction panel = new ObjectAction();
		
		frame.getContentPane().add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		frame.setSize(490,600);
		
		frame.setResizable(false);
		
		
		
		
	}
	
	
}
