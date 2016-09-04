package java0707_statement;
//객체 지향언어의 최소단위는 class
//변수 배열 구조체 클래스 : 저장하는 공간
public class Java039_array {

	public static void main(String[] args) {
		/*int ko=90;
		int en=80;
		int jp=40*/

				
		//new = 힙 메모리에 배열을 생성하는 키워드.  클래스에서 사용하면 객체를 생성하는 키워드
		//처음 저장되는 초기값은 0 : int 이기 때문.  double 이면 0.0
		
		int[]	jumsu=new int[3];
		/*
		 * new: 힙메모리에 배열을 생성해주는 키워드이다.
		 * 배열에 저장된 값을 요소(element)라 한다.
		 * 배열은 생성될때 요소에 접근할 수 있도록 인덱스가 제공된다.
		 * (인덱스는 0부터 시작한다.)
		 * 
		 * 배열의 크기를 리턴해주는 키워드는 length 이다.
		 */
		for(int i=0;i<jumsu.length;i++){  
			System.out.printf("jumsu[%d]=%d\n",i,jumsu[i]);
		}
		
		jumsu[0]=90;
		jumsu[1]=80;
		jumsu[2]=40;
		
		for(int i=0;i<3;i++){
			System.out.printf("jumsu[%d]=%d\n",i,jumsu[i]);
		}
				
		String data="Java";
		System.out.println("문자열길이:"+data.length());   //()있으면 메소드[String클래스에서 제공하는메소드]  ()없으면 키워드
		
		
	}//end main()

}//end class
