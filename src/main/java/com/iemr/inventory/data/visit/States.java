package com.iemr.inventory.data.visit;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

public class States {

	@Expose
	private Integer stateID;
	
	@Expose
	private String stateName;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
}
