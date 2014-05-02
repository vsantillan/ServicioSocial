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
    //NO se modifican
    private static final String IP_PUERTO_BD_ITT_CENTRO_COMPUTO ="192.168.2.1:1521:";
    private static final String SID_ORACLE_ITT_CENTRO_COMPUTO   ="sia";
    
    //Modificar al ambiante a usar (Desarrollo,Calidad,Producción)
    //salvame
    private static final String IP_PUERTO_BD_ITT_VINCULACION ="192.168.40.120:1521:";
    private static final String SID_ORACLE_ITT_VINCULACION ="xe";
    public Conexion() {
    }

    //conexion a la base de datos
    public Connection conectar(String usu, String cont) throws ClassNotFoundException, SQLException {
        //IP LUGO
        String host = IP_PUERTO_BD_ITT_CENTRO_COMPUTO;
        String sid  = SID_ORACLE_ITT_CENTRO_COMPUTO;

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
        String host = IP_PUERTO_BD_ITT_VINCULACION;
        String sid  = SID_ORACLE_ITT_VINCULACION;
        
        //Servidor BD 

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
