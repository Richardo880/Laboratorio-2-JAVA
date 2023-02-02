package labo2.T2E3;

public class tarea2ej1{
    public static int fib1(int n){
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        return fib1(n-1) + fib1(n-2);
    }

    public static int fib2(int n){
        if(n == 0){
            return 0;
        }

        int [] f = new int[n+1];

        f[0] = 0;
        f[1] = 1;

        for(int i = 2; i <= n; i++){
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }

    public static void main(String [] args){
        long t1, t2, t3, t4;

        System.out.printf("%-5s %-35s %-35s \n", "N", "Tiempo de fib1 en microsegundos", "Tiempo de fib2 en microsegundos");
        for(int i = 1; i <= 50; i++){
            t1 = System.nanoTime();
            fib1(i);
            t2 = System.nanoTime();

            t3 = System.nanoTime();
            fib2(i);
            t4 = System.nanoTime();

            System.out.printf("%-5d %-35d %-35d \n", i, (t2-t1)/1000, (t4-t3)/1000);
        }
    }
}
