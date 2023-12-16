/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultaProducto;
import modelo.Producto;
import vista.formProducto;

/**
 *
 * @author danie
 */
public class CProducto implements ActionListener{
    private Producto p;
    private ConsultaProducto modP;
    private formProducto vista;
    
    public CProducto(Producto p, ConsultaProducto c, formProducto f){
        this.p = p;
        this.modP = c;
        this.vista =  f;
        this.vista.btn_guardar.addActionListener(this);
        this.vista.btn_buscar.addActionListener(this);
        this.vista.btn_eliminar.addActionListener(this);
        this.vista.btn_limpiar.addActionListener(this);
        this.vista.btn_modificar.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setTitle("CRUD MVC");
        vista.setLocationRelativeTo(null);
        vista.txt_id.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btn_guardar){
            p.setCodigo(vista.txt_codigo.getText());
            p.setNombre(vista.txt_nombre.getText());
            p.setPrecio(Double.parseDouble(vista.txt_precio.getText()));
            p.setCantidad(Integer.parseInt(vista.txt_cantidad.getText()));
            
            if(modP.registrar(p)){
                JOptionPane.showMessageDialog(null, "registro guardado");
                limpiar();
            }else{
                 JOptionPane.showMessageDialog(null, "error al guardar");
                 limpiar();
            }
        }
        if(e.getSource() == vista.btn_modificar){
            p.setId(Integer.parseInt(vista.txt_id.getText()));
            p.setCodigo(vista.txt_codigo.getText());
            p.setNombre(vista.txt_nombre.getText());
            p.setPrecio(Double.parseDouble(vista.txt_precio.getText()));
            p.setCantidad(Integer.parseInt(vista.txt_cantidad.getText()));
            
            if(modP.modificar(p)){
                JOptionPane.showMessageDialog(null, "registro modificado");
                limpiar();
            }else{
                 JOptionPane.showMessageDialog(null, "error al modificar");
                 limpiar();
            }
        }
        if(e.getSource() == vista.btn_eliminar){
            p.setId(Integer.parseInt(vista.txt_id.getText()));
           
        
            if(modP.eliminar(p)){
                JOptionPane.showMessageDialog(null, "registro eliminado");
                limpiar();
            }else{
                 JOptionPane.showMessageDialog(null, "error al eliminar");
                 limpiar();
            }
        }
        if(e.getSource() == vista.btn_buscar){
            p.setCodigo(vista.txt_codigo.getText());
           
        
            if(modP.buscar(p)){
                vista.txt_id.setText(String.valueOf(p.getId()));
                vista.txt_codigo.setText(p.getCodigo());
                vista.txt_nombre.setText(p.getNombre());
                vista.txt_precio.setText(String.valueOf(p.getPrecio()));
                vista.txt_cantidad.setText(String.valueOf(p.getCantidad()));
            }else{
                 JOptionPane.showMessageDialog(null, "No se encontro el registro");
                 limpiar();
            }
        }
        if(e.getSource() == vista.btn_limpiar){
            limpiar();
        }
    }
    
    public void limpiar(){
        vista.txt_id.setText(null);
        vista.txt_codigo.setText(null);
        vista.txt_nombre.setText(null);
        vista.txt_precio.setText(null);
        vista.txt_cantidad.setText(null);
        
    }
}
