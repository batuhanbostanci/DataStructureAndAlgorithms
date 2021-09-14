
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class WeatherProcess {
	public static void reader() throws IOException    {
		ArrayList<Integer> numberOfMonths = new ArrayList<Integer>();
		ArrayList<Double> avaregeOfMonths = new ArrayList<Double>();
		Scanner reader = new Scanner(new FileReader("weather.txt"));
		FileWriter writer1 =  new FileWriter("output.txt ");
		
		int sum = 0;
		double  average =0;
		int	counter =0;
		int month =1;
		while(reader.hasNextLine()) {
				int first = reader.nextInt();
				String[] months = new String[first];
				String lines = reader.nextLine();
				months = lines.split(" ");
				//to add the indexes to ArrayList 
				for(int i=0;i<=first;i++) {
                    if(i != 0){
                       int a = Integer.valueOf(months[i]);
                       numberOfMonths.add(a);
                       //	 System.out.print(a);
                    }
	             }
				
				//to get ArrayList  elements
				for(int k=0;k<numberOfMonths.size();k++) {
			         	
			     		sum += numberOfMonths.get(k);
			   //  	   System.out.println(sum);  
        
				}
				//adding average of temperature to ArrayList 
				average = (double)sum /numberOfMonths.size();
			
				avaregeOfMonths.add(average);
				//comparison of days with average
					for(int i =0;i<numberOfMonths.size();i++){
					
							if(numberOfMonths.get(i) > average) {
								counter++;
							}
							
					}
					
				System.out.println("Month " + month + " average temperature: " + average +"\n"+
						( counter) + " days were above the average temperature" +"\n");
				
						writer1.write("Month " + month + " average temperature: " + average );
						writer1.write("\n");
						writer1.write( (counter+1) + " days were above the average temperature");
						writer1.write("\r\n");
						writer1.write("\r\n");
						
		
				numberOfMonths.clear();
				sum =0;
				counter=0;
				month++;
				
			
			}

		reader.close();
				
		double totalAverage =0;
		int counter2=0;
		for(int i=0;i<avaregeOfMonths.size();i++) {
			totalAverage += (double) avaregeOfMonths.get(i);
				
		}
		double ave = totalAverage /12;
		for(int i=0;i<avaregeOfMonths.size();i++) {
			if(avaregeOfMonths.get(i) > ave) {
			counter2++;
			}
		}
		
		System.out.println("Average temperature for the year: " + ave);
		System.out.println(counter2 + " were above average temperature");
		writer1.write("Average temperature for the year: " + ave);
		writer1.write("\r\n");
		writer1.write(counter2 + " were above average temperature");
		writer1.write("\r\n");
		writer1.flush();
		writer1.close();
		}
		
		
		
		
	
		public static void main(String[] args) throws IOException {
			reader();
			
			}
}