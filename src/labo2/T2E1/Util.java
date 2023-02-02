package labo2.T2E1;

import java.util.ArrayList;
import java.util.List;

public class Util{
    public static void quickSort(List<Integer> items){
        if(items.size() > 1){
            List<Integer> smaller = new ArrayList<Integer>();
            List<Integer> same = new ArrayList<Integer>();
            List<Integer> larger = new ArrayList<Integer>();

            // Pivot    
            Integer chosenItem = items.get(items.size() / 2);
            
            for(Integer i: items){
                if(i < chosenItem){
                    smaller.add(i);
                }else if(i > chosenItem){
                    larger.add(i);
                }else{
                    same.add(i);
                }
            }

            // Recursive calls
            quickSort(smaller);
            quickSort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        } 
    }
}