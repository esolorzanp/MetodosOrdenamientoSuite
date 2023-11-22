package model;

import java.util.ArrayList;
import java.util.List;

public class Ordenamiento {
    /**
     * Ordena un int[] ascendentemente.
     *
     * @param x - int[]
     * @return int[] x
     */
    public int[] bubbleAscending(int[] x) {
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
    public int[] bubbleDescending(int[] x) {
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
    public String[] bubbleAscending(String[] x) {
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
    public String[] bubbleDescending(String[] x) {
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

    /**
     * Return an array of Integer sorted by quick sort method ascending.
     *
     * @param x array Integer
     * @return array sorted
     */
    public int[] quickSortAscending(int[] x) {
        List<Integer> izqList = new ArrayList<>();
        List<Integer> derList = new ArrayList<>();
        List<Integer> ePivotList = new ArrayList<>();
        int t = x.length;
        int ePivot = -1;
        for (int i = 0; i < t; i++) {
            if (ePivot == -1) {
                ePivot = x[i];
            }
            if (x[i] < ePivot) {
                izqList.add(x[i]);
            } else if (x[i] > ePivot) {
                derList.add(x[i]);
            } else {
                ePivotList.add(x[i]);
            }
        }
        if (izqList.size() > 1) {
            int[] a = convertListIntToArray(izqList);
            a = this.quickSortAscending(a);
            izqList = convertArrayToListInt(a);
        }
        if (derList.size() > 1) {
            int[] a = convertListIntToArray(derList);
            a = this.quickSortAscending(a);
            derList = this.convertArrayToListInt(a);
        }
        return this.joinDerPivotIzqListInt(izqList, derList, ePivotList);
    }

    /**
     * Return an array of integer sorted descending by quick sort method
     *
     * @param x array of integer
     * @return array sorted
     */
    public int[] quickSortDescending(int[] x) {
        List<Integer> izqList = new ArrayList<>();
        List<Integer> derList = new ArrayList<>();
        List<Integer> ePivotList = new ArrayList<>();
        int t = x.length;
        int ePivot = -1;
        for (int i = 0; i < t; i++) {
            if (ePivot == -1) {
                ePivot = x[i];
            }
            if (x[i] > ePivot) {
                izqList.add(x[i]);
            } else if (x[i] < ePivot) {
                derList.add(x[i]);
            } else {
                ePivotList.add(x[i]);
            }
        }
        if (izqList.size() > 1) {
            int[] a = convertListIntToArray(izqList);
            a = this.quickSortDescending(a);
            izqList = convertArrayToListInt(a);
        }
        if (derList.size() > 1) {
            int[] a = convertListIntToArray(derList);
            a = this.quickSortDescending(a);
            derList = this.convertArrayToListInt(a);
        }
        return this.joinDerPivotIzqListInt(izqList, derList, ePivotList);
    }

    /**
     * Return an array of String ordered ascending by quick sort method
     * @param x array of String
     * @return array sorted ascending
     */
    public String[] quickSortAscending(String[] x) {
        List<String> izqList = new ArrayList<>();
        List<String> derList = new ArrayList<>();
        List<String> ePivotList = new ArrayList<>();
        int t = x.length;
        String ePivot = "";
        for (int i = 0; i < t; i++) {
            if (ePivot == "") {
                ePivot = x[i];
            }
            if (x[i].compareTo(ePivot) < 0) {
                izqList.add(x[i]);
            } else if (x[i].compareTo(ePivot) > 0) {
                derList.add(x[i]);
            } else {
                ePivotList.add(x[i]);
            }
        }
        if (izqList.size() > 1) {
            String[] a = convertListStringToArray(izqList);
            a = this.quickSortAscending(a);
            izqList = convertArrayToListString(a);
        }
        if (derList.size() > 1) {
            String[] a = convertListStringToArray(derList);
            a = this.quickSortAscending(a);
            derList = this.convertArrayToListString(a);
        }
        return this.joinDerPivotIzqListString(izqList, derList, ePivotList);
    }

    /**
     * Return an array of String ordered descending by quick sort method
     * @param x array of String
     * @return array ordered
     */
    public String[] quickSortDescending(String[] x) {
        List<String> izqList = new ArrayList<>();
        List<String> derList = new ArrayList<>();
        List<String> ePivotList = new ArrayList<>();
        int t = x.length;
        String ePivot = "";
        for (int i = 0; i < t; i++) {
            if (ePivot == "") {
                ePivot = x[i];
            }
            if (x[i].compareTo(ePivot) > 0) {
                izqList.add(x[i]);
            } else if (x[i].compareTo(ePivot) < 0) {
                derList.add(x[i]);
            } else {
                ePivotList.add(x[i]);
            }
        }
        if (izqList.size() > 1) {
            String[] a = convertListStringToArray(izqList);
            a = this.quickSortDescending(a);
            izqList = convertArrayToListString(a);
        }
        if (derList.size() > 1) {
            String[] a = convertListStringToArray(derList);
            a = this.quickSortDescending(a);
            derList = this.convertArrayToListString(a);
        }
        return this.joinDerPivotIzqListString(izqList, derList, ePivotList);
    }

    private int[] joinDerPivotIzqListInt(List<Integer> m, List<Integer> n, List<Integer> p) {
        List<Integer> x = new ArrayList<>(m);
        for (int e : p) {
            x.add(e);
        }
        for (int e : n) {
            x.add(e);
        }
        return this.convertListIntToArray(x);
    }

    private String[] joinDerPivotIzqListString(List<String> m, List<String> n, List<String> p) {
        List<String> x = new ArrayList<>(m);
        for (String e : p) {
            x.add(e);
        }
        for (String e : n) {
            x.add(e);
        }
        return this.convertListStringToArray(x);
    }

    private List<Integer> convertArrayToListInt(int[] x) {
        List<Integer> a = new ArrayList<>();
        for (int e : x) {
            a.add(e);
        }
        return a;
    }

    private int[] convertListIntToArray(List<Integer> x) {
        int[] a = new int[x.size()];
        int t = x.size();
        for (int i = 0; i < t; i++) {
            a[i] = x.get(i);
        }
        return a;
    }

    private List<String> convertArrayToListString(String[] x) {
        List<String> a = new ArrayList<>();
        for (String e : x) {
            a.add(e);
        }
        return a;
    }

    private String[] convertListStringToArray(List<String> x) {
        String[] a = new String[x.size()];
        int t = x.size();
        for (int i = 0; i < t; i++) {
            a[i] = x.get(i);
        }
        return a;
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
            n[i] = (int) Math.pow((double) calcAleatorio(1, 9),(double) calcAleatorio(1,9));
        }
        return n;
    }

    public String[] getArray(int s, int c) {
        String[] str = new String[s];
//        String abc = "abcdfghijklmnopqrstuvwxyz";
        String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ abcdefghijklmnñopqrstuvwxyz";
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
        /*
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
        */

        Ordenamiento ordenamiento = new Ordenamiento();
        int e = ordenamiento.calcAleatorio(2, 9);
        int[] x = ordenamiento.getArray(e);
        int[] t = x;
        ordenamiento.showArray(x);
        x = ordenamiento.quickSortAscending(x);
        System.out.println('\n' + "Ordenamiento int ascendente");
        ordenamiento.showArray(x);
        System.out.println('\n' + "Ordenamiento int descendente");
        x = ordenamiento.quickSortDescending(t);
        ordenamiento.showArray(x);

        String[] s = ordenamiento.getArray(5, 3);
        System.out.println('\n' + "Array string original:");
        ordenamiento.showArray(s);
        s = ordenamiento.quickSortAscending(s);
        System.out.println('\n' + "Array string ordenado ascendentemente:");
        ordenamiento.showArray(s);
        s = ordenamiento.quickSortDescending(s);
        System.out.println('\n' + "Array string ordenado descendentemente:");
        ordenamiento.showArray(s);
    }
}
