package labo2.T2E1;

import java.util.ArrayList;
import java.util.List;

public class tarea2ej2{
    public static void quickSort(List<Integer> items){
        if(items.size() > 1){
            List<Integer> smaller = new ArrayList<Integer>();
            List<Integer> same = new ArrayList<Integer>();
            List<Integer> larger = new ArrayList<Integer>();

            // Pivot    
            Integer chosenItem;
            
            Integer a = items.get(0);
            Integer b = items.get(items.size() / 2);
            Integer c = items.get(items.size()-1);

            if(a < b && b < c){
                chosenItem = b;
            }else if(a < c && c < b){
                chosenItem = c;
            }else if(b < a && a < c){
                chosenItem = a;
            }else if(b < c && c < a){
                chosenItem = c;
            }else if(c < a && a < b){
                chosenItem = a;
            }else if(c < b && b < a){
                chosenItem = b;
            }else{
                chosenItem = a;
            }
            
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