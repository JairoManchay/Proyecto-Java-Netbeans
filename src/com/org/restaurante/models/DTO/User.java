/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.restaurante.models.DTO;

/**
 *
 * @author Usuario
 */
public class User {
    
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    

    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }

    
    
}
