package test1;

public class Person {

	private int id;
	private String name;
	private int taxId;
	
	private Address add; 
	
	public Person(){
		
	}
	public Person(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
			
	public void setAdd(Address add) {
		this.add = add;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxId=" + taxId
				+ ", add=" + add + "]";
	}
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}
	
	public void speak(){
		System.out.println("I am a person  " );
	}
}
