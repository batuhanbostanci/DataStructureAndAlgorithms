
public class Cone extends Cylinder {

	public Cone(int height, int r) {
		super(height, r);
		
	}

	@Override
	public void volume() {
		double vol = getR()*getR()*getHeight();
		System.out.println("Cone has height " + getHeight() + " radius " + getR());
		System.out.println("The volume of the Cone is " + vol);
			}

	@Override
	public String toString() {
		return "Cone [toString()=" + super.toString() + ", getR()=" + getR() + ", getHeight()=" + getHeight()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
	
	

	
}
