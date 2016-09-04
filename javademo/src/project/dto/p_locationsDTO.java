package project.dto;

public class p_locationsDTO {
	private int location_id;
	private String si;
	private String gu;
	private String dong;
	private int gps_x;
	private int gps_y;
	
	private static p_locationsDTO dto = new p_locationsDTO();
	
	public p_locationsDTO() {
		
	}
	
	public static p_locationsDTO getInstance(){
		return dto;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getSi() {
		return si;
	}

	public void setSi(String si) {
		this.si = si;
	}

	public String getGu() {
		return gu;
	}

	public void setGu(String gu) {
		this.gu = gu;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public int getGps_x() {
		return gps_x;
	}

	public void setGps_x(int gps_x) {
		this.gps_x = gps_x;
	}

	public int getGps_y() {
		return gps_y;
	}

	public void setGps_y(int gps_y) {
		this.gps_y = gps_y;
	}
	
	
	
}
