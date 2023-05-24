package com.iemr.inventory.data.locationmaster;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

@Entity
@Table(name="m_state")
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="StateID")
	private Integer stateID; 
	@Expose
	@Column(name="StateName")
	private String stateName;

	@Expose
	@Column(name="StateCode")
	private char stateCode;
	@Expose
	@Column(name="CountryID")
	private Integer countryID;
	@Expose
	@Column(name="Deleted" , insertable = false, updatable = true)
	private Boolean deleted; 
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
	
	@OneToOne(mappedBy="stateMaster")
	private StateServiceMapping1 roleMapping;
	
	
	public State() {
		// TODO Auto-generated constructor stub
	}

	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}


	public char getStateCode() {
		return stateCode;
	}

	public void setStateCode(char stateCode) {
		this.stateCode = stateCode;
	}

	public Integer getCountryID() {
		return countryID;
	}

	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
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

	
	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public StateServiceMapping1 getRoleMapping() {
		return roleMapping;
	}

	public void setRoleMapping(StateServiceMapping1 roleMapping) {
		this.roleMapping = roleMapping;
	}

	
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	

	
	


}
