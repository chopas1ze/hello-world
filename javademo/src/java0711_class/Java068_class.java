package java0711_class;

/* [실행결과]를 참조하여  main() 메소드에 로직에 추가하세요.
 * 
 * [실행결과]
 * 생성자 호출됨
 * Bible 작자미상
 */
class Book2 {
	String title;   
	String author;  

	void show() { //8
		System.out.println(title + " " + author);
	}

	public Book2() {
		this("", "");
		System.out.println("생성자 호출됨");
	}

	public Book2(String title) {  //2
		this(title, "작자미상"); //3
	}

	public Book2(String title, String author) { //4 
		this.title = title; //5
		this.author = author; //6
	}

}

public class Java068_class {

	public static void main(String[] args) {
		Book2 javaBook = new Book2("Java", "황기태"); 
		Book2 bible = new Book2("Bible");  // 1
		Book2 emptyBook = new Book2();
		///////// 여기에 구현하세요.
		bible.show(); //7

	}// end main()
}// end class
