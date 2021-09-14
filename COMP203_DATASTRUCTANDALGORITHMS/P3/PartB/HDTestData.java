package PartB;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HDTestData {
    public static void main(String []args){
        AVLTree<String> serailNumber = new AVLTree<String>();
        AVLTree<String> model = new AVLTree<String>();
        AVLTree<String> capacity = new AVLTree<String>();
        AVLTree<String> totalPoweredHours = new AVLTree<String>();
        ArrayList<String> inputFile = new ArrayList<String>();
        ArrayList<Integer>  randomNumberArrayList = new ArrayList<Integer>();

        //this array for the random numbers
        int[] numberOfNs={10,100,250,500,1000,10000,100000};
        //this k is very important because if we want to change random number below in for loop we need to increase or decrease k
        int k;

        //we can increase or decrease the value of k in here
        for( k=0;k<3;k++) {
            for (int i = 0; i < numberOfNs[k]; i++) {
                //bound is 73654 because this is the last index number of data_main.csv
                int random = new Random().nextInt(73654);
                randomNumberArrayList.add(random);
            }
            try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("data_main.csv")))) {
                scanner.nextLine();

                while (scanner.hasNextLine()) {
                    String read = scanner.nextLine();
                    inputFile.add(read);

                }
                //this is for the insterting part
                long start = System.currentTimeMillis();
                for (int i = 0; i < randomNumberArrayList.size(); i++) {
                    String insert = inputFile.get(randomNumberArrayList.get(i));
                    String[] array = insert.split(",");
                    serailNumber.insert(array[0]);
                    model.insert(array[1]);
                    capacity.insert(array[2]);
                    totalPoweredHours.insert(array[3]);
                }
                long elapsed = System.currentTimeMillis();
                //This printing part for the insertion
                System.out.println("Number of " + numberOfNs[k]+" are below ");
                System.out.println("Time for the inserting " + (elapsed - start) + " milliseconds");
                System.out.println("SERIAL NUMBERS ");
                serailNumber.display();
                System.out.println("--------");
                System.out.println("MODELS ARE ");
                model.display();
                System.out.println("--------");
                System.out.println("CAPACITY ARE ");
                capacity.display();
                System.out.println("--------");
                System.out.println("TOTAL POWERED HOURS ARE ");
                totalPoweredHours.display();

                //for the searching part and when we search a index. the output will be like that( name then ,depth, and height)
                long start1 = System.currentTimeMillis();
                System.out.println("Number of searching " + numberOfNs[k]+" are below ");
                for (int i = 0; i < randomNumberArrayList.size(); i++) {
                    String search = inputFile.get(randomNumberArrayList.get(i));
                    String[] array = search.split(",");
                    serailNumber.search(array[0]);
                    model.search(array[1]);
                    capacity.search(array[2]);
                    totalPoweredHours.search(array[3]);
                }
                long elapsed1 = System.currentTimeMillis();

                System.out.println("Time for the searching random data's " + (elapsed1-start1)+" milliseconds");
                //for the deletion part of the indexes. again when we delete a number the output will be lik that(name + is deleted)
                long start2 = System.currentTimeMillis();
                System.out.println("Number of deleting " + numberOfNs[k]+" are below ");
                for (int i = 0; i < randomNumberArrayList.size(); i++) {
                    String insert = inputFile.get(randomNumberArrayList.get(i));
                    String[] array = insert.split(",");
                    serailNumber.delete(array[0]);
                    model.delete(array[1]);
                    capacity.delete(array[2]);
                    totalPoweredHours.delete(array[3]);
                }
                long elapsed2 = System.currentTimeMillis();

                System.out.println("Time for the deleting random data's " + (elapsed2-start2)+" milliseconds");
                System.out.println("--------");


            } catch (FileNotFoundException e) {
                System.out.println("The file has not been read sir!");
            }
        }
        //i put 3 due to hw file we can increase or decrease the k
        //this increase for the datas 10,100,250,1000,10000
        k++;

    }
}
