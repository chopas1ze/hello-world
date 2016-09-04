package java0715_abstract_interface;

abstract class Shape {
	int width;
	int height;

	public Shape(int width, int height) {
		this.width = width;
		this.height = height;
	}

	void prn() {
		System.out.printf("width=%d height=%d\n", width, height);

	}

	abstract double getArea();
}

class Rect extends Shape {

	public Rect(int width, int height) {
		super(width, height);

	}

	double getArea() {
		return width * height;
	}

}// end Rect

class Trai extends Shape {

	public Trai(int width, int height) {
		super(width, height);

	}

	double getArea() {
		return width * height * 0.5;
	}

}

// end Trai

public class Java097_abstract {

	public static void main(String[] args) {
		// Shape은 추상클래스이므르 객체 생성을 할 수 없다.
		// Shape se = new Shape(10,20);

		Rect rr = new Rect(10, 20);
		System.out.println("사각형 넓이:" + rr.getArea());

		Trai tt = new Trai(10, 20);
		System.out.println("삼각형 넓이:" + tt.getArea());
	} // end main()

}// end class
