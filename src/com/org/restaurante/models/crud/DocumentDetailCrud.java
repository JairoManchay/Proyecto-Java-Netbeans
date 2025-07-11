package com.org.restaurante.models.crud;

import com.org.restaurante.db.DbConnection;
import com.org.restaurante.models.Entity.DocumentDetailEntity;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class DocumentDetailCrud extends DbConnection {
    
    public boolean insert(DocumentDetailEntity det) {
        Connection cn = getConnection();
        CallableStatement st = null;

        try {
            st = cn.prepareCall("call sp_registrar_detalle_documento(?,?,?,?)");

            st.setString(1, det.getId_documento());
            st.setString(2, det.getId_producto());
            st.setInt(3, det.getCantidad());
            st.setDouble(4, det.getPrecio());

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
    
}
