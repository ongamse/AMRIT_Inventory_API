package com.iemr.inventory.data.visit;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class I_bendemographics {
	
	@Expose
	private Integer stateID;
	
	@Expose
	private Integer districtID;
	
	@Expose
	private States m_state;
	
	@Expose
	private Districts m_district;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
}
