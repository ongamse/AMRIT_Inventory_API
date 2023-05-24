package com.iemr.inventory.data.supplier;

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
@Table(name="m_supplieraddress")
public class M_Supplieraddress {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="SupplierAddressID")
	private Integer SupplierAddressID;
	@Expose
	@Column(name="SupplierID")
	private Integer supplierID; 
	@Expose
	@Column(name="AddressLine1")
	private String addressLine1;
	@Expose
	@Column(name="AddressLine2")
	private String addressLine2;
	@Expose
	@Column(name="District")
	private String district;
	@Expose
	@Column(name="State")
	private String state;
	@Expose
	@Column(name="Country")
	private String country;
	@Expose
	@Column(name="PinCode")
	private String pinCode;
	@Expose
	@Column(name="ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name="Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name="CreatedBy")
	private String createdBy;
	@Expose
	@Column(name="CreatedDate", insertable = false, updatable = true)
	private Date createdDate;
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name="LastModDate", insertable = false, updatable = true)
	private Date lastModDate;
	
	
	public M_Supplieraddress() {
		// TODO Auto-generated constructor stub
	}  
	
	
	
	
	
	
	
	public Integer getSupplierAddressID() {
		return SupplierAddressID;
	}

	public void setSupplierAddressID(Integer supplierAddressID) {
		SupplierAddressID = supplierAddressID;
	}

	public Integer getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(Integer supplierID) {
		this.supplierID = supplierID;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
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

	public OutputMapper getOutputMapper() {
		return outputMapper;
	}

	public void setOutputMapper(OutputMapper outputMapper) {
		this.outputMapper = outputMapper;
	}







	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
