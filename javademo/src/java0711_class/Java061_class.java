package java0711_class;

/*
 * 칼의 노래 			대출중
 * 어두운 상점의 거리 		대출가능
 */

class Book {
	String title;

	String process(boolean state) {
		if (state) {
			return "대출가능";
		} else {
			return "대출중";
		}
	}// end process()
}// end class

public class Java061_class {

	public static void main(String[] args) {
		int data=10;  //스택메모리에 저장(int는 자바 기본 명령어이기 떄문)
		Book bk = new Book();  //bk = 객체참조변수 (or참조변수), Book() <- 생성자
		bk.title = "칼의 노래";  //힙메모리의 bk공간에서 title 저장
		System.out.printf("%s %s\n", bk.title, bk.process(false));

		Book bn = new Book();
		bn.title = "어두운 상점의 거리";
		System.out.printf("%s %s\n", bn.title, bk.process(true));

	}// end main()

}// end class
