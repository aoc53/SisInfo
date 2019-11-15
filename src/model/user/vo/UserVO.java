package model.user.vo;

import java.util.Date;

/**
 * Clase VO que implementa el objeto DEMO
 * @author
 *
 */
public class UserVO {

    private int id;
    private String tipo;
    private String email;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String contrasenya;

    /**
     * propiedad name: Nombre
     */
    private String name;

    public UserVO(int id,
                  String tipo,
                  String email,
                  String nombre,
                  String apellidos,
                  Date fechaNacimiento,
                  String contrasenya
                  ) {
        this.id = id;
        this.tipo = tipo;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenya = contrasenya;
    }

    /*
     * Métodos set / get de las propiedades
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
}