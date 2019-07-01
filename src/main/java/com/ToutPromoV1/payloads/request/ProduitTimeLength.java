package com.ToutPromoV1.payloads.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class ProduitTimeLength {
	
	@NotNull
	@Max(30)
	private Integer days;
	
	@NotNull
	@Max(23)
	private Integer hours;

	public Integer getDays() {
		return days;
	}

	public Integer getHours() {
		return hours;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	
	

}
