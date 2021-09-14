import java.util.BitSet;

public class BinaryWord implements Complementable<BinaryWord> {
		private BitSet bitset;
		private int length;
		
		//Constructor 
	public BinaryWord(String bitset) {
		this.length = bitset.length();
		this.bitset = new BitSet(length);
			int i =0;
			while(i<length) {
				if(bitset.charAt(i)=='1') {
					this.bitset.set(i);
				}
				i++;
			}
		}

	@Override
	public BinaryWord complement() {
		BinaryWord binaryWord = new BinaryWord(BitSetToString(bitset));
		bitset = new BitSet(this.length);
		bitset.or(bitset);
		bitset.flip(0, this.length);
		
		return binaryWord;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bitset == null) ? 0 : bitset.hashCode());
		result = prime * result + length;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinaryWord other = (BinaryWord) obj;
		if (bitset == null) {
			if (other.bitset != null)
				return false;
		} else if (!bitset.equals(other.bitset))
			return false;
		if (length != other.length)
			return false;
		return true;
	}
	
	private String BitSetToString(BitSet bitset) {
		String empty = "";	
		int i =0;
		while(i<length) {
			empty += Integer.toString(bitset.get(i) ? 1 : 0);
			i++;
		}

		return empty;
	}


	@Override
	public String toString() {
		return "BinaryWord [bitset=" + bitset + ", length=" + length + "]";
	}



	public BitSet getBitset() {
		return bitset;
	}


	public void setBitset(BitSet bitset) {
		this.bitset = bitset;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	


	

	

	

}
