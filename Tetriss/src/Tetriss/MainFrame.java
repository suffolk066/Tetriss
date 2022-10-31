package Tetriss;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	Container con = getContentPane();
	GamePanel panel = new GamePanel();
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("테트리스 게임");
		setSize(800, 800);
		setFrame();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void setFrame() {
		con.setLayout(null);
		con.add(panel);
	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
