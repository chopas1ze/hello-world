package java0725_collection.prob;

import java.util.ArrayList;

public class BookManager {
	public static int getRentalPrice(ArrayList<BookDTO> bookList, String kind) {
		// 구현하세요.
		int sum = 0;

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getKind() == kind) {
				sum = sum + bookList.get(i).getRentalPrice();
			}
		}
		return sum;

		
/*		for(BookDTO dto : bookList){
			if(dto.getKind()==kind){
				sum+=dto.getRentalPrice();
			}
			return sum;  */	
		
	}// end getRentalPrice()
}// end class
