package labo2.T2E2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class tarea2ej1{
    public static <T extends Comparable<? super T>> void quickSort(List<T> items){
        if(items.size() > 1){
            List<T> smaller = new ArrayList<T>();
            List<T> same = new ArrayList<T>();
            List<T> larger = new ArrayList<T>();

            // Pivot    
            T chosenItem = items.get(items.size() / 2);
            
            for(T i: items){
                if(i.compareTo(chosenItem) < 0){
                    smaller.add(i);
                }else if(i.compareTo(chosenItem) > 0){
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

    public static <T extends Comparable<? super T>> void eliminarDuplicados(List<T> lista){// Algoritmo que elimina los elementos repetidos
        // PRIMERA PARTE: ORDENACION
        // Primero se ordena la lista con el metodo quicksort que sabemos que en promedio tiene un tiempo de 
        // ejecucion O(NlogN)
        quickSort(lista);

        System.out.println("Lista ordenada: ");
        System.out.println(lista);

        // SEGUNDA PARTE: ELIMINACION
        for(int i = 1; i < lista.size(); i++){      // 1 + N por que va desde 1 hasta N que son (N-1) + la comparacion de salida mas la asignacion de i
            if(lista.get(i) == lista.get(i-1)){     // (N-1) x (4)
                lista.remove(i-1);                  // (N-1) x (2) En el peor caso todos los elementos son duplicados asi que esta sentencia se ejecutara N-1 veces
                i--;                                // (N-1) x (2)
            }
        }

        // Sumando todos los tiempos tenemos 9N - 7
        // El termino dominante aqui es 9N
        // Por lo que su cota superior es O(N)

        // Entonces hasta ahora tenemos 2 cotas de 2 partes distintas del algoritmo
        // PRIMERA PARTE: ORDENACION        O(NlogN)
        // SEGUNDA PARTE: ELIMINACION       O(N)
        // La cota mayor corresponde a O(NlogN) por lo tanto el tiempo del algoritmo sera O(NlogN)
    }

    public static void main(String [] agrs){
        int low = 1;
        int high = 20;
        int size = 30;

        Random r = new Random();

        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < size; i++){
            list.add(r.nextInt(high + 1 - low) + low);
        }

        System.out.println("Lista inicial: ");
        System.out.println(list);

        eliminarDuplicados(list);

        System.out.println("Lista sin elementos repetidos: ");
        System.out.println(list);


    }
}
