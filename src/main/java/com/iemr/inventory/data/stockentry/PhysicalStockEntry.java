package com.iemr.inventory.data.stockentry;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name="t_PhysicalStockEntry")
@Data
public class PhysicalStockEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="PhyEntryID")
	private Long phyEntryID;
	
	@Expose
	@Column(name="VanSerialNo")
	private Long vanSerialNo;
	
	@Expose
	@Column(name="RefNo")
	private String refNo;
	
	@Expose
	@Column(name="FacilityID")
	private Integer facilityID;
	
	@Expose
	@Column(name = "VanID")
	private Long vanID;

	@Expose
	@Column(name = "ParkingPlaceID")
	private Long parkingPlaceID;
	
	@OneToMany(mappedBy = "physicalStockEntry")
	@Transient
	@Expose
	private List<ItemStockEntry> itemStockEntry ;
	
	@Expose
	@Column(name="ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name="SyncFacilityID")
	private Integer syncFacilityID;
	
	@Expose
	@Column(name="Status")
	private String status;
	
	@Expose
	@Column(name="Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	
	@Expose
	@Column(name="Processed", insertable = false, updatable = true)
	private Character processed;
	
	@Expose
	@Column(name="CreatedBy")
	private String createdBy;
	
	@Expose
	@Column(name="CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	
	@Expose
	@Column(name="LastModDate", insertable = false, updatable = false)
	private Date lastModDate;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}


}
