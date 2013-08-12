/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.login;

/**
 *
 * @author ingluisestrada
 */
import edu.servicio.toluca.login.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Login {

    private String roles = "";

    public Login() {
    }

    public String ValidarUsuario(String usu, String pass) throws ClassNotFoundException, SQLException {

        ArrayList<Login> ListaUsu = new ArrayList<Login>();
        String sql = "";
        ResultSet rs = null;
        PreparedStatement st = null;
        int Error = 0;
        Connection con = null;
        Conexion conexion = new Conexion();
        con = conexion.conectar(usu, pass);
        if (con != null) {

            sql = "SELECT GRANTED_ROLE FROM USER_ROLE_PRIVS WHERE USERNAME=?";

            try {
                st = con.prepareStatement(sql);
                st.setString(1, usu.toUpperCase());
                rs = st.executeQuery();
                while (rs.next()) {
                    Login objUsu = new Login();
                    objUsu.setRoles(rs.getString("GRANTED_ROLE"));
                    roles=rs.getString("GRANTED_ROLE");
                    ListaUsu.add(objUsu);
                    objUsu = null;                }
                
                con.close();

            } catch (SQLException e) {
                // TODO
                Error++;
            } finally {
                try {
                    if (st != null) {
                        st.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }

                    st = null;
                    rs = null;
                    con.close();

                } catch (SQLException ee) {
                    Error++;
                }

            }
        } else {
            return roles;
        }

        return roles;

    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
