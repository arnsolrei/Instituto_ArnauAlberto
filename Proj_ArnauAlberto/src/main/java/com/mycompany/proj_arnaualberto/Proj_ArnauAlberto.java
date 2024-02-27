/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proj_arnaualberto;

import java.sql.SQLException;
import com.mycompany.proj_arnaualberto.Queries;
import java.util.Scanner;

/**
 *
 * @author rolet
 */
public class Proj_ArnauAlberto {

    public static void main(String[] args) throws SQLException {
        
       Scanner sc= new Scanner(System.in);
       boolean exit=false;
       int opc= 0;
       
       do{
              System.out.println("Quiere añadir una carrera?");
              System.out.println("Quiere borrar una carrera?");
              System.out.println("Quiere actualizar una carrera?");
              System.out.println("Ver carrera.");
              opc=sc.nextInt();
                      
          switch(opc){
              case 1 : 
              case 2 : 
              case 3 :
              case 4 : 
                     
                    
          }
       }
        
       
       Mysql sql = new Mysql();
       Scanner sc= new Scanner(System.in);
       Carrera car= new Carrera(sc.nextLine());
       sql.getConnection();
       Queries queries= new Queries();
       queries.insertCarrera(car);
       queries.deleteCarreras(car);
       queries.fetchCarreras(car);
       
       
    }
   //public static void insert(carrera){
}
