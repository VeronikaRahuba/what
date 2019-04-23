import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        StringBuilder Str = new StringBuilder("Мама и папа заказали арбуз. И дети рады!");
        String a = Str.toString();
        Text text;
        text = new Text(a);
        int counts = 0, count = 0;
        Word qwe = new Word("");
        int max, z, q = 0;

        for (int i = 0; i < text.sen.length; i++) {
            for (int j = 0; j < text.sen[i].sl.length; j++) {
                counts += 1;
            }
        }
        int sub[] = new int[counts];
        for (int i = 0; i < text.sen.length; i++) {
            for (int j = 0; j < text.sen[i].sl.length; j++) {
                for (int k = 0; k < text.sen[i].sl[j].buk.length; k++) {
                    if (text.sen[i].sl[j].buk[k].toString().equals("а")) {
                        sub[count] += 1;
                    }
                }
                System.out.println(sub[count]);
                count++;
            }
        }
        for (int i = 0; i < sub.length; i++) {
            max = sub[i];
            for (int j = i; j < sub.length; j++) {
                if (max < sub[j]) {
                    max = sub[j];
                    q = j;
                }
            }
            z = sub[i];
            sub[i] = sub[q];
            sub[q] = z;
            qwe = text.sen[i].sl[q];
            text.sen[i].sl[q] = text.sen[i].sl[i];
            text.sen[i].sl[i] = qwe;
        }
        for (int i = 0; i < text.sen.length; i++) {
            for (int j = 0; j < text.sen[i].sl.length; j++) {
                System.out.println(text.sen[i].sl[j].toString());
            }
        }
    }
}
    class Sym {
        String s;

        Sym(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return (s);
        }
    }

    class Word {
        Letter[] buk;

        Word(String toBuk) {

            String[] split = toBuk.split("");
            buk = new Letter[split.length];
            for (int i = 0; i < toBuk.length(); i++) {
                buk[i] = new Letter(split[i]);
            }
        }

        @Override
        public String toString() {
            String a = "";
            {
                for (int i = 0; i < buk.length; i++) {
                    a += buk[i].toString();
                }
            }
            return (a);
        }
    }

    class Znak extends Sym {
        String s;

        Znak(String s) {
            super(s);
        }

        public String toString() {
            return (s);
        }
    }

    class Letter {
        String b;

        Letter(String b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return (b);
        }
    }

    class Sentence {
        Sym[] sym;
        Znak[] zn;
        Word[] sl;
        String sub;

        public Sentence(String toSym) {
            String[] split = toSym.split(" ");
            sl = new Word[split.length];
            zn = new Znak[split.length];
            sym = new Sym[0];
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains(".")) {
                    sub = split[i].substring(split[i].length() - 1);
                    split[i].replace(".", "");
                    zn[i] = new Znak(".");
                    sl[i] = new Word(split[i]);
                    sym = Arrays.copyOf(sym, sym.length + 3);
                    sym[i] = new Sym(split[i]);
                    sym[i + 1] = new Sym(sub);
                    sym[i + 2] = new Sym(" ");
                } else if (split[i].contains(",")) {
                    sub = split[i].substring(split[i].length() - 1);
                    split[i].replace(",", "");
                    zn[i] = new Znak(",");
                    sl[i] = new Word(split[i]);
                    sym = Arrays.copyOf(sym, sym.length + 3);
                    sym[i] = new Sym(split[i]);
                    sym[i + 1] = new Sym(sub);
                    sym[i + 2] = new Sym(" ");
                } else i 
f (split[i].contains("!")) {
                    sub = split[i].substring(split[i].length() - 1);
                    split[i].replace("!", "");
                    zn[i] = new Znak("!");
                    sl[i] = new Word(split[i]);
                    sym = Arrays.copyOf(sym, sym.length + 3);
                    sym[i] = new Sym(split[i]);
                    sym[i + 1] = new Sym(sub);
                    sym[i + 2] = new Sym(" ");
                } else if (split[i].contains("?")) {
                    sub = split[i].substring(split[i].length() - 1);
                    split[i].replace("?", "");
                    zn[i] = new Znak("?");
                    sym = Arrays.copyOf(sym, sym.length + 3);
                    sl[i] = new Word(split[i]);
                    sym[i] = new Sym(split[i]);
                    sym[i + 1] = new Sym(sub);
                    sym[i + 2] = new Sym(" ");
                } else {
                    zn[i] = new Znak("");
                    sl[i] = new Word(split[i]);
                    sym = Arrays.copyOf(sym, sym.length + 2);
                    sym[i] = new Sym(split[i]);
                    sym[i + 1] = new Sym(" ");
                }
            }
        }

        @Override
        public String toString() {
            String a = "";
            {
                for (int i = 0; i < sl.length; i++) {
                    a += (sym[i].toString() + " ");

                }
            }
            return (a);
        }
    }


class Text {
    Sentence[] sen;

    public Text(String toSen) {
        String[] split = toSen.split("(?<=[?!.]) ");
        sen = new Sentence[split.length];
        for (int i = 0; i < split.length; i++) {
            sen[i] = new Sentence(split[i]);
        }
    }
    @Override
    public String toString() {
        String a = "";
        {
            for (int i = 0; i < sen.length; i++) {
                a += sen[i].toString();
            }
        }
        return a;
    }
}
