package java0727_inner_thread;

abstract class InnerAnonymous {
	abstract void prn();

}// end InnerAnonymous

class OuterAnonymous {
	private int x;

	public void call() {
		InnerAnonymous tt = new InnerAnonymous() {

			@Override
			void prn() {
				x = 5;
				System.out.println(x);
			}

		}; // <- 주의
		tt.prn();
	}// end call()
	
}// end OuterAnonymous

public class Java191_inner {

	public static void main(String[] args) {
		OuterAnonymous outer=new OuterAnonymous();
		outer.call();
		
		
		
	}// end main()

}// end class
