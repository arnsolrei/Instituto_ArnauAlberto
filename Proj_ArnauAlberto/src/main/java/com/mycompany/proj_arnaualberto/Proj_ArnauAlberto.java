package com.mycompany.proj_arnaualberto;

import com.mycompany.db.Mysql;
import com.mycompany.modelo.Carrera;
import java.sql.SQLException;
import com.mycompany.db.Queries;
import java.sql.Connection;
import java.util.Scanner;

public class Proj_ArnauAlberto {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int opc = 0;
        Mysql sql = new Mysql();
        Connection conn = sql.getConnection();
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
                    System.out.print("Introduce el nombre de la carrera: ");
                    car = new Carrera(sc.nextLine());
                    queries.insertCarrera(car, conn);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("Introduce el nombre de la carrera: ");
                    car = new Carrera(sc.nextLine());
                    queries.deleteCarreras(car, conn);
                    break;
                case 3:
                    System.out.println("No esta implementado, espera a futuras versiones.");
                    break;
                case 4:
                    sc.nextLine();
                    System.out.print("Introduce el nombre de la carrera: ");
                    car = new Carrera(sc.nextLine());
                    queries.fetchCarreras(car, conn);
                    break;
                case 5:
                    exit = true;
                    conn.close();
                    sc.close();
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Introduce numero valido.");
                    break;
            }
        } while (!exit);

    }
}
