/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_mvc;

import controlador.CProducto;
import modelo.ConsultaProducto;
import modelo.Producto;
import vista.formProducto;

/**
 *
 * @author danie
 */
public class CRUD_MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto mod = new Producto();
        ConsultaProducto modC = new ConsultaProducto();
        formProducto frm = new formProducto();
        CProducto c = new CProducto(mod, modC, frm);
        c.iniciar();
        frm.setVisible(true);
    }
    
}
