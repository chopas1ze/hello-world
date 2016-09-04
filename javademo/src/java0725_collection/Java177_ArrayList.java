package java0725_collection;

import java.util.ArrayList;

public class Java177_ArrayList {

	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("oracle");
		aList.add("mysql");
		aList.add("mysql");
		String[] arr = display(aList);
		for (String data : arr) {
			System.out.println(data);
		}

	}// end main()

	public static String[] display(ArrayList<String> aList) {
	/*	String[] arr = new String[aList.size()];
		for(int i = 0;i<aList.size();i++){
			arr[i]=aList.get(i);
		}   */
		
	//	String[] arr = new String[aList.size()];
		//return aList.toArray(arr);   //aList값을 arr배열에 복사함. .toArray()
		
		Object[] obj=aList.toArray();
		String[] stn = new String[obj.length];
		for(int i =0;i<obj.length;i++){
			stn[i]=(String)obj[i];
		}
		return stn;
	}

}// end class
