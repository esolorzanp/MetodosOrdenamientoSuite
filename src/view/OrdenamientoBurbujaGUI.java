package view;

import control.SortingCtrl;

import javax.swing.*;
import java.awt.event.*;

public class OrdenamientoBurbujaGUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea expTextArea;
    private JTextArea ordTextArea;
    private JButton agregarButton;
    private JTextField expTextField;
    private JButton ordenarButton;
    private JRadioButton ascendenteRadioButton;
    private JRadioButton descendenteRadioButton;
    private JButton limpiarListasButton;
    private JRadioButton alfabeticaRadioButton;
    private JRadioButton numericaRadioButton;
    private ButtonGroup expBtnGroup;
    private ButtonGroup ordBtnGroup;
    private SortingCtrl burbujaCtrl;

    public OrdenamientoBurbujaGUI() {
        burbujaCtrl = new SortingCtrl();

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(800, 500);
        setLocationRelativeTo(this);

        expTextArea.setEditable(false);
        ordTextArea.setEditable(false);

        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
        agregarButton.addActionListener(e -> onAgregar());
        limpiarListasButton.addActionListener(e -> onLimpiarListas());
        ordenarButton.addActionListener(e -> onOrdenar());

        expBtnGroup = new ButtonGroup();
        expBtnGroup.add(numericaRadioButton);
        expBtnGroup.add(alfabeticaRadioButton);
        alfabeticaRadioButton.setSelected(true);

        ordBtnGroup = new ButtonGroup();
        ordBtnGroup.add(ascendenteRadioButton);
        ordBtnGroup.add(descendenteRadioButton);
        ascendenteRadioButton.setSelected(true);

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
    }

    private void onAgregar() {
        String exp = expTextField.getText();
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

    private void fillExpTextArea() {
        if (alfabeticaRadioButton.isSelected()) {
            expTextArea.setText(burbujaCtrl.getExprString());
        } else if (numericaRadioButton.isSelected()) {
            expTextArea.setText(burbujaCtrl.getExprInteger());
        }
    }

    private void fillOrdTextArea() {
        if (alfabeticaRadioButton.isSelected()) {
            ordTextArea.setText(burbujaCtrl.getSortString());
        } else if (numericaRadioButton.isSelected()) {
            ordTextArea.setText(burbujaCtrl.getSortInteger());
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

    private void onLimpiarListas() {
        expTextArea.setText("");
        ordTextArea.setText("");
        burbujaCtrl.initLists();
    }

    private void onOrdenar() {
        if (alfabeticaRadioButton.isSelected()) {
            if (!burbujaCtrl.hasItemsExpStringList()) {
                JOptionPane.showMessageDialog(null, "La lista de expresiones está vacía, debe ingresarle expresiones alfbéticas o numércias", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (ascendenteRadioButton.isSelected()) {
                    burbujaCtrl.sortBubbleAscendingListString();
                } else if (descendenteRadioButton.isSelected()) {
                    burbujaCtrl.sortBubbleDescendingListString();
                }
                fillOrdTextArea();
            }
        } else if (numericaRadioButton.isSelected()) {
            if (!burbujaCtrl.hasItemsExpIntegerList()) {
                JOptionPane.showMessageDialog(null, "La lista de expresiones está vacía, debe ingresarle expresiones alfbéticas o numércias", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (ascendenteRadioButton.isSelected()) {
                    burbujaCtrl.sortBubbleAscendingListInteger();
                } else if (descendenteRadioButton.isSelected()) {
                    burbujaCtrl.sortBubbleDescendingListInteger();
                }
                fillOrdTextArea();
            }
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
        OrdenamientoBurbujaGUI dialog = new OrdenamientoBurbujaGUI();
//        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
