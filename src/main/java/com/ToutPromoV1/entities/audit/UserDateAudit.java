package com.ToutPromoV1.entities.audit;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@JsonIgnoreProperties(
		value= {"createdBy","updatedBY"},
		allowGetters=true)
public class UserDateAudit extends DateAudit {
	
	@CreatedBy
	@Column(updatable=false)
	private Long createdBy;
	
	@LastModifiedBy
	private Long updatedBy;

	public Long getCreatedBy() {
		return createdBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	

}
