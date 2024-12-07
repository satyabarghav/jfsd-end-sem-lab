package com.klef.jfsd.exam.HibernatePositionalParams;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;


public class ClientDemo {
	public static void main(String[] args) {
		ClientDemo obj = new ClientDemo();
		Scanner in = new Scanner(System.in);
//		obj.inserDept();
		obj.updateDept(in.nextInt());
		in.close();
		
	}
	public void updateDept(int deptId) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		Scanner in = new Scanner(System.in);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Department dept = session.find(Department.class, deptId );
		if(dept==null) {
			System.out.println("Department not found");
		}
		else {
			System.out.println("Enter Department Name: ");
			String name = in.next();
			System.out.println("Enter Department Location: ");
			String loc = in.next();
			System.out.println("Enter Department HOD Name: ");
			String hname = in.next();
			MutationQuery query = session.createMutationQuery("update Department set name=?1,location=?2, HODName=?3 where deptId = ?4");
		       
		       query.setParameter(1, name);
		       query.setParameter(2, loc);
		       query.setParameter(3, hname);
		       query.setParameter(4, deptId);
		       
		       int n = query.executeUpdate();
		       t.commit();
		       System.out.println(n+ " Department Updated Successfully");
		       
		       session.close();
		       sf.close();
		       in.close();
		}
	}
	
	public void inserDept() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		Scanner in = new Scanner(System.in);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Department dept = new Department();
		
		System.out.println("Enter Department Name: ");
		dept.setName(in.next());
		System.out.println("Enter Department Location: ");
		dept.setLocation(in.next());
		System.out.println("Enter Department HOD Name: ");
		dept.setHODName(in.next());
		
		session.persist(dept);
		
		t.commit();
		System.out.println("Department Added Successfully!");
		session.close();
		sf.close();
		
	}
	
	
}
