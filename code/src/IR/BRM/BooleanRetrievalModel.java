package IR.BRM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;






public class BooleanRetrievalModel {
    private ArrayList<String> Dictionary; //implement dictionary by ArrayList to lookup fast

    //Algorithm for the intersection of two postings lists p 1 and p 2 .
    public ArrayList<Integer> intersect(Posting p1, Posting p2){
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < p1.IndexList.size() && j < p2.IndexList.size()) {
            if (p1.IndexList.get(i) == p2.IndexList.get(j)) {
                result.add(i);
                i++;
                j++;
            } else if (p1.IndexList.get(i) < p2.IndexList.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
    public ArrayList<Integer> union(Posting p1, Posting p2){
        Set<Integer> set = new HashSet<>();
        for(int i:p1.IndexList){
            set.add(i);
        }
        for(int i:p2.IndexList){
            set.add(i);
        }
        return new ArrayList<>(set);
    }
    //in p1 not in p2
    public ArrayList<Integer> complement(Posting p1, Posting p2){
        ArrayList<Integer> result = new ArrayList<>(p1.IndexList);
        int i = 0;
        int j = 0;
        while(i < p1.IndexList.size()) {
            if(p2.IndexList.get(j)<p1.IndexList.get(i)){
                j++;
            }else if(p2.IndexList.get(j)>p1.IndexList.get(i)){
                result.add(p1.IndexList.get(i));
                i++;
            }else{
                j++;
                i++;
            }
        }
        return result;
    }
    public  ArrayList<Integer> query(String s){
        ArrayList<Integer> result = new ArrayList<>();
        return result;
    }
}
