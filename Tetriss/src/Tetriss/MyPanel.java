package Tetriss;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {
	final int ROWS = 12;
	final int COLS = 10;
	int[][] frame = new int[ROWS][COLS];
	MyRect rects[][];
	int shape[][] = {
					{2, 5},
					{3, 4},
					{3, 5},
					{3, 6}
					};
	Listener lis = new Listener();
	
	public MyPanel() {
		rects = new MyRect[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if(i == 0 || i == ROWS-1 || j == 0 || j == COLS-1) {
					rects[i][j] = new MyRect(j*51, i*51, 50, 50, Color.BLACK);
				} else {
					rects[i][j] = new MyRect(j*51, i*51, 50, 50, Color.LIGHT_GRAY);
				}
			}
		}
	} // panel
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// ㅗ 자 모양 블록 그리기
		for (int i = 0; i < 4; i++) {
			rects[shape[i][0]] [shape[i][1]].setC(Color.RED);
		}
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				rects[i][j].draw(g);
			}
		}
		addKeyListener(lis);
	}
	
	class Listener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			System.out.println(key);
			if (key == KeyEvent.VK_LEFT) {
				for (int i = 0; i < 4; i++) {
					shape[i][1] -= 1;
				}
			} else {
				return;
			}
//			switch (key) {
//			case KeyEvent.VK_LEFT:
//				for (int i = 0; i < 4; i++) {
//					rects[shape[i][0]] [shape[i][1]].setC(Color.YELLOW);
//					shape[i][1] -= 1;
//					System.out.println(key);
//				}
//				break;
//			case KeyEvent.VK_RIGHT:
//				for (int i = 0; i < 4; i++) {
//					rects[shape[i][0]] [shape[i][1]].setC(Color.YELLOW);
//					shape[i][1] += 1;
//				}
//				System.out.println(key);
//				break;
//
//			}
		} // pressed
		
	}
}
