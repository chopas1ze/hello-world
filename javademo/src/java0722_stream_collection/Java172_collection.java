package java0722_stream_collection;

import java.util.Vector;

/*
 * 배열 : length
 * 문자명 : length()
 * 컬렉션 : size()
 */

public class Java172_collection {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.addElement(new String("java"));

		// capacity() : 백터의 용량 리턴(메모리에 요소를 저장할 수 있는 크기)
		System.out.println("용량:" + v.capacity()); // 용량:10 스트링은 기본이 10개
		// size() : 백터에 저장된 요소 갯수
		System.out.println("크기:" + v.size()); // 크기:1

		//Vector생성자 인자값이 하나이면 최초 생성될 용량의 값이다.
		//용량의 증가는 기존의 2배이다.
		v = new Vector<String>(2); // 메모리 용량 2개  
		v.addElement(new String("seoul"));
		v.addElement(new String("busan"));
		v.addElement(new String("inchon"));  //갯수 증가

		System.out.println("용량:" + v.capacity());  //용량:4  <- 2배 증가
		System.out.println("크기:" + v.size());  //크기:3
		
		//Vector생성자의 첫번째 인자값은 최초로 생성되는 용량의 값이고
		// 두번째 인자값은 증가되는 값이다.
		v=new Vector<String>(2,1);  //메모리 용량 2개, 증가는 1씩 증가
		v.addElement(new String("홍길동"));
		v.addElement(new String("영순이"));
		v.addElement(new String("갑돌이"));
		
		System.out.println("용량:" + v.capacity());  //용량:3
		System.out.println("크기:" + v.size());  //크기:3
		
		//필요없는 메모리 공간을 제거한다.
		v = new Vector<String>();
		v.addElement(new String("apple"));
		v.trimToSize();  //<- 제거 메소드
		
		System.out.println("용량:" + v.capacity());  //용량: 1
		System.out.println("크기:" + v.size());  //크기: 1
		
		//백터컬렉션만 인자값으로 조정하고, 다른컬렉션은 자동으로 된다.
	}// end main()

}// end class
