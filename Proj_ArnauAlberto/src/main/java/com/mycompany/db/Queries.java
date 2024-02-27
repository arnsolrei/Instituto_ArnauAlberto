package com.mycompany.db;

import com.mycompany.modelo.Carrera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries {

    public Queries() {
    }

    public void insertCarrera(Carrera car, Connection conn) {
        try {
            if (conn != null) {
                String query = "INSERT INTO `escuela`.`carreras`(`nombre`) VALUES('" + car.nombre
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

    public void fetchCarreras(Carrera Car, Connection conn) {
        try {
            String query = "SELECT * FROM `escuela`.`carreras` WHERE nombre = '" + Car.nombre + "';";
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
    
    public void updateCarreras(Carrera Car, Connection conn, String nombreEditar) {
        try {
            String query = "SELECT * FROM `escuela`.`carreras` WHERE nombre = '" + Car.nombre + "';";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                updateCarrerasPorId(rs.getInt("id"), conn, nombreEditar);
            }
        } catch (SQLException ex) {
            System.err.println("Error en la conexión con la BBDD: " + ex.getMessage());
        }
    }

    public void deleteCarreras(Carrera car, Connection conn) {
        try {
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
    public void updateCarrerasPorId(int carId, Connection conn, String nombreEditar) {
        try {
            String query = "UPDATE `escuela`.`carreras` SET `nombre` = ? WHERE (`id` = ?);";
            
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, nombreEditar);
            st.setInt(2, carId);
            int result = st.executeUpdate();
            if (result >= 1) {
                System.out.println("Carrera editada exitosamente!");
            }
        } catch (SQLException ex) {
            System.err.println("Error con la conexión de la BBDD! " + ex.getMessage());
        }
    }
}
