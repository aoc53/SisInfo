package model.sensor.vo;


/**
 * Clase VO que implementa el objeto DEMO
 * @author
 *
 */
public class SensorVO {

    private int idSensor;
    private String localizacion;
    private String descripcion;
    private String nombre;

    /**
     * propiedad name: Nombre
     */
    private String name;

    public SensorVO(int idSensor,
    				String localizacion,
    				String descripcion,
    				String nombre
                  ) {
        this.idSensor = idSensor;
        this.localizacion = localizacion;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    /*
     * Métodos set / get de las propiedades
     */
    public int getId() {
        return idSensor;
    }

    public void setId(int id) {
        this.idSensor = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String tipo) {
        this.localizacion = localizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String email) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}