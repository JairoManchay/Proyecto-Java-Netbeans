/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.restaurante.models.controller;
import com.org.restaurante.models.DTO.User;
/**
 *
 * @author Usuario
 */
public class UserController {
    
    
    public boolean validateLogin(String user, String password){
        
        
        User usuarioAdmin = new User("admin", "123456");
        User usuario = new User("user", "123456");
        
        /*if(user.equals(usuario.getName())){
            return (user.equals(usuario.getName()) && password.equals(usuario.getPassword()));
        }else if(user.equals(usuarioAdmin.getName())){
            return (user.equals(usuarioAdmin.getName()) && password.equals(usuarioAdmin.getPassword()));
        }else{
            return false;
        }*/
        return true;
        
        
    }
}
