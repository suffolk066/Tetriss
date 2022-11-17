package Tetriss;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameArea extends JPanel {

	private int gridRows;
	private int gridColumn;
	private int gridCellSize;
	
	private TetrisBlock block;

	public GameArea(int column) {
		setBounds(100, 100, 301, 451);
		setBorder(getBorder());
		gridColumn = column;
		gridCellSize = getBounds().width / gridColumn;
		gridRows = getBounds().height / gridCellSize;
		
		spawnBlock();
	}

	public void spawnBlock() {
		block = new TetrisBlock(new int[][] {{1, 0}, {1, 0}, {1, 0}, {1, 1}}, Color.blue);
	}
	
	public void moewBlockDown() {
		block.moveDown();
		repaint();
	}
	
	private void drawBlock(Graphics g) {
		int h = block.getHeight();
		int w = block.getWidth();
		Color c = block.getColor();
		int[][] shape = block.getShape();
		
		for (int row = 0; row < h; row++) {
			for (int col = 0; col < w; col++) {
				if (shape[row][col] == 1) {
					int x = (block.getX() + col) * gridCellSize;
					int y = (block.getY() + row) * gridCellSize;
					
					g.setColor(c);
					g.fillRect(x, y, gridCellSize, gridCellSize);
					g.setColor(Color.black);
					g.drawRect(x, y, gridCellSize, gridCellSize);
				}
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int y = 0; y < gridRows; y++) {
			for (int x = 0; x < gridColumn; x++) {
				g.drawRect(x * gridCellSize, y * gridCellSize, gridCellSize, gridCellSize);
			}
		}
		
		g.setColor(Color.RED);
		drawBlock(g);
	}
}
