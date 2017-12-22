package IR;

import java.util.ArrayList;
import java.util.Iterator;


import IR.BRM.BooleanRetrievalModel;
import IR.BRM.Dictionary;
import IR.BRM.InvertedIndex;
import IR.BRM.Posting;

public class Main {


    public static void main(String[] args) {
	// write your code here

    }

    public void testBooleanRetrievalModel(){
        ArrayList<Integer> intersectResult;
        String term1 = "";
        String term2 = "";
        Dictionary dictionary = new Dictionary("dictionary.txt");
        if(dictionary.get(term1)==0||dictionary.get(term2)==0){
            intersectResult = new ArrayList<>();
            return;
        }
        InvertedIndex invertedIndex = new InvertedIndex("InvertedIndex.txt");
        Posting p1 = invertedIndex.getPosting(term1);
        Posting p2 = invertedIndex.getPosting(term2);
        intersectResult = new BooleanRetrievalModel().intersect(p1, p2);
        for (Iterator<Integer> it = intersectResult.iterator(); it.hasNext(); ) {
            int i = it.next();
            System.out.println(i);
        }
    }


}
