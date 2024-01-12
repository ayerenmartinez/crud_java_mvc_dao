
package com.ayeren.crud_mvc_escritorio.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Anthony Davis Yeren Martinez
 */
public class Conexion {
    Connection con;
    public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3308/bdcrudmvc_escritorio";
        String user = "root";
        String pass = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
        }
        return con;
    }
}
