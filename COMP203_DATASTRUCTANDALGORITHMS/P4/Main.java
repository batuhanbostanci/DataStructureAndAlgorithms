import java.io.*;
import java.util.Scanner;
//Tacettin Batuhan Bostanci
//Id No:110 510 179

public class Main {
    public static void main(String [] args){
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("in.dat")))) {
            MinHeap heap = new MinHeap();
             int value = Integer.parseInt( scanner.nextLine());//reading integer value from the input file
                String[] titleArray = new String[value];//this is for the all inputs files array
            for (int i = 0; i <value ; i++) {
                titleArray[i] = scanner.nextLine();//writing names of the inputs to the titleArray
            }
            for (int i = 0; i <value ; i++) {
                Scanner scanner2 = new Scanner(new BufferedReader(new FileReader(titleArray[i])));//Second Scanner method for the read indexes from input files
                while (scanner2.hasNextLine()){
                 heap.insert(scanner2.nextLine());//inserting indexes to heap
                }
            }
            for (int i = 0; i < heap.count ; i++) {
                heap.deleteHeap();
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file has not been read sir!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

