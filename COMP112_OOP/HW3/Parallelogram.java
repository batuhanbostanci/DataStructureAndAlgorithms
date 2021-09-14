
public class Parallelogram extends TriangularPrism{

	public Parallelogram(int height, int base) {
		super(height, base);
		
	}

	@Override
	public void volume() {
		double vol=2*getBase()*getHeight();
		System.out.println("Parallelogram has height " + getHeight() + " base " + getBase() );
		System.out.println("The volume of the Parallelogram is " + vol);
		
	}

	@Override
	public String toString() {
		return "Parallelogram [getBase()=" + getBase() + ", toString()=" + super.toString() + ", getHeight()="
				+ getHeight() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
}
	
	
	

