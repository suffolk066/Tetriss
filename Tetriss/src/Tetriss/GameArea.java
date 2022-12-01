package Tetriss;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameArea extends JPanel {

	private int gridRows;
	private int gridColumns;
	private int gridCellSize;
	private Color[][] background;
	
	private TetrisBlock block;

	public GameArea(int column) {
		setBounds(100, 100, 301, 451);
		setBorder(getBorder());
		gridColumns = column;
		gridCellSize = getBounds().width / gridColumns;
		gridRows = getBounds().height / gridCellSize;
		
		background = new Color[gridRows][gridColumns];
	}

	public void spawnBlock() {
		block = new TetrisBlock(new int[][] {{1, 0}, {1, 0}, {1, 1}}, Color.blue);
		block.spawn(gridColumns);
	}
	
	public boolean moveBlockDown() {
		if (checkBottom() == false) {
			moveBlockToBackground();
			return false;
		}
		block.moveDown();
		repaint();
		
		return true;
	}

	public void moveBlockRight() {
		// →키 -> x++
		if (!checkRight()) return;
		block.moveRight();
		repaint();
	}
	
	
	public void moveBlockLeft() {
		// ←키 -> x--
		if (!checkLeft()) return;
		block.moveLeft();
		repaint();
	}
	
	public void dropBlock() {
		// ↓키 -> y++
		block.moveDown();
		repaint();
	}
	
	public void dropBlockQuick() {
		// 스페이스바 -> 퀵드랍
		while(checkBottom()) {
			block.moveDown();
		}
		repaint();
	}
	
	public void rotateBlock(int i) {
		if (i == KeyEvent.VK_UP) {
			block.rotateUp();
		} else if (i == KeyEvent.VK_DOWN) {
			block.rotateDown();
		}
		repaint();
	}
	
	private boolean checkBottom() {
		if (block.getBottomEdge() == gridRows) {
			return false;
		}
		
		int[][] shape = block.getShape();
		int w = block.getWidth();
		int h = block.getHeight();
		
		/*
	 	Exception in thread "Thread-0" java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
		at Tetriss.GameArea.checkBottom(GameArea.java:98)
		at Tetriss.GameArea.moveBlockDown(GameArea.java:35)
		at Tetriss.GameThread.run(GameThread.java:14)
		 */
		for (int col = 0; col < w; col++) {
			for (int row = h - 1; row >= 0; row--) {
				if(shape[row][col] != 0) {
					int x = col + block.getX();
					int y = row + block.getY() + 1;
					if (y < 0) break;
					if(background[y][x] != null) return false;
					break;
				}
			}
		}
				
		return true;
	}
	
	private boolean checkLeft() {
		if(block.getLeftEdge() == 0) return false;
		
		int[][] shape = block.getShape();
		int h = block.getHeight();
		
		for (int row = 0; row < h; row++) {
			for (int col = 0; col >= 0; col++) {
				if(shape[row][col] != 0) {
					int x = col + block.getX() - 1;
					int y = row + block.getY();
					if (y < 0) break;
					if(background[y][x] != null) return false;
					break;
				}
			}
		}
		
		return true;
	}
	
	private boolean checkRight() {
		if(block.getRightEdge() == gridColumns) return false;
		
		int[][] shape = block.getShape();
		int w = block.getWidth();
		int h = block.getHeight();
		
		for (int row = 0; row < h; row++) {
			for (int col = w - 1; col >= 0; col--) {
				if(shape[row][col] != 0) {
					int x = col + block.getX() + 1;
					int y = row + block.getY();
					if (y < 0) break;
					if(background[y][x] != null) return false;
					break;
				}
			}
		}
		
		return true;
	}
	
	private void moveBlockToBackground() {
		int[][] shape = block.getShape();
		int h = block.getHeight();
		int w = block.getWidth();
		
		int xPos = block.getX();
		int yPos = block.getY();
		
		Color color = block.getColor();
		
		for (int r = 0; r < h; r++) {
			for(int c = 0; c < w; c++) {
				if(shape[r][c] == 1) {
					background[r + yPos][c + xPos] = color;
				}
			}
		}
	}
	
	private void drawBlock(Graphics g) {
		int h = 0;
		int w = 0;
		Color color = null;
		int[][] shape = null;
		try {
			h = block.getHeight();
			w = block.getWidth();
			color = block.getColor();
			shape = block.getShape();
		} catch (Exception e) {
			System.out.println("Start");
		}
		
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
			for(int c = 0; c < gridColumns; c++) {
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
			for (int x = 0; x < gridColumns; x++) {
				g.drawRect(x * gridCellSize, y * gridCellSize, gridCellSize, gridCellSize);
			}
		}
		drawBackground(g);
		drawBlock(g);
	}
}
