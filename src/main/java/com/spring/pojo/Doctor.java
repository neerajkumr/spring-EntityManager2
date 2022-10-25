package com.spring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	private int doc_id;
	@Column(name = "doc_name")
	private String docName;
	@Column(name = "specialist")
	private String specialist;
	@Column(name = "experience")
	private String experience;

	public Doctor() {
	}

	public Doctor(int doc_id, String docName, String specialist, String experience) {
		super();
		this.doc_id = doc_id;
		this.docName = docName;
		this.specialist = specialist;
		this.experience = experience;
	}

	public int getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Doctor [doc_id=" + doc_id + ", docName=" + docName + ", specialist=" + specialist + ", experience="
				+ experience + "]";
	}

}
