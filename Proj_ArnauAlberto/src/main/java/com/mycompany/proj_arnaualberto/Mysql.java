/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proj_arnaualberto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rolet
 */

public class Mysql {
    public static void Conectar() {
        Connection connection = null;

        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            String url = "jdbc:mysql://localhost:3306/escuela";
            String username = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url, username, password);

            // Comprobar si la conexión fue exitosa
            if (connection != null) {
                System.out.println("¡Conexión exitosa a la base de datos!");
            } else {
                System.out.println("Error al conectar a la base de datos.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo encontrar el driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión a la base de datos.");
            e.printStackTrace();
        } 
        
     try{
         String Query="SELECT*FROM carreras";
         Statement st=connection.createStatement();
         java.sql.ResultSet resultSet;
         resultSet=st.executeQuery(Query);
         
         while(resultSet.next()){
             System.out.println("ID: "+resultSet.getString("id")+ " "+
                     "Nombre: "+resultSet.getString("nombre")+" ");}
     }catch(SQLException ex){
         ex.printStackTrace();
                     }
     }
    public Connection getConnection() throws SQLException {
        String BD_URL = String.format("%s//%s/%s","jdbc:mysql:" ,"localhost", "escuela");
        Connection conn;
        conn = DriverManager.getConnection(BD_URL,"root" , "123456");
        return conn;
    }
    }
    

