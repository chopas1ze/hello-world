package java0727_inner_thread;

class User2 implements Runnable {

	@Override
	public void run() {
		for (int j = 0; j <= 5; j++) {
			// Thread클래스에는 현재 쓰레드의 정보를 가져오는 메소드인 currentThread()가 있다.
			System.out.printf("%s j=%d\n", Thread.currentThread().getName(), j);
		}

	}// end run()
}// end User2

public class Java193_Thread {

	public static void main(String[] args) {
		User2 user2 = new User2();
		Thread th = new Thread(user2);
		th.start();
		
		System.out.println("main thread end");
	}// end main()

}// end class
