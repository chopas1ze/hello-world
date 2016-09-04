package java0725_collection;

import java.util.Vector;

public class Java173_collection {

	
	
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(new Integer(10));  //0 index
		v.add(new Integer(20));  //1
		v.add(new Integer(30));  //2
		
		//1인덱스의 요소가 제거된다.
		v.remove(1);
		
		//0인덱스에 40요소를 삽입한다.
		v.add(0,new Integer(40));  //기존 0인덱스에 값이 있으니 삽입.
		
		for(Integer it: v)
			System.out.println(it);
		
		
	}//end main()

}//end class
