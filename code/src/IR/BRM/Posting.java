package IR.BRM;

import java.util.LinkedList;

public class Posting{
    String term;
    LinkedList<Integer> IndexList;
    public Posting(String term,LinkedList<Integer>  IndexList){
        this.term = term;
        this.IndexList = IndexList;
    }
}
