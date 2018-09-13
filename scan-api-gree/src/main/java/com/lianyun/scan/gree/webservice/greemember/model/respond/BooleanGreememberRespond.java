package com.lianyun.scan.gree.webservice.greemember.model.respond;

import com.google.gson.annotations.SerializedName;
import com.lianyun.scan.gree.webservice.greemember.model.respond.BooleanGreememberRespond.BooleanRespond;

public class BooleanGreememberRespond extends GreememberRespond<BooleanRespond> {

	public static class BooleanRespond {
		@SerializedName("Success")
		private boolean success;

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

	}
	@SerializedName("Data")
	private BooleanRespond data;

	public BooleanRespond getData() {
		return data;
	}

	public void setData(BooleanRespond data) {
		this.data = data;
	}

}
