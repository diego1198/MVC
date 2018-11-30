/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Controladores.CtrlProducto;
import Modelos.*;
import Vistas.ProductoView;

/**
 *
 * @author Diego Beltrán
 */
public class MVCTienda {
    
    public static void main(String [] args){
        ProductoVO prod = new ProductoVO();
        ProductoDAO dao = new ProductoDAO();
        ProductoView vista = new ProductoView();
        
        CtrlProducto ctrl = new CtrlProducto(prod, dao, vista);
        ctrl.iniciar();
        vista.setVisible(true);
    }
    
}
