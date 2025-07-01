package com.org.restaurante.models.crud;

import com.org.restaurante.db.DbConnection;
import com.org.restaurante.models.Entity.DocumentEntity;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class DocumentCrud extends DbConnection {
    
    public boolean insert(DocumentEntity doc) {
        Connection cn = getConnection();
        CallableStatement st = null;

        try {
            st = cn.prepareCall("call sp_registrar_documento(?,?,?,?,?,?)");

            st.setDate(1, Date.valueOf(doc.getFecha()));
            st.setString(2, doc.getTipo());
            st.setString(3, doc.getNum_cliente());
            st.setString(4, doc.getNombre_cliente());
            st.setString(5, doc.getForma_pago());
            st.setInt(6, doc.getNum_mesa());

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
    
    public ArrayList<DocumentEntity> list() {
        ArrayList<DocumentEntity> lista = new ArrayList<>();
        Connection cn = getConnection();
        CallableStatement st = null;
        ResultSet rs = null;

        try {
            st = cn.prepareCall("call sp_listar_documentos()");
            rs = st.executeQuery();

            while (rs.next()) {
                DocumentEntity doc = new DocumentEntity();
                doc.setCodigo(rs.getString("codigo"));
                doc.setFecha(LocalDate.ofInstant(rs.getDate("fecha").toInstant(), ZoneId.systemDefault()));
                doc.setTipo(rs.getString("tipo"));
                doc.setNum_cliente(rs.getString("num_cliente"));
                doc.setNombre_cliente(rs.getString("nombre_cliente"));
                doc.setForma_pago(rs.getString("forma_pago"));
                doc.setNum_mesa(rs.getInt("num_mesa"));

                lista.add(doc);
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
