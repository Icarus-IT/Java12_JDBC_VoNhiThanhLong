package cybersoft.java12.jsp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cybersoft.java12.jsp.dbconnection.MySqlConnection;
import cybersoft.java12.jsp.model.Customer;

public class CustomerRepository {
	public List<Customer> findAllCustomer() {
		List<Customer> customers = new ArrayList<Customer>();
		Connection connection = MySqlConnection.getConnection();
		String query = "SELECT code, name, address, email " + "FROM customer";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Customer customer = new Customer();

				customer.setCode(resultSet.getInt("code"));
				customer.setName(resultSet.getNString("name"));
				customer.setAddress(resultSet.getNString("address"));
				customer.setEmail(resultSet.getString("email"));

				customers.add(customer);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Connection to database has been disconnected!!");
		}
		return customers;
	}

	public Customer finCustomerByCode(int code) {
		Customer customer = null;
		try {
			Connection connection = MySqlConnection.getConnection();
			String query = "SELECT code, name, address, email from customer where code=?";
			PreparedStatement st = connection.prepareStatement(query);
			st.setInt(1, code);
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next()) {
				customer = new Customer();

				customer.setCode(resultSet.getInt("code"));
				customer.setName(resultSet.getNString("name"));
				customer.setAddress(resultSet.getNString("address"));
				customer.setEmail(resultSet.getString("email"));
			}
		} catch (SQLException e) {
			System.out.println("Connection to database has been disconnected!!");
		}
		return customer;
	}
	
	public int addNewCustomer(Customer customer) {		
		try {
			Connection connection = MySqlConnection.getConnection();
			String query = "INSERT INTO customer(name, address, email) values(?, ?, ?)";
			PreparedStatement st = connection.prepareStatement(query);
			st.setString(1, customer.getName());
			st.setString(3, customer.getEmail());
			st.setString(2, customer.getAddress());
			int check =st.executeUpdate();
			return check;
		} catch (SQLException e) {
			System.out.println("Connection to database has been disconnected!!");
		}
		return 0;
	}
	
	public int deleteCustomerByCode(int code) {
	
		try {
			Connection connection = MySqlConnection.getConnection();
			String query = "DELETE FROM customer WHERE code = ?";
			PreparedStatement st = connection.prepareStatement(query);
			st.setInt(1, code);
			int check = st.executeUpdate();
			return check;
		} catch (SQLException e) {
			System.out.println("Connection to database has been disconnected!!");
		}
		return 0;
	}
	
	public int updateCustomer(Customer customer, int code) {
	
		try {
			Connection connection = MySqlConnection.getConnection();
			String query = "UPDATE customer SET name = ?, address = ?, email = ? WHERE code = ?";
			
			PreparedStatement st = connection.prepareStatement(query);
			st.setString(1, customer.getName());
			st.setString(3, customer.getEmail());
			st.setString(2, customer.getAddress());
			st.setInt(4, code);
			int check = st.executeUpdate();
			return check;
		} catch (SQLException e) {
			System.out.println("Connection to database has been disconnected!!");
		}
		return 0;
	}
	
}