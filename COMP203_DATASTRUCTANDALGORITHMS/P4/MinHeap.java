import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MinHeap {


    ArrayList<String> arrayList = new ArrayList<String>();//this arraylist for the values of the inputs files
    HashMap<String, Integer> hashMap =new HashMap<String, Integer>();//this hasHmap for the counting values of the indexes
    private boolean hasLeft(int i){return (2*i+1)<arrayList.size();}//boolean method for the leftSide, is there a child or not from nodes of parents
    private boolean hasRight(int i){return (2*i+2)<arrayList.size();}//boolean method for the rightSide, is there a child or not from nodes of parents
    int count=0;//this is for the counting all indexes when i delete indexes i need to learn size of the arraylist
    public MinHeap() throws IOException {
    }


    void swap(int index1, int index2){//swap method for the swapping
        String temp = arrayList.get(index1);
        arrayList.set(index1, arrayList.get(index2));
        arrayList.set(index2,temp);

    }

    BufferedWriter writer = new BufferedWriter(new FileWriter("out.dat"));
    void deleteHeap() throws IOException {//deleting nodes from heap
        String te = arrayList.get(0);
        //System.out.println(te + " " +hashMap.get(te));
        writer.write(te + " " +hashMap.get(te)+"\n");
        swap(0,arrayList.size()-1);
        arrayList.remove(arrayList.size()-1);
        heapifyDown(0);
        writer.flush();
    }

    void heapifyDown(int i){
        while (hasLeft(i)){
            int leftIn = 2*i+1;
            int smalChiInd = leftIn;
            if(hasRight(i)){
                int rightIn = 2*i+2;
                    if(arrayList.get(leftIn).compareTo(arrayList.get(rightIn))>0)
                        smalChiInd = rightIn;
            }
            if(arrayList.get(smalChiInd).compareTo(arrayList.get(i))>=0)
                break;
                swap(i,smalChiInd);
                i = smalChiInd;

        }
    }
    private int parent(int i) {
        if (i == 0)
            return 0;

        return (i - 1) / 2;
    }

    void heapifyUp(int i){
        if(i>0 && arrayList.get(parent(i)).compareTo(arrayList.get(i))>0){
            swap(i,parent(i));
            heapifyUp(parent(i));
        }

    }

    void insert(String name){
        if(!arrayList.contains(name)){
            arrayList.add(name);
            hashMap.put(name,1);//for the values i initialised all values as 1
            count++;//counting increase
        }
        else hashMap.put(name, hashMap.get(name)+1);// if key was ocurred value increase as 1

        heapifyUp(arrayList.size()-1);
    }

}


