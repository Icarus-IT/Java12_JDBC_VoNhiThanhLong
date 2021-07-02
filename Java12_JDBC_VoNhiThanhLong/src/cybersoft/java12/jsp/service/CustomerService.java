package cybersoft.java12.jsp.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java12.jsp.model.Customer;
import cybersoft.java12.jsp.repository.CustomerRepository;

public class CustomerService {
	private List<Customer> customers;
	private CustomerRepository repository;
	public CustomerService() {
		repository = new CustomerRepository();
		customers = new LinkedList<Customer>();
		
		customers.add(new Customer(1, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(2, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(3, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(4, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(5, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(6, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(7, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(8, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(9, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		
	}
	
	/* hiện thực code cho các phương thức sau:
	 * - findAllCustomers: 
	 	* trả về danh sách customer đang quản lý
	 * - findCustomerByCode: 
		 * trả về 1 customer có code bằng với tham số
		 * được truyền vào
	 * - deleteCustomerByCode:
	 	* xóa customer có mã code bằng với tham số
	 	* được truyền vào	 
	 * - addNewCustomer:
	 	* thêm customer vào danh sách quản lý	 
	 *  */
	public List<Customer> findAllCustomers(){
		return repository.findAllCustomer();
	}
	
	public Customer findCustomerByCode(int code) {
		
		return repository.finCustomerByCode(code);
		
	
	}
	
	public void deleteCustomerByCode(int code) {
		
		
		for(Customer cus: customers) {
			if(cus.getCode()!=code)
				continue;
			
			repository.deleteCustomerByCode(code);
			return;
		}
	
	}
	
	public void addNewCustomer(Customer customer) {	
		repository.addNewCustomer(customer);
	//	customers.add(customer);
	}
	public void update(Customer customerToUpdate,int codeToUpdate) {
		for (int i = 0; i <customers.size(); i++) {
			if (customers.get(i).getCode()!=codeToUpdate) {
				continue;
				
			}
			repository.updateCustomer(customerToUpdate, codeToUpdate);
		}
	}
}