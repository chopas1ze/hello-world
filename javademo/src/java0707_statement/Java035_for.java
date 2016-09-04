package java0707_statement;

/*
 * 반복문에서 특정 위치로 이동(continue)을 하거나 빠져(break)나올때
 * 반복문에 label명을 지정하고 호출하면 된다.
 */
public class Java035_for {

	public static void main(String[] args) {
		int cnt=0;
		move: //라벨지정
		for(int i=1;i<=5;i++){
			
			for(int j=1;j<=5;j++){
				cnt++;
				if(cnt%3!=0){
				//break move; //라벨 지정한 for문을 빠져나온다
				continue move;
				// 라벨 지정한 for문의 증감식으로 이동한다.
				}
				System.out.println(cnt+"\t");
			
			}
		}
		
	}//end main()

}//end class
