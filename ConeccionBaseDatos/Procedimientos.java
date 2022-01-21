/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConeccionBaseDatos;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class Procedimientos {

    public static void entradaArticulos(String a, String b, String c, String d, int e, int f, int g) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call entradaArticulo(?,?,?,?,?,?,?)}");
        entrada.setString(1, a);
        entrada.setString(2, b);
        entrada.setString(3, c);
        entrada.setString(4, d);
        entrada.setInt(5, e);
        entrada.setInt(6, f);
        entrada.setInt(7, g);
        entrada.execute();

    }

    public static void eliminarArticulos(int a) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call eliminarArticulo(?)}");
        entrada.setInt(1, a);

        entrada.execute();

    }

    public static void buscarArticulos(int a) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call buscarArticulo(?)}");
        entrada.setInt(1, a);

        entrada.execute();

    }
}
