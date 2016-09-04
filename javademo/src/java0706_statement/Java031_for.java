package java0706_statement;

public class Java031_for {

	public static void main(String[] args) {
		// int sum=0; // int sum; 만 설정해주면 메모리에 아무것도 없어서 오류로 뜬다.
		int odd = 0; // 홀수누적
		int even = 0; // 짝수누적
		for (int i = 1; i <= 10; i++) {
			if(i%2==0){
				even = even + i;	
			} else {
			odd = odd + i;
							}
		
	}
		System.out.printf("짝수누적:%d\n",even);
		System.out.printf("홀수누적:%d\n",odd);
	}

}
	
