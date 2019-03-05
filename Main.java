public class Main {
    public static void main(String args[]) {
        StringBuilder Str = new StringBuilder("Мама и папа заказали арбуз");
        System.out.println(Str);
        String a = Str.toString();
        String[] ar = a.split(" ");
        int sub[] = new int[ar.length];
        int max,z,q = 0;
        String qwe;

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length(); j++) {
                if (ar[i].charAt(j) == 'а') {
                    sub[i] += 1;
                }
            }
        }

        for (int i = 0; i < sub.length; i++) {
            max = sub[i];
            for (int j = 0 + i; j < sub.length; j++) {
                if (max < sub[j]) {
                    max = sub[j];
                    q = j;
                }
            }
            z = sub[i];
            sub[i] = max;
            sub[q] = z;
            qwe = ar[i];
            ar[i] = ar[q];
            ar[q] = qwe;
        }

        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }
}
