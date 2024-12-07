package com.klef.jfsd.exam.HibernatePositionalParams;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dept_table")
public class Department {
	@Id
	@GeneratedValue
	private int deptId;
	private String name;
	private String location;
	private String HODName;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHODName() {
		return HODName;
	}
	public void setHODName(String hODName) {
		HODName = hODName;
	}
	
}
