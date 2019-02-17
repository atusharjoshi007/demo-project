package com.tushar.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tushar.dto.Address;
import com.tushar.dto.UserDetails;

public class HiernateTest {

	public static void main(String[] args) {
		

		Address addr = new Address();
		addr.setCity("PCMC");
		addr.setState("MH");
		addr.setStreet("My street");
		addr.setPincode(411033);
		
		Address addr1 = new Address();
		addr1.setCity("PCMC office");
		addr1.setState("MH office");
		addr1.setStreet("My office street");
		addr1.setPincode(411005);
		
		UserDetails user = new UserDetails();
		user.setUserName("Kamlesh User");
		user.setJoinedDate(new Date());
		user.setDescription("users description goes here");

		user.getListOfAddresses().add(addr);
		user.getListOfAddresses().add(addr1);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user =(UserDetails) session.get(UserDetails.class, 1);
		session.close();
		System.out.println("User address List is  "+user.getListOfAddresses().toString());
		
		for(Address addr2: user.getListOfAddresses()) {
			System.out.println(addr2.getCity());
		}
		
		
	}

}
