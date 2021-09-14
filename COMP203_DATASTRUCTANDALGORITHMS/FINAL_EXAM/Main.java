import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[]args){
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("FinalExamGraphFile.txt")))) {
            ArrayList<Edges> edges = new ArrayList<>();
            //QUESTION 1 STARTING-----------------------------------------------------------------------------------------------------
            while (scanner.hasNextLine()){//this is for the insert FinalExamGraphFile to graph
                String text = scanner.nextLine();
                String[]  array = text.split("\\s+");
                Edges edg = new Edges(Integer.parseInt(array[0]),Integer.parseInt(array[1]),Integer.parseInt(array[2]));
                edges.add(edg);

            }

            //QUESTION 2 STARTING-----------------------------------------------------------------------------------------------------
            Scanner scanner2 = new Scanner(new BufferedReader(new FileReader("Positive.txt")));
            while (scanner2.hasNextLine()){//this is for the insert positive to graph
                String text = scanner2.nextLine();
                String[]  array = text.split("\\s+");
                Edges edg = new Edges(Integer.parseInt(array[0]),Integer.parseInt(array[1]),1);
                edges.add(edg);

            }
            Graph graph = new Graph(edges);

            Graph.get(graph,101);//this one just example


            //QUESTION 3 STARTING-----------------------------------------------------------------------------------------------------
            // starting and writing negative values to negativeGraphNumber for the 4th question
            // this is creates negative vales as a random type I set the bound 6500 because of it increase the chance to be friend in the future

            BufferedWriter writer1 = new BufferedWriter(new FileWriter("negativeGraphNumber.txt"));//this writer to write negative to text file because i use this values in the arraylist in below
            int temp=0;
            while (temp<5592){
                int random = new Random().nextInt(5592);//creating randoms
                int random1 = new Random().nextInt(5592);//creating randoms


                for (Graph.Node edge : graph.adjList.get(random)) {//for each method to look the every index of edge
                    if(edge.value>0) {
                        if (!graph.adjList.get(random).contains(random1)) {//this, if method looks graph contains random random value if it not contains then pass
                            random = new Random().nextInt(5592);
                            writer1.write(random + " " + random1 + " " + 1 + "\n");// I set the strength of the source and destination as 1 because there wasn't any information for this one
                            writer1.flush();
                            temp++;
                        }
                        if(temp==5592){//we finished loops when it reached 5592
                            break;
                        }

                    }

                }

            }

            //QUESTION 4 STARTING-----------------------------------------------------------------------------------------------------

            BufferedWriter writer = new BufferedWriter(new FileWriter("positiveGraphNumber.txt"));// write all positiveGraphNumbers to text
            for(int src_vertex=0;src_vertex<graph.adjList.size();src_vertex++){
                for (Graph.Node edge : graph.adjList.get(src_vertex)) {
                    writer.write(src_vertex + " " + edge.value +" "+ edge.weight+"\n");
                    writer.flush();
                }
            }
            writer.close();
            writer1.close();
            ArrayList<Edges> postiveGraphNumber = new ArrayList<>();
            Scanner scanner5 = new Scanner(new BufferedReader(new FileReader("positiveGraphNumber.txt")));
            while (scanner5.hasNextLine()){//this reading is the read all the graph later than to control if there is common friend or not
                String text = scanner5.nextLine();
                String[]  array = text.split("\\s+");
                Edges edg2 = new Edges(Integer.parseInt(array[0]),Integer.parseInt(array[1]),Integer.parseInt(array[2]));
                postiveGraphNumber.add(edg2);
            }

            ArrayList<Edges> edgesNegative = new ArrayList<>();
            ArrayList<Edges> edgesPositive = new ArrayList<>();
            Scanner scanner3 = new Scanner(new BufferedReader(new FileReader("negativeGraphNumber.txt")));
            Scanner scanner4 = new Scanner(new BufferedReader(new FileReader("positive.txt")));

            while (scanner3.hasNextLine()){//this reading for the reading negative and adding arraylist
                String text = scanner3.nextLine();
                String[]  array = text.split("\\s+");
                Edges edg1 = new Edges(Integer.parseInt(array[0]),Integer.parseInt(array[1]),Integer.parseInt(array[2]));
                edgesNegative.add(edg1);
            }
            while (scanner4.hasNextLine()){//this reading for the reading positive and adding arraylist
                String text = scanner4.nextLine();
                String[]  array = text.split("\\s+");
                Edges edg2 = new Edges(Integer.parseInt(array[0]),Integer.parseInt(array[1]),1);
                edgesPositive.add(edg2);
            }

            getPosNegCommonNumber(postiveGraphNumber,edgesNegative,101,2378);//this is example to control, is there a common friend or not

            //QUESTION 5 STARTING
            ArrayList<Edges> commonFriendScores= new ArrayList<>();
            for (int i = 0; i <edgesNegative.size() ; i++) {// adding positive and negative values to one arraylist
                Edges e1 = new Edges(edgesPositive.get(i).source,edgesPositive.get(i).destination,edgesPositive.get(i).weight);
                Edges e2 = new Edges(edgesNegative.get(i).source,edgesNegative.get(i).destination,edgesNegative.get(i).weight);
                commonFriendScores.add(e1);
                commonFriendScores.add(e2);
            }

            //Initialize all the elements
            QuickSort qs = new QuickSort();
            HeapSort hs = new HeapSort();
            MergeSort ms = new MergeSort();
            InsertionSort is = new InsertionSort();

            //This part Quick Sort Part
            ArrayList<Edges> quickSortArrayList = new ArrayList<Edges>();
            copy(commonFriendScores,quickSortArrayList);
            long start1 =System.currentTimeMillis();
            qs.sort(quickSortArrayList,0,quickSortArrayList.size()-1);
            long finish1 =System.currentTimeMillis();
            System.out.println("Quick Sort Passing Time " +(finish1-start1)+" millisecond");


            //This part heap sort Part
            ArrayList<Edges> heapSortArrayList = new ArrayList<Edges>();
            copy(commonFriendScores,heapSortArrayList);
            long start2 = System.currentTimeMillis();
            hs.sort(heapSortArrayList);
            long finish2 = System.currentTimeMillis();
            System.out.println("Heap Sort Passing Time " +(finish2-start2)+" millisecond");


            //This part merge sort Part
            ArrayList<Edges> mergeSortArrayList = new ArrayList<Edges>();
            copy(commonFriendScores,mergeSortArrayList);
            long start3 = System.currentTimeMillis();
            ms.sort(mergeSortArrayList,0,mergeSortArrayList.size()-1);
            long finish3 = System.currentTimeMillis();
            System.out.println("Merge Sort Passing Time " +(finish3-start3)+" millisecond");


            //This part insertion Part
            ArrayList<Edges> insertionSortArrayList = new ArrayList<Edges>();
            copy(commonFriendScores,insertionSortArrayList);
            long start4 = System.currentTimeMillis();
            is.sort(insertionSortArrayList);
            long finish4 = System.currentTimeMillis();
            System.out.println("Insertion Sort Passing Time " +(finish4-start4)+" millisecond");

            ArrayList<Edges> aboveArrayList = new ArrayList<>();
            ArrayList<Edges> belowArrayList = new ArrayList<>();

            for (int i = 0; i <commonFriendScores.size()/2 ; i++) {
                Edges e = new Edges(commonFriendScores.get(i).source,commonFriendScores.get(i).destination,commonFriendScores.get(i).weight);
                aboveArrayList.add(e);
            }
            for (int i = commonFriendScores.size()/2; i <commonFriendScores.size() ; i++) {
                Edges e = new Edges(commonFriendScores.get(i).source,commonFriendScores.get(i).destination,commonFriendScores.get(i).weight);
                belowArrayList.add(e);
            }
            int counterAbove=0;
            for (int i = 0; i <edgesPositive.size() ; i++) {
                for (int j = 0; j <aboveArrayList.size() ; j++) {
                    if(edgesPositive.get(i).source==aboveArrayList.get(j).source&&edgesPositive.get(i).destination==aboveArrayList.get(j).destination&&edgesPositive.get(i).weight==aboveArrayList.get(j).weight){
                        counterAbove++;
                    }
                }
            }
           int counterBelow=0;
            for (int i = 0; i <edgesNegative.size() ; i++) {
                for (int j = 0; j <belowArrayList.size() ; j++) {
                    if(edgesNegative.get(i).source==belowArrayList.get(j).source&&edgesNegative.get(i).destination==belowArrayList.get(j).destination&&edgesNegative.get(i).weight==belowArrayList.get(j).weight){
                        counterBelow++;
                    }
                }
            }
            System.out.println("Your guess is correct with "+ counterAbove+"/"+counterBelow+ " accuracy");

           

        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
    static void copy(ArrayList<Edges> arrayList, ArrayList<Edges> arrayList2){//this copy method for the copy arraylist to another arraylist to sorting
        for (int i = 0; i <arrayList.size() ; i++) {
            Edges edges = new Edges(arrayList.get(i).source , arrayList.get(i).destination , arrayList.get(i).weight);
            arrayList2.add(edges) ;

        }
    }
    static void getNumb(ArrayList<Edges> arrayList,int source) {//this one just the controlling
        int counter = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).source == source) {
                System.out.println(arrayList.get(i).source + " " + arrayList.get(i).destination + " " + arrayList.get(i).weight);
                counter++;
            }
        }
        System.out.println(counter);
    }


    static void getPosNegCommonNumber(ArrayList<Edges> arrayList,ArrayList<Edges> arrayList2,int source, int source2){//this method for the to find common friends
        int counter=0;
        List<Edges> tempArrayList = new ArrayList<>();
        List<Edges> tempArrayList2 = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).source==source) {
                Edges te = new Edges(arrayList.get(i).source ,arrayList.get(i).destination , arrayList.get(i).weight);
                tempArrayList.add(te);

            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).source==source2) {
                Edges te = new Edges(arrayList.get(i).source ,arrayList.get(i).destination , arrayList.get(i).weight);
                tempArrayList2.add(te);

            }
        }
        for (int i = 0; i <tempArrayList.size() ; i++) {
            for (int j = 0; j <tempArrayList2.size() ; j++) {
                if(tempArrayList.get(i).destination==tempArrayList2.get(j).destination){
                    counter++;
                }
            }
        }
        if(counter==0){
            System.out.println("("+source +" and "+source2+")"+" hasn't common friend");
        }else
            System.out.println("("+source +" and "+source2+")"+" has common "+counter+ " friend");

    }
    static class MergeSort {
        //merge part
        void merge(ArrayList<Edges> arrayList, int l, int m, int r) {

            int n1 = m - l + 1;
            int n2 = r - m;
            ArrayList<Edges> left = new ArrayList<>();
            ArrayList<Edges> right = new ArrayList<>();

            for (int i = 0; i < n1; ++i) {
                Edges edges = new Edges(arrayList.get(l + 1).source, arrayList.get(l + 1).destination, arrayList.get(l + 1).weight);
                left.add(edges);
            }
            for (int j = 0; j < n2; ++j) {
                Edges edges = new Edges(arrayList.get(m + 1 + j).source, arrayList.get(m + 1 + j).destination, arrayList.get(m + 1 + j).weight);
                right.add(edges);
            }


            int i = 0, j = 0;
            int k = l;
            while (i < n1 && j < n2) {
                if (left.get(i).source <= right.get(j).source) {
                    arrayList.get(k).source = left.get(i).source;
                    i++;
                } else {
                    arrayList.get(k).source = right.get(j).source;
                    j++;
                }
                k++;
            }
            while (i < n1) {
                arrayList.get(k).source = left.get(i).source;
                i++;
                k++;
            }
            while (j < n2) {
                arrayList.get(k).source = right.get(j).source;
                j++;
                k++;
            }
        }


        void sort(ArrayList<Edges> arrayList, int l, int r) {//merging sort part
            if (l < r) {
                int m = (l + r) / 2;
                sort(arrayList, l, m);
                sort(arrayList, m + 1, r);
                merge(arrayList, l, m, r);
            }
        }

        //print part
        void printArray(ArrayList<Edges> arrayList) {
            int n = arrayList.size();
            for (int i = 0; i < n; ++i)
                System.out.println(arrayList.get(i).source + " " + arrayList.get(i).destination + " " + arrayList.get(i).weight);

        }
    }
    static class InsertionSort {
        //sorting part
        void sort(ArrayList<Edges> arrayList) {
            for (int i = 1; i < arrayList.size(); ++i) {
                int key = arrayList.get(i).source;
                int j = i - 1;

            
                while (j >= 0 && arrayList.get(j).source > key) {
                    arrayList.get(j+1).source = arrayList.get(j).source;
                    j = j - 1;
                }
                arrayList.get(j+1).source = key;
            }
        }

        //print part
        void printArray(ArrayList<Edges> arrayList) {
            int n = arrayList.size();
            for (int i=0; i<n; ++i)
                System.out.println(arrayList.get(i).source+" "+arrayList.get(i).destination+" "+arrayList.get(i).weight);

        }
    }
    static  class QuickSort {
        int partition(ArrayList<Edges> arrayList, int smaller, int bigger) {//partition part
            int pivot = arrayList.get(bigger).source;

            int i = (smaller-1); // index of smaller element
            for (int j=smaller; j<bigger; j++)
            {
                if (arrayList.get(j).source < pivot)
                {
                    i++;
                    int temp = arrayList.get(i).source;
                    arrayList.get(i).source = arrayList.get(j).source;
                    arrayList.get(j).source = temp;
                }
            }

            int temp = arrayList.get(i+1).source;
            arrayList.get(i+1).source = arrayList.get(bigger).source;
            arrayList.get(bigger).source = temp;

            return i+1;
        }
        //print part
        void printArray(ArrayList<Edges> arrayList) {
            int n = arrayList.size();
            for (int i=0; i<n; ++i)
                System.out.println(arrayList.get(i).source+" "+arrayList.get(i).destination+" "+arrayList.get(i).weight);

        }
        //sorting part
        void sort(ArrayList<Edges> arrayList, int smaller, int bigger) {
            if (smaller < bigger)
            {
                int pi = partition(arrayList, smaller, bigger);
                sort(arrayList, smaller, pi-1);
                sort(arrayList, pi+1, bigger);
            }
        }
    }
    static class HeapSort {

        //sort part
        public void sort(ArrayList<Edges> arrayList) {
            for (int i = arrayList.size() / 2 - 1; i >= 0; i--)
                heapify(arrayList, arrayList.size(), i);

            for (int i = arrayList.size() - 1; i > 0; i--) {
                // Move current root to end
                int temp = arrayList.get(0).source;
                arrayList.get(0).source =  arrayList.get(i).source;
                arrayList.get(i).source = temp;
                heapify(arrayList, i, 0);
            }
        }

        void heapify(ArrayList<Edges> arrayList, int n, int i) {//heapify part
            int largest = i;
            int l = 2 * i + 1;
            int r = 2 * i + 2;


            if (l < n &&  arrayList.get(l).source >  arrayList.get(largest).source)
                largest = l;


            if (r < n && arrayList.get(r).source > arrayList.get(largest).source)
                largest = r;


            if (largest != i) {
                int swap =arrayList.get(i).source;
                arrayList.get(i).source =arrayList.get(largest).source;
                arrayList.get(largest).source = swap;
                heapify(arrayList, n, largest);
            }
        }

        //print part
        void printArray(ArrayList<Edges> arrayList) {
            for (int i = 0; i < arrayList.size(); ++i)
                System.out.println(arrayList.get(i).source+" "+arrayList.get(i).destination+" "+arrayList.get(i).weight);

        }
    }

}

