package Tetriss;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	private final int BOARD_ROWS = 15;
	private final int BOARD_COLS = 10;
	private final int CELL_SIZE = 30;
	int[][] cell;
	
	public GamePanel() {
		setBounds(100, 100, 301, 451);
		setBackground(Color.white);
	}
	
	public void block() {
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < BOARD_COLS; i++ ) {
			g.drawRect(i * CELL_SIZE, 0, CELL_SIZE, CELL_SIZE);
			for (int j = 0; j < BOARD_ROWS; j++) {
				g.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
			}
		}
		cell = new int[][]{{1, 0}, {1, 0}, {1, 0}, {1, 1}};
		g.setColor(Color.red);
		for (int i = 0; i < 4; i++) {
			g.fillRect(0, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
		}
	}
}
