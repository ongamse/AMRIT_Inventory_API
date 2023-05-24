package com.iemr.inventory.data.stockExit;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.data.store.M_Facility;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class StockTransferItem {

	
	@Expose
	private Integer transferFromFacilityID;;
	
	@Expose
	private M_Facility transferFromFacility;
	
	@Expose
	private Integer transferToFacilityID;
	
	@Expose
	private String itemName;
	
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
