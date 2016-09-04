package java0722_stream_collection;

import java.util.Vector;

public class Java169_collection {

	public static void main(String[] args) {
		Vector v = new Vector();
		// .add 는 논리값으로 리턴. .addElement는 결과값을 리턴하지 않는다.
		
		//Integer -> Object (업케스팅)되어 저장됨.  
		//모든 컬렉션에서 저장되는 것은 객체형태로 저장됨.
		v.addElement(new Integer(10)); //0 인덱스
		v.addElement(new Integer(20));  //1
		v.addElement(new Integer(30));  //2
		
		//int -> Integer   스택에서 저장된것이 힙으로 바뀜.
		
		int num=40;
		//int -> Integer -> Object (auto boxing -> upcasting)  
		v.addElement(num);  //3        v.addElement(40); 
		
		
		
		//Object -> Integer(다운캐스팅)
		Integer it =(Integer)v.get(0);
		System.out.println(it);
		
		//object -> Integer -> int (down casting -> auto unboxing)
		int data=(Integer)v.get(3);
		System.out.println(data);
		
		
	}// end main()

}// end class
