/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diego Beltrán
 */
public class ProductoDAO {

    Conexion con = new Conexion();

    public boolean Agregar(ProductoVO prod) {
        PreparedStatement ps = null;
        Connection conn = con.getConexion();

        String sql = "insert into producto(codigo,nombre,precio,costo,fechaCaducidad,stock) values (?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, prod.getCod());
            ps.setString(2, prod.getNombre());
            ps.setFloat(3, prod.getCosto());
            ps.setFloat(4, prod.getPrecio());
            ps.setString(5, prod.getFechaCaducidad());
            ps.setInt(6, prod.getStock());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean Modificar(ProductoVO prod) {
        PreparedStatement ps = null;
        Connection conn = con.getConexion();

        String sql = "update producto set nombre=?, precio=?, costo=?, fechaCaducidad=?, stock=? where codigo = ?;";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, prod.getNombre());
            ps.setFloat(2, prod.getPrecio());
            ps.setFloat(3, prod.getCosto());
            ps.setString(4, prod.getFechaCaducidad());
            ps.setInt(5, prod.getStock());
            ps.setInt(6, prod.getCod());
            System.out.println(ps);
            ps.execute();
            
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean Eliminar(ProductoVO prod) {
        PreparedStatement ps = null;
        Connection conn = con.getConexion();

        String sql = "delete from producto where codigo = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, prod.getCod());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean Buscar(ProductoVO prod) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = con.getConexion();

        String sql = "select * from producto where codigo = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, prod.getCod());
            rs = ps.executeQuery();
            if (rs.next()) {
                prod.setNombre(rs.getString("nombre"));
                prod.setPrecio(Float.parseFloat(rs.getString("precio")));
                prod.setCosto(Float.parseFloat(rs.getString("costo")));
                prod.setFechaCaducidad(rs.getString("fechaCaducidad"));
                prod.setStock(Integer.parseInt(rs.getString("stock")));
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
