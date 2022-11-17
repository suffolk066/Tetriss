package Tetriss;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameArea extends JPanel {

	private int gridRows;
	private int gridColumn;
	private int gridCellSize;
	private Color[][] background;
	
	private TetrisBlock block;

	public GameArea(int column) {
		setBounds(100, 100, 301, 451);
		setBorder(getBorder());
		gridColumn = column;
		gridCellSize = getBounds().width / gridColumn;
		gridRows = getBounds().height / gridCellSize;
		
		background = new Color[gridRows][gridColumn];
	}

	public void spawnBlock() {
		block = new TetrisBlock(new int[][] {{1, 0}, {1, 0}, {1, 0}, {1, 1}}, Color.blue);
		block.spawn(gridColumn);
	}
	
	public boolean moveBlockDown() {
		if (checkBottom() == false) return false;
		block.moveDown();
		repaint();
		
		return true;
	}
	
	private boolean checkBottom() {
		if (block.getBottomEdge() == gridRows) {
			return false;
		}
		return true;
	}
	
	private void moveBlockToBackground() {
		int[][] shape = block.getShape();
		int h = block.getHeight();
		int w = block.getWidth();
		
		int xPos = block.getX();
		int yPost = block.getY();
		
		Color color = block.getColor();
		
		for (int r = 0; r < h; r++) {
			for(int c = 0; c < w; c++) {
				if(shape[r][c] == 1) {
					
				}
			}
		}
	}
	
	private void drawBlock(Graphics g) {
		int h = block.getHeight();
		int w = block.getWidth();
		Color color = block.getColor();
		int[][] shape = block.getShape();
		
		for (int row = 0; row < h; row++) {
			for (int col = 0; col < w; col++) {
				if (shape[row][col] == 1) {
					int x = (block.getX() + col) * gridCellSize;
					int y = (block.getY() + row) * gridCellSize;
					drawGridSquare(g, color, x, y);
				}
			}
		}
	}
	
	private void drawBackground(Graphics g) {
		Color color;
		for (int r = 0; r < gridRows; r++) {
			for(int c = 0; c < gridColumn; c++) {
				color = background[r][c];
				if(color != null) {
					int x = c * gridCellSize;
					int y = r * gridCellSize;
					drawGridSquare(g, color, x, y);
				}
			}
		}
	}
	
	private void drawGridSquare(Graphics g, Color color, int x, int y) {
		g.setColor(color);
		g.fillRect(x, y, gridCellSize, gridCellSize);
		g.setColor(Color.black);
		g.drawRect(x, y, gridCellSize, gridCellSize);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int y = 0; y < gridRows; y++) {
			for (int x = 0; x < gridColumn; x++) {
				g.drawRect(x * gridCellSize, y * gridCellSize, gridCellSize, gridCellSize);
			}
		}
		drawBackground(g);
		drawBlock(g);
	}
}
