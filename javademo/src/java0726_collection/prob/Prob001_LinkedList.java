package java0726_collection.prob;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * LinkedList
 * 1 List : 순서적으로 데이터를 저장
 * 2 Stack : LIFO
 * 3 Queue : FIFO
 */

public class Prob001_LinkedList {

	public static void main(String[] args) {
		/*
		 * booklist.txt파일의 데이터를 Stack으로 처리하여 출력되도록 
		 * 프로그램을 구현하시오.
		 *  title             	publisher   writer     price
		 	JSP Programming  	JSPPub     JSPExpert   21000
			Servlet Programming WeBBest 	GoodName	 20000
			JDBC Programming 	JDBCBest 	NaDo SQL 	30000
			SQL Fundmental 		SQLBest		 Na SQL 	47000
			Java Programming 	JavaBest	 Kim kava	 25000
		 */
		
		Scanner sc = null;
		LinkedList<Book> nList = new LinkedList<Book>();
		try {
			 sc = new Scanner(new File("./src/java0726_collection/prob/booklist.txt"));
			 System.out.println("title            publisher       writer         price");
			 
			 while(sc.hasNextLine()){
				 String[] arr = sc.nextLine().split("/");
				  nList.push(new Book(arr[0],arr[1],arr[2],arr[3]));
			 }
			 while(!nList.isEmpty()){
				 Book b = nList.pop();
				 System.out.printf("%s  %10s  %15s  %10s\n",b.getTitle(),b.getPublisher(),b.getWriter(),b.getPrice());
				 
			 }
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			sc.close();
		}
		
		
		
	
	}//end main()

}//end class











