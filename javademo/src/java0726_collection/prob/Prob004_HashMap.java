package java0726_collection.prob;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
/*
 * [출력결과]
 * 찾는 도서명을 입력 :java
 * 책이름 : java
 * 책저자 : kim
 * 페이지 : 100
 * 
 * 찾는 도서명을 입력 :jsp
 * 찾는 도서가 없습니다
 */
import java.util.Set;

public class Prob004_HashMap {
	public static void main(String[] args) {
		BookShop bk1 = new BookShop("java", "kim", 100);
		BookShop bk2 = new BookShop("c++", "lee", 250);
		BookShop bk3 = new BookShop("oracle", "park", 300);
		BookShop[] bs = new BookShop[3];
		bs[0] = bk1;
		bs[1] = bk2;
		bs[2] = bk3;
		display(bs);

	}

	public static void display(BookShop[] bs) {
		Map<String, BookShop> map = new HashMap<String, BookShop>();
		map.put(bs[0].getTitle(), bs[0]);
		map.put(bs[1].getTitle(), bs[1]);
		map.put(bs[2].getTitle(), bs[2]);

		// 출력결과를 참조하여 구현하세요.
		System.out.println("찾는 도서명을 입력 :");
		Scanner sc = new Scanner(System.in);
		String title = sc.nextLine();

		Set<String> set = map.keySet();
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			String ig = ite.next();
			if (title.equals(map.get(ig).getTitle())) {
				System.out.println("책이름 : " + map.get(ig).getTitle());
				System.out.println("책저자 : " + map.get(ig).getAuthor());
				System.out.println("페이지 : " + map.get(ig).getPage());
				break;
			}else if(ite.hasNext()==false){
				System.out.println("찾는 도서가 없습니다");
			}
		}
		
	}
}
		//if(map.containsKey(title))  <- 매개변수 값이 키값과 같은지 확인.