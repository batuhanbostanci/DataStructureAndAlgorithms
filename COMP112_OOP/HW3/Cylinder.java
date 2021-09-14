
public class Cylinder extends Shape {
	
	private int r;
	public Cylinder(int height, int r) {
		super(height);
		this.r=r;
	}
	@Override
	public void volume() {
			double vol = 3*r*r*getHeight();
			System.out.println("Cylinder has height " + getHeight() + " radius " + r);
			System.out.println("The volume of the Cylinder is " + vol);
		
	}
	
	@Override
	public String toString() {
		return "Cylinder [r=" + r + ", getR()=" + getR() + ", getHeight()=" + getHeight() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}

	
	
	

}
