package model.zona.vo;

import java.util.Date;

/**
 * Clase VO que implementa el objeto DEMO
 * @author
 *
 */
public class ZonaVO {

    private int idZona;
    private String ciudad;

    /**
     * propiedad name: Nombre
     */
    private String name;

    public ZonaVO(int idZona,
                  String ciudad
                  ) {
        this.idZona = idZona;
        this.ciudad = ciudad;
    }

    /*
     * Métodos set / get de las propiedades
     */
    public int getId() {
        return idZona;
    }

    public void setId(int id) {
        this.idZona = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}