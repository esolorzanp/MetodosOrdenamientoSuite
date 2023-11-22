package view;

import control.SortingCtrl;

import javax.swing.*;
import java.awt.event.*;

public class OrdenamientoGUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton agregarButton;
    private JButton limpiarListasButton;
    private JButton ordenarButton;
    private JButton cargarListaButton;
    private JTextField expTextField;
    private JRadioButton alfabeticaRadioButton;
    private JRadioButton bubbleRadioButton;
    private JRadioButton numericaRadioButton;
    private JRadioButton quickSorteRadioButton;
    private JRadioButton ascendenteRadioButton;
    private JRadioButton descendenteRadioButton;
    private JTextArea expTextArea;
    private JTextArea ordeTextArea;
    private ButtonGroup expresionBtng;
    private ButtonGroup metodoBtng;
    private ButtonGroup ordenarBtng;
    private SortingCtrl sortingCtrl;

    public OrdenamientoGUI() {
        sortingCtrl = new SortingCtrl();

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Sorting methods: Bubble and QuickSort");

        expresionBtng = new ButtonGroup();
        alfabeticaRadioButton.setSelected(true);
        bubbleRadioButton.setSelected(true);
        ascendenteRadioButton.setSelected(true);
        expresionBtng.add(alfabeticaRadioButton);
        expresionBtng.add(numericaRadioButton);
        metodoBtng = new ButtonGroup();
        metodoBtng.add(bubbleRadioButton);
        metodoBtng.add(quickSorteRadioButton);
        ordenarBtng = new ButtonGroup();
        ordenarBtng.add(ascendenteRadioButton);
        ordenarBtng.add(descendenteRadioButton);
        expTextArea.setEditable(false);
        ordeTextArea.setEditable(false);

        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
        agregarButton.addActionListener(e -> onAgregar());
        limpiarListasButton.addActionListener(e -> onLimpiarListas());
        ordenarButton.addActionListener(e -> onOrdenar());
        cargarListaButton.addActionListener(e -> onCargarLista());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        setSize(800, 600);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    private void onAgregar() {
        String exp = expTextField.getText();
        if (exp.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una expresión para agregarla a la lista", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (alfabeticaRadioButton.isSelected()) {
                if (!esExpresionString(exp)) {
                    JOptionPane.showMessageDialog(null, "La expresión alfabética no corresponde a una palabra u oración", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (!sortingCtrl.add(exp)) {
                        JOptionPane.showMessageDialog(null, "La expresión alfabética no fue agregada", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        fillExpTextArea();
                        expTextField.setText("");
                        JOptionPane.showMessageDialog(null, "Expresión agregada con éxito", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else if (numericaRadioButton.isSelected()) {
                try {
                    int expNum = Integer.parseInt(exp);
                    if (!sortingCtrl.add(expNum)) {
                        JOptionPane.showMessageDialog(null, "La expresión alfabética no fue agregada", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        fillExpTextArea();
                        expTextField.setText("");
                        JOptionPane.showMessageDialog(null, "Expresión agregada con éxito", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "La expresión numperica no corresponde a un número", "Error", JOptionPane.ERROR_MESSAGE);
                } finally {

                }
            }
        }
    }

    private void onLimpiarListas() {
        expTextField.setText("");
        expTextArea.setText("");
        ordeTextArea.setText("");
        sortingCtrl.initLists();
    }

    private void onOrdenar() {
        if (alfabeticaRadioButton.isSelected()) {
            if (!sortingCtrl.hasItemsExpStringList()) {
                JOptionPane.showMessageDialog(null, "La lista de expresiones está vacía, debe ingresarle expresiones alfbéticas o numércias", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
//                long startTime = System.currentTimeMillis();
                long startTime = System.nanoTime();
                if (bubbleRadioButton.isSelected()) {
                    if (ascendenteRadioButton.isSelected()) {
                        sortingCtrl.sortBubbleAscendingListString();
                    } else if (descendenteRadioButton.isSelected()) {
                        sortingCtrl.sortBubbleDescendingListString();
                    }
                } else if (quickSorteRadioButton.isSelected()) {
                    if (ascendenteRadioButton.isSelected()) {
                        sortingCtrl.sortQuickSortAscendingListString();
                    } else if (descendenteRadioButton.isSelected()) {
                        sortingCtrl.sortQuickDescendingListString();
                    }
                }
//                long endTime = System.currentTimeMillis();
                long endTime = System.nanoTime();
                fillOrdTextArea(startTime, endTime);
            }
        } else if (numericaRadioButton.isSelected()) {
            if (!sortingCtrl.hasItemsExpIntegerList()) {
                JOptionPane.showMessageDialog(null, "La lista de expresiones está vacía, debe ingresarle expresiones alfbéticas o numércias", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
//                long startTime = System.currentTimeMillis();
                long startTime = System.nanoTime();
                if (bubbleRadioButton.isSelected()) {
                    if (ascendenteRadioButton.isSelected()) {
                        sortingCtrl.sortBubbleAscendingListInteger();
                    } else if (descendenteRadioButton.isSelected()) {
                        sortingCtrl.sortBubbleDescendingListInteger();
                    }
                } else if (quickSorteRadioButton.isSelected()) {
                    if (ascendenteRadioButton.isSelected()) {
                        sortingCtrl.sortQuickAscendingListInteger();
                    } else if (descendenteRadioButton.isSelected()) {
                        sortingCtrl.sortQuickDescendingListInteger();
                    }
                }
//                long endTime = System.currentTimeMillis();
                long endTime = System.nanoTime();
                fillOrdTextArea(startTime,endTime);
            }
        }
    }

    private boolean esExpresionString(String x) {
        boolean b = true;
        String caracteresValidos = "ÁÉÍÓÚABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúabcdefghijklmnñopqrstuvwxyz ";
        int t = x.length();
        for (int i = 0; i < t; i++) {
            if (!caracteresValidos.contains(String.valueOf(x.charAt(i)))) {
                return false;
            }
        }
        return b;
    }

    private void fillExpTextArea() {
        if (alfabeticaRadioButton.isSelected()) {
            expTextArea.setText(sortingCtrl.getExprString());
        } else if (numericaRadioButton.isSelected()) {
            expTextArea.setText(sortingCtrl.getExprInteger());
        }
    }

    private void fillOrdTextArea(long startTime, long endTime) {
        String strTime = "\n\n" //'\n' + '\n'
                + "Tiempo transcurrido: "
                + (endTime - startTime) + " nanosegundos";
        if (alfabeticaRadioButton.isSelected()) {
            ordeTextArea.setText(sortingCtrl.getSortString() + strTime);
        } else if (numericaRadioButton.isSelected()) {
            ordeTextArea.setText(sortingCtrl.getSortInteger() + strTime);
        }
    }

    private void onCargarLista() {
        if (alfabeticaRadioButton.isSelected()) {
            sortingCtrl.cargarLista(0);
        } else if (numericaRadioButton.isSelected()) {
            sortingCtrl.cargarLista(1);
        }
        fillExpTextArea();
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        OrdenamientoGUI dialog = new OrdenamientoGUI();
        dialog.pack();
        System.exit(0);
    }
}
