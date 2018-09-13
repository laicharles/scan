package com.lianyun.scan.gree.webservice.greemember.model.respond;

import com.google.gson.annotations.SerializedName;
import com.lianyun.scan.gree.webservice.greemember.model.respond.ValidGreememberRespond.ValidRespond;

public class ValidGreememberRespond extends GreememberRespond<ValidRespond> {

	public static class ValidRespond {
		@SerializedName("valide")
		private boolean valid;

		public boolean isValid() {
			return valid;
		}

		public void setValid(boolean valid) {
			this.valid = valid;
		}

	}

	@SerializedName("Data")
	private ValidRespond data;

	public ValidRespond getData() {
		return data;
	}

	public void setData(ValidRespond data) {
		this.data = data;
	}

}
