/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guimattresssales;

/**
 *
 * @author Student
 */

import java.io.FileWriter;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JTextField txtName, txtPrice;
    private JComboBox<String> cmbProduct;
    private JButton btnProcess, btnClear;

    public Main() {
        setTitle("Mattress Sales");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Displaying menu
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        file.add(exit);

        JMenu tools = new JMenu("Tools");
        JMenuItem processMenu = new JMenuItem("Process");
        processMenu.addActionListener(e -> processSale());
        JMenuItem clearMenu = new JMenuItem("Clear");
        clearMenu.addActionListener(e -> clearFields());
        tools.add(processMenu);
        tools.add(clearMenu);

        bar.add(file);
        bar.add(tools);
        setJMenuBar(bar);

        add(new JLabel("Customer Name:"));
        txtName = new JTextField();
        add(txtName);

        add(new JLabel("Product Name:"));
        cmbProduct = new JComboBox<>(new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
        add(cmbProduct);

        add(new JLabel("Product Price:"));
        txtPrice = new JTextField();
        add(txtPrice);

        btnProcess = new JButton("Process");
        btnProcess.addActionListener(e -> processSale());
        add(btnProcess);

        btnClear = new JButton("Clear");
        btnClear.addActionListener(e -> clearFields());
        add(btnClear);
    }

    private void processSale() {
        try {
            String name = txtName.getText();
            String product = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations();
            double vat = calc.GetVat(price);
            double comm = calc.GetCommission(price);
            double total = calc.GetTotal(price);

            // Creating Message
            String msg = "Customer Name: " + name + "\nProduct: " + product
                    + "\nVAT: R " + vat + "\nCOMMISSION: R " + comm + "\nTOTAL: R " + total;
            JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Saving to the data.txt thingy
            FileWriter w = new FileWriter("data.txt");
            w.write("DATA LOG\n");
            w.write("********************************************\n");
            w.write("Customer Name: " + name + "\n");
            w.write("Product: " + product + "\n");
            w.write("VAT: R " + vat + "\n");
            w.write("COMMISSION: R " + comm + "\n");
            w.write("TOTAL: R " + total + "\n");
            w.write("********************************************\n");
            w.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid name and price");
        }
    }

    private void clearFields() {
        txtName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
