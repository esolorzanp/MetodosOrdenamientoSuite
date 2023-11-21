package view;

import control.OrdenamientoBurbujaCtrl;

import javax.swing.*;
import java.awt.event.*;

public class OrdenamientoGUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton agregarButton;
    private JButton limpiarListasButton;
    private JButton ordenarButton;
    private JTextField expTextField;
    private JRadioButton alfabeticaRadioButton;
    private JRadioButton bubbleRadioButton;
    private JRadioButton numericaRadioButton;
    private JRadioButton quickSorteRadioButton;
    private JRadioButton ascendenteRadioButton;
    private JRadioButton descendenteRadioButton;
    private JTextArea expTextArea;
    private JTextArea textArea2;
    private ButtonGroup expresionBtng;
    private ButtonGroup metodoBtng;
    private ButtonGroup ordenarBtng;
    private OrdenamientoBurbujaCtrl burbujaCtrl;

    public OrdenamientoGUI() {
        burbujaCtrl = new OrdenamientoBurbujaCtrl();

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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

        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
        agregarButton.addActionListener(e -> onAgregar());
        limpiarListasButton.addActionListener(e -> onLimpiarListas());
        ordenarButton.addActionListener(e -> onOrdenar());

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

        setSize(800, 400);
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
                    if (!burbujaCtrl.add(exp)) {
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
                    if (!burbujaCtrl.add(expNum)) {
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
        System.out.println("click en Limpiar listas");
        expTextField.setText("");
        expTextArea.setText("");
        burbujaCtrl.initLists();
    }

    private void onOrdenar() {
        System.out.println("click en Ordenar");
        if (alfabeticaRadioButton.isSelected()) {
            if (!burbujaCtrl.hasItemsExpStringList()) {
                JOptionPane.showMessageDialog(null, "La lista de expresiones está vacía, debe ingresarle expresiones alfbéticas o numércias", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (ascendenteRadioButton.isSelected()) {
                    burbujaCtrl.ordenarAscendenteListaString();
                } else if (descendenteRadioButton.isSelected()) {
                    burbujaCtrl.ordenarDescendenteListaString();
                }
                fillOrdTextArea();
            }
        } else if (numericaRadioButton.isSelected()) {
            if (!burbujaCtrl.hasItemsExpIntegerList()) {
                JOptionPane.showMessageDialog(null, "La lista de expresiones está vacía, debe ingresarle expresiones alfbéticas o numércias", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (ascendenteRadioButton.isSelected()) {
                    burbujaCtrl.ordenarAscendenteListaInteger();
                } else if (descendenteRadioButton.isSelected()) {
                    burbujaCtrl.ordenarDescendenteListaInteger();
                }
                fillOrdTextArea();
            }
        }
    }

    private boolean esExpresionString(String x) {
        boolean b = true;
        String caracteresValidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";
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
            expTextArea.setText(burbujaCtrl.getExprString());
        } else if (numericaRadioButton.isSelected()) {
            expTextArea.setText(burbujaCtrl.getExprInteger());
        }
    }

    private void fillOrdTextArea() {
        if (alfabeticaRadioButton.isSelected()) {
            expTextArea.setText(burbujaCtrl.getOrdeString());
        } else if (numericaRadioButton.isSelected()) {
            expTextArea.setText(burbujaCtrl.getOrdeInteger());
        }

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
//        dialog.setVisible(true);
        System.exit(0);
    }
}
