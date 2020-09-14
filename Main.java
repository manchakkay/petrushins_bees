package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        // Переменные для проверки на выход за пределы Double
        double test_max;
        boolean max;
        // Цикл перебора разных данных
        for (int i = 0; i < T; i++) {
            max = false;
            double n_prev = sc.nextDouble();
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double n;

            int j = 1;
            n = (a * n_prev) - (b * (n_prev*n_prev));
            // Цикл для приведения к точным значениям
            while ((abs((n-n_prev)) > 0.000000000000001) && (j < 10000) && (n > 0)){
                n_prev = n;
                test_max = b * (n_prev * n_prev);

                n = (a * n_prev) - (b * (n_prev*n_prev));
                j++;

                if(Double.isNaN(test_max)){
                    max = true;
                    break;

                }
            }
            // Вывод значений
            System.out.print( i + ": ");
            if (((Double.isInfinite(n)) && (n > 0)) || (max)) {
                System.out.println(-1);
            } else if ((n < 0) || (Double.isNaN(n))) {
                System.out.println(0);
            } else {
                if (abs(Math.round(n)-n) < 0.01 ){
                    System.out.println(Math.round(n));
                } else {
                    System.out.println(n);
                }

            }
        }
    }

    private static double abs(double a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}
