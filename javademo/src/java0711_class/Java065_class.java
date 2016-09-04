package java0711_class;

class Rect {
	int width;
	int height;

	public Rect() {

	}

	// 사각형의 둘레를 구하는 로직
	int girth() {
		return (width + height) * 2;
	}

	// 사각형의 넓이를 구하는 로직
	int area() {
		return width + height;
	}
}// end class

public class Java065_class {

	public static void main(String[] args) {
		Rect rt = new Rect();
		rt.width = 5;
		rt.height = 3;
		System.out.println("둘레:" + rt.girth());
		System.out.println("넓이:" + rt.area());
		
	}// end main()

}// end class
