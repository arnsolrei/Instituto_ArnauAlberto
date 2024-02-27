/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proj_arnaualberto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author rolet
 */
public class Queries {

    private final Mysql DB;
    
   

    public Queries() {
        DB = new Mysql();
        
        
    }

    

    public void insertCarrera(Carrera car) {
        try {
            Connection conn = DB.getConnection();
            if (conn != null) {
                String query = "INSERT INTO `escuela`.`carreras`(`nombre`) VALUES('"+car.nombre
                        + "');";
                System.out.println(query);
                Statement st = conn.createStatement();
                st.executeUpdate(query);
                System.out.println("CARRERA AÑADIDA CORRECTAMENTE!");
            }
        } catch (SQLException ex) {
            System.err.println("Error añadiendo carrera: " + ex.getMessage());
        }
    }

    public void fetchCarreras(Carrera Car) {
        try {
            Connection conn = DB.getConnection();
            String query = "SELECT * FROM `escuela`.`carreras` WHERE nombre ="+Car.nombre;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                
                System.out.println("Nombre: " + rs.getString("nombre") 
                );
            }
        } catch (SQLException ex) {
            System.err.println("Error en la conexión con la BBDD: " + ex.getMessage());
        }
    }

    public void deleteCarreras(Carrera car) {
        try {
            Connection conn = DB.getConnection();
            String query = "DELETE FROM `escuela`.`carreras` WHERE nombre = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, car.nombre);
            int result = st.executeUpdate();
            if (result >= 1) {
                System.out.println("Carrera borrada exitosamente!");
            }
        } catch (SQLException ex) {
            System.err.println("Error con la conexión de la BBDD! " + ex.getMessage());
        }
    }
}

