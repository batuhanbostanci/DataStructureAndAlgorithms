
public class Cube extends Shape {

	public Cube(int height) {
		super(height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void volume() {
		double vol = getHeight()*getHeight()*getHeight();
		System.out.println("Cube has height " + getHeight());
		System.out.println("The volume of the Cube is " + vol);
		
	}

	@Override
	public String toString() {
		return "Cube [getHeight()=" + getHeight() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	

}
