package Tetriss;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	Container con = getContentPane();
	GamePanel panel = new GamePanel();
	JLabel statusBar = new JLabel("0");
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("테트리스 게임");
		setSize(330, 520);
		setFrame();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void setFrame() {
		con.add(panel);
		panel.setFocusable(true);
		panel.requestFocus();
		con.add(statusBar, BorderLayout.SOUTH);
		
	}


	public static void main(String[] args) {
		new MainFrame();
	}

}
