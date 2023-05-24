package com.iemr.inventory.data.indent;

import java.math.BigDecimal;
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
//import com.iemr.inventory.data.rolemaster.M_Role;
import com.iemr.inventory.data.store.M_Facility;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name="m_itemfacilitymapping")
@Data
public class ItemfacilitymappingIndent {
	
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
	private BigDecimal qoh;
	
	@Expose
	@Transient
	private String itemName;
	
	@Expose
	@Transient
	private String itemCode;
	
	@Expose
	@Transient
	private Integer itemCategoryID;
	
	@Transient
	@Expose
	private String itemCategory;
	
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
	private ItemIndent itemIndent;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ItemID", insertable = false, updatable = false)
	@Expose
	private ItemStockEntryIndent itemStockEntryIndent;
	

	@Transient
	@Expose
	private Boolean discontinued;
	
	@Transient
	@Expose
	private String itemForm;
	
	@Transient
	@Expose
	private String pharmacologicalCategoryName;
	
	@Transient
	@Expose
	private String strength;
	
	@Transient
	@Expose
	private String uomName;
	
	@Transient
	@Expose
	private String composition;
	
	@Transient
	@Expose
	private Boolean isMedical;
	
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	
	
	
	
	
	
	
	

}
