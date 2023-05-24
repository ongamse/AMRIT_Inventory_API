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
@Table(name="m_ServiceMaster")
public class ServiceMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="ServiceID")
	private Integer serviceID;
	@Expose
	@Column(name="ServiceName")
	private String serviceName; 
	@Expose
	@Column(name="ServiceDesc")
	private String serviceDesc;
	@Expose
	@Column(name="Deleted", insertable = false, updatable = true)
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
	
	@Expose
	@Column(name="IsNational")
	private Boolean isNational;
	
	@OneToOne(mappedBy="serviceMaster")
	private StateServiceMapping1 roleMapping;
	
	public ServiceMaster() {
		// TODO Auto-generated constructor stub
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

	public String getServiceDesc() {
		return serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
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


	public StateServiceMapping1 getRoleMapping() {
		return roleMapping;
	}


	public void setRoleMapping(StateServiceMapping1 roleMapping) {
		this.roleMapping = roleMapping;
	}
	
	
	
	
	
	public Boolean getIsNational() {
		return isNational;
	}


	public void setIsNational(Boolean isNational) {
		this.isNational = isNational;
	}





	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
	

	
	
	

}
