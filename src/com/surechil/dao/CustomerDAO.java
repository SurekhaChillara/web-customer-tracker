package com.surechil.dao;

import java.util.List;


import com.surechil.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
