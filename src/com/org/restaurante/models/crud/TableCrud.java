package com.org.restaurante.models.crud;

import com.org.restaurante.db.DbConnection;
import com.org.restaurante.models.Entity.TableEntity;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TableCrud extends DbConnection {

    public boolean insert(TableEntity tab) {
        Connection cn = getConnection();
        CallableStatement st = null;

        try {
            st = cn.prepareCall("call sp_registrar_mesa(?)");
            
            st.setInt(1, tab.getAsientos());
            
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

    public boolean update(TableEntity tab) {
        Connection cn = getConnection();
        CallableStatement st = null;

        try {
            st = cn.prepareCall("call sp_modificar_mesa(?,?,?)");

            st.setInt(1, tab.getNumero());
            st.setInt(2, tab.getAsientos());
            st.setBoolean(3, tab.getDisponible());

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

    public ArrayList<TableEntity> list() {
        ArrayList<TableEntity> lista = new ArrayList<>();
        Connection cn = getConnection();
        CallableStatement st = null;
        ResultSet rs = null;

        try {
            st = cn.prepareCall("call sp_listar_mesas()");
            
            rs = st.executeQuery();

            while (rs.next()) {
                TableEntity tab = new TableEntity();
                tab.setNumero(rs.getInt("numero"));
                tab.setAsientos(rs.getInt("asientos"));
                tab.setDisponible(rs.getBoolean("disponible"));

                lista.add(tab);
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
}
