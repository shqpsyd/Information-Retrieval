package IR.BRM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class InvertedIndex{
    ArrayList<Posting> table;
    public InvertedIndex(String invertedIndex){
        this.table = new ArrayList<>();
        int list = 0;
        try {
            String line;
            while((line = new BufferedReader(new FileReader(new File(invertedIndex))).readLine())!=null){
                LinkedList<Integer> templist = new LinkedList<>();
                String[] temp = line.trim().split(" ");
                for(int i = 1; i < temp.length;i++){
                    templist.add(Integer.parseInt(temp[i]));
                }
                String term = new String(temp[0]);
                this.table.add(new Posting(term,templist));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Posting getPosting(String term){
        for(int i = 0; i< table.size(); i++){
            if(table.get(i).term.equals(term)){
                return table.get(i);
            }
        }
        return null;
    }
}
