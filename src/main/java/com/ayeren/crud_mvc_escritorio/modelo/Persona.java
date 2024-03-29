
package com.ayeren.crud_mvc_escritorio.modelo;

/**
 *
 * @author Anthony Davis Yeren Martinez
 */
public class Persona {
    private Integer id;
    private String nombres;
    private String correo;
    private String telefono;

    public Persona() {
    }

    public Persona(Integer id, String nombres, String correo, String telefono) {
        this.id = id;
        this.nombres = nombres;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombres=" + nombres + ", correo=" + correo + ", telefono=" + telefono + '}';
    }
    
    
}
