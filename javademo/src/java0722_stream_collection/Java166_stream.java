package java0722_stream_collection;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Java166_stream {

	public static void main(String[] args) {
		/*
		 * DataOutputStream과 DataInputStream
		 * 1. 기본데이터형 단위로 쓰고 읽는 스트림이다.
		 * 2. 각 자료형의 크기가 다르므로 출력할때와 입력할때 순서에 주의한다.
		 * 이런게 있다고만 알고 있어라.
		 */
			
		
		DataOutputStream ds = null;
		FileOutputStream fs = null;
		FileInputStream is = null;
		DataInputStream di = null;
		
		
		
		try {
			fs = new FileOutputStream("./src/java0722_stream_collection/sample.txt");
			ds = new DataOutputStream(fs);  //매개변수타입이 스트링이나 파일이면 직접연결가능. 아니면 간접연결필요.
			ds.writeInt(65);  //'A';
			ds.writeDouble(10.5);
			ds.writeChar('a');
			ds.writeUTF("java");          //스트링 입력시 writeUTF
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		
			try {
				ds.close();
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("////////////////////////");
		
		try {
			is = new FileInputStream("./src/java0722_stream_collection/sample.txt");
			di = new DataInputStream(is);

			System.out.println(di.readInt());
			System.out.println(di.readDouble());
			System.out.println(di.readChar());
			System.out.println(di.readUTF());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				di.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		
	}// end main()

}// end class
