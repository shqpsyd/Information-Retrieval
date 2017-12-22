package IR.BRM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary{
    class Node{
        private String term;
        private int frequency;
        public Node(String term, int frequency){
            this.term = term;
            this.frequency = frequency;
        }
    }
    ArrayList<Node> dictionary;
    //dict is a dictionary text file provided by user in which terms are separated by '\n'
    public Dictionary(String dict){
        this.dictionary = new ArrayList<>();
        try{
            String line;
            while((line = new BufferedReader(new FileReader(new File(dict))).readLine())!=null){
                String[] unit = line.trim().split(" ");
                dictionary.add(new Node(unit[0],Integer.parseInt(unit[1])));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public Dictionary(ArrayList<Node> dictionary) {
        this.dictionary = dictionary;
    }
    public int get(String term){
        for(Node n: dictionary){
            if(n.term.equals(term)){
                return n.frequency;
            }
        }
        return 0;

    }
}
