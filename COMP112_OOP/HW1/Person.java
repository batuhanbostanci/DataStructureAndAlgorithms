import java.util.Random;

public class Person {
	  private String person;
	    private int energy;
	    private boolean isParent;
	    private boolean haveInfant;
	    private int room;
	    private int boxNum;

	    public Person(String person, int energy, boolean isParent, boolean haveInfant, int room, int boxNum) {
	        this.person = person;
	        this.energy = energy;
	        this.isParent = isParent;
	        this.haveInfant = haveInfant;
	        this.room = room;
	        this.boxNum = boxNum;
	    }
	    
	    public int goRandomRoom(int numOfRooms, int numOfBoxes, Person person){
	        Random random = new Random();
	        int randomRoom = random.nextInt(numOfRooms) + 1;
	        room = randomRoom;
	        if(person.getPerson().equals("daughter"))
	            goRandomBox(numOfBoxes);
	        return room;
	    }
	    
	    public int goRandomBox(int numOfBoxes){
	        Random random = new Random();
	        int randomBox = random.nextInt(numOfBoxes) + 1;
	        boxNum = randomBox;
	        energy--;
	        return boxNum;
	    }
	    
	    public int fatherSearch(Person daughter, int numOfRooms, int numOfBoxes){
	        int[][] daughterRoom = new int[numOfRooms][numOfBoxes];
	        daughterRoom[daughter.getRoom()-1][daughter.getBox()-1] = 1;
	        int count = 0;
	        for(int i = 0; i < numOfRooms; i++){
	            for(int j = 0; j < numOfBoxes; j++){
	                count++;
	                if(daughterRoom[i][j] == 1){
	                    if(haveInfant)
	                        return count*2;
	                    else
	                        return count;
	                }
	            }
	        }
	        return count;
	    }
	    
	    public String getPerson() {
	        return person;
	    }

	    public int getEnergy() {
	        return energy;
	    }

	    public int getRoom() {
	        return room;
	    }

	    public boolean isIsParent() {
	        return isParent;
	    }

	    public boolean isHaveInfant() {
	        return haveInfant;
	    }

	    public int getBox() {
	        return boxNum;
	    }

	    public void setPerson(String person) {
	        this.person = person;
	    }

	    public void setEnergy(int energy) {
	        this.energy = energy;
	    }

	    public void setRoom(int room) {
	        this.room = room;
	    }

	    public void setIsParent(boolean isParent) {
	        this.isParent = isParent;
	    }

	    public void setHaveInfant(boolean haveInfant) {
	        this.haveInfant = haveInfant;
	    }

	    public void setBox(int box) {
	        this.boxNum = box;
	    }

}
