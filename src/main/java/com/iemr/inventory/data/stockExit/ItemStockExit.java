package com.iemr.inventory.data.stockExit;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.data.stockentry.ItemStockEntry;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "t_itemstockexit")
@Data
public class ItemStockExit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "ItemStockExitID")
	private Long itemStockExitID;
	
	@Expose
	@Column(name="VanSerialNo")
	private Long vanSerialNo;

	@Expose
	@Column(name = "ItemStockEntryID")
	private Long itemStockEntryID;

	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "itemStockEntryID")
	private ItemStockEntry itemStockEntry;


	@Expose
	@Column(name = "FacilityID")
	private Integer facilityID;
	
	@Expose
	@Column(name="SyncFacilityID")
	private Integer syncFacilityID;
	
	@Expose
	@Transient
	private Integer itemID;

	@Expose
	@Transient
	private Integer quantityInHand;

	@Expose
	@Column(name = "Quantity")
	private Integer quantity;

	@Expose
	@Column(name = "ExitTypeID")
	private Long exitTypeID;

	@Expose
	@Column(name = "ExitType")
	private String exitType;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private Character processed;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Expose
	@Column(name = "VanID")
	private Long vanID;

	@Expose
	@Column(name = "ParkingPlaceID")
	private Long parkingPlaceID;

	@Expose
	@Transient
	private Integer duration;

	@Expose
	@Transient
	private String durationUnit;

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
