package Tetriss;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	final int BOARD_ROWS = 12;
	final int BOARD_COLS = 10;
	int[][] gameBoard = new int[BOARD_ROWS][BOARD_COLS];
	
	GenerateRect rects[][];
	Listener keyListener = new Listener();
	
	// ㅗ자 모양 도형
	int rectShape[][] = {
					{2, 5},
					{3, 4},
					{3, 5},
					{3, 6}
					};
	
	
	public GamePanel() {
		rects = new GenerateRect[BOARD_ROWS][BOARD_COLS];
		for (int i = 0; i < BOARD_ROWS; i++) {
			for (int j = 0; j < BOARD_COLS; j++) {
				if(i == 0 || i == BOARD_ROWS-1 || j == 0 || j == BOARD_COLS-1) {
					rects[i][j] = new GenerateRect(j*51, i*51, 50, 50, Color.BLACK);
				} else {
					rects[i][j] = new GenerateRect(j*51, i*51, 50, 50, Color.LIGHT_GRAY);
				}
			}
		}
		addKeyListener(keyListener);
	} // panel
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// 게임판 그리기
		for (int i = 0; i < BOARD_ROWS; i++) {
			for (int j = 0; j < BOARD_COLS; j++) {
				rects[i][j].drawRect(g);
			}
		}
		// ㅗ 자 모양 블록 그리기
		for (int i = 0; i < 4; i++) {
			rects[rectShape[i][0]] [rectShape[i][1]].setColor(Color.RED);
		}
	}
	
	class Listener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			System.out.println("input:" + key);
			
			// 왼쪽 방향키 누르면 -1
			if (key == KeyEvent.VK_LEFT) {
				for (int i = 0; i < 4; i++) {
					if (rectShape[i][1] < 2) {
						System.out.println("왼쪽 이동 불가");
						return;
					}
					// 원래 색 지우기
					rects[rectShape[i][0]] [rectShape[i][1]].setColor(Color.LIGHT_GRAY);
					rectShape[i][1] -= 1;
					// 이동한 칸에 다시 입히기
					rects[rectShape[i][0]] [rectShape[i][1]].setColor(Color.RED);
				}
			} else if (key == KeyEvent.VK_RIGHT) {
				for (int i = 0; i < 4; i++) {
					if (rectShape[i][1] > 7 ) {
						System.out.println("오른쪽 이동 불가");
						return;
					}
					// 원래 색 지우기
					System.out.println("변경전: " + rectShape[i][1]);
//					rects[rectShape[i][0]] [rectShape[i][1]].setColor(Color.LIGHT_GRAY);
					rectShape[i][1] += 1;
					System.out.println("변경후: " + rectShape[i][1]);
					// 이동한 칸에 다시 입히기
					rects[rectShape[i][0]] [rectShape[i][1]].setColor(Color.RED);
				}
			}
			repaint();
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