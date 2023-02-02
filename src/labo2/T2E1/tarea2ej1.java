package labo2.T2E1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class tarea2ej1{
    public static <T extends Comparable<? super T>> int linearSearch(List<T> a, T x){
        for(int i = 0; i < a.size(); i++){
            if(a.get(i).compareTo(x) == 0){
                return i;
            }
        }

        return -1; // Not found
    }

    public static <T extends Comparable<? super T>> int binarySearch(List<T> a, T x){
        int low = 0;
        int high = a.size() - 1;
        int mid;

        while(low <= high){
            mid = (low + high) / 2;

            if( a.get(mid).compareTo(x) < 0){
                low = mid + 1;
            }else if(a.get(mid).compareTo(x) > 0){
                high = mid - 1;
            }else{
                return mid;
            }
        }

        return -1; // Not found
    }

    public static void main(String [] args){
        List<Integer> list = new ArrayList<Integer>();

        Random r = new Random();
        int low = 10000;
        int high = 1000000;

        long t1, t2, t3, t4;

        System.out.printf("         %-30s %-30s \n", "Busqueda binaria", "Busqueda lineal");
        System.out.printf("         %-8s %-10s %-10s %-10s %-8s %-10s %-10s %-10s \n", "T(n)", "T/N", "T/(NlogN)", "T/N2", "T(n)", "T/N", "T/(NlogN)", "T/N2");


        for(int N = 50000; N <= 1000000; N = N + 50000){
            // Clear list
            list.clear();
            
            // Fill list
            for(int j = 0; j < N; j++){
                list.add(r.nextInt(high + 1 - low) + low);
            }

            // Linear search
            t3 = System.currentTimeMillis();
            for(int l = 0; l < N; l++){
                linearSearch(list, r.nextInt(high + 1 - low) + low);
            }
            t4 = System.currentTimeMillis();

            // Binary search
            tarea2ej2.quickSort(list);
            t1 = System.currentTimeMillis();
            for(int l = 0; l < N; l++){
                binarySearch(list, r.nextInt(high + 1 - low) + low);
            }
            t2 = System.currentTimeMillis();

            //System.out.printf("N: %d %d %d \n", N, (t2-t1), (t4-t3));

            System.out.printf("%-9d", N);
            
            System.out.printf("%-8d %-10d %-10.10f %-10.10f %-8d %-10d %-10.10f %-10.10f \n", (t2-t1), (t2-t1)/N, (t2-t1)/(N*(Math.log(N)/Math.log(2))), (t2-t1)/(Math.pow(N, 2)), (t4-t3), (t4-t3)/N, (t4-t3)/(N*(Math.log(N)/Math.log(2))), (t4-t3)/(Math.pow(N, 2)));
        }
    }
}