import java.util.Scanner;

/******************************************************************************
 *  Compilation:  javac RandomWalk.java
 *  Execution:    java RandomWalk n
 *  Dependencies: StdDraw.java
 *
 *  % java RandomWalk 20
 *  total steps = 300
 *
 *  % java RandomWalk 50
 *  total steps = 2630
 *
 *  Simulates a 2D random walk and plots the trajectory.
 *
 *  Remarks: works best if n is a divisor of 600.
 *
 ******************************************************************************/

public class RandomWalk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;
        int r = 0;
        int i = 1;
        while (Math.abs(x) < n && Math.abs(y) < n) {


            for (int k = 0; k < i; k++) {
                if (r % 4 == 1) x++;
                else if (r % 4 == 2) y--;
                else if (r % 4 == 3) x--;
                else y++;

                StdDraw.setPenColor(StdDraw.PINK);
                StdDraw.filledSquare(x, y, 0.45);
            }

            r++;
            steps++;
            if (r % 2 == 0)
                i++;

            StdDraw.show();
            StdDraw.pause(120);
        }
        StdOut.println("Total steps = " + steps);
    }

}

