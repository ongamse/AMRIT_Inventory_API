package com.iemr.inventory.data.locationmaster;

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

@Entity
@Table(name="showofficedetails")
public class Showofficedetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="PSAddMapID")
	private Integer pSAddMapID;
	@Expose
	@Column(name="ServiceProviderID")
	private Integer serviceProviderID; 
	@Expose
	@Column(name="ServiceProviderName")
	private String serviceProviderName; 
	@Expose
	@Column(name="StateID")
	private Integer stateID; 
	@Expose
	@Column(name="StateName")
	private String stateName; 
	@Expose
	@Column(name="ServiceID")
	private Integer serviceID; 
	@Expose
	@Column(name="ServiceName")
	private String serviceName; 
	@Expose
	@Column(name="DistrictID")
	private Integer districtID; 
	@Expose
	@Column(name="DistrictName")
	private String districtName;
	@Expose
	@Column(name="LocationName")
	private String locationName; 
	@Expose
	@Column(name="Address")
	private String address;
	@Expose
	@Column(name="ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name="Deleted")
	private Boolean deleted;
	
	@Expose
	@Column(name="CreatedBy")
	private String createdBy; 
	@Expose
	@Column(name="CreatedDate")
	private Date createdDate;
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy ;
	
	@Expose
	@Column(name="LastModDate")
	private Date lastModDate;
	
	public Showofficedetails() {
		// TODO Auto-generated constructor stub
	}

	






	public Integer getpSAddMapID() {
		return pSAddMapID;
	}


	public void setpSAddMapID(Integer pSAddMapID) {
		this.pSAddMapID = pSAddMapID;
	}


	public Integer getServiceProviderID() {
		return serviceProviderID;
	}


	public void setServiceProviderID(Integer serviceProviderID) {
		this.serviceProviderID = serviceProviderID;
	}


	public String getServiceProviderName() {
		return serviceProviderName;
	}


	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}


	public Integer getStateID() {
		return stateID;
	}


	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}


	public String getStateName() {
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	public Integer getServiceID() {
		return serviceID;
	}


	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}


	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public Integer getDistrictID() {
		return districtID;
	}


	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}


	public String getDistrictName() {
		return districtName;
	}


	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}


	public String getLocationName() {
		return locationName;
	}


	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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
