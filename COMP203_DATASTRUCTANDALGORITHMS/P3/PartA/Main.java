package PartA;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        BinarySearchTree tree = new BinarySearchTree();
        ArrayList<String> arraylist = new ArrayList<String>();
        ArrayList<String> arraylist2 = new ArrayList<String>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("starwars.txt")))) {
            Scanner scanner2 = new Scanner(new BufferedReader(new FileReader("ReadList.txt")));
            //reading file from text
            while (scanner.hasNextLine()) {
                String read = scanner.nextLine();
                arraylist.add(read);

            }
            //reading file from text
            while (scanner2.hasNextLine()) {
                String read2 = scanner2.nextLine();
                if(arraylist2.contains(read2)){
                    System.out.println("System road this name before");
                }else {
                    arraylist2.add(read2);
                }
            }
            //This is inserting to tree
            long start = System.currentTimeMillis();
            for (String s : arraylist) {

                tree.insert(s);
            }
            long elapsed = System.currentTimeMillis();
            System.out.println(elapsed - start + " milliseconds passed for inserting");
            tree.display();
            System.out.println("--------");
            //This part for the max and min charther part
            long start1 = System.currentTimeMillis();
            System.out.println("The min charter is " + tree.minValue());
            System.out.println("The max charter is " + tree.maxValue());
            long elapsed1 = System.currentTimeMillis();
            System.out.println(elapsed1 - start1 + " milliseconds passed to find min value");
            System.out.println("-----------");

            // This part for the get the indexes from second array and to search for
            for(String s1:arraylist2){
                long start12= System.currentTimeMillis();
                if(arraylist.contains(s1)) {
                    System.out.println(tree.search(s1));
                }else{
                    System.out.println( s1 +" wasn't found in the tree");
                    continue;
                }
                long elapsed2= System.currentTimeMillis();
                System.out.println("Time to find the name from arraylist " + (elapsed2-elapsed1) + " millisecond");
                System.out.println("---------------");
                tree.h=0;
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file has not been read sir!");
        }
    }
}