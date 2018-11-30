/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.ProductoDAO;
import Modelos.ProductoVO;
import Vistas.ProductoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Beltrán
 */
public class CtrlProducto implements ActionListener{
    private ProductoVO prod;
    private ProductoDAO prdao;
    private ProductoView view;

    public CtrlProducto(ProductoVO prod, ProductoDAO prdao, ProductoView view) {
        this.prod = prod;
        this.prdao = prdao;
        this.view = view;
        this.view.btnAgregar.addActionListener(this);
        this.view.btnBorrar.addActionListener(this);
        this.view.btnConsultar.addActionListener(this);
        this.view.btnModificar.addActionListener(this);
    }
    
    public void iniciar(){
        view.setTitle("Producto");
        view.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==view.btnAgregar){
            prod.setCod(Integer.parseInt(view.txtCod.getText()));
            prod.setNombre(view.txtNombre.getText());
           do{
            prod.setCosto(Float.parseFloat(view.txtCosto.getText()));
            prod.setPrecio(Float.parseFloat(view.txtPrecio.getText()));
            if(Float.parseFloat(view.txtCosto.getText())>Float.parseFloat(view.txtPrecio.getText())){
                            JOptionPane.showMessageDialog(null, "El precio es menor que el costo, va a tener una perdida");
                            view.txtPrecio.setText("");
                            view.txtCosto.setText("");
            }
            }while(Float.parseFloat(view.txtCosto.getText())>Float.parseFloat(view.txtPrecio.getText()));
            String fecha = String.valueOf(view.jCalendario.getCalendar().get(Calendar.YEAR)) +"-"+
                                      String.valueOf(view.jCalendario.getCalendar().get(Calendar.MARCH)+1)+"-"+
                                      String.valueOf(view.jCalendario.getCalendar().get(Calendar.DAY_OF_MONTH)) ;
            prod.setFechaCaducidad(fecha);
            prod.setStock(Integer.parseInt(view.txtStock.getText()));
            
            if(prdao.Agregar(prod)){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error en la insercion");
            }
        }else if(e.getSource()==view.btnModificar){
            prod.setCod(Integer.parseInt(view.txtCod.getText()));
            prod.setNombre(view.txtNombre.getText());
            do{
            prod.setCosto(Float.parseFloat(view.txtCosto.getText()));
            prod.setPrecio(Float.parseFloat(view.txtPrecio.getText()));
            if(Float.parseFloat(view.txtCosto.getText())>Float.parseFloat(view.txtPrecio.getText())){
                            JOptionPane.showMessageDialog(null, "El precio es menor que el costo, va a tener una perdida");
            }
            }while(Float.parseFloat(view.txtCosto.getText())>Float.parseFloat(view.txtPrecio.getText()));
            String fecha = String.valueOf(view.jCalendario.getCalendar().get(Calendar.YEAR)) +"-"+
                                      String.valueOf(view.jCalendario.getCalendar().get(Calendar.MARCH)+1)+"-"+
                                      String.valueOf(view.jCalendario.getCalendar().get(Calendar.DAY_OF_MONTH)) ;
            prod.setFechaCaducidad(fecha);
            prod.setStock(Integer.parseInt(view.txtStock.getText()));
            
            if(prdao.Modificar(prod)){
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error en la modificación");
            }
        }else if(e.getSource()==view.btnBorrar){
            prod.setCod(Integer.parseInt(view.txtCod.getText()));
            if(prdao.Eliminar(prod)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error en la eliminacion");
            }
        }else{
            Calendar cal = Calendar.getInstance();
            prod.setCod(Integer.parseInt(view.txtCod.getText()));
            if(prdao.Buscar(prod)){
                view.txtNombre.setText(prod.getNombre());
                view.txtCosto.setText(String.valueOf(prod.getCosto()));
                view.txtPrecio.setText(String.valueOf(prod.getPrecio()));
                view.txtStock.setText(String.valueOf(prod.getStock()));
                view.jCalendario.setCalendar(fecha(String.valueOf(prod.getFechaCaducidad())));
            }else{
                JOptionPane.showMessageDialog(null, "Registro no encontrado");
                limpiar();
            }
        }
    }
    
    public Calendar fecha(String fecha){
        Calendar aux = Calendar.getInstance();
        String[] aux1 = fecha.split("-");
        int dia = Integer.parseInt(aux1[2]);
        int mes =Integer.parseInt( aux1[1]);
        mes = mes -1;
        int anio = Integer.parseInt(aux1[0]);
        aux.set(anio, mes, dia);
        return aux;
    }
    
    public void limpiar(){
        view.txtCod.setText("");
        view.txtNombre.setText("");
        view.txtCosto.setText("");
        view.txtPrecio.setText("");
        view.jCalendario.setCalendar(null);
        view.txtStock.setText("");
    }
    
    
    
}
