package cybersoft.java12.jsp.model;

public class Customer {
	private int code;
	private String name;
	private String email;
	private String address;
	
	public Customer() {
		
	}
	
	public Customer(int code, String name, String email, String address) {
		this.code = code;
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
