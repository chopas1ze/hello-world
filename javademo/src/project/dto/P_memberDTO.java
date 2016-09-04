package project.dto;

import java.sql.Date;

import project.dao.P_memberDAO;

public class P_memberDTO {

	private String id;
	private String name;
	private Date birthday;
	private String phone;
	private String password;
	private char gender;
	private Date buyDate;
	private int distance;
	private String carId;
	private String locationId;
	private String KindId;

	private static P_memberDTO dto = new P_memberDTO();

	private P_memberDTO() {

	}

	public static P_memberDTO getInstance() {
		return dto;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getKindId() {
		return KindId;
	}

	public void setKindId(String kindId) {
		KindId = kindId;
	}

}
