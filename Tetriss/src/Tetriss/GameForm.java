package Tetriss;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class GameForm extends JFrame {
	Container con = getContentPane();
	GameArea panel = new GameArea(10);
	
	public GameForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("테트리스 게임");
		setSize(800, 800);
		setFrame();
		setLocationRelativeTo(null);
		setVisible(true);
		startGame();
	}

	private void setFrame() {
		con.setLayout(null);
		con.add(panel);
	}
	
	public void startGame() {
		new GameThread(panel).start();
	}
	
	public static void main(String[] args) {
		new GameForm();
	}

}
