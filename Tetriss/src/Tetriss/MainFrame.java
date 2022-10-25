package Tetriss;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	Container con = getContentPane();
	GamePanel panel = new GamePanel();
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("메인 프레임");
		setSize(528, 650);
		setFrame();
		setVisible(true);
	}

	private void setFrame() {
		con.add(panel);
		panel.setFocusable(true);
		panel.requestFocus();
		
	}


	public static void main(String[] args) {
		new MainFrame();
	}

}
