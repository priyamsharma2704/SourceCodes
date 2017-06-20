package spring.project;

public class Triangle {
	
	private int sides;
	private Point pointA,pointB,pointC;	
	
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}

	public void draw(){
		System.out.println("Sides = " + sides +"\nTriangle drawn " +pointA);
		}

	@Override
	public String toString() {
		return "Triangle [sides=" + sides + ", pointA=" + pointA + ", pointB="
				+ pointB + ", pointC=" + pointC + "]";
	}
	

}
