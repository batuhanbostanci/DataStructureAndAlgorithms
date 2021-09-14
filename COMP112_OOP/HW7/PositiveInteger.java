
public class PositiveInteger extends SemiGroup<PositiveInteger>{
		private int number;
		public PositiveInteger()  {
			this(0);
		}
		
		public PositiveInteger(int number)  {
			if (number >= 0) {
				this.number = number;
			} 
			else {
				System.out.println("you should write postive number");
				
			}
		}
		
		
		@Override
		PositiveInteger operator(PositiveInteger number)  {
			PositiveInteger numb = new PositiveInteger(number.getNumber() + this.number);
			return numb;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		@Override
		public String toString() {
			return "PositiveInteger [number=" + number + "]";
		}

		
		

}
