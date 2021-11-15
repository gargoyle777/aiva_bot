public class Main {
	public static void main(String[] args) {
		Bot bot = new Bot(5);
		bot.setup();	
		int randomiser=4;
		boolean flag=true;
		for(int i=0;i<50;i++) {
			if(flag) {
				randomiser=9;
				flag=false;
			}
			else {
				randomiser=4;
				flag=true;
			}
			bot.createTracks(4, randomiser, 0, 0, 0, 7);
			System.out.println("submission n: "+i);
			try {
				Thread.sleep(300000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}
