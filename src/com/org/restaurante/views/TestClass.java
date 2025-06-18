/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.restaurante.views;

import com.org.restaurante.models.Entity.TableEntity;

/**
 *
 * @author Pc
 */
public class TestClass {
    public static void main(String[] args) {
        TableEntity tb = new TableEntity();
        tb.setAsientos(5);
        
        tb.insert();
    }
}
