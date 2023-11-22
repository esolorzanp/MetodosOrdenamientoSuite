package control;

import model.Ordenamiento;

import java.util.ArrayList;
import java.util.List;

public class SortingCtrl {
    List<String> exprStringList;
    List<String> ordeStringList;
    List<Integer> exprIntegerList;
    List<Integer> ordeIntegerList;

    public SortingCtrl() {
        initLists();
    }

    public boolean add(String s) {
        return exprStringList.add(s);
    }

    public boolean add(int i) {
        return exprIntegerList.add(i);
    }

    public String getExprString() {
        String str = "";
        for (String e : exprStringList) {
            str += e + '\n';
        }
        return str;
    }

    public String getExprInteger() {
        String str = "";
        for (int e : exprIntegerList) {
            str += "" + e + '\n';
        }
        return str;
    }

    public String getSortString() {
        String str = "";
        for (String e : ordeStringList) {
            str += e + '\n';
        }
        return str;
    }

    public String getSortInteger() {
        String str = "";
        for (int e : ordeIntegerList) {
            str += "" + e + '\n';
        }
        return str;
    }

    public boolean hasItemsExpStringList() {
        return exprStringList.size() > 0;
    }

    public boolean hasItemsExpIntegerList() {
        return exprIntegerList.size() > 0;
    }

    public void initLists() {
        exprStringList = new ArrayList<>();
        ordeStringList = new ArrayList<>();
        exprIntegerList = new ArrayList<>();
        ordeIntegerList = new ArrayList<>();
    }

    public boolean sortBubbleAscendingListString() {
        Ordenamiento orden = new Ordenamiento();
        ordeStringList = new ArrayList<>();
        int t = exprStringList.size();
        String[] x = new String[t];
        for (int i = 0; i < t; i++) {
            x[i] = exprStringList.get(i);
        }
        x = orden.bubbleAscending(x);
        for (String e : x) {
            ordeStringList.add(e);
        }
        return true;
    }

    public boolean sortBubbleDescendingListString() {
        Ordenamiento orden = new Ordenamiento();
        ordeStringList = new ArrayList<>();
        int t = exprStringList.size();
        String[] x = new String[t];
        for (int i = 0; i < t; i++) {
            x[i] = exprStringList.get(i);
        }
        x = orden.bubbleDescending(x);
        for (String e : x) {
            ordeStringList.add(e);
        }
        return true;
    }

    public boolean sortBubbleAscendingListInteger() {
        Ordenamiento orden = new Ordenamiento();
        ordeIntegerList = new ArrayList<>();
        int t = exprIntegerList.size();
        int[] x = new int[t];
        for (int i = 0; i < t; i++) {
            x[i] = exprIntegerList.get(i);
        }
        x = orden.bubbleAscending(x);
        for (int e : x) {
            ordeIntegerList.add(e);
        }
        return true;
    }

    public boolean sortBubbleDescendingListInteger() {
        Ordenamiento orden = new Ordenamiento();
        ordeIntegerList = new ArrayList<>();
        int t = exprIntegerList.size();
        int[] x = new int[t];
        for (int i = 0; i < t; i++) {
            x[i] = exprIntegerList.get(i);
        }
        x = orden.bubbleDescending(x);
        for (int e : x) {
            ordeIntegerList.add(e);
        }
        return true;
    }

    /*
     *
     * ********************************************
     *
     */
    public boolean sortQuickSortAscendingListString() {
        Ordenamiento orden = new Ordenamiento();
        ordeStringList = new ArrayList<>();
        int t = exprStringList.size();
        String[] x = new String[t];
        for (int i = 0; i < t; i++) {
            x[i] = exprStringList.get(i);
        }
        x = orden.quickSortAscending(x);
        for (String e : x) {
            ordeStringList.add(e);
        }
        return true;
    }

    public boolean sortQuickDescendingListString() {
        Ordenamiento orden = new Ordenamiento();
        ordeStringList = new ArrayList<>();
        int t = exprStringList.size();
        String[] x = new String[t];
        for (int i = 0; i < t; i++) {
            x[i] = exprStringList.get(i);
        }
        x = orden.quickSortDescending(x);
        for (String e : x) {
            ordeStringList.add(e);
        }
        return true;
    }

    public boolean sortQuickAscendingListInteger() {
        Ordenamiento orden = new Ordenamiento();
        ordeIntegerList = new ArrayList<>();
        int t = exprIntegerList.size();
        int[] x = new int[t];
        for (int i = 0; i < t; i++) {
            x[i] = exprIntegerList.get(i);
        }
        x = orden.quickSortAscending(x);
        for (int e : x) {
            ordeIntegerList.add(e);
        }
        return true;
    }

    public boolean sortQuickDescendingListInteger() {
        Ordenamiento orden = new Ordenamiento();
        ordeIntegerList = new ArrayList<>();
        int t = exprIntegerList.size();
        int[] x = new int[t];
        for (int i = 0; i < t; i++) {
            x[i] = exprIntegerList.get(i);
        }
        x = orden.quickSortDescending(x);
        for (int e : x) {
            ordeIntegerList.add(e);
        }
        return true;
    }

    public void cargarLista(int ord) {
        Ordenamiento orden = new Ordenamiento();
        this.initLists();
        if (ord == 0) {
            for (String e : orden.getArray(1000, 25)) {
                exprStringList.add(e);
            }
        } else if (ord == 1) {
            for (int e : orden.getArray(1000)) {
                exprIntegerList.add(e);
            }
        }
    }
}
