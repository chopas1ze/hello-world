package java0718_api;

/*
 * [출력결과]
 * ip:127.0.0.1
 * port:8000
 * 
 */
public class Java116_String {

	public static void main(String[] args) {
		String sn="127.0.0.1:8000";
		String[] arr= sn.split(":");
		for(int i = 0; i<arr.length;i++){
			if(i==0){
				System.out.println("ip:"+arr[i]);
			}
			else {
				System.out.println("port:"+arr[i]);
			}
		}
		
		int index=sn.indexOf(":");
		System.out.println("ip:"+sn.substring(0, index));
		System.out.println("port:"+sn.substring(index+1));
		
		
		
		
	}//end main()

}//end class
