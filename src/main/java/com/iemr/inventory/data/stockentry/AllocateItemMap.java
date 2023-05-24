package com.iemr.inventory.data.stockentry;

import java.util.List;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class AllocateItemMap {

	
//	private Integer itemStockEntryID;
	@Expose
	private Integer facilityID;
	@Expose
	private Integer itemID;

//	private Integer quantity;
//	
	@Expose
	private String itemName;
//	
//	private Integer qunatityRequired;
	@Expose
	private List<ItemBatchList> itemBatchList;
	

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
}
