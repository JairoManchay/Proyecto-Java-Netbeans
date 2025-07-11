package com.org.restaurante.models.crud;

import com.org.restaurante.db.DbConnection;
import com.org.restaurante.models.Entity.ProductEntity;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductCrud extends DbConnection {
    
    public boolean insert(ProductEntity prod) {
        Connection cn = getConnection();
        CallableStatement st = null;

        try {
            st = cn.prepareCall("call sp_registrar_producto(?,?,?,?)");

            st.setString(1, prod.getDescripcion());
            st.setDouble(2, prod.getPrecio());
            st.setString(3, prod.getCategoria());
            st.setInt(4, prod.getStock());

            st.execute();

            int rs = st.getUpdateCount();

            return rs == 1;
        } catch (SQLException e) {
            System.out.println("Error al registrar -> " + e.getMessage());

            return false;
        } finally {
            try {
                st.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion -> " + e.getMessage());
            }
        }
    }

    public boolean update(ProductEntity prod) {
        Connection cn = getConnection();
        CallableStatement st = null;

        try {
            st = cn.prepareCall("call sp_modificar_producto(?,?,?,?,?)");

            st.setString(1, prod.getCodigo());
            st.setString(2, prod.getDescripcion());
            st.setDouble(3, prod.getPrecio());
            st.setString(4, prod.getCategoria());
            st.setInt(5, prod.getStock());

            st.execute();

            int rs = st.getUpdateCount();

            return rs == 1;
        } catch (SQLException e) {
            System.out.println("Error al modificar -> " + e.getMessage());

            return false;
        } finally {
            try {
                st.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion -> " + e.getMessage());
            }
        }
    }

    public ArrayList<ProductEntity> list() {
        ArrayList<ProductEntity> lista = new ArrayList<>();
        Connection cn = getConnection();
        CallableStatement st = null;
        ResultSet rs = null;

        try {
            st = cn.prepareCall("call sp_listar_productos()");
            rs = st.executeQuery();

            while (rs.next()) {
                ProductEntity prod = new ProductEntity();
                prod.setCodigo(rs.getString("codigo"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setStock(rs.getInt("stock"));

                lista.add(prod);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion -> " + e.getMessage());
            }
        }

        return lista;
    }
    
    public ProductEntity get(String codigo) {
        ProductEntity prod = null;
        Connection cn = getConnection();
        CallableStatement st = null;
        ResultSet rs = null;

        try {
            st = cn.prepareCall("call sp_obtener_producto(?)");
            
            st.setString(1, codigo);
            
            rs = st.executeQuery();

            while (rs.next()) {
                prod = new ProductEntity();
                prod.setCodigo(rs.getString("codigo"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion -> " + e.getMessage());
            }
        }

        return prod;
    }
}
