import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static Scanner scan;
	public static void main(String[] args) {
			String process = "To exit press q\n" +
							  "1.Positive Integer\n"+
							  "2.RGBColors\n"+
							  "3.Binary Word ";
			scan = new Scanner(System.in);
			while(true) {
				
				System.out.println("********************");
				System.out.println(process);
				System.out.println("********************");
				String a = scan.nextLine();				
					//exit
					if(a.equals("q")) {
						System.out.println(" The end of the process");
						break;
					}
					//Positive Integer
					else if (a.equals("1")) {
						Collection<PositiveInteger> number = new LinkedList<PositiveInteger>();
						System.out.println("Please write how many numbers could you want to add");
						int nu = scan.nextInt();
						for(int i = 0; i < nu; i++) {
							number.add(new PositiveInteger(scan.nextInt()));		
						}
						System.out.println("The sum is  " + PositiveInteger.combine(number).getNumber());
						break;
					}
					//RGBColors
					else if (a.equals("2")) {
						Collection<RGBColor> collection = new ArrayList<RGBColor>();
						ArrayList<RGBColor> collection2 = new ArrayList<RGBColor>();
						int [][] doubleArray = new int[3][3];
						for(int i = 0; i < 3; i++) {
							System.out.println("Write value of green, red , blue colors ");
							for(int j = 0; j < 3; j++) {
								doubleArray[i][j] = scan.nextInt();
							}
						}
						for(int i = 0; i < 3; i++) {
							collection.add(new RGBColor(doubleArray[i][0], doubleArray[i][1], doubleArray[i][2]));
							collection2.add(new RGBColor(doubleArray[i][0], doubleArray[i][1], doubleArray[i][2]));
						}
						System.out.println("mix of the colors 1 and 2 " + collection2.get(0).operator(collection2.get(1)).getRed() + " - " + collection2.get(0).operator(collection2.get(1)).getGreen() + " - " + collection2.get(0).operator(collection2.get(1)).getBlue());
						System.out.println("combinations of all colors " + RGBColor.combine(collection).getRed() + " - " + RGBColor.combine(collection).getGreen() + " - " + RGBColor.combine(collection).getBlue() );
						break;
					}
					//Binary Word 
					else if (a.equals("3")) {
						System.out.println("write BinaryWord");
						String sss = scan.nextLine();
						BinaryWord binary = new BinaryWord(sss);
						System.out.println("the binary word is  " + binary + " is " + binary.complement() );
						break;
	
					}
					else {
						
					}
				
			}

	}

}
