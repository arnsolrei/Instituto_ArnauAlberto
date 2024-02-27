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

        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int opc = 0;
        Mysql sql = new Mysql();
        sql.getConnection();
        Queries queries = new Queries();
        do {
            System.out.println("1.Quiere añadir una carrera?");
            System.out.println("2.Quiere borrar una carrera?");
            System.out.println("3.Quiere actualizar una carrera?");
            System.out.println("4.Ver carrera.");
            System.out.println("5.Salir");
            opc = sc.nextInt();
            Carrera car;
            switch (opc) {
                case 1:
                    sc.nextLine();
                    System.out.println("Introduce el nombre de la carrera: ");
                    car = new Carrera(sc.nextLine());
                    queries.insertCarrera(car);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Introduce el nombre de la carrera: ");
                    car = new Carrera(sc.nextLine());
                    queries.deleteCarreras(car);
                    break;
                case 3:
                    System.out.println("No esta implementado, espera a futuras versiones.");
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Introduce el nombre de la carrera: ");
                    car = new Carrera(sc.nextLine());
                    queries.fetchCarreras(car);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Introduce numero valido.");
                    break;
            }
        } while (!exit);

    }
}
