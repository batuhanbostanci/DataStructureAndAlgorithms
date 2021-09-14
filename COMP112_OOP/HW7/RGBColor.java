
public class RGBColor  extends SemiGroup<RGBColor> implements Complementable<RGBColor> {
		private int green;
		private int red;
		private int blue;
		
		public RGBColor(int green, int red, int blue) {
			super();
			this.green = green;
			this.red = red;
			this.blue = blue;
		}
		
		@Override
		RGBColor operator(RGBColor rgb) {
			RGBColor colors = new RGBColor((rgb.getGreen() + green) , (rgb.red + red) /2 ,(rgb.blue + red) /2);
			return colors;
		}
		@Override
		public RGBColor complement() {
			// TODO Auto-generated method stub
			return new RGBColor(255 -green, 255 -red, 255 -blue);
		}

		public int getGreen() {
			return green;
		}

		public void setGreen(int green) {
			this.green = green;
		}

		public int getRed() {
			return red;
		}

		public void setRed(int red) {
			this.red = red;
		}

		public int getBlue() {
			return blue;
		}

		public void setBlue(int blue) {
			this.blue = blue;
		}
	
		
}
