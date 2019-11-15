package model.sensor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.db.ConnectionManager;
import model.sensor.vo.SensorVO;

/**
 * Clase DAO de gestión de objetos DEMO
 *
 * @author
 */
public class SensorDAO
{
    private static String findByIdQuery = "SELECT * FROM Sensor WHERE id = ?";
    private static String findAll = "SELECT * FROM Sensor";

    public SensorVO findById(int id) {
        SensorVO result = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(findByIdQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // Leemos resultados
            if (rs.first()) {
                result = new SensorVO(rs.getInt("idSensor"),
                        rs.getString("localizacion"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
                );
                        //(rs.getInt("id"), rs.getString("name"));
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
    public List<SensorVO> findAll() {
        List<SensorVO> result = new ArrayList<SensorVO>();
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(findAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SensorVO tmp = new SensorVO(rs.getInt("idSensor"),
                        rs.getString("localizacion"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
                );
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