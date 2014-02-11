/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author oracle
 */
public class Conexion {

    public Conexion() {
    }

    //conexion a la base de datos
    public Connection conectar(String usu, String cont) throws ClassNotFoundException, SQLException {
//        String host = "192.168.2.1:1521:";
//        String sid = "sia";

        String host = "localhost:1521:";
        String sid = "orcl";

        String usuario = usu;

        String contrasena = cont;
        String cadenaconexion;
        cadenaconexion = "jdbc:oracle:thin:@" + host + sid;

//        String cadenaconexion ="jdbc:oracle:thin:@localhost:1521:XE";
        System.out.println("Creando conexion...");
        Connection connx = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connx = DriverManager.getConnection(cadenaconexion, usuario, contrasena);
        System.out.println("Conexion exitosa!");
        return connx;

    }
    
    public Connection conectarAux(String usu, String cont) throws ClassNotFoundException, SQLException {
        String host = "localhost:1521:";
        String sid = "orcl";

//        String host = "localhost:1521:";
//        String sid = "xe";

        String usuario = usu;

        String contrasena = cont;
        String cadenaconexion;
        cadenaconexion = "jdbc:oracle:thin:@" + host + sid;

//        String cadenaconexion ="jdbc:oracle:thin:@localhost:1521:XE";
        System.out.println("Creando conexion...");
        Connection connx = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connx = DriverManager.getConnection(cadenaconexion, usuario, contrasena);
        System.out.println("Conexion exitosa!");
        return connx;

    }

    //conexion a la base de datos
    public static Connection conectar_dgest() {
        String host = "148.208.217.107:1521:";
        String sid = "developer";

        String usuario = "usu";
        String contrasena = "pas";
        String cadenaconexion;
        cadenaconexion = "jdbc:oracle:thin:@" + host + sid;

        Connection connx = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Ocurrio el siguiente error driver " + e.getMessage());
            return null;
        }
        try {
            connx = DriverManager.getConnection(cadenaconexion, usuario, contrasena);
            return connx;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
