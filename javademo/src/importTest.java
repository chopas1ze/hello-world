import java.text.SimpleDateFormat;
import java.util.Date;

public class importTest {
	
	
public static void main(String[] args) {
	Date today = new Date();
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy/mm/dd");
	
	System.out.println(date.format(today));
	
	
	
}

}
