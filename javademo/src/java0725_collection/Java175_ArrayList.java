package java0725_collection;

import java.util.ArrayList;

/*
 * Vector와 ArrayList
 * 1 Vector은 동기화 처리가 되여 있고 ArrayList은 비동기화 처리한다.
 * 2 Vector와 ArrayList은 메모리에 요소를 처리할때 배열의 구조를 따른다.
 * 3 Vector와 ArrayList의 클래스는 처리방법이 비슷하다.
 * 4 Vector와 ArrayList으로 요소의  추가,삭제를 처리하는 것은
 *    좋은 방법이 아니다.(추가시 배열이 뒤로 밀리고, 삭제시 배열이 앞으로 떙겨진다.)
 *    
 *    1) 배열: 순차(추가) <Vector,ArrayList>
 *    2) 링크 : 비순차(삽입,삭제) <LinkedList>
 */

public class Java175_ArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(new Integer(10));
		aList.add(new Integer(20));
		aList.add(new Integer(30));

		for (int i = 0; i < aList.size(); i++) {
			System.out.println(aList.get(i));
		}
		
	}// end main()

}// end class
