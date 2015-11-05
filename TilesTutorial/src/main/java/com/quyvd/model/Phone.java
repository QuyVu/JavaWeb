package com.quyvd.model;

public class Phone {
	private String homePhone;
	private String mobilePhone;

	public Phone(String homePhone, String mobilePhone) {
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
}
