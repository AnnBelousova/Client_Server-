package communication;

import business.Customer;

public class Request {
	
	private TypeRequest type;
	
	private Customer customer;

	public TypeRequest getType() {
		return type;
	}

	public void setType(TypeRequest type) {
		this.type = type;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "TypeRequest [type=" + type + ", customer=" + customer + "]";
	}

	public Request(TypeRequest type, Customer customer) {
		super();
		this.type = type;
		this.customer = customer;
	}
	public Request(TypeRequest type) {
		super();
		this.type = type;
	}
}
