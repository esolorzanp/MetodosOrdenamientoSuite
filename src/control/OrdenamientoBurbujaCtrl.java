package control;

import model.Ordenamiento;

import java.util.ArrayList;
import java.util.List;

public class OrdenamientoBurbujaCtrl {
    List<String> exprStringList;
    List<String> ordeStringList;
    List<Integer> exprIntegerList;
    List<Integer> ordeIntegerList;

    public OrdenamientoBurbujaCtrl() {
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

    public String getOrdeString() {
        String str = "";
        for (String e : ordeStringList) {
            str += e + '\n';
        }
        return str;
    }

    public String getOrdeInteger() {
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

    public boolean ordenarAscendenteListaString() {
        Ordenamiento orden = new Ordenamiento();
        ordeStringList = new ArrayList<>();
        int t = exprStringList.size();
        String[] x = new String[t];
        for (int i = 0; i < t; i++) {
            x[i] = exprStringList.get(i);
        }
        x = orden.burbujaAscendente(x);
        for (String e : x) {
            ordeStringList.add(e);
        }
        return true;
    }

    public boolean ordenarDescendenteListaString() {
        Ordenamiento orden = new Ordenamiento();
        ordeStringList = new ArrayList<>();
        int t = exprStringList.size();
        String[] x = new String[t];
        for (int i = 0; i < t; i++) {
            x[i] = exprStringList.get(i);
        }
        x = orden.burbujaDescendente(x);
        for (String e : x) {
            ordeStringList.add(e);
        }
        return true;
    }

    public boolean ordenarAscendenteListaInteger() {
        Ordenamiento orden = new Ordenamiento();
        ordeIntegerList = new ArrayList<>();
        int t = exprIntegerList.size();
        int[] x = new int[t];
        for (int i = 0; i < t; i++) {
            x[i] = exprIntegerList.get(i);
        }
        x = orden.burbujaAscendente(x);
        for (int e : x) {
            ordeIntegerList.add(e);
        }
        return true;
    }

    public boolean ordenarDescendenteListaInteger() {
        Ordenamiento orden = new Ordenamiento();
        ordeIntegerList = new ArrayList<>();
        int t = exprIntegerList.size();
        int[] x = new int[t];
        for (int i = 0; i < t; i++) {
            x[i] = exprIntegerList.get(i);
        }
        x = orden.burbujaDescendente(x);
        for (int e : x) {
            ordeIntegerList.add(e);
        }
        return true;
    }

}
