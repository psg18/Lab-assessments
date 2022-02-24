package com.model.persistence.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
//	static SessionFactory factory = null;

//	private HibernateSessionFactory() {
//	}
//
//	public static SessionFactory getSessionFactory() {
////		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
////				.build();
////
////		 factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
//		
//		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//		factory = configuration.buildSessionFactory(); 
//		return factory;
//	}
	
	
	public static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//			sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		}
		return sessionFactory;
		
	}
}