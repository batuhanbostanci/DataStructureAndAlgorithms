import java.io.FileNotFoundException; 
import java.io.FileReader;

import java.util.Scanner;


public class H2Main {
	public static void main(String[] args) throws FileNotFoundException {
		
	
		Scanner scanner = new Scanner(new FileReader("input.txt"));
		
			while(scanner.hasNextLine()) {
				String informations = scanner.nextLine();
				String[]array = informations.split(",");
					
					if(array[0].equals("Cylinder")) {
						Cylinder cy = new Cylinder(Integer.valueOf(array[1]),Integer.valueOf(array[2]));
						cy.toString();
						cy.volume();
						
					}
					
					else if(array[0].equals("Cone")) {
						Cone cone = new Cone(Integer.valueOf(array[1]), Integer.valueOf(array[2]));
						cone.volume();
					
					}
					else if (array[0].equals("Cube")) {
						Cube cube = new Cube(Integer.valueOf(array[1]));
						cube.toString();
						cube.volume();
						
					}
					else if (array[0].equals("RectangularPrism")) {
						RectangularPrisim pri = new RectangularPrisim(Integer.valueOf(array[1]),Integer.valueOf(array[2]),Integer.valueOf(array[3]));
						pri.toString();
						pri.volume();
					}
					else if (array[0].equals("TriangularPrism")) {
						TriangularPrism ang = new TriangularPrism(Integer.valueOf(array[1]),Integer.valueOf(array[2]));
						ang.toString();
						ang.volume();
					}
					else if (array[0].equals("ParallelogramPrism")) {
						Parallelogram para = new Parallelogram(Integer.valueOf(array[1]),Integer.valueOf(array[2]));
						para.toString();
						para.volume();
					}
					
			
			}
			scanner.close();

	}

}			
			
			
		
		

