package model.articulo.vo;

/**
 * Clase VO que implementa el objeto DEMO
 * @author
 *
 */
public class ArticuloVO {

    private int idArticulo;
    private String contenido;
    private String titulo;

    /**
     * propiedad name: Nombre
     */
    private String name;

    public ArticuloVO(int idArticulo,
                  String contenido,
                  String titulo
                  ) {
        this.idArticulo = idArticulo;
        this.contenido = contenido;
        this.titulo = titulo;
    }

    /*
     * Métodos set / get de las propiedades
     */
    public int getId() {
        return idArticulo;
    }

    public void setId(int id) {
        this.idArticulo = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}