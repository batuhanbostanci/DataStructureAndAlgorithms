
public class RectangularPrisim extends Cube  {
	private int width;
	private int length;

	public RectangularPrisim(int height, int width, int length) {
		super(height);
		this.length= length;
		this.width=width;
		
	}

	@Override
	public void volume() {
		double vol = getHeight()*width*length;
		System.out.println("RectangularPrisim has height " + getHeight() + " width "+ width+ " length " + length);
		System.out.println("The volume of the RectangularPrisim is " + vol);
		
	}

	@Override
	public String toString() {
		return "RectangularPrisim [width=" + width + ", length=" + length + ", toString()=" + super.toString()
				+ ", getHeight()=" + getHeight() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
	
	

	
}
