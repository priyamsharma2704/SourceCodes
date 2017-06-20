package springDemo;

public class Triangle {
	
	private String type;
	private int side;
				
	public void setSide(int side) {
		this.side = side;
	}

	public String getType() {
		return type;
	}
	
	public Triangle(String type) {
		
		this.type = type;
	}

	public void draw(){
		System.out.println(getType()+ "\nSides = "+ side   + "\nTriangle drawn");
	}


	

}
