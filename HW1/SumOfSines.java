import java.util.Scanner;

public class SumOfSines {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double t = sc.nextDouble();
        System.out.println(Math.sin(2*t) + Math.sin(3*t));
    }
}
