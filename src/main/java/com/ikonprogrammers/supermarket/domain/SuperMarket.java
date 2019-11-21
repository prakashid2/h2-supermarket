package com.ikonprogrammers.supermarket.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;

@Entity
@Table(name="supermarket")
public class SuperMarket implements Serializable{

	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="ID")
	private Long id;

	@Basic(optional=false)
	@Column(name="NAME")
	private String name;

	@Basic(optional=false)
	@Column(name="ADDRESS")
	private String address;

	@Basic(optional=false)
	@Column(name="PHONE")
	private String phone;

	@Basic(optional=false)
	@Column(name="OWNER")
	private String owner;

	@OneToMany(mappedBy="market",cascade=CascadeType.ALL)
	@JsonManagedReference
	private Collection<Employee> employees;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		int hash = 0;
	    hash += (id != null ? id.hashCode() : 0);
	    return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if(!(object instanceof SuperMarket)) {
			return false;
		}
		SuperMarket other = (SuperMarket)object;
		if((this.id==null&&other.id!=null) || (this.id!=null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ikonprogrammers.supermarket.domain.SuperMarket[ id=" + id + " ]";
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}


}
