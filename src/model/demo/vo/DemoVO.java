package model.demo.vo;

/**
 * Clase VO que implementa el objeto DEMO
 * @author
 *
 */
public class DemoVO {
    /**
     * propiedad id: identificador único de la entidad
     */
    private int id;
    /**
     * propiedad name: Nombre
     */
    private String name;

    /**
     * constructor que nos permite crear objetos DEMO a partir de sus componentes
     * @param id
     * @param name
     */
    public DemoVO(int id, String name) {
        this.id = id;
        this.name = name;
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
}