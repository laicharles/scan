package com.lianyun.scan.gree.webservice.greemember.model.respond;

import com.google.gson.annotations.SerializedName;

//{
//    "Code": 0,
//    "Error": "",
//    "Data": {
//        "ID": 1530086557244,
//        "Account": "13411558121",
//        "Password": "",
//        "PlatformType": 0,
//        "UserInfo": {
//            "ID": 1530086557244,
//            "Fullname": "zhijian",
//            "Telphone": "13411558121",
//            "Sex": "1",
//            "Birthday": "",
//            "Address": "",
//            "Avatar": "",
//            "Email": "",
//            "BloodType": "",
//            "BodyShape": "",
//            "MaritalStatus": "",
//            "Character": ""
//        },
//        "Roles": [
//            {
//                "Code": "common",
//                "Name": "普通用户"
//            }
//        ]
//    }
//}
public class UserInfo {

	@SerializedName("ID")
	private long id;
	@SerializedName("Fullname")
	private String name;
	@SerializedName("Telphone")
	private String tel;
	@SerializedName("Sex")
	private String sex;
	@SerializedName("Birthday")
	private String birthday;
	@SerializedName("Address")
	private String address;
	@SerializedName("Email")
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
