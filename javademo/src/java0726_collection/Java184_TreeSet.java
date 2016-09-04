package java0726_collection;

import java.util.Iterator;

//tree문자가 들어가있으면 정렬

import java.util.TreeSet;

public class Java184_TreeSet {

	public static void main(String[] args) {
		//요소를 정렬해서 처리할때 사용됨
		TreeSet<Integer> tree = new TreeSet<Integer>();
		tree.add(new Integer(10));   //add시켜줄떄마다 정렬이 일어나서, 처리속도가 느리다. 
		tree.add(new Integer(20));
		tree.add(new Integer(15));
		tree.add(new Integer(20));  //중복허용 안함.
		
		System.out.println("오름차순");
		Iterator<Integer> ite = tree.iterator();   //앞에서부터 꺼내온다.
		
		//다음에 가져올 요소가 있으면 true 없으면 false을 리턴
		while(ite.hasNext()){
			//요소를 가져온다.
			System.out.println(ite.next());
		}
		
		System.out.println("내림차순");
		ite=tree.descendingIterator();  //뒤에서부터 꺼내온다.
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
		
	}//end main()

}//end class
