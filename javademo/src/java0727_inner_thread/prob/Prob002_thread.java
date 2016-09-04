package java0727_inner_thread.prob;
/*[문제2] Thread객체를 생성한후 다음과 같이 출력하시오

클래스명 : KoreanThread
클래스명 : EnglishLowerThread
클래스명 : EnglishUpperThread
클래스명 : Prob002_thread.java
		       EnglishLowerThread t1=new EnglishLowerThread();
			   EnglishUpperThread t2=new EnglishUpperThread();
			   KoreanThread t3=new KoreanThread();
	   
	           -- 사용자가 나머지 구현하시오--   
	           
[조건]	     
각각 데이타는 배열에 저장한후 사용한다

[출력화면]	 
abcdefghijklmnopqrstuvwxyz
ABCDEFGHIJKLMNOPQRSTUVWXYZ
ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ
*/
class KoreanThread extends Thread {
	char[] arr = {'ㄱ','ㄴ','ㄷ','ㄹ','ㅁ','ㅂ','ㅅ','ㅇ','ㅈ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
	
	@Override
	public void run() {
		for(int i = 0;i<arr.length;i++){
			System.out.print(arr[i]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}//end KoreanThread

class EnglishLowerThread extends Thread {
	char[] low ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','y','v','w','x','y','z'};
	@Override
	public void run() {
		for(int i = 0;i<low.length;i++){
			System.out.print(low[i]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}//end EnglishLowerThread 

class EnglishUpperThread extends Thread {
	char[] upper ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
	          'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	@Override
	public void run() {
		for(int i = 0;i<upper.length;i++){
			System.out.print(upper[i]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}//end EnglishUpperThread
public class Prob002_thread {

	public static void main(String[] args) {
		   EnglishLowerThread t1=new EnglishLowerThread();
		   EnglishUpperThread t2=new EnglishUpperThread();
		   KoreanThread t3=new KoreanThread();
		   
		   t1.start();
		   try {
			t1.join();
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		   t2.start();
		   try {
			t2.join();
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
		}
		
		   
		   
	}//end main()

}//end class
