/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.restaurante.views;

import com.org.restaurante.models.Entity.TableEntity;
import com.org.restaurante.models.crud.TableCrud;
import java.util.ArrayList;

/**
 *
 * @author Pc
 */
public class TestClass {

    private static TableCrud tbCrud;

    public static void main(String[] args) {
        TableEntity tab = new TableEntity();
        tab.setNumero(1);
        tab.setAsientos(10);
        tab.setDisponible(false);

        tbCrud = new TableCrud();

        ArrayList<TableEntity> mesas = tbCrud.list();

        for (TableEntity t : mesas) {
            System.out.println("Mesa: " + t.getNumero()
                                + "\nAsientos: " + t.getAsientos() + "\n\n");
        }
    }
}
