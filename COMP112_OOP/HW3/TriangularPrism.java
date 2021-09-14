
public class TriangularPrism extends Shape {
	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	private int base;

	public TriangularPrism(int height, int base) {
		super(height);
		this.base=base;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void volume() {
		double vol = base*getHeight();
		System.out.println("TriangularPrism has height " + getHeight() + " base " + base );
		System.out.println("The volume of the TriangularPrisim is " + vol);
		
	}

	@Override
	public String toString() {
		return "TriangularPrism [base=" + base + ", getBase()=" + getBase() + ", getHeight()=" + getHeight()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	

}
