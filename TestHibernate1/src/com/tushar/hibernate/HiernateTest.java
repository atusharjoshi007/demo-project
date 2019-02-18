package com.tushar.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tushar.dto.Address;
import com.tushar.dto.UserDetails;
import com.tushar.dto.Vehicle;

public class HiernateTest {

	public static void main(String[] args) {
				
		UserDetails user = new UserDetails();
		user.setUserName("Kamlesh User");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		user.setVehicle(vehicle);
				
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		
	}

}
