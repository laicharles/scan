package com.lianyun.scan.user.vo;

//{
//	"tel": "",
//	"captcha": "1234"
//  "type": 1
//}
public class SendCodeVo extends NeedCaptchaVo {

	private String tel;

	private int type;

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
