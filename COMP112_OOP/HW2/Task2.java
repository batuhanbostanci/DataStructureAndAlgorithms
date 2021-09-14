import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.stream.Collectors.toMap;

public class Task2 {
	public static void read_albums(String input) throws IOException {
		BufferedReader reader= new BufferedReader(new FileReader(input));
		   ArrayList<String> words = new ArrayList<String>();    
	        Map<String, Integer> map = new HashMap<String, Integer>();
	        String line ="";    
		
     
     
				        while((line = reader.readLine()) != null) {    
				            String array[] = line.split("-");    
				           
				            for(String s : array){    
				                words.add(s);   
				               
				            }   
				            
				            
				        }    
				        
				        
					       reader.close();

					       for(String word : words){
					            Integer count = map.get(word);
					            if(count == null)
					                count = 0;
					            map.put(word, count+1);
					        }
					         
					            			     
           
				        
				        Map<String, Integer> sorted = map
				            .entrySet()
				            .stream()
				            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				            .collect(
				                toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
				                    LinkedHashMap::new));
				        
				        for (Map.Entry entry : sorted.entrySet())
				        {
				            if(!entry.getKey().toString().contains("("))
				                System.out.println(entry.getKey() + " : " + entry.getValue());
				        }
				    }
				    
	
	
		public static void main(String[] args) throws IOException{
			 read_albums("albums.txt");
	  }
	}
        
     
        
   
				
				

	  	  
		
		
	
		
			
			
				
				
			
			
		
		
	
	
	

	
	
	
	
	