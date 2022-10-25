package com.spring.pojo;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.spring.Dao.DoctorDao;
import com.spring.Dao.PatientDao;

public class Main {
	private final static Logger log = Logger.getLogger("Main");

	public static void main(String[] args) {
		int type;
		log.setLevel(Level.ALL);
		DoctorDao dao = new DoctorDao();
		PatientDao pdao = new PatientDao();
		while (true) {
			Scanner sc = new Scanner(System.in);
			log.info("Enter the type ");
			type = Integer.parseInt(sc.next());
			if (type == 1) {
				dao.list();
			} else if (type == 2) {
				dao.insert();
			} else if (type == 3) {
				dao.getDocById();
			} else if (type == 4) {
				dao.deleteById();
			} else if (type == 5) {
				dao.update();
			} else if (type == 6) {
				pdao.patList();
			} else if (type == 7) {
				pdao.save();
			} else if (type == 8) {
				pdao.getById();
			} else if (type == 9) {
				pdao.delete();
			} else {
				log.warning("not a defined type for a operation closing the entity");
				pdao.end();
				dao.closeEntity();
				break;
			}
			
			
		}
	}
}
