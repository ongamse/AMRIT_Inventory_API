package com.iemr.inventory.data.drugtype;

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
@Table(name="m_drugtype")
public class M_Drugtype {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="DrugTypeID")
	private Integer drugTypeID;
	@Expose
	@Column(name="DrugTypeName")
	private String drugTypeName;
	@Expose
	@Column(name="DrugTypeDesc")
	private String drugTypeDesc;
	@Expose
	@Column(name="DrugTypeCode")
	private String drugTypeCode;
	@Expose
	@Column(name="Status")
	private String status;
	@Expose
	@Column(name="ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name="Deleted",insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name="CreatedBy")
	private String createdBy;
	@Expose
	@Column(name="CreatedDate",insertable = false, updatable = false)
	private Date createdDate;
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name="LastModDate" ,insertable = false, updatable = false)
	private Date lastModDate;
	
	
	public M_Drugtype() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the drugTypeID
	 */
	public Integer getDrugTypeID() {
		return drugTypeID;
	}


	/**
	 * @param drugTypeID the drugTypeID to set
	 */
	public void setDrugTypeID(Integer drugTypeID) {
		this.drugTypeID = drugTypeID;
	}


	/**
	 * @return the drugTypeName
	 */
	public String getDrugTypeName() {
		return drugTypeName;
	}


	/**
	 * @param drugTypeName the drugTypeName to set
	 */
	public void setDrugTypeName(String drugTypeName) {
		this.drugTypeName = drugTypeName;
	}


	/**
	 * @return the drugTypeDesc
	 */
	public String getDrugTypeDesc() {
		return drugTypeDesc;
	}


	/**
	 * @param drugTypeDesc the drugTypeDesc to set
	 */
	public void setDrugTypeDesc(String drugTypeDesc) {
		this.drugTypeDesc = drugTypeDesc;
	}


	/**
	 * @return the drugTypeCode
	 */
	public String getDrugTypeCode() {
		return drugTypeCode;
	}


	/**
	 * @param drugTypeCode the drugTypeCode to set
	 */
	public void setDrugTypeCode(String drugTypeCode) {
		this.drugTypeCode = drugTypeCode;
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * @return the providerServiceMapID
	 */
	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}


	/**
	 * @param providerServiceMapID the providerServiceMapID to set
	 */
	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}


	/**
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}


	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}


	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}


	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}


	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	/**
	 * @return the lastModDate
	 */
	public Date getLastModDate() {
		return lastModDate;
	}


	/**
	 * @param lastModDate the lastModDate to set
	 */
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
