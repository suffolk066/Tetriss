package Tetriss;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class mainFrame extends JFrame {
	Container con = getContentPane();
	MyPanel panel = new MyPanel();
	
	public mainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("메인 프레임");
		setSize(528, 650);
		setFrame();
		setVisible(true);
	}

	private void setFrame() {
//		JPanel pnlFrame = new JPanel();
//		con.add(pnlFrame);
		con.add(panel);
		panel.setFocusable(true);
		panel.requestFocus();
		
	}


	public static void main(String[] args) {
		new mainFrame();
	}

}
