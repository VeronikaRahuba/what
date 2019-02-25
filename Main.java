import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte B[][];
        byte C[][];
        byte s;
        byte c;
        byte a;
        byte b;
        byte i;
        byte j;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Количество строк");
        s = scanner.nextByte();
        System.out.println("Количество столбиков");
        c = scanner.nextByte();
        B = new byte[s][c];
        C = new byte[c][s];
        System.out.println("Ввод поэлементно");
        for (i = 0; i < s; i++) {
            for (j = 0; j < c; j++) {
                B[i][j] = scanner.nextByte();
            }
        }
        System.out.println("Ваша матрица В:");
        for (i = 0; i < s; i++) {
            for (j = 0; j < c; j++) {
                System.out.print("  " + B[i][j]);
            }
            System.out.println();
        }

        for (i = 0; i < s; i++) {
            for (j = 0; j < c; j++) {
                C[j][i] = B[i][j];
            }

        }

        System.out.println("Транмпонированная матрица С:");
        for (j = 0; j < c; j++) {
            for (i = 0; i < s; i++) {
                System.out.print("  " + C[j][i]);
            }
            System.out.println();
        }

        b = 0;
        for (i = 0; i < s; i++) {
            a = C[0][i];
            for (j = 0; j < c-1; j++)
            {
                if (a <  C[j+1][i])
                {
                    a=C[j+1][i];
                }
            }
            b += a;
        }
        System.out.print("Сумма макс.элем в столбиках = " + b);
    }
}
