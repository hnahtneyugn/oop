public class SumOfTwoDice {
    public static void main(String[] args) {
        int sides = 6;
        int x = 1 + (int)(Math.random() * sides);
        int y = 1 + (int)(Math.random() * sides);
        System.out.println(x+y);
    }
}
