package com.spring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
	private int pat_id;
	@Column(name="pat_name")
	private String pat_name;
	@Column(name="age")
	private String age;

	public Patient() {

	}

	public Patient(int pat_id, String pat_name, String age) {
		super();
		this.pat_id = pat_id;
		this.pat_name = pat_name;
		this.age = age;
	}

	public int getPat_id() {
		return pat_id;
	}

	public void setPat_id(int pat_id) {
		this.pat_id = pat_id;
	}

	public String getPat_name() {
		return pat_name;
	}

	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "pat_id=" + pat_id + ", pat_name=" + pat_name + ", age=" + age + "";
	}

}
