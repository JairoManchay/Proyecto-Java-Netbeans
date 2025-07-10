/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.org.restaurante.models.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ProductForm extends JPanel {

    private JTextField txtId, txtNombre, txtPrecio, txtStock;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    /**
     * Creates new form ProductForm
     */
    public ProductForm() {
        initComponents();
        
        setLayout(new BorderLayout());;

        
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4; // Que ocupe todas las columnas
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(15, 10, 10, 10);
        JLabel titulo = new JLabel("Listado de Productos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelFormulario.add(titulo, gbc);
        

        // Reorganizar desde 0 
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ID
        gbc.gridy = 1; gbc.gridx = 0;
        panelFormulario.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        txtId = new JTextField(10);
        panelFormulario.add(txtId, gbc);

        // Nombre
        gbc.gridx = 2; gbc.gridy = 1;
        panelFormulario.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 3;
        txtNombre = new JTextField(15);
        panelFormulario.add(txtNombre, gbc);

       // Precio
        gbc.gridx = 0; gbc.gridy = 2;
        panelFormulario.add(new JLabel("Precio:"), gbc);
        gbc.gridx = 1;
        txtPrecio = new JTextField(10);
        panelFormulario.add(txtPrecio, gbc);

        // Stock
        gbc.gridx = 2; gbc.gridy = 2;
        panelFormulario.add(new JLabel("Stock:"), gbc);
        gbc.gridx = 3;
        txtStock = new JTextField(10);
        panelFormulario.add(txtStock, gbc);

        // Botones
        JPanel panelBotones = new JPanel();
        JButton btnCrear = new JButton("Crear");
        JButton btnEditar = new JButton("Editar");
        JButton btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnCrear);
        panelBotones.add(btnEditar);
        panelBotones.add(btnLimpiar);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(20, 10, 20, 10);
        panelFormulario.add(panelBotones, gbc);

        add(panelFormulario, BorderLayout.NORTH);
        
        // Creacion de la tabla
        String[] productList = {"codigo","descripcion","precio","categoria"};
        modeloTabla = new DefaultTableModel(productList, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        
        add(scrollPane, BorderLayout.SOUTH);
        
        btnCrear.addActionListener(e -> crearProducto());
        btnEditar.addActionListener(e -> editarProducto());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        // Cuando seleccionas una fila, carga datos en los campos
        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                selectedRowTable(e);
            }
        });
    }

    private void crearProducto(){
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        Double precio = Double.valueOf(txtPrecio.getText());
        Integer stock = Integer.valueOf(txtStock.getText());
        
        validarCamposVacios(id, nombre, precio, stock);
        
        modeloTabla.addRow(new Object[]{id, nombre, precio, stock});
        limpiarCampos();
    }
    
    private void editarProducto(){
        int fila = tabla.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(this, "Seleccione un producto para editar");
            return;
        }
        
          modeloTabla.setValueAt(txtId.getText(), fila, 0);
            modeloTabla.setValueAt(txtNombre.getText(), fila, 1);
            modeloTabla.setValueAt(txtPrecio.getText(), fila, 2);
            modeloTabla.setValueAt(txtStock.getText(), fila, 3);

            limpiarCampos();
    }
    
    private void selectedRowTable(MouseEvent e){
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            txtId.setText(modeloTabla.getValueAt(fila, 0).toString());
            txtNombre.setText(modeloTabla.getValueAt(fila, 1).toString());
            txtPrecio.setText(modeloTabla.getValueAt(fila, 2).toString());
            txtStock.setText(modeloTabla.getValueAt(fila, 3).toString());
        }

    }
    
    private void validarCamposVacios(String id, String nombre, Double precio, Integer stock){
            if (id.isEmpty() || nombre.isEmpty() || precio==0 || stock==0) {
                JOptionPane.showMessageDialog(this, "Completa todos los campos.");
                return;
            }
    }
    
    private void limpiarCampos(){
        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
