package com.spring.Dao;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.spring.pojo.Patient;

public class PatientDao {
	private final static Logger log = Logger.getLogger("Patient-Dao");
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence1");
	static EntityManager em = emf.createEntityManager();
	Scanner sc = new Scanner(System.in);
	int id;
	String name;
	String age;
	Patient pat;

	public void save() {
		em.getTransaction().begin();
		log.info("Enter the id,name,age to insert");
		id = sc.nextInt();
		name = sc.next();
		age = sc.next();
		pat = new Patient(id, name, age);
		em.persist(pat);
		em.getTransaction().commit();
		log.info("Data inserted successful");
	}

	public void patList() {
		em.getTransaction().begin();
		String sql = "select p from Patient p";
		@SuppressWarnings("unchecked")
		List<Patient> list = em.createQuery(sql).getResultList();
		if (list != null) {
			for (Patient p : list) {
				System.out.println((p.getPat_id() + "\n " + p.getPat_name() + "\n " + p.getAge()));
				//em.getTransaction().commit();
			}
		} else {
			log.warning("List Not Found");
			em.getTransaction().rollback();
		}

	}

	public void getById() {
		
		log.info("Enter id to get details");
		id = sc.nextInt();
		pat = em.find(Patient.class, id);
		if (pat != null) {
			System.out.println("Patient by ID \n" + pat.getPat_id() + "\n" + pat.getPat_name() + "\n" + pat.getAge());
		} else {
			log.warning("No details based on id");
			em.getTransaction().rollback();
		}
	}
	public void delete() {
		log.info("Enter id to delete the corresponding details");
		id = sc.nextInt();
		pat=em.find(Patient.class,id);
		if(pat!=null) {
			em.getTransaction().begin();
			em.remove(pat);
			em.getTransaction().commit();
		}
		else {
			log.warning("ID Not Found");
			em.getTransaction().rollback();
		}
	}
	public void end() {
		em.close();
		emf.close();
	}

}
