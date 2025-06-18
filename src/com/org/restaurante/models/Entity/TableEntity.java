/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.restaurante.models.Entity;

import com.org.restaurante.db.DbSingleton;
import com.org.restaurante.interfaces.CrudInterface;
import java.sql.*;

/**
 *
 * @author Usuario
 */
public class TableEntity implements CrudInterface {

    private Integer numero;
    private Integer asientos;
    private Boolean disponible;

    public TableEntity() {
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAsientos() {
        return asientos;
    }

    public void setAsientos(Integer asientos) {
        this.asientos = asientos;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public void insert() {
        try (Connection cn = DbSingleton.getConnection(); 
                CallableStatement st = cn.prepareCall("call sp_registrar_mesa(?)")) {
            st.setInt(1, asientos);

            st.execute();

            int c = st.getUpdateCount();

            System.out.println(c > 0 ? "Se registro correctamente" : "Error al registrar");

            st.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al registrar -> " + e.getMessage());
        }
    }

    @Override
    public void update() {

    }
}
