package com.iemr.inventory.data.items;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class ItemInStore {

	@Expose
	private Integer itemID;

	@Expose
	private String itemName;

	@Expose
	private Long quantity;

	@Expose
	private Integer facilityID;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
	public ItemInStore(Integer facilityID, Integer itemID, String itemName, Long quantity) {
		// TODO Auto-generated constructor stub
		this.facilityID=facilityID;
		this.itemID=itemID;
		this.itemName=itemName;
		this.quantity=quantity;
	}


}
