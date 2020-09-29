package de.harshaheg.hack;

import java.util.concurrent.Callable;

class CelebrityTake2 implements Callable<Long> {
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
        CelebrityTake2 cel = new CelebrityTake2();
        cel.findCeleb();
    }

    void findCeleb() {
        int n = MATRIX.length;
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == celebrity) continue;

            if (!(knows(i, celebrity) && !knows(celebrity, i))) {
                celebrity = -1;
            }
        }

        if (celebrity == -1) {
            System.out.println("No Celebrity");
        } else
            System.out.println("Celebrity ID " +
                    celebrity);


    }

    @Override
    public Long call() throws Exception {

        long b = System.nanoTime();


        long e = System.nanoTime();
        return e - b;
    }

    static boolean knows(int a, int b) {
        boolean res = (MATRIX[a][b] == 1) ?
                true :
                false;
        return res;
    }
}

