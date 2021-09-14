import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[]args){
        readingMethods("input1.txt","output1.txt");
        readingMethods("input2.txt","output2.txt");

    }
    //Method for the input and output files
    public static void readingMethods(String file, String outFile){
        //Try catch block for errors
        //Reading method with Buffered Reader
        try(Scanner scanner  = new Scanner(new BufferedReader( new FileReader(file)))) {
            //Writing method with Buffered Reader
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            //This is the first input of input.txt for the array size
            String firstInput = scanner.nextLine();
            //I created a array to keep the elements of input page
            int[] emptyArray =new int[Integer.parseInt(firstInput)];
            //filling the array
            for(int i =0;i<Integer.parseInt(firstInput);i++){
                emptyArray[i]= 0;
            }
            //while method for the read all the inputs until end of the input page
            while(scanner.hasNextLine()){
                String text = scanner.nextLine();
                // This spilt for the while reading inputs, it passed empty line like (3 4)=>(34)
                String[]  array = text.split("\\s+");
                //1 - print the counters in ascending index value order as (index, count) pairs.
                if(array[0].equals("1")){
                    writer.write("print by index"+"\n");
                    //This directly takes the inputs from my emptyArray and write to the output.txt
                    for(int i=0;i<emptyArray.length;i++){
                        writer.write( i + " " + emptyArray[i] + "\n");
                    }
                    writer.write("-------"+"\n");
                }
                //2 - print the counters in ascending counter value order as (index, count) pairs.
                if(array[0].equals("2")){
                    //Hashmap for the put the temp2 indexes with current index
                    HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
                    //Creating new empty array for the sorting
                    int[] temp2 = new int[Integer.parseInt(firstInput)];
                        //filling the empty array
                    for(int i=0;i<Integer.parseInt(firstInput);i++){
                        temp2[i] = emptyArray[i];
                    }
                    //put array index to hashMap
                    for(int i=0;i<Integer.parseInt(firstInput);i++){
                        hashMap.put(i,temp2[i]);
                    }
                    //Creating ser for the select all the elements in hashMap for the sorting with indexes
                    Set<Map.Entry<Integer, Integer>> entrySet = hashMap.entrySet();
                    //entrySet to list for the comparision of hashmap elements
                    List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer,Integer>>(entrySet);
                    //Override Collections.sor for the comparatorTo method
                    Collections.sort(entryList, new Comparator<Map.Entry<Integer,Integer>>(){
                        @Override
                        public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                            return o1.getValue().compareTo(o2.getValue());
                        }
                    });
                    //After comparing index i put the current indexes to sort with LinkedHashMap
                    LinkedHashMap<Integer,Integer> sortHashMap = new LinkedHashMap<Integer,Integer>();
                    //for each loop to get key and values
                    for(Map.Entry<Integer,Integer> entry:entryList){
                        sortHashMap.put(entry.getKey(),entry.getValue());
                    }
                    //writer method
                    writer.write("print by count"+"\n");
                    //again for each method for writer method
                    for(Integer printArray : sortHashMap.keySet()){
                        writer.write(printArray +" "+ sortHashMap.get(printArray)+"\n");
                    }
                    writer.write("-------"+"\n");
                }
                //if the process goes to 3 then, i increased  the current index as 1
                if(array[0].equals("3")){
                    emptyArray[Integer.parseInt(array[1])] ++;
                }
                //if the process goes to 3 then, i decreased   the current index as 1
                if(array[0].equals("4")){
                    emptyArray[Integer.parseInt(array[1])] --;
                }
                    // process goes to five
                if(array[0].equals("5")){
                    //i created a counter for the how many index do we have
                    int counter =0;
                    //those are getting the which element takes from the array
                    int number1 =Integer.parseInt(array[1]);
                    int number2 =Integer.parseInt(array[2]);
                    //again empty array to put indexes to this array
                    int[] temp1 = new int[Integer.parseInt(firstInput)];
                    //filling the array
                    for(int i=0;i<Integer.parseInt(firstInput);i++){
                        temp1[i] = emptyArray[i];
                    }
                    //I used Arrays.sort because we need to sorting array to count the indexes what we will want
                    Arrays.sort(temp1);
                    //this for loop for the counter
                    for(int i=0;i<temp1.length;i++){
                        if(temp1[i]>=number1 && temp1[i]<=number2){
                            counter++;
                        }
                    }
                    //writer method for the Bufferedwriter
                    writer.write(counter + " counters valued between "+ number1 +" and "+ number2 +"\n");
                }
                //to finis the process
                if(array[0].equals("0")){
                    break;
                }
            }
            //those are necessary things for the writing
            writer.flush();
            writer.close();
            //These are catching the exceptions if there will be
        } catch (FileNotFoundException e) {
            System.out.println("File has not been found");
        } catch (IOException e) {
            System.out.println("while writing the error has been occur ");
        }
    }

}
