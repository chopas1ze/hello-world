package java0804_jdbc;

import java.util.ArrayList;

import java0804_jdbc.dao.JoinDAO;
import java0804_jdbc.dto.EmployeesDTO;

public class Java200_jdbc {

	public static void main(String[] args) {

			JoinDAO dao = JoinDAO.getInstance();
			ArrayList<EmployeesDTO> aList=dao.listMethod();
			for(EmployeesDTO edto : aList){
				System.out.printf("%d,%s,%s,%d,%s,%d,%s\n",edto.getEmployee_id(),edto.getFirst_name(),edto.getSalary(),edto.getMdto().getDepartment_id(),edto.getMdto().getDepartment_name(),edto.getLdto().getLocation_id(),edto.getLdto().getCity());
			}
		
		
	}//end main()

}//end class

