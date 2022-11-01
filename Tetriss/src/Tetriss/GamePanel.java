package Tetriss;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private int gridRows;
	private int gridColumn;
	private int gridCellSize;
	
	private int[][] block = {
			{1, 0}, 
			{1, 0}, 
			{1, 0}, 
			{1, 1}
			}; 

	public GamePanel(int column) {
		setBounds(100, 100, 301, 451);
		setBorder(getBorder());
		gridColumn = column;
		gridCellSize = getBounds().width / gridColumn;
		gridRows = getBounds().height / gridCellSize;
		
	}

	private void drawBlock(Graphics g) {
		for (int row = 0; row < block.length; row++) {
			for (int col = 0; col < block[0].length; col++) {
				if (block[row][col] == 1)
					g.fillRect(col * gridCellSize, row * gridCellSize, gridCellSize, gridCellSize);
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
