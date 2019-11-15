package model.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.db.ConnectionManager;
import model.demo.vo.DemoVO;

/**
 * Clase DAO de gestión de objetos DEMO
 *
 * @author
 */
public class DemoDAO
{
    private static String findByIdQuery = "SELECT * FROM demo WHERE id = ?";
    private static String findAll = "SELECT * FROM demo";

    /**
     * Busca un registro en la tabla DEMO por ID
     *
     * @param id Identificador del registro buscado
     * @return Objeto DemoVO con el identificador buscado, o null si no se encuentra
     */
    public DemoVO findById(int id) {
        DemoVO result = null;
        try {
            // Abrimos la conexión e inicializamos los parámetros
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(findByIdQuery);
            ps.setInt(1, id);
            // Ejecutamos la consulta
            ResultSet rs = ps.executeQuery();

            // Leemos resultados
            if (rs.first()) {
                result = new DemoVO(rs.getInt("id"), rs.getString("name"));
            } else {
                result = null;
            }
            ConnectionManager.releaseConnection(conn);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return result;
    }

    /**
     * Devuelve todos los registros de la tabla DEMO
     *
     * @return Lista de todos los registros de la tabla DEMO
     */
    public List<DemoVO> findAll() {
        List<DemoVO> result = new ArrayList<DemoVO>();
        try {
            // Abrimos la conexión e inicializamos los parámetros
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(findAll);
            // Ejecutamos la consulta
            ResultSet rs = ps.executeQuery();

            // Leemos resultados
            while (rs.next()) {
                DemoVO tmp = new DemoVO(rs.getInt("id"), rs.getString("name"));
                result.add(tmp);
            }
            ConnectionManager.releaseConnection(conn);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return result;
    }
}