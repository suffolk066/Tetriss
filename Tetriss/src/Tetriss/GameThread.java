package Tetriss;

public class GameThread extends Thread {
	private GameArea area;
	
	public GameThread(GameArea area) {
		this.area = area;
	}
	
	@Override
	public void run() {
		while (true) {
			area.spawnBlock();
			while (area.moveBlockDown()) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
