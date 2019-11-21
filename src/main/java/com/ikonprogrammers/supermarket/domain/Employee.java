package com.ikonprogrammers.supermarket.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.CascadeType;

@Entity
@Table(name="employee")
public class Employee implements Serializable {

	private static final Long serialVersionUID = 1L;

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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
	@Column(name="DOB")
	private LocalDate dob;

	@Basic(optional=false)
	@Column(name="GENDER")
	private char gender;

	@Basic(optional=false)
	@Column(name="SALARY")
	private Long salary;

	@Basic(optional=false)
	@Column(name="JOBCODE")
	private String jobcode;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="MARKET_ID", nullable=false, referencedColumnName="ID")
	@JsonBackReference
	private SuperMarket market;



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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getJobcode() {
		return jobcode;
	}
	public void setJobcode(String jobcode) {
		this.jobcode = jobcode;
	}

	@Override
	public int hashCode() {
		int hash = 0;
	    hash += (id != null ? id.hashCode() : 0);
	    return hash;
	}

	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Employee)) {
			return false;
		}
		Employee other = (Employee)object;
		if(this.id==null&&other.id!=null || (this.id!=null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ikonprogrammers.supermarket.Employee[id="+id+" ]";
	}

	public SuperMarket getMarket() {
		return market;
	}
	public void setMarket(SuperMarket market) {
		this.market = market;
	}

	@Transient
	private String dobstr;
	public void setDobstr(String dobstr) {
		System.out.println("In setDobstr:"+dobstr);
		this.dobstr = dobstr;
	}

	@PrePersist
	void preInsert() {
		System.out.println("In preInsert");
		if(dobstr!=null) {
			this.dob = LocalDate.parse(dobstr, formatter);
			System.out.println(this.dob);
		}
	}

}
