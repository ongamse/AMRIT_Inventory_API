package com.iemr.inventory.data.store;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name="m_van")
@Data
public class M_Van {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="VanID")
	private Integer vanID;
	
	@Expose
	@Column(name="VanName")
	private String vanName;
	@Expose
	@Column(name="VehicalNo")
	private String vehicalNo;
	@Expose
	@Column(name="VanTypeID")
	private Integer vanTypeID;
//	@Expose
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(updatable = false, insertable = false, name = "VanTypeID")
//	private M_VanType m_vanType;
	@Expose
	@Transient
	String vanType;
	
	@Expose
	@Column(name="ProviderServiceMapID")
	private Integer providerServiceMapID;
//	@Expose
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(updatable = false, insertable = false, name = "ProviderServiceMapID")
//	private M_ProviderServiceMapping m_providerServiceMapping;
	
	@Expose
	@Transient
	private Integer serviceProviderID;

	@Expose
	@Column(name="CountryID")
	private Integer countryID;
//	@Expose
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(updatable = false, insertable = false, name = "countryID")
//	private M_Country m_country;
	@Expose
	@Transient
	String countryName;
	
	@Expose
	@Column(name="StateID")
	private Integer stateID;
//	@Expose
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(updatable = false, insertable = false, name = "stateID")
//	private State state;
	@Expose
	@Transient
	String stateName;
	
//	@Expose
//	@Column(name="DistrictID")
//	private Integer districtID;
//	@Expose
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(updatable = false, insertable = false, name = "districtID")
//	private M_District m_district;
//	@Expose
//	@Transient
//	String districtName;
	
	@Expose
	@Column(name="ParkingPlaceID")
	private Integer parkingPlaceID;
//	@Expose
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(updatable = false, insertable = false, name = "parkingPlaceID")
//	private M_Parkingplace m_parkingplace;
	@Expose
	@Transient
	String parkingPlaceName;
	
	@Expose
	@Column(name="IsFacility")
	private Boolean isFacility;
	
	
	@Expose
	@Transient
	private Integer districtBlockID;
	
	@Expose
	@Column(name="FacilityID")
	private Integer facilityID;
	

	@Expose
	@Column(name = "Deleted",insertable = false, updatable = true)
	private Boolean deleted; 
	@Expose
	@Column(name = "Processed",insertable = false, updatable = true)
	private String processed;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate" ,insertable = false, updatable = false)
	private Date createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy; 
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;
	
	public M_Van() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public M_Van(Integer vanID, String vanName, String vehicalNo, Integer vanTypeID, String vanType, Boolean deleted,
			Integer providerServiceMapID, Integer countryID, String countryName, Integer stateID, String stateName,
		 Integer parkingPlaceID, String parkingPlaceName,Integer districtBlockID) {
		super();
		this.vanID = vanID;
		this.vanName = vanName;
		this.vehicalNo = vehicalNo;
		this.vanTypeID = vanTypeID;
		this.vanType = vanType;
		this.providerServiceMapID = providerServiceMapID;
		this.countryID = countryID;
		this.countryName = countryName;
		this.stateID = stateID;
		this.stateName = stateName;
		this.parkingPlaceID = parkingPlaceID;
		this.parkingPlaceName = parkingPlaceName;
		this.deleted = deleted;
		this.districtBlockID=districtBlockID;
	}
	
//	public M_Van(Integer vanID, String vanName, String vehicalNo, Integer vanTypeID, String vanType, Boolean deleted,
//			Integer providerServiceMapID, Integer countryID, String countryName, Integer stateID, String stateName,
//			Integer districtID, String districtName, Integer parkingPlaceID, String parkingPlaceName,Integer districtBlockID) {
//		super();
//		this.vanID = vanID;
//		this.vanName = vanName;
//		this.vehicalNo = vehicalNo;
//		this.vanTypeID = vanTypeID;
//		this.vanType = vanType;
//		this.providerServiceMapID = providerServiceMapID;
//		this.countryID = countryID;
//		this.countryName = countryName;
//		this.stateID = stateID;
//		this.stateName = stateName;
////		this.districtID = districtID;
////		this.districtName = districtName;
//		this.parkingPlaceID = parkingPlaceID;
//		this.parkingPlaceName = parkingPlaceName;
//		this.deleted = deleted;
//		this.districtBlockID=districtBlockID;
//	}
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
	
}
