package Tetriss;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class GameForm extends JFrame {
	Container con = getContentPane();
	GameArea gameArea = new GameArea(10);

	public GameForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("테트리스 게임");
		setSize(800, 800);
		setFrame();
		setLocationRelativeTo(null);
		setVisible(true);
		startGame();
		initControls();
		con.requestFocus();
	}
	
	private void initControls() {
		con.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				int rotateType = 0;
				switch (key) {
				case KeyEvent.VK_RIGHT:
					gameArea.moveBlockRight();
					break;
				case KeyEvent.VK_LEFT:
					gameArea.moveBlockLeft();
					break;
				case KeyEvent.VK_UP:
					rotateType = KeyEvent.VK_UP;
					gameArea.rotateBlock(rotateType);
					break;
				case KeyEvent.VK_DOWN:
					rotateType = KeyEvent.VK_DOWN;
					gameArea.rotateBlock(rotateType);
					break;
				case KeyEvent.VK_SPACE:
					gameArea.dropBlockQuick();
					break;
				}
			}
		});
	}
	
	private void setFrame() {
		con.setLayout(null);
		con.add(gameArea);
	}
	
	public void startGame() {
		new GameThread(gameArea).start();
	}
	
	public static void main(String[] args) {
		new GameForm();
	}
}
