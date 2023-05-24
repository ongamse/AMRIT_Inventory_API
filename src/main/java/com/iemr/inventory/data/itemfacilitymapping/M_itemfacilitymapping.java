package com.iemr.inventory.data.itemfacilitymapping;

import java.sql.Date;

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
import com.iemr.inventory.data.items.ItemMaster;
import com.iemr.inventory.data.locationmaster.DistrictBranchMapping;
//import com.iemr.inventory.data.rolemaster.M_Role;
import com.iemr.inventory.data.store.M_Facility;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name="m_itemfacilitymapping")
@Data
public class M_itemfacilitymapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "ItemFacilityMapID")
	private Integer itemFacilityMapID;
	@Expose
	@Column(name = "FacilityID")
	private Integer facilityID;
	@Expose
	@Column(name = "ItemID")
	private Integer itemID;
	
	@Expose
	@Transient
	private Integer itemCategoryID;
	
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "FacilityID")
	private M_Facility facility;
	
	@Expose
	@Column(name = "MappingType")
	private String mappingType; 
	@Expose
	@Column(name = "Status")
	private String status;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
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
	
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ItemID", insertable = false, updatable = false)
	@Expose
	private ItemMasterforFacilityMapping itemMasterforFacilityMapping;
	
	
	@Transient
	@Expose
	private String itemName;
	
	@Transient
	@Expose
	private Boolean discontinued;
	
	
	public M_itemfacilitymapping() {
		// TODO Auto-generated constructor stut
	}
	
	
	
	

	
	public M_itemfacilitymapping(Integer itemID,String itemName) {
		this.itemID=itemID;
		this.itemName=itemName;
	}
	 
	public M_itemfacilitymapping(Integer itemID,String itemName,Boolean discontinued,Integer categoryID) {
		this.itemID=itemID;
		this.itemName=itemName;
		this.discontinued=discontinued;
		this.itemCategoryID=categoryID;
	}
	
	

	
	
	

	public ItemMasterforFacilityMapping getItemMasterforFacilityMapping() {
		return itemMasterforFacilityMapping;
	}






	public void setItemMasterforFacilityMapping(ItemMasterforFacilityMapping itemMasterforFacilityMapping) {
		this.itemMasterforFacilityMapping = itemMasterforFacilityMapping;
	}






	public Integer getItemStoreMapID() {
		return itemFacilityMapID;
	}



	public void setItemStoreMapID(Integer itemStoreMapID) {
		this.itemFacilityMapID = itemStoreMapID;
	}



	public Integer getFacilityID() {
		return facilityID;
	}



	public void setFacilityID(Integer facilityID) {
		this.facilityID = facilityID;
	}



	public Integer getItemID() {
		return itemID;
	}



	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}



	public String getMappingType() {
		return mappingType;
	}



	public void setMappingType(String mappingType) {
		this.mappingType = mappingType;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}



	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}



	public Boolean getDeleted() {
		return deleted;
	}



	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public String getModifiedBy() {
		return modifiedBy;
	}



	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	public Date getLastModDate() {
		return lastModDate;
	}



	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}
	
	
	
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	
	
	
	
	
	
	
	

}
