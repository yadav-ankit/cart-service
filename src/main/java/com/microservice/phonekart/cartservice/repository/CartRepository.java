package com.microservice.phonekart.cartservice.repository;
import org.springframework.stereotype.Repository;

import com.microservice.phonekart.cartservice.TO.OrderTO;
import com.microservice.phonekart.cartservice.models.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@Repository
public class CartRepository {

	private final SessionFactory sessionFactory = buildSessionFactory();

	public CartRepository() {
	}
	
	private static SessionFactory buildSessionFactory() 
    {
        try
        {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

	
	public List<OrderTO> getLimitedOrders(int orderNumber, String status) {
		Session session = null;
		Transaction tx;
		Query<?> query;
		List<OrderTO> orderTO = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			query = session.createQuery("from Order o where o.orderNumber  > :orderNumber");
			query.setParameter("orderNumber", orderNumber);
		//	query.setParameter("status", status);
			
			
			@SuppressWarnings("unchecked")
			List<Order> list = (List<Order>) query.getResultList();
			
			System.out.println("List sizE IS --> "  + list.size());
			
			orderTO = mapResponse(list);
			return orderTO;

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			session.close();
		}
		return orderTO;
	}
	
	private List<OrderTO> mapResponse(List<Order> list) {
		
		List<OrderTO> orderTOList = new ArrayList<OrderTO>();
		
		for(Order order : list) {
			OrderTO orderTO = new OrderTO();
			
			orderTO.setEmployeeID(order.getEmployeeID());
			orderTO.setOrderDate(order.getOrderDate());
			orderTO.setShippedDate(order.getShippedDate());
			orderTO.setStatus(order.getStatus());
			orderTO.setName(order.getName());
			orderTO.setCustomerNumber(order.getCustomerNumber());
			orderTO.setOrderNumber(order.getOrderNumber());
			orderTO.setComments(order.getComments());
			
			orderTOList.add(orderTO);
		}
		
		return orderTOList;
		
	}
	
}
