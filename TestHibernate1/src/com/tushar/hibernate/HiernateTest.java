package com.tushar.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tushar.dto.UserDetails;
import com.tushar.dto.Vehicle;

public class HiernateTest {

	public static void main(String[] args) {
				
		UserDetails user = new UserDetails();
		user.setUserName("Kamlesh User");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Bike");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
				
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		
	}

}
