/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayeren.crud_mvc_escritorio.controlador;

import com.ayeren.crud_mvc_escritorio.dao.CRUD;
import com.ayeren.crud_mvc_escritorio.modelo.Persona;
import com.ayeren.crud_mvc_escritorio.dao.PersonaDAOImpl;
import com.ayeren.crud_mvc_escritorio.vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anthony Davis Yeren Martinez
 */
public class Controlador implements ActionListener {

    Persona persona = new Persona();
    Principal principal = new Principal();
    DefaultTableModel modelo = new DefaultTableModel();
    CRUD dao = new PersonaDAOImpl();

    public Controlador(Principal principal) {
        this.principal = principal;
        this.principal.btnListar.addActionListener(this);
        this.principal.btnGuardar.addActionListener(this);
        this.principal.btnEditar.addActionListener(this);
        this.principal.btnOk.addActionListener(this);
        this.principal.btnEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.btnListar) {
            listar(principal.tblDatos);
        }
        if (e.getSource() == principal.btnGuardar) {
            agregar();
            limpiarTabla();
            listar(principal.tblDatos);
        }
        if (e.getSource() == principal.btnEditar) {
            int fila = principal.tblDatos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(principal, "Debe seleccionar una fila");
            } else {
                int id = Integer.parseInt(principal.tblDatos.getValueAt(fila, 0).toString());
                String nombres = principal.tblDatos.getValueAt(fila, 1).toString();
                String correo = principal.tblDatos.getValueAt(fila, 2).toString();
                String telefono = principal.tblDatos.getValueAt(fila, 3).toString();
                principal.txtID.setText("" + id);
                principal.txtNombres.setText(nombres);
                principal.txtCorreo.setText(correo);
                principal.txtTelefono.setText(telefono);
            }
        }
        if (e.getSource() == principal.btnOk) {
            actualizar();
            limpiarTabla();
            listar(principal.tblDatos);
        }
        if (e.getSource() == principal.btnEliminar) {
           eliminar();
           limpiarTabla();
           listar(principal.tblDatos);
        }
    }

    public void listar(JTable table) {
        modelo = (DefaultTableModel) table.getModel();
        List<Persona> lista = dao.listarTodos();
        Object[] object = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getNombres();
            object[2] = lista.get(i).getCorreo();
            object[3] = lista.get(i).getTelefono();
            modelo.addRow(object);
        }
        table.setModel(modelo);
    }

    public void agregar() {
        String nombres = principal.txtNombres.getText();
        String correo = principal.txtCorreo.getText();
        String telefono = principal.txtTelefono.getText();
        persona.setNombres(nombres);
        persona.setCorreo(correo);
        persona.setTelefono(telefono);
        dao.registrar(persona);
    }

    public void actualizar() {
        int id = Integer.parseInt(principal.txtID.getText());
        String nombres = principal.txtNombres.getText();
        String correo = principal.txtCorreo.getText();
        String telefono = principal.txtTelefono.getText();
        persona.setId(id);
        persona.setNombres(nombres);
        persona.setCorreo(correo);
        persona.setTelefono(telefono);
        dao.actualizar(persona);
    }
    
    public void eliminar() {
        int fila = principal.tblDatos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(principal, "Debe seleccionar una persona");
        } else {
            int id = Integer.parseInt(principal.tblDatos.getValueAt(fila, 0).toString());
            dao.eliminar(id);
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < principal.tblDatos.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
