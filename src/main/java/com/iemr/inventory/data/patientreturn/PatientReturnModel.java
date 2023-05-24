package com.iemr.inventory.data.patientreturn;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class PatientReturnModel {

	@Expose
	private Long benRegID;

	@Expose
	private Integer facilityID;
	
	@Expose
	private Integer itemID;
	
	@Expose
	private String itemName;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();
	
	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	public PatientReturnModel(Long benRegID, Integer facilityID, Integer itemID, String itemName) {
		this.benRegID=benRegID;
		this.facilityID=facilityID;
		this.itemID=itemID;
		this.itemName=itemName;
		
	}
}
