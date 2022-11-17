package Tetriss;

public class GameThread extends Thread {
	private GameArea area;
	
	public GameThread(GameArea area) {
		this.area = area;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				area.moewBlockDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
