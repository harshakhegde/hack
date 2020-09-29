package de.harshaheg.hack;

import java.util.concurrent.Callable;

/*

 */
class CelebrityTake1 implements Callable<Long> {
    static int MATRIX[][] = {
            {0, 0, 1, 1, 0, 0, 0, 1, 1, 0},
            {0, 0, 1, 0, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
            {1, 0, 1, 0, 0, 1, 1, 1, 0, 1},
            {0, 0, 1, 0, 0, 0, 1, 1, 0, 1},
            {0, 0, 1, 0, 0, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 1, 0, 0},
    };


    // Driver Code
    public static void main(String[] args) throws Exception {
        CelebrityTake1 cel = new CelebrityTake1();
        System.out.println(String.format("Time taken %d ns", cel.call()));

    }

    private static boolean b(int i) {
        return i > 0 ? true : false;
    }

    @Override
    public Long call() throws Exception {

        long b = System.nanoTime();
        int n = MATRIX.length;
        boolean follows[] = new boolean[n];
        boolean followed[] = new boolean[n];


        for (int i = 0; i < n; i++) {
            follows[i] = false;
            for (int j = 0; j < n; j++) {
                follows[i] = follows[i] || b(MATRIX[i][j]);
            }
        }

        for (int j = 0; j < n; j++) {
            followed[j] = true;
            for (int i = 0; i < n; i++) {
                followed[j] = (i == j) ? followed[j] && true : followed[j] && b(MATRIX[i][j]);
            }
        }


        for (int i = 0; i < n; i++) {
            if (followed[i] == true && follows[i] == false) {
                System.out.println("Celebrity: " + i);
            }
        }
        long e = System.nanoTime();
        return e - b;
    }
}

