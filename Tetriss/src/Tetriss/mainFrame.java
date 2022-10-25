package Tetriss;

import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class mainFrame extends JFrame {
	Container con = getContentPane();
	
	public mainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("서버");
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new mainFrame();
	}

}
