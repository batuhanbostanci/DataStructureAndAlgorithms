import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task1 {
	public static void count_letters(String input_file, String output_file) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(input_file));
		BufferedWriter writer =new BufferedWriter(new FileWriter(output_file));
		
			int [] array = new int[26];
			char [] chars = new char[26];
			String letters="";
			String emptyLine;
			
			while((emptyLine = reader.readLine()) != null) {
			letters = letters +emptyLine;
			}
			reader.close();
			
			for(int i =0;i<letters.length();i++) {
				
				if(letters.charAt(i)>64 && letters.charAt(i)<91) {
					array[letters.charAt(i)-65]++;
				}
				else if (letters.charAt(i)>96 && letters.charAt(i)<123) {
					array[letters.charAt(i)-97]++;
				}
				
			}
			
			  
              int j = 0;
              for(char c = 'a'; c <= 'z'; ++c){
            	  c =  chars[j]++; 
                  
              }
              
              for(int i = 0; i < array.length; i++){
                  writer.write(String.valueOf(chars[i] + " " + array[i]) + "\n");
              }
              writer.close();
				
	}
	
			public static void main(String[] args) throws IOException {
		
					count_letters("in_file.txt","out_file.txt");
		
	}
}

	