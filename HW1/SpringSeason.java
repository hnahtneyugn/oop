import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();
        boolean date = true;
        if ((m == 3 && 20 <= d && d <= 31)|| (m == 4 && 1 <= d && d <= 30) || (m == 5 && 1 <= d && d <= 31) || (m == 6 && 1 <= d && d <= 20)) {
            System.out.println(date);
        } else {
            System.out.println(!date);
        }
    }
}
