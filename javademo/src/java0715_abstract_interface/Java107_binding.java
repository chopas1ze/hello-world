package java0715_abstract_interface;

public class Java107_binding {

	public static void main(String[] args) {
		// 결합도가 낮다. (동적 바인딩)
		 //Tv tv = new LgTv2();
		Tv tv = new SamsungTv2();
		process(tv);

	} // end main()

	public static void process(Tv tv) {
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soundDown();
	}

}// end class
