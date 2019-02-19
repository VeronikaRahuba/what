public class Main {
    public static void main(String[] args) {
        short n = 2;
        short m = 2;
        short a = 1;
        short b = 2;
        short C = 0;
        float S = 0;

        if (a <= C && C <= n || b <= 0 && 0 <= m) {
            System.out.println("Error");
//            System.exit(1);
        } else {
            for (short i = a; i <= n; i++) {
                for (short j = b; j <= m; j++) {
                    S += ((float) i / j) / (i - C);
                }
            }
            System.out.println("S= " + S);
        }
    }
}
