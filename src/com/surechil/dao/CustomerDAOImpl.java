package com.surechil.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.surechil.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute the query and get the result list
		List<Customer> customers = theQuery.getResultList();

		// return results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer to Database
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomers(int theId) {

		// get the Current session
		Session currentSession = sessionFactory.getCurrentSession();

		// Retrieve/read from the database using primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get the Current hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete the object using primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");

		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}

}
