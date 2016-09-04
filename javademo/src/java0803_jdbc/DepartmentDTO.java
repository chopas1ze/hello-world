package java0803_jdbc;

//Data Transfer Object(DTO) : 데이터 관리 객체
//Variable Object(VO)  <- 요즘은 이 단어를 사용하지 않음.

public class DepartmentDTO {
	//실수면 double 로 지정
	private int department_id;
	//디비 char 라도 String으로 받는다.(디비 char는 2자리이기 때문)
	private String department_name;
	private int manager_id;
	private int location_id;
	
	public DepartmentDTO() {}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	
	
	


}//end class
