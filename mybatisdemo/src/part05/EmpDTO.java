package part05;

import java.util.List;

public class EmpDTO {
	private String employee_id, first_name, job_id, department_id, location_id, salary;
	private List<DeptDTO> dept2;
	private List<LocDTO> loc2;
	private DeptDTO dept;
	private LocDTO loc;
	
	public List<DeptDTO> getDept2() {
		return dept2;
	}

	public void setDept2(List<DeptDTO> dept2) {
		this.dept2 = dept2;
	}

	public List<LocDTO> getLoc2() {
		return loc2;
	}

	public void setLoc2(List<LocDTO> loc2) {
		this.loc2 = loc2;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}


	
	public LocDTO getLoc() {
		return loc;
	}

	public void setLoc(LocDTO loc) {
		this.loc = loc;
	}

	public DeptDTO getDept() {
		return dept;
	}

	public void setDept(DeptDTO dept) {
		this.dept = dept;
	}

	public String getLocation_id() {
		return location_id;
	}

	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	public EmpDTO() {
	
	}

	public EmpDTO(String employee_id, String first_name, String job_id, String department_id) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.job_id = job_id;
		this.department_id = department_id;
	}
	
	

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getDepartment_id() {
		
		return department_id;
	}

	public void setDepartment_id(String department_id) {		
		this.department_id = department_id;
	}
	
	
	
	
}// end class







