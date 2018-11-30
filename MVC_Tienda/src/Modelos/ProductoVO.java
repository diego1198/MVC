/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Date;

/**
 *
 * @author Diego Beltrán
 */
public class ProductoVO {

    private int cod;
    private String nombre;
    private float precio;
    private float costo;
    private String fechaCaducidad;
    private int stock;

    public ProductoVO() {
    }
    
    

    public ProductoVO(int cod, String nombre, float precio, float costo, String fechaCaducidad, int stock) {
        this.cod = cod;
        this.nombre = nombre;
        this.precio = precio;
        this.costo = costo;
        this.fechaCaducidad = fechaCaducidad;
        this.stock = stock;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
