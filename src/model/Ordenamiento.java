package model;

public class Ordenamiento {
    /**
     * Ordena un int[] ascendentemente.
     *
     * @param x - int[]
     * @return int[] x
     */
    public int[] burbujaAscendente(int[] x) {
        int s = x.length;
        for (int i = 0; i < s; i++) {
            int t = x[i];
            for (int j = i + 1; j < s; j++) {
                if (t > x[j]) {
                    x[i] = x[j];
                    x[j] = t;
                    t = x[i];
                }
            }
        }
        return x;
    }

    /**
     * Ordena un int[] descendentemente.
     *
     * @param x - int[]
     * @return int[]
     */
    public int[] burbujaDescendente(int[] x) {
        int s = x.length;
        for (int i = 0; i < s; i++) {
            int t = x[i];
            for (int j = i + 1; j < s; j++) {
                if (t < x[j]) {
                    x[i] = x[j];
                    x[j] = t;
                    t = x[i];
                }
            }
        }
        return x;
    }

    /**
     * Ordena un String[] ascendentemente.
     *
     * @param x - String[]
     * @return String[]
     */
    public String[] burbujaAscendente(String[] x) {
        int s = x.length;
        for (int i = 0; i < s; i++) {
            String t = x[i];
            for (int j = i + 1; j < s; j++) {
                if (t.compareTo(x[j]) > 0) {
                    x[i] = x[j];
                    x[j] = t;
                    t = x[i];
                }
            }
        }
        return x;
    }

    /**
     * Ordena un String[] descendentemente.
     *
     * @param x - String[]
     * @return String[]
     */
    public String[] burbujaDescendente(String[] x) {
        int s = x.length;
        for (int i = 0; i < s; i++) {
            String t = x[i];
            for (int j = i + 1; j < s; j++) {
                if (t.compareTo(x[j]) < 0) {
                    x[i] = x[j];
                    x[j] = t;
                    t = x[i];
                }
            }
        }
        return x;
    }

    /*
     * Métodos adicionales
     */
    public int calcAleatorio(int min, int max) {
        return (int) ((Math.random() * (max - min + 1)) + min);
    }

    public void showArray(int[] n) {
        int s = n.length;
        for (int i = 0; i < s; i++) {
            System.out.print(((i == 0) ? "{" : "")
                    + n[i]
                    + ((i < s - 1) ? "," : "")
                    + ((i == s - 1) ? "}" : "")
            );
        }
    }

    public void showArray(String[] str) {
        int s = str.length;
        for (int i = 0; i < s; i++) {
            System.out.print(
                    ((i == 0) ? "{" : "")
                            + '"'
                            + str[i]
                            + '"'
                            + ((i < s - 1) ? "," : "")
                            + ((i == s - 1) ? "}" : "")
            );
        }
    }

    public int[] getArray(int s) {
        int[] n = new int[s];
        for (int i = 0; i < s; i++) {
            n[i] = calcAleatorio(1, 9);
        }
        return n;
    }

    public String[] getArray(int s, int c) {
        String[] str = new String[s];
        String abc = "abcdfghijklmnopqrstuvwxyz";
        int sAbc = abc.length();
        for (int i = 0; i < s; i++) {
            str[i] = "";
            for (int j = 0; j < c; j++) {
                str[i] += abc.charAt(calcAleatorio(0, sAbc - 1));
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Ordenamiento ordenamiento = new Ordenamiento();
        int[] x = ordenamiento.getArray(10);
        System.out.println("Array int original:");
        ordenamiento.showArray(x);
        x = ordenamiento.burbujaAscendente(x);
        System.out.println('\n' + "Array int ordenado ascendentemente:");
        ordenamiento.showArray(x);
        x = ordenamiento.burbujaDescendente(x);
        System.out.println('\n' + "Array int ordenado descendentemente:");
        ordenamiento.showArray(x);

        String[] s = ordenamiento.getArray(20, 3);
        System.out.println('\n' + "Array string original:");
        ordenamiento.showArray(s);
        s = ordenamiento.burbujaAscendente(s);
        System.out.println('\n' + "Array string ordenado ascendentemente:");
        ordenamiento.showArray(s);
        s = ordenamiento.burbujaDescendente(s);
        System.out.println('\n' + "Array string ordenado descendentemente:");
        ordenamiento.showArray(s);
    }
}
