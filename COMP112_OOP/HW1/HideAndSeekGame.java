
public class HideAndSeekGame {
	 public static void main(String[] args){
	        int numOfRooms = 5;
	        int numOfBoxes = 5;
	        int minutes = 0;
	        int takeBabyCount = 0;
	        
	        boolean roundOver = false;
	        
	        Person father = new Person("father", 100, true, false, 1, 0);
	        Person mother = new Person("mother", 0, true, true, 1, 0);
	        Person daughter = new Person("daughter", 100, false, false, 1, 0);
	        
	        System.out.println("Game started at 18:00");
	        while(takeBabyCount < 3 || father.getEnergy() > 1) {

	            while(!roundOver)
	            {
	                mother.goRandomRoom(numOfRooms, numOfBoxes, mother);
	                System.out.println("Mother at room " + mother.getRoom());

	                daughter.goRandomRoom(numOfRooms, numOfBoxes, daughter);
	                System.out.println("Daughter at room " + daughter.getRoom());
	                System.out.println("Daughter is hiding in the box " + daughter.getBox());

	                if(mother.getRoom() <= daughter.getRoom()){
	                    System.out.println("Mother gave the infant to Father");
	                    father.setHaveInfant(true);
	                    mother.setHaveInfant(false);
	                    roundOver = true;
	                    takeBabyCount++;
	                }

	                father.setEnergy(father.getEnergy() - father.fatherSearch(daughter, numOfRooms, numOfBoxes));
	                //System.out.println("takeBabyCount: " + takeBabyCount);
	                
	                if(father.isHaveInfant()){
	                    minutes += father.fatherSearch(daughter, numOfRooms, numOfBoxes)/2;
	                }
	                else{
	                    minutes += father.fatherSearch(daughter, numOfRooms, numOfBoxes);
	                }
	            }
	            roundOver = false;
	            father.setHaveInfant(false);
	            mother.setHaveInfant(true);
	        }
	        if(takeBabyCount > 3){
	            System.out.println("Daughter starts crying please stop the game");
	        }
	        System.out.println("Father's left energy is " + father.getEnergy());
	        System.out.println("Father and Daughter played " + minutes + " minute(s) hide and seek");
	    }

}
