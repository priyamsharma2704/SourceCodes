package test1;

public class Address {
	private String street;
	private String pinCode;
	
	public Address(String street, String pinCode) {		
		this.street = street;
		this.pinCode = pinCode;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", pinCode=" + pinCode + "]";
	}
	
	
}
