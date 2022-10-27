package Tetriss;

import java.util.Random;

public class Tetromino {
	
	/*
	 * 열거형 enum 선언
	 * Tetrominoe에 테트리스 도형들 넣기
	 */
	protected enum Tetrominoe {
		NoShape, ZShape, SShape, LineShape,
		TShape, SquareShape, LShape, MirroedLShape
	}
	
	private Tetrominoe pieceShape;
	private int coords[][];
	private int [][][] coordsTable;

	
	public Tetromino() {
		coords = new int[4][2];
		setShape(Tetrominoe.NoShape);
	}

	void setShape(Tetrominoe shape) {
		coordsTable = new int[][][] {
			   { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } },
			   { { 0, -1 }, { 0, 0 }, { -1, 0 }, { -1, 1 } },
			   { { 0, -1 }, { 0, 0 }, { 1, 0 }, { 1, 1 } },
			   { { 0, -1 }, { 0, 0 }, { 0, 1 }, { 0, 2 } },
			   { { -1, 0 }, { 0, 0 }, { 1, 0 }, { 0, 1 } },
			   { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, 1 } },
			   { { -1, -1 }, { 0, -1 }, { 0, 0 }, { 0, 1 } },
			   { { 1, -1 }, { 0, -1 }, { 0, 0 }, { 0, 1 } }
		};
			
		for (int i = 0; i < 4; i++) {
		    System.arraycopy(coordsTable[shape.ordinal()], 0, coords, 0, 4);
		}
		
		pieceShape = shape;
	}
	
//	private void setX(int index, int x) {
//        coords[index][0] = x;
//    }
//
//    private void setY(int index, int y) {
//        coords[index][1] = y;
//    }
//
//    int x(int index) {
//        return coords[index][0];
//    }
//
//    int y(int index) {
//        return coords[index][1];
//    }
//
//    Tetrominoe getShape() {
//        return pieceShape;
//    }
//    
//    void setRandomShape() {
//    	var randNums = new Random();
//        int randNum = Math.abs(randNums.nextInt()) % 7 + 1;
//
//        // enum Tetrominoe의 values()를 배열 values에 전달
//        Tetrominoe[] values = Tetrominoe.values();
//        // setShape에 랜덤값이 들어간 values를 전달
//        setShape(values[randNum]);
//    }
//    
//    public int minX() {
//
//        int m = coords[0][0];
//
//        for (int i = 0; i < 4; i++) {
//
//            m = Math.min(m, coords[i][0]);
//        }
//
//        return m;
//    }
//
//    int minY() {
//
//        int m = coords[0][1];
//
//        for (int i = 0; i < 4; i++) {
//
//            m = Math.min(m, coords[i][1]);
//        }
//
//        return m;
//    }

}
