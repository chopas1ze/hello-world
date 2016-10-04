package project.dto;

public class YujiDTO {
	private String member_id;
	private String car_id;
	private float eff;
	private String fuel_kind;
	private long price;
	
	
	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public String getCar_id() {
		return car_id;
	}


	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}


	public float getEff() {
		return eff;
	}


	public void setEff(float eff) {
		this.eff = eff;
	}


	public String getFuel_id() {
		return fuel_kind;
	}


	public void setFuel_id(String fuel_id) {
		this.fuel_kind = fuel_id;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}

	
	private static YujiDTO dto=new YujiDTO();
	
	private YujiDTO() {
		
	}
	public static YujiDTO getInstance(){
		return dto;
	}

		

}//end class
