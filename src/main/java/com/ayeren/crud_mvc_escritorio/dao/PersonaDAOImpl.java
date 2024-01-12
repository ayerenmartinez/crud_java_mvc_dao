
package com.ayeren.crud_mvc_escritorio.dao;

import com.ayeren.crud_mvc_escritorio.modelo.Conexion;
import com.ayeren.crud_mvc_escritorio.modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Anthony Davis Yeren Martinez
 */
public class PersonaDAOImpl implements PersonaDAO{
    Conexion conexion =new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public List<Persona> listarTodos() {
        List<Persona> lista = new ArrayList<>();
        String sql = "select * from persona";
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Persona persona = new Persona();
                persona.setId(rs.getInt(1));
                persona.setNombres(rs.getString(2));
                persona.setCorreo(rs.getString(3));
                persona.setTelefono(rs.getString(4));
                lista.add(persona);
            }
        } catch (Exception e) {
        }finally{
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    @Override
    public Persona leerPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrar(Persona t) {
        String sql = "insert into persona(nombres,correo,telefono) values(?,?,?)";
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getCorreo());
            ps.setString(3, t.getTelefono());
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Persona registrada correctamente");
            }
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }finally{
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }

    @Override
    public void actualizar(Persona t) {
        String sql = "update persona set nombres = ?, correo=?, telefono =? where id = ?";
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getCorreo());
            ps.setString(3, t.getTelefono());
            ps.setInt(4, t.getId());
            ps.executeUpdate();
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Persona actualizada correctamente");
            }
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }finally{
             if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from persona where id="+id;
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Persona eliminada correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
             if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    
}
