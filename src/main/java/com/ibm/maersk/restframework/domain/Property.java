package com.ibm.maersk.restframework.domain;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GEMSPROPERTIES")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROPID")
	@ApiModelProperty(notes = "The database generated product ID")
	private Integer propId;
	@Column(name = "INSTMST")
	@ApiModelProperty(notes = "The inserted date and time")
	private Date insTmst;
	@Column(name = "INSUSER")
	@ApiModelProperty(notes = "The user who inserted")
	private String inUser;
	@Column(name = "UPDTMST")
	@ApiModelProperty(notes = "The last updated date and time")
	private Date updTmst;
	@Column(name = "UPDUSER")
	@ApiModelProperty(notes = "The user who last updated")
	private String updUser;
	@Column(name = "SRVCNAME")
	@ApiModelProperty(notes = "The property service name")
	private String srvcName;
	@Column(name = "KEYNAME")
	@ApiModelProperty(notes = "The property key name")
	private String keyName;
	@Column(name = "KEYVALUE")
	@ApiModelProperty(notes = "The property key value")
	private String keyValue;

	public Integer getPropId() {
		return propId;
	}

	public void setPropId(Integer propId) {
		this.propId = propId;
	}

	public Date getInsTmst() {
		return insTmst;
	}

	public void setInsTmst(Date insTmst) {
		this.insTmst = insTmst;
	}

	public String getInUser() {
		return inUser;
	}

	public void setInUser(String inUser) {
		this.inUser = inUser;
	}

	public Date getUpdTmst() {
		return updTmst;
	}

	public void setUpdTmst(Date updTmst) {
		this.updTmst = updTmst;
	}

	public String getUpdUser() {
		return updUser;
	}

	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}

	public String getSrvcName() {
		return srvcName;
	}

	public void setSrvcName(String srvcName) {
		this.srvcName = srvcName;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
}
